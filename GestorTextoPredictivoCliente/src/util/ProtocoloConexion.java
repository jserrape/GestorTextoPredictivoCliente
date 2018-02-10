/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jcsp0003
 */
public class ProtocoloConexion {

    private final Configuracion config;
    private final String mac;

    public ProtocoloConexion(Configuracion conf) {
        this.config = conf;
        this.mac = getMac();
        enviarMensaje(0, "");
    }

    /**
     * Función que en función de un código selecciona el tipo de mensaje que
     * debe enviar al servidor 0 Comunicar mac 1 Solicitar lista de dataSets 2
     * Crear dataSet 3 Eliminar dataSet 4 DataSet cargado 5 Cargar DataSet 6
     * Añadir fichero al conjunto 7 Hacer prediccion 9 registro
     *
     * @param cod Codigo del tipo de mensaje
     * @param mensaje Mensaje que envía al servidor
     * @return Respuesa del servidor
     */
    public String enviarMensaje(int cod, String mensaje) {
        switch (cod) {
            case 0:
                comunicarMac();
                break;
            case 1:
                return obtenerListaDataSet();
            case 2:
                return crearDataSet(mensaje);
            case 3:
                return eliminarDataSet(mensaje);
            case 4:
                return dataSetCargado();
            case 5:
                return cargarDataSet(mensaje);
            case 6:
                enviarTexto(mensaje);
                break;
            case 7:
                return this.solicitarPrediccion(mensaje);
            case 8:
                return login(mensaje);
            case 9:
                return registro(mensaje);
        }
        return "";
    }

    /**
     * Envía la dirección mac del ordenar al servidor
     */
    private void comunicarMac() {
        try {
            config.getIn().readLine();
            System.out.println("Client: " + mac);
            config.getOut().println(mac);
            config.getIn().readLine();
        } catch (IOException ex) {
            Logger.getLogger(ProtocoloConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Solicita al servidor la lisa de los dataSet asociados
     *
     * @return Lisa de dataSets
     */
    private String obtenerListaDataSet() {
        try {
            config.getOut().println("1");
            String conjunos = config.getIn().readLine();
            if (!"-1".equals(conjunos)) {
                return conjunos;
            } else {
                return "";
            }
        } catch (IOException ex) {
            Logger.getLogger(ProtocoloConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    /**
     * Solicita al servidor crear un daaSet
     *
     * @param nombre Nombre y características del dataSet
     * @return Lista de todos los dataSets
     */
    private String crearDataSet(String nombre) {
        config.getOut().println("2" + nombre);
        try {
            return config.getIn().readLine();
        } catch (IOException ex) {
            Logger.getLogger(ProtocoloConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    /**
     * Pide al servidor eliminar un dataSet determinado
     *
     * @param nombre Nombre del dataSet a eliminar
     * @return Lista de todos los dataSets
     */
    private String eliminarDataSet(String nombre) {
        config.getOut().println("3" + nombre);
        try {
            return config.getIn().readLine();
        } catch (IOException ex) {
            Logger.getLogger(ProtocoloConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    /**
     * Solicita saber al servidor qué dataSet tiene cargado
     *
     * @return DataSet cargado
     */
    private String dataSetCargado() {
        config.getOut().println("4");
        try {
            return config.getIn().readLine();
        } catch (IOException ex) {
            Logger.getLogger(ProtocoloConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "-1";
    }

    /**
     * Solicita al servidor que cargue un dataSet
     *
     * @param mensaje Nombre del dataSet a cargar
     * @return Nombre del dataSet que ha cargado
     */
    private String cargarDataSet(String mensaje) {
        config.getOut().println("5" + mensaje);
        try {
            return config.getIn().readLine();
        } catch (IOException ex) {
            Logger.getLogger(ProtocoloConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Ninguno";
    }

    /**
     * Envia una cadena de texto al servidor para que la analice para fuuras
     * predicciones.
     *
     * @param mensaje Cadena de texto a analizar
     */
    private void enviarTexto(String mensaje) {
        config.getOut().println("6" + mensaje);
    }

    /**
     * Solicita una predicción a partir de una semilla
     *
     * @param mensaje Semilla de predicción
     * @return Array con las predicciones obenidas
     */
    private String solicitarPrediccion(String mensaje) {
        config.getOut().println("7" + mensaje);
        try {
            return config.getIn().readLine();
        } catch (IOException ex) {
            Logger.getLogger(ProtocoloConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    /**
     * Se desconecta del servidor
     */
    public void desconectar() {
        try {
            config.getOut().println("8");
            config.getOut().close();
            config.getIn().close();
            config.getStdIn().close();
            config.getKkSocket().close();
        } catch (IOException ex) {
            Logger.getLogger(ProtocoloConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String login(String mensaje) {
        config.getOut().println("8" + mensaje);
        try {
            return config.getIn().readLine();
        } catch (IOException ex) {
            Logger.getLogger(ProtocoloConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "-1";
    }

    private String registro(String mensaje) {
        config.getOut().println("9" + mensaje);
        try {
            return config.getIn().readLine();
        } catch (IOException ex) {
            Logger.getLogger(ProtocoloConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "-1";
    }

    /**
     * Obtiene la direccion ip y mac del equipo
     *
     * @return Direccion mac
     */
    private static String getMac() {
        InetAddress ip;
        try {
            ip = InetAddress.getLocalHost();
            System.out.println("Current IP address : " + ip.getHostAddress());
            NetworkInterface network = NetworkInterface.getByInetAddress(ip);
            byte[] mac = network.getHardwareAddress();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }
            return sb.toString();
        } catch (UnknownHostException | SocketException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
}
