/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Xenahort
 */
public class BuscarFrame extends javax.swing.JDialog {

    private final javax.swing.JTextArea jTextArea;
    private int posCaret;

    /**
     * Creates new form BuscarFrame
     *
     * @param parent Clase frame que invoca a BuscarFrame
     * @param modal Modo del JDialog
     * @param jt JTextArea principal de escritura
     */
    public BuscarFrame(java.awt.Frame parent, boolean modal, javax.swing.JTextArea jt) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);

        jButton1.setEnabled(false);
        jTextField1.addKeyListener(new listenerEscritura(jTextField1, this.jButton1));
        this.jTextArea = jt;
        posCaret = 0;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        check = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Buscar:");

        jButton1.setText("Buscar siguiente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        check.setText("Coincidir mayúsculas y minúsculas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(check))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(check))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Cierra la ventana
     *
     * @param evt Evento de pulsar el un boton
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * Busca la siguiente palabra igual a la escrita
     *
     * @param evt Evento de pulsar el un boton
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        boolean coincidir = check.isSelected();
        String strBusco;
        int posIni;
        if (coincidir) {
            strBusco = jTextField1.getText();
            posIni = this.jTextArea.getText().indexOf(strBusco, posCaret);
        } else {
            strBusco = jTextField1.getText().toLowerCase();
            posIni = this.jTextArea.getText().toLowerCase().indexOf(strBusco, posCaret);
        }
        if (posIni != -1) {
            this.jTextArea.select(posIni, posIni + strBusco.length());
            posCaret = strBusco.length() + posIni;
        } else {
            posCaret = 0;
            if (coincidir) {
                strBusco = jTextField1.getText();
                posIni = this.jTextArea.getText().indexOf(strBusco, posCaret);
            } else {
                strBusco = jTextField1.getText().toLowerCase();
                posIni = this.jTextArea.getText().toLowerCase().indexOf(strBusco, posCaret);
            }
            if (posIni != -1) {
                this.jTextArea.select(posIni, posIni + strBusco.length());
                posCaret = strBusco.length() + posIni;
            } else {
                this.jTextArea.select(0, 0);
                JOptionPane.showMessageDialog(null, "No se encontró '" + strBusco + "'");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox check;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    /**
     * Listener que bloquea o desbloquea el botón de buscar la siguiente
     * coincidencia de la palabra escrita
     */
    private static class listenerEscritura implements KeyListener {

        private final javax.swing.JTextField jTF;
        private final javax.swing.JButton botonSiguiente;

        /**
         * Constructor paramerizado
         *
         * @param jTF JTextField de escriura de la palabra a buscar
         * @param bs Boton de buscar la siguiene palabra
         */
        public listenerEscritura(javax.swing.JTextField jTF, javax.swing.JButton bs) {
            this.jTF = jTF;
            this.botonSiguiente = bs;
        }

        /**
         * Evento de pulsar y soltar una tecla
         *
         * @param ke Evento de tecla
         */
        @Override
        public void keyTyped(KeyEvent ke) {

        }

        /**
         * Evento de pulsar una tecla
         *
         * @param ke Evento de tecla
         */
        @Override
        public void keyPressed(KeyEvent ke) {

        }

        /**
         * Evento de soltar una tecla para desbloquear el boton de buscar
         *
         * @param ke Evento de tecla
         */
        @Override
        public void keyReleased(KeyEvent ke) {
            if (!"".equals(this.jTF.getText())) {
                this.botonSiguiente.setEnabled(true);
            } else {
                this.botonSiguiente.setEnabled(false);
            }
        }
    }
}
