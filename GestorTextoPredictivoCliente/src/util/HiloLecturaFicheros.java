/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jcsp0003
 */
public class HiloLecturaFicheros implements Runnable {

    private final ProtocoloConexion protocolo;
    private final ArrayList<String> ficheros;
    private final ArrayList<String> urls;

    public HiloLecturaFicheros(ProtocoloConexion prot, ArrayList<String> ficheros, ArrayList<String> urls) {
        this.protocolo = prot;
        this.ficheros = ficheros;
        this.urls = urls;
    }

    @Override
    public void run() {
        lecturaDatos lectura = new lecturaDatos();
        String texto;
        try {
            for (int i = 0; i < ficheros.size(); i++) {
                texto = lectura.lectura("pdf", ficheros.get(i));
                this.protocolo.enviarMensaje(6, texto.replaceAll(":", ".").toLowerCase().replaceAll("[^\\dA-Za-z.,()á-úÁ-Ú ]", ""));
            }
            for (int i = 0; i < urls.size(); i++) {
                texto = lectura.lectura("url", urls.get(i));
                this.protocolo.enviarMensaje(6, texto.toLowerCase().replaceAll("[^\\dA-Za-z.á-úÁ-Ú ]", ""));
            }
        } catch (IOException ex) {
            Logger.getLogger(HiloLecturaFicheros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
