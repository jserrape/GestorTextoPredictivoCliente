/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import Frame.InterfazFrame;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

/**
 *
 * @author jcsp0003
 */
public final class Configuracion {

    private SSLSocket socket;
    private PrintWriter out;
    private BufferedReader in;
    private BufferedReader stdIn;

    private String idioma;
    private ArrayList<String> palabras;

    private final InterfazFrame interfaz;

    private final String address;
    private final int port = 4444;

    /**
     * Constructor por defecto de la clase Configuracion
     *
     * @param interfaz Clase de la interfaz principal
     * @param ip Ip del servidor
     */
    public Configuracion(InterfazFrame interfaz, String ip) {
        this.interfaz = interfaz;
        if ("-1".equals(ip)) {
            address = "localhost";
        } else {
            address = ip;
        }
        conectar();

        escribirFicheroIdiomaEspanol();
        //escribirFicheroIdiomaIngles();
    }

    /**
     * Conecta con el servidor
     */
    public void conectar() {
        cargarConf();
        try {
            try {
                ssl();
            } catch (KeyStoreException | FileNotFoundException | NoSuchAlgorithmException | UnrecoverableKeyException | CertificateException | KeyManagementException ex) {
                Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
            }
            out = new PrintWriter(getKkSocket().getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(getKkSocket().getInputStream()));
            stdIn = new BufferedReader(new InputStreamReader(System.in));
            this.interfaz.conexionCorrecta();
        } catch (IOException ex) {
            this.interfaz.errorConexion();
            Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Lee el idioma predefinido de la última sesión y lo carga.
     */
    private void cargarConf() {
        try {
            File archivoo = new File("./conf");
            FileReader fr = new FileReader(archivoo);
            BufferedReader br = new BufferedReader(fr);
            setIdioma(br.readLine());
            cargarIdioma(idioma);
        } catch (IOException ex) {
            Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void ssl() throws KeyStoreException, FileNotFoundException, NoSuchAlgorithmException, UnrecoverableKeyException, IOException, CertificateException, KeyManagementException {
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new FileInputStream("certs/client/clientKey.jks"), "clientpass".toCharArray());

        KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        kmf.init(keyStore, "clientpass".toCharArray());

        KeyStore trustedStore = KeyStore.getInstance("JKS");
        trustedStore.load(new FileInputStream("certs/client/clientTrustedCerts.jks"), "clientpass".toCharArray());

        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init(trustedStore);

        SSLContext sc = SSLContext.getInstance("TLS");
        TrustManager[] trustManagers = tmf.getTrustManagers();
        KeyManager[] keyManagers = kmf.getKeyManagers();
        sc.init(keyManagers, trustManagers, null);

        SSLSocketFactory ssf = sc.getSocketFactory();
        socket = (SSLSocket) ssf.createSocket(address, port);
        socket.startHandshake();
    }

    /**
     * Devuelve una palabra especifica del array de palabras
     *
     * @param i Posicion del array
     * @return Palabra de dicha posición
     */
    public String getPalabra(int i) {
        return palabras.get(i);
    }

    /**
     * Escribe el nuevo idioma en el fichero conf
     */
    public void escribirConf() {
        String ruta = "./conf";
        File archivo = new File(ruta);
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write(idioma);
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Carga el idioma indicado
     *
     * @param idiom Nombre del fichero de idioma a cargar
     */
    public void cargarIdioma(String idiom) {
        palabras = new ArrayList();
        FileReader f = null;
        try {
            String cadena;
            f = new FileReader("./idioma/" + idiom);
            try (BufferedReader b = new BufferedReader(f)) {
                while ((cadena = b.readLine()) != null) {
                    palabras.add(cadena);
                }
                this.idioma = idiom;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                f.close();
            } catch (IOException ex) {
                Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * @return the kkSocket
     */
    public Socket getKkSocket() {
        return socket;
    }

    /**
     * @return the out
     */
    public PrintWriter getOut() {
        return out;
    }

    /**
     * @return the in
     */
    public BufferedReader getIn() {
        return in;
    }

    /**
     * @return the stdIn
     */
    public BufferedReader getStdIn() {
        return stdIn;
    }

    /**
     * @return the idioma
     */
    public String getIdioma() {
        return idioma;
    }

    /**
     * @param idioma the idioma to set
     */
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public void escribirFicheroIdiomaEspanol() {
        String ruta = "./idioma/Español";
        File archivo = new File(ruta);
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write("Archivo");
            bw.newLine();
            bw.write("Editar");
            bw.newLine();
            bw.write("Ajustes");
            bw.newLine();
            bw.write("Ayuda");
            bw.newLine();
            bw.write("Nuevo");
            bw.newLine();
            bw.write("Abrir");
            bw.newLine();
            bw.write("Guardar");
            bw.newLine();
            bw.write("Guardar como...");
            bw.newLine();
            bw.write("Salir");
            bw.newLine();
            bw.write("Deshacer");
            bw.newLine();
            bw.write("Cortar");
            bw.newLine();
            bw.write("Copiar");
            bw.newLine();
            bw.write("Pegar");
            bw.newLine();
            bw.write("Eliminar");
            bw.newLine();
            bw.write("Buscar...");
            bw.newLine();
            bw.write("Reemplazar");
            bw.newLine();
            bw.write("Seleccionar todo");
            bw.newLine();
            bw.write("Hora y fecha");
            bw.newLine();
            bw.write("Formato");
            bw.newLine();
            bw.write("Predicción");
            bw.newLine();
            bw.write("Idioma");
            bw.newLine();
            bw.write("Aceptar");
            bw.newLine();
            bw.write("Cancelar");
            bw.newLine();
            bw.write("Elegir idioma de la interfaz");
            bw.newLine();
            bw.write("Seleccione uno de los idiomas siguientes para la interfaz");
            bw.newLine();
            bw.write("Fuente");
            bw.newLine();
            bw.write("Estilo de la fuente");
            bw.newLine();
            bw.write("Tamaño");
            bw.newLine();
            bw.write("Muestra");
            bw.newLine();
            bw.write("Normal");
            bw.newLine();
            bw.write("Negrita");
            bw.newLine();
            bw.write("Cursiva");
            bw.newLine();
            bw.write("Anadir nueva url:");
            bw.newLine();
            bw.write("Anadir nueva url");
            bw.newLine();
            bw.write("Gestor de texto predictivo con origen de datos configurable");
            bw.newLine();
            bw.write("Selección de idioma");
            bw.newLine();
            bw.write("Acceder");
            bw.newLine();
            bw.write("Registrarse");
            bw.newLine();
            bw.write("Correo");
            bw.newLine();
            bw.write("Contraseña");
            bw.newLine();
            bw.write("Nombre");
            bw.newLine();
            bw.write("Apellidos");
            bw.newLine();
            bw.write("Repetir correo");
            bw.newLine();
            bw.write("Usuario o contraseña erróneo");
            bw.newLine();
            bw.write("Ya existe un usuario con ese correo");
            bw.newLine();
            bw.write("Seleccionar conjunto");
            bw.newLine();
            bw.write("Añadir documentos");
            bw.newLine();
            bw.write("Cargar");
            bw.newLine();
            bw.write("Eliminar");
            bw.newLine();
            bw.write("DataSet cargado:");
            bw.newLine();
            bw.write("Crear nuevo conjunto");
            bw.newLine();
            bw.write("Nombre del conjunto:");
            bw.newLine();
            bw.write("Idioma del conjunto");
            bw.newLine();
            bw.write("Tamaño máximo de la semilla");
            bw.newLine();
            bw.write("Tamaño mínimo de la semilla");
            bw.newLine();
            bw.write("Tamaño de la predicción");
            bw.newLine();
            bw.write("Máximo de predicciones");
            bw.newLine();
            bw.write("Se debe tener un conjunto de datos cargado para poder añadir documentos.");
            bw.newLine();
            bw.write("Nuevo fichero");
            bw.newLine();
            bw.write("Nuevo directorio");
            bw.newLine();
            bw.write("Nuevo html");
            bw.newLine();
            bw.write("Borrar");
            bw.newLine();
            bw.write("Ninguno");
            bw.newLine();
            bw.write("Otro");
            bw.newLine();
            bw.write("Buscar:");
            bw.newLine();
            bw.write("Coincidir mayúsculas y minúsculas");
            bw.newLine();
            bw.write("Buscar siguiente");
            bw.newLine();
            bw.write("Ver la Ayuda");
            bw.newLine();
            bw.write("1) Zona de escritura del usuario, en la que el usuario redactará el texto sobre el que se realizarán las predicciones.");
            bw.newLine();
            bw.write("2) Botón que informa si se ha producido una desconexión con el servidor, mediante el cual se puede tratar de volver a conectar.");
            bw.newLine();
            bw.write("3) Opción que permite cambiar el idioma de la interfaz.");
            bw.newLine();
            bw.write("4) Opción de predicción mediante la cual se puede iniciar sesión o registrarse en el sistema,  y utilizar conjuntos de datos una vez registrado.");
            bw.newLine();
            bw.write("1) Tabla de conjuntos de los que dispone el usuario.");
            bw.newLine();
            bw.write("2) Característica para crear un nuevo conjunto de datos a partir de un nombre de conjunto, un idioma y las características de la predicción. ");
            bw.newLine();
            bw.write("3) Campo que indica el conjunto de daos cargado");
            bw.newLine();
            bw.write("4) Botón para cargar un conjunto seleccionado.");
            bw.newLine();
            bw.write("5) Botón para eliminar un conjunto seleccionado.");
            bw.newLine();
            bw.write("1) Botón para seleccionar un fichero, directorio o dirección web para añadirlo al conjunto de datos activo.");
            bw.newLine();
            bw.write("2) Botón para eliminar un documento previamente seleccionado.");
            bw.newLine();
            bw.write("3) Botón para cargar los documentos de la tabla.");
            bw.newLine();
            bw.write("4) Tabla con los documentos que se añadirán.");
            bw.newLine();
            bw.write("¿Desea cerrar la aplicación?");
            bw.newLine();
            bw.write("No se encontró");
            bw.newLine();
            bw.write("¿Desea eliminar el conjunto seleccionado?");
            bw.newLine();
            bw.write("Se ha perdido la conexión con el servidor.");
            bw.newLine();
            bw.write("Error de conexion");
            bw.newLine();
            bw.write("Anterior");
            bw.newLine();
            bw.write("Siguiente");
            bw.newLine();
            bw.write("Tipo");
            bw.newLine();
            bw.write("Dirección");
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void escribirFicheroIdiomaFrances() {
        String ruta = "./idioma/Français";
        File archivo = new File(ruta);
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(archivo));

            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void escribirFicheroIdiomaItaliano() {
        String ruta = "./idioma/Italiano";
        File archivo = new File(ruta);
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(archivo));

            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void escribirFicheroIdiomaPortugues() {
        String ruta = "./idioma/Portugues";
        File archivo = new File(ruta);
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(archivo));

            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
