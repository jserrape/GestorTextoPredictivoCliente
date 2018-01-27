/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.event.MenuKeyEvent;
import javax.swing.event.MenuKeyListener;

/**
 *
 * @author jcsp0003
 */
public class PopUpMenu {

    private final JPopupMenu jpopMenu;
    private final javax.swing.JTextArea jt;

    /**
     * Constructor parametrizado
     *
     * @param jp Objeto JPopMenu que mostrará las predicciones
     * @param jt Area de texto principal de escritura
     */
    public PopUpMenu(JPopupMenu jp, javax.swing.JTextArea jt) {
        this.jpopMenu = jp;
        this.jt = jt;
    }

    /**
     * Muestra las predicciones en unas coordenadas
     *
     * @param ke Eveno de escritura
     * @param x Coordenada x
     * @param y Coordenada y
     * @param strResultado Cadena de texo con las predicciones
     */
    public void mostrar(KeyEvent ke, int x, int y, String strResultado) {

        this.jpopMenu.setVisible(false);
        this.jpopMenu.removeAll();

        String[] predicciones = strResultado.split(", ");

        JMenuItem item;

        for (String prediccione : predicciones) {
            item = new JMenuItem(prediccione);
            this.jpopMenu.add(item);
            item.addActionListener(new ActionListenerImpl(jt));
            item.addMenuKeyListener(new MenuKeyListenerImpl(jt, item, this));
        }

        this.jpopMenu.show(ke.getComponent(), x, y);
        this.jt.requestFocus();
    }

    /**
     * Otorga el foco al JPopMenu
     */
    public void darFoco() {
        this.jpopMenu.requestFocus();
    }

    /**
     * Elimina de la interfaz el JPopMenu
     */
    public void desaparecer() {
        this.jpopMenu.setVisible(false);
    }

    /**
     * Listener de seleccion de un item de prediccion
     */
    private static class ActionListenerImpl implements ActionListener {

        private final javax.swing.JTextArea jt;

        /**
         * Constructor parametrizado
         *
         * @param jt Area de texto principal de la interfaz
         */
        public ActionListenerImpl(javax.swing.JTextArea jt) {
            this.jt = jt;
        }

        /**
         * Evento de seleccion de un item que selecciona el texto de item y lo
         * añade al area de texto de escritura
         *
         * @param e Evento de seleccion
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            StringBuilder sb = new StringBuilder(jt.getText());
            if (jt.getText().charAt(jt.getCaretPosition() - 1) != ' ') {
                String semilla; //semilla
                if (jt.getCaretPosition() - 10 < 0) {
                    semilla = jt.getText().substring(0, jt.getCaretPosition());
                } else {
                    semilla = jt.getText().substring(jt.getCaretPosition() - 10, jt.getCaretPosition());
                }
                String[] palabras = semilla.split("\\s+");
                String palabraInacabada = palabras[palabras.length - 1];
                String prediccionRecortada = e.getActionCommand().substring(palabraInacabada.length(), e.getActionCommand().length());

                sb.insert(jt.getCaretPosition(), prediccionRecortada + " ");
            } else {
                sb.insert(jt.getCaretPosition(), e.getActionCommand() + " ");
            }
            jt.setText(sb.toString());
        }
    }

    /**
     * Listener de seleccion de un item de prediccion mediante eclado
     */
    private static class MenuKeyListenerImpl implements MenuKeyListener {

        private final javax.swing.JTextArea jt;
        private final JMenuItem item;
        private final PopUpMenu pop;

        /**
         * Constructor paramerizado
         *
         * @param jt Area de texto principal de la interfaz
         * @param item Item seleccionado
         * @param pop Objeto JPpopMenu
         */
        public MenuKeyListenerImpl(javax.swing.JTextArea jt, JMenuItem item, PopUpMenu pop) {
            this.jt = jt;
            this.item = item;
            this.pop = pop;
        }

        /**
         * Acción de pulsar y soltar la tecla
         *
         * @param mke Eveno de teclado
         */
        @Override
        public void menuKeyTyped(MenuKeyEvent mke) {
        }

        /**
         * Acción de pulsar la tecla.
         *
         * @param mke Eveno de teclado
         */
        @Override
        public void menuKeyPressed(MenuKeyEvent mke) {
        }

        /**
         * Acción de soltar la tecla que selecciona el texto de item y lo añade
         * al area de texto de escritura
         *
         * @param mke Eveno de teclado
         */
        @Override
        public void menuKeyReleased(MenuKeyEvent mke) {
            if (mke.getKeyCode() == 10 && this.item.isArmed()) {
                StringBuilder sb = new StringBuilder(jt.getText());
                if (jt.getText().charAt(jt.getCaretPosition() - 1) != ' ') {
                    String semilla; //semilla
                    if (jt.getCaretPosition() - 10 < 0) {
                        semilla = jt.getText().substring(0, jt.getCaretPosition());
                    } else {
                        semilla = jt.getText().substring(jt.getCaretPosition() - 10, jt.getCaretPosition());
                    }
                    String[] palabras = semilla.split("\\s+");
                    String palabraInacabada = palabras[palabras.length - 1];
                    String prediccionRecortada = this.item.getText().substring(palabraInacabada.length(), this.item.getText().length());

                    sb.insert(jt.getCaretPosition(), prediccionRecortada + " ");
                } else {
                    sb.insert(jt.getCaretPosition(), this.item.getText() + " ");
                }
                jt.setText(sb.toString());
                pop.desaparecer();
            }
        }
    }
}
