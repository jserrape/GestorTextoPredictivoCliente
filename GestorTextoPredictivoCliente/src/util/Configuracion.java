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
    }

    /**
     * Conecta con el servidor
     */
    public void conectar() {
        cargarConf();
        try {
            ssl();

            out = new PrintWriter(getSocket().getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(getSocket().getInputStream()));
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

    /**
     * Añade el protocolo ssl
     */
    private void ssl() {
        KeyStore keyStore;
        try {
            keyStore = KeyStore.getInstance("JKS");
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
        } catch (KeyStoreException | IOException | KeyManagementException | NoSuchAlgorithmException | CertificateException | UnrecoverableKeyException ex) {
            Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
        }
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
     * @return the Socket
     */
    public Socket getSocket() {
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
}
