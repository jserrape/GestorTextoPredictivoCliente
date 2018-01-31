/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import Frame.InterfazFrame;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.BadLocationException;
import net.infonode.gui.laf.InfoNodeLookAndFeel;

public class Main {

    public static void main(String[] args) throws IOException, BadLocationException {

        /**
        try {
            UIManager.setLookAndFeel(new InfoNodeLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }*/

        InterfazFrame interfaz = new InterfazFrame();
        interfaz.setVisible(true);
    }

}
