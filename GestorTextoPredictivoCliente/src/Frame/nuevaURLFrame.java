/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 *
 * @author jcsp0003
 */
public class nuevaURLFrame extends javax.swing.JDialog {

    private final ConfigurarPrediccion confPrediccion;

    /**
     * Consrucor parametrizado de la clase nuevaURLFrame
     *
     * @param parent Clase frame que invoca a ReemplazarFrame
     * @param modal Modo del JDialog
     * @param op Frame que invoca a este
     */
    public nuevaURLFrame(javax.swing.JDialog parent, boolean modal, ConfigurarPrediccion op) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);

        this.jTextField1.addKeyListener(new KeyListenerImpl(botonAceptar, jTextField1));
        this.confPrediccion = op;
        this.jTextField1.addMouseListener(new MouseListenerImpl(this.jPopupMenu1, this.jTextField1));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        botonAceptar = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        botonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        botonAceptar.setText("Aceptar");
        botonAceptar.setEnabled(false);
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Anadir nueva url:");

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(botonAceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonCancelar)
                .addGap(67, 67, 67))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAceptar)
                    .addComponent(botonCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Envia la url escria a la clase ConfigurarPrediccion
     *
     * @param evt Evento de pulsar el un boton
     */
    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        this.confPrediccion.nuevaFilaTablaFicheros("URL", this.jTextField1.getText());
        this.dispose();
    }//GEN-LAST:event_botonAceptarActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

    }//GEN-LAST:event_jTextField1ActionPerformed

    /**
     * Cierra el frame
     *
     * @param evt Evento de pulsar el un boton
     */
    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonCancelarActionPerformed

    /**
     * Listener del jTextField1
     */
    private static class KeyListenerImpl implements KeyListener {

        private final javax.swing.JButton jButton;
        private final javax.swing.JTextField jTextField;

        /**
         * Consructor parametrizado
         *
         * @param jButton1 Boton "Aceptar"
         * @param jTextField1 Zona de escritura de texto
         */
        private KeyListenerImpl(JButton jButton1, javax.swing.JTextField jTextField1) {
            this.jButton = jButton1;
            this.jTextField = jTextField1;
        }

        /**
         * Listener que sucede al: al pulsar y soltar la tecla.
         *
         * @param e Evento sucedido
         */
        @Override
        public void keyTyped(KeyEvent e) {
        }

        /**
         * Listener que sucede al: al pulsar la tecla.
         *
         * @param e Evento sucedido
         */
        @Override
        public void keyPressed(KeyEvent e) {
        }

        /**
         * Listener que sucede al: al soltar la tecla.
         *
         * @param e Evento sucedido
         */
        @Override
        public void keyReleased(KeyEvent e) {
            //UrlValidator validar = new UrlValidator();
            this.jTextField.setText(this.jTextField.getText().replaceAll("\\s", ""));

            /*
            if (validar.isValid(this.jTextField.getText())) {
                this.jButton.setEnabled(true);
            } else {
                this.jButton.setEnabled(false);
            }*/
            this.jButton.setEnabled(true);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    /**
     * Lisener para detectar si se hace click derecho sobre el area de texto
     */
    private static class MouseListenerImpl implements MouseListener {

        private final JPopupMenu popMenu;
        private final javax.swing.JTextField jTextField;

        public MouseListenerImpl(JPopupMenu pop, javax.swing.JTextField jT) {
            this.popMenu = pop;
            this.jTextField = jT;
        }

        /**
         * Evento de pinchar y soltar.
         *
         * @param e Evento de pulsar el raton
         */
        @Override
        public void mouseClicked(MouseEvent e) {
        }

        /**
         * Evento de presionar el botón.
         *
         * @param e Evento de pulsar el raton
         */
        @Override
        public void mousePressed(MouseEvent e) {
        }

        /**
         * Evento de soltar el botón.
         *
         * @param e Evento de pulsar el raton
         */
        @Override
        public void mouseReleased(MouseEvent e) {
            if (e.getButton() == 3) {
                this.popMenu.setVisible(false);
                this.popMenu.removeAll();

                JMenuItem item;

                item = new JMenuItem("Cortar");
                this.popMenu.add(item);
                item.addActionListener(new ActionListenerImpl(jTextField, 1));

                item = new JMenuItem("Copiar");
                this.popMenu.add(item);
                item.addActionListener(new ActionListenerImpl(jTextField, 2));

                item = new JMenuItem("Pegar");
                this.popMenu.add(item);
                item.addActionListener(new ActionListenerImpl(jTextField, 3));

                this.popMenu.show(e.getComponent(), e.getX(), e.getY());
            }
        }

        /**
         * Evento de entrar en un componente con el puntero.
         *
         * @param e Evento de pulsar el raton
         */
        @Override
        public void mouseEntered(MouseEvent e) {
        }

        /**
         * Evento de salir de un componente con el puntero.
         *
         * @param e Evento de pulsar el raton
         */
        @Override
        public void mouseExited(MouseEvent e) {
        }

        /**
         * Listener de seleccionar un item
         */
        private static class ActionListenerImpl implements ActionListener {

            private final javax.swing.JTextField jTextField;
            private final int valor;

            /**
             * Consrucor parametrizado
             *
             * @param jT Caja de texto de la url
             * @param valor
             */
            public ActionListenerImpl(javax.swing.JTextField jT, int valor) {
                this.jTextField = jT;
                this.valor = valor;
            }

            /**
             * Evento de seleccionar el iem y decidir la acción correspondiene
             *
             * @param e Evento de seleccion del item
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (valor) {
                    case 1: //Cortar
                        this.jTextField.cut();
                        break;
                    case 2: //Copiar
                        this.jTextField.copy();
                        break;
                    case 3: //Pegar
                        this.jTextField.paste();
                        break;
                }
            }
        }
    }

}
