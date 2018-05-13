/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import Frame.InterfazFrame;
import java.io.*;
import javax.swing.text.BadLocationException;

public class Main {

    public static void main(String[] args) throws IOException, BadLocationException {

        InterfazFrame interfaz;
        if (args.length == 0) {
            interfaz = new InterfazFrame();
        } else {
            interfaz = new InterfazFrame(args[0]);
        }
        interfaz.setVisible(true);

    }

}
