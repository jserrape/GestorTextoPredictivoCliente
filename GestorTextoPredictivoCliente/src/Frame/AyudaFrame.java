/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import javax.swing.ImageIcon;
import util.Configuracion;

/**
 *
 * @author jcsp0003
 */
public class AyudaFrame extends javax.swing.JDialog {

    private int imagenAyuda;
    private final Configuracion config;

    /**
     * Creates new form AyudaFrame
     *
     * @param parent Clase frame que invoca a AyudaFrame
     * @param modal Modo del JDialog
     * @param conf Configuración con las cadenas de texto del idioma
     */
    public AyudaFrame(java.awt.Frame parent, boolean modal, Configuracion conf) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.config = conf;
        this.jButton1.setText(this.config.getPalabra(86));
        this.jButton2.setText(this.config.getPalabra(87));
        this.jButton2.setText(this.config.getPalabra(21));
        this.jTextArea1.setWrapStyleWord(true);
        this.setTitle(this.config.getPalabra(67));
        ayuda1();
        imagenAyuda = 1;
        jButton1.setEnabled(false);
        ImageIcon icon = new ImageIcon(this.getClass().getResource("/ayuda/ayuda1.png"));
        this.jLabel1.setIcon(icon);
    }

    /**
     * Mensajes a mostrar para la vista de ayuda 1
     */
    private void ayuda1() {
        jTextArea1.setText(this.config.getPalabra(68));
        jTextArea1.append("\n\n" + this.config.getPalabra(69));
        jTextArea1.append("\n\n" + this.config.getPalabra(70));
        jTextArea1.append("\n\n" + this.config.getPalabra(71));
    }

    /**
     * Mensajes a mostrar para la vista de ayuda 2
     */
    private void ayuda2() {
        jTextArea1.setText(this.config.getPalabra(72));
        jTextArea1.append("\n\n" + this.config.getPalabra(73));
        jTextArea1.append("\n\n" + this.config.getPalabra(74));
        jTextArea1.append("\n\n" + this.config.getPalabra(75));
        jTextArea1.append("\n\n" + this.config.getPalabra(76));
    }

    /**
     * Mensajes a mostrar para la vista de ayuda 3
     */
    private void ayuda3() {
        jTextArea1.setText(this.config.getPalabra(77));
        jTextArea1.append("\n\n" + this.config.getPalabra(78));
        jTextArea1.append("\n\n" + this.config.getPalabra(79));
        jTextArea1.append("\n\n" + this.config.getPalabra(80));
    }

    /**
     * Muestra la siguiente vista de ayuda
     */
    private void siguiente() {
        if (imagenAyuda < 3) {
            ++imagenAyuda;
            ImageIcon icon = new ImageIcon(this.getClass().getResource("/ayuda/ayuda" + imagenAyuda + ".png"));
            this.jLabel1.setIcon(icon);
            jButton1.setEnabled(true);
            if (imagenAyuda == 1) {
                ayuda1();
            }
            if (imagenAyuda == 2) {
                ayuda2();
            }
            if (imagenAyuda == 3) {
                ayuda3();
                jButton2.setEnabled(false);
            }
        }
    }

    /**
     * Muestra la vista de ayuda anterior
     */
    private void anterior() {
        if (imagenAyuda > 1) {
            --imagenAyuda;
            ImageIcon icon = new ImageIcon(this.getClass().getResource("/ayuda/ayuda" + imagenAyuda + ".png"));
            this.jLabel1.setIcon(icon);
            jButton2.setEnabled(true);
            if (imagenAyuda == 1) {
                ayuda1();
                jButton1.setEnabled(false);
            }
            if (imagenAyuda == 2) {
                ayuda2();
            }
            if (imagenAyuda == 3) {
                ayuda3();
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setText("Anterior");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Siguiente");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Aceptar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setOpaque(false);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Botón para mostrar la ayuda siguiente
     * @param evt Evento de pulsar el botón
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        siguiente();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * Botón para cerrar la vista
     * @param evt Evento de pulsar el botón
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * Botón para mostrar la ayuda anterior
     * @param evt Evento de pulsar el botón
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        anterior();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
