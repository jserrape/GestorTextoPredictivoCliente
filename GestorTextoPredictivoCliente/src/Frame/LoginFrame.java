/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.apache.commons.codec.digest.DigestUtils;
import util.Configuracion;
import util.ProtocoloConexion;

/**
 *
 * @author jcsp0003
 */
public class LoginFrame extends javax.swing.JDialog {

    private final ProtocoloConexion protocolo;
    private final InterfazFrame interfaz;
    private final Configuracion config;

    /**
     * Consttructor parametrizado
     *
     * @param parent Clase frame que invoca a LoginFrame
     * @param modal Modo del JDialog
     * @param protocolo Clase con las funciones para la comunicación con el
     * servidor
     * @param inter Interfaz principal de escritura
     * @param conf Configuración con las cadenas de texto del idioma
     */
    public LoginFrame(java.awt.Frame parent, boolean modal, ProtocoloConexion protocolo, InterfazFrame inter, Configuracion conf) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.config = conf;
        setIdiomaInterfaz();

        this.protocolo = protocolo;
        this.interfaz = inter;
        botonRegistrarse.setEnabled(false);
        botonAcceder.setEnabled(false);
        jLabel7.setVisible(false);
        jLabel8.setVisible(false);

        listenerRegistro listener2 = new listenerRegistro(fieldNombre, this.fieldApellidos, this.fieldMail1, this.fieldMail2);
        listenerLogin listener1 = new listenerLogin(jTextField1, jTextField2);
        jTextField1.addKeyListener(listener1);
        jTextField2.addKeyListener(listener1);
        fieldNombre.addKeyListener(listener2);
        fieldApellidos.addKeyListener(listener2);
        fieldMail1.addKeyListener(listener2);
        fieldMail2.addKeyListener(listener2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        botonAcceder = new javax.swing.JButton();
        botonCancelar1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        botonRegistrarse = new javax.swing.JButton();
        botonCancelar2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        fieldNombre = new javax.swing.JTextField();
        fieldApellidos = new javax.swing.JTextField();
        fieldMail1 = new javax.swing.JTextField();
        fieldMail2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Correo");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Contraseña");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        botonAcceder.setText("Acceder");
        botonAcceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAccederActionPerformed(evt);
            }
        });

        botonCancelar1.setText("Cancelar");
        botonCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelar1ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 51, 51));
        jLabel8.setText("Usuario o contraseña erróneo");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(botonAcceder)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonCancelar1)
                .addGap(25, 25, 25))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(76, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                    .addComponent(jTextField2))
                .addGap(70, 70, 70))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAcceder)
                    .addComponent(botonCancelar1))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Acceder", jPanel1);

        botonRegistrarse.setText("Registrarse");
        botonRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarseActionPerformed(evt);
            }
        });

        botonCancelar2.setText("Cancelar");
        botonCancelar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelar2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Nombre");

        jLabel4.setText("Apellidos");

        jLabel5.setText("Correo");

        jLabel6.setText("Repetir correo");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 51, 51));
        jLabel7.setText("Ya existe un usuario con ese correo");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(fieldApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel3))
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGap(54, 54, 54)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addGap(10, 10, 10)
                                                    .addComponent(fieldMail1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jLabel7)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(fieldNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(fieldMail2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addGap(36, 90, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(botonRegistrarse)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonCancelar2)
                        .addGap(28, 28, 28))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(fieldApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(fieldMail1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(fieldMail2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonRegistrarse)
                    .addComponent(botonCancelar2))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Registrarse", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Solicita al servidor regisrarse
     *
     * @param evt Accion del boton
     */
    private void botonRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarseActionPerformed
        try {
            if ("-1".equals(this.protocolo.enviarMensaje(9, this.fieldNombre.getText() + "#" + this.fieldApellidos.getText() + "#" + this.fieldMail1.getText()))) {
                jLabel7.setVisible(true);
            } else {
                this.dispose();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, this.config.getPalabra(84), this.config.getPalabra(85), JOptionPane.ERROR_MESSAGE);
            this.interfaz.errorConexion();
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonRegistrarseActionPerformed

    /**
     * Cierra el frame
     *
     * @param evt Accion del boton
     */
    private void botonCancelar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelar2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonCancelar2ActionPerformed

    /**
     * Cierra el frame
     *
     * @param evt Accion del boton
     */
    private void botonCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelar1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonCancelar1ActionPerformed

    /**
     * Solicita al servidor acceder a una cuenta
     *
     * @param evt Accion del boton
     */
    private void botonAccederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAccederActionPerformed
        try {
            if ("-1".equals(this.protocolo.enviarMensaje(8, jTextField1.getText() + "#" + DigestUtils.sha1Hex(jTextField2.getText())))) {
                jLabel8.setVisible(true);
            } else {
                this.interfaz.logear();
                this.dispose();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, this.config.getPalabra(84), this.config.getPalabra(85), JOptionPane.ERROR_MESSAGE);
            this.interfaz.errorConexion();
            this.dispose();
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonAccederActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAcceder;
    private javax.swing.JButton botonCancelar1;
    private javax.swing.JButton botonCancelar2;
    private javax.swing.JButton botonRegistrarse;
    private javax.swing.JTextField fieldApellidos;
    private javax.swing.JTextField fieldMail1;
    private javax.swing.JTextField fieldMail2;
    private javax.swing.JTextField fieldNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPasswordField jTextField2;
    // End of variables declaration//GEN-END:variables

    /**
     * Establece el idioma indicado en la configuracion
     */
    private void setIdiomaInterfaz() {
        jTabbedPane1.setTitleAt(0, this.config.getPalabra(36));
        jTabbedPane1.setTitleAt(1, this.config.getPalabra(37));
        jLabel1.setText(this.config.getPalabra(38));
        jLabel2.setText(this.config.getPalabra(39));
        botonAcceder.setText(this.config.getPalabra(21));
        botonCancelar1.setText(this.config.getPalabra(22));
        jLabel8.setText(this.config.getPalabra(43));
        jLabel7.setText(this.config.getPalabra(44));
        jLabel3.setText(this.config.getPalabra(40));
        jLabel4.setText(this.config.getPalabra(41));
        jLabel5.setText(this.config.getPalabra(38));
        jLabel6.setText(this.config.getPalabra(42));
        botonRegistrarse.setText(this.config.getPalabra(37));
        botonCancelar2.setText(this.config.getPalabra(22));
    }

    /**
     * Listener de escritura en los campos del login
     */
    private class listenerLogin implements KeyListener {

        private final JTextField mail;
        private final JTextField pass;

        /**
         * Consructor parametrizado
         *
         * @param mail JTextField del correo
         * @param pass JTextField de la conraseña
         */
        public listenerLogin(JTextField mail, JTextField pass) {
            this.mail = mail;
            this.pass = pass;
        }

        /**
         * Evento de pulsar y soltar una tecla
         *
         * @param ke Evento de tecla
         */
        @Override
        public void keyTyped(KeyEvent e) {
        }

        /**
         * Evento de pulsar una tecla
         *
         * @param ke Evento de tecla
         */
        @Override
        public void keyPressed(KeyEvent e) {
        }

        /**
         * Evento de soltar una tecla para desbloquear el boton de acceder
         *
         * @param ke Evento de tecla
         */
        @Override
        public void keyReleased(KeyEvent e) {
            String aux1, aux2;
            aux1 = mail.getText().replaceAll(" ", "");
            aux2 = pass.getText().replaceAll(" ", "");
            if (!"".equals(aux1) && !"".equals(aux2)) {
                botonAcceder.setEnabled(true);
            } else {
                botonAcceder.setEnabled(false);
            }
        }
    }

    /**
     * Listener de escritura en los campos de regisro
     */
    private class listenerRegistro implements KeyListener {

        private final JTextField nombre;
        private final JTextField app;
        private final JTextField mail1;
        private final JTextField mail2;

        /**
         * Consructor parametrizado
         *
         * @param nombre JTextField del nombre
         * @param app JTextField de los apellidos
         * @param mail1 JTextField del correo
         * @param mail2 JTextField de repetir el correo
         */
        public listenerRegistro(JTextField nombre, JTextField app, JTextField mail1, JTextField mail2) {
            this.nombre = nombre;
            this.app = app;
            this.mail1 = mail1;
            this.mail2 = mail2;
        }

        /**
         * Evento de pulsar y soltar una tecla
         *
         * @param ke Evento de tecla
         */
        @Override
        public void keyTyped(KeyEvent e) {
        }

        /**
         * Evento de pulsar una tecla
         *
         * @param ke Evento de tecla
         */
        @Override
        public void keyPressed(KeyEvent e) {
        }

        /**
         * Evento de soltar una tecla para desbloquear el boton de registrarse
         *
         * @param ke Evento de tecla
         */
        @Override
        public void keyReleased(KeyEvent e) {
            String aux1, aux2, aux3, aux4;
            aux1 = nombre.getText().replaceAll(" ", "");
            aux2 = app.getText().replaceAll(" ", "");
            aux3 = mail1.getText().replaceAll(" ", "");
            aux4 = mail2.getText().replaceAll(" ", "");

            if (aux3.equals(aux4) && !"".equals(aux1) && !"".equals(aux2) && !"".equals(aux3)) {
                botonRegistrarse.setEnabled(true);
            } else {
                botonRegistrarse.setEnabled(false);
            }
        }
    }
}
