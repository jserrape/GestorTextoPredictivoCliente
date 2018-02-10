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

    public ProtocoloConexion(Configuracion conf) {
        this.config = conf;
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
    public String enviarMensaje(int cod, String mensaje) throws IOException {
        switch (cod) {
            case 0:
                desconectar();
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
     * Solicita al servidor la lisa de los dataSet asociados
     *
     * @return Lisa de dataSets
     */
    private String obtenerListaDataSet() throws IOException {
        config.getOut().println("1");
        String conjunos = config.getIn().readLine();
        if (!"-1".equals(conjunos)) {
            return conjunos;
        } else {
            return "";
        }
    }

    /**
     * Solicita al servidor crear un daaSet
     *
     * @param nombre Nombre y características del dataSet
     * @return Lista de todos los dataSets
     */
    private String crearDataSet(String nombre) throws IOException {
        config.getOut().println("2" + nombre);
        return config.getIn().readLine();
    }

    /**
     * Pide al servidor eliminar un dataSet determinado
     *
     * @param nombre Nombre del dataSet a eliminar
     * @return Lista de todos los dataSets
     */
    private String eliminarDataSet(String nombre) throws IOException {
        config.getOut().println("3" + nombre);
            return config.getIn().readLine();
    }

    /**
     * Solicita saber al servidor qué dataSet tiene cargado
     *
     * @return DataSet cargado
     */
    private String dataSetCargado() throws IOException {
        config.getOut().println("4");
            return config.getIn().readLine();
    }

    /**
     * Solicita al servidor que cargue un dataSet
     *
     * @param mensaje Nombre del dataSet a cargar
     * @return Nombre del dataSet que ha cargado
     */
    private String cargarDataSet(String mensaje) throws IOException {
        config.getOut().println("5" + mensaje);
            return config.getIn().readLine();
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
    private String solicitarPrediccion(String mensaje) throws IOException {
        config.getOut().println("7" + mensaje);

            return config.getIn().readLine();
    }

    /**
     * Se desconecta del servidor
     */
    public void desconectar() throws IOException {
            config.getOut().println("0");
            config.getOut().close();
            config.getIn().close();
            config.getStdIn().close();
            config.getKkSocket().close();
    }

    private String login(String mensaje) throws IOException {
        config.getOut().println("8" + mensaje);
            return config.getIn().readLine();
    }

    private String registro(String mensaje) throws IOException {
        config.getOut().println("9" + mensaje);

            return config.getIn().readLine();
    }

}
