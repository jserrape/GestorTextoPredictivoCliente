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
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
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

    private String address = "192.168.0.105";
    private int port = 4444;

    /**
     * Constructor por defecto de la clase Configuracion
     *
     * @param interfaz Clase de la interfaz principal
     */
    public Configuracion(InterfazFrame interfaz) {
        this.interfaz = interfaz;
        conectar();

        escribirFicheroIdiomaEspanol();
        escribirFicheroIdiomaIngles();
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
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void escribirFicheroIdiomaIngles() {
        String ruta = "./idioma/English";
        File archivo = new File(ruta);
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write("Archive");
            bw.newLine();
            bw.write("Edit");
            bw.newLine();
            bw.write("Settings");
            bw.newLine();
            bw.write("Help");
            bw.newLine();
            bw.write("New");
            bw.newLine();
            bw.write("Open");
            bw.newLine();
            bw.write("Save");
            bw.newLine();
            bw.write("Save as...");
            bw.newLine();
            bw.write("Close");
            bw.newLine();
            bw.write("Undo");
            bw.newLine();
            bw.write("Cut");
            bw.newLine();
            bw.write("Copy");
            bw.newLine();
            bw.write("Paste");
            bw.newLine();
            bw.write("Remove");
            bw.newLine();
            bw.write("Find...");
            bw.newLine();
            bw.write("Replace");
            bw.newLine();
            bw.write("Select all");
            bw.newLine();
            bw.write("Time and date");
            bw.newLine();
            bw.write("Format");
            bw.newLine();
            bw.write("Prediction");
            bw.newLine();
            bw.write("Language");
            bw.newLine();
            bw.write("Accept");
            bw.newLine();
            bw.write("Cancel");
            bw.newLine();
            bw.write("Choose interface language");
            bw.newLine();
            bw.write("Select one of the following languages ​​for the interface:");
            bw.newLine();
            bw.write("Font");
            bw.newLine();
            bw.write("Font style");
            bw.newLine();
            bw.write("Size");
            bw.newLine();
            bw.write("Sample");
            bw.newLine();
            bw.write("Normal");
            bw.newLine();
            bw.write("Bold");
            bw.newLine();
            bw.write("Italics");
            bw.newLine();
            bw.write("Add new url:");
            bw.newLine();
            bw.write("Add new url");
            bw.newLine();
            bw.write("Predictive text manager with configurable data source");
            bw.newLine();
            bw.write("Language selection");
            bw.newLine();
            bw.write("Log in");
            bw.newLine();
            bw.write("Sign in");
            bw.newLine();
            bw.write("Email");
            bw.newLine();
            bw.write("Password");
            bw.newLine();
            bw.write("Name");
            bw.newLine();
            bw.write("Surname");
            bw.newLine();
            bw.write("Repeat email");
            bw.newLine();
            bw.write("Wrong username or password");
            bw.newLine();
            bw.write("There is already a user with that email");
            bw.newLine();
            bw.write("Select set");
            bw.newLine();
            bw.write("Add documents");
            bw.newLine();
            bw.write("Load");
            bw.newLine();
            bw.write("Delete");
            bw.newLine();
            bw.write("DataSet loaded:");
            bw.newLine();
            bw.write("Create new set");
            bw.newLine();
            bw.write("Name of the set:");
            bw.newLine();
            bw.write("Set language");
            bw.newLine();
            bw.write("Maximum size of the seed");
            bw.newLine();
            bw.write("Minimum size of the seed");
            bw.newLine();
            bw.write("Size of the prediction");
            bw.newLine();
            bw.write("Maximum predictions");
            bw.newLine();
            bw.write("You must have a set of data loaded to be able to add documents.");
            bw.newLine();
            bw.write("New file");
            bw.newLine();
            bw.write("New directory");
            bw.newLine();
            bw.write("New html");
            bw.newLine();
            bw.write("Delete");
            bw.newLine();
            bw.write("None");
            bw.newLine();
            bw.write("Other");
            bw.newLine();
            bw.write("Search:");
            bw.newLine();
            bw.write("Match case");
            bw.newLine();
            bw.write("Find next");
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
