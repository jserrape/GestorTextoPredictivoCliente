/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jcsp0003
 */
public class Configuracion {

    private Socket kkSocket;
    private PrintWriter out;
    private BufferedReader in;
    private BufferedReader stdIn;

    private String idioma;
    private ArrayList<String> palabras;

    /**
     * Constructor por defecto
     */
    public Configuracion() {
        try {
            kkSocket = new Socket("192.168.0.104", 4444);
            out = new PrintWriter(getKkSocket().getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(getKkSocket().getInputStream()));
            stdIn = new BufferedReader(new InputStreamReader(System.in));
            cargarConf();
        } catch (IOException ex) {
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
        return kkSocket;
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
