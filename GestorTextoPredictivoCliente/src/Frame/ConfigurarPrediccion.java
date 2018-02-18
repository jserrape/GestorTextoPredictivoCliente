/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import util.Configuracion;
import util.HiloLecturaFicheros;
import util.ProtocoloConexion;

/**
 *
 * @author jcsp0003
 */
public class ConfigurarPrediccion extends javax.swing.JDialog {

    private final ProtocoloConexion protocolo;
    private DefaultTableModel modeloTablaFicheros;
    private DefaultTableModel modeloTablaConjuntos;
    private final InterfazFrame interfaz;
    private final Configuracion config;

    /**
     * Constructor parametrizado de la clase ConfigurarPrediccion
     *
     * @param parent parent Clase frame que invoca a ConfigurarPrediccion
     * @param modal Modo del JDialog
     * @param protocol Objeto con las funciones para comunicarse de con el
     * servidor
     * @param interf Frame principal de escritura
     */
    public ConfigurarPrediccion(java.awt.Frame parent, boolean modal, ProtocoloConexion protocol, InterfazFrame interf, Configuracion conf) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.config = conf;
        setIdiomaInterfaz();

        this.protocolo = protocol;
        this.interfaz = interf;

        configuracionInicial();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jtSemilla = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jMinSemilla = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jtamPrediccion = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        jtManPredicciones = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaConjuntos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setText("Cargar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Eliminar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("DataSet cargado:");

        jTextField1.setEnabled(false);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jButton3.setText("Crear nuevo conjunto");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre del conjunto:");

        jtSemilla.setModel(new javax.swing.SpinnerNumberModel(3, 1, 5, 1));

        jLabel3.setText("Tamaño máximo de la semilla");

        jMinSemilla.setModel(new javax.swing.SpinnerNumberModel(1, 1, 4, 1));

        jLabel4.setText("Tamaño mínimo de la semilla");

        jtamPrediccion.setModel(new javax.swing.SpinnerNumberModel(2, 0, 5, 1));

        jLabel5.setText("Tamaño de la predicción");

        jtManPredicciones.setModel(new javax.swing.SpinnerNumberModel(10, 2, 20, 1));

        jLabel6.setText("Máximo de predicciones");

        jLabel8.setText("Idioma del conjunto");

        tablaConjuntos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tablaConjuntos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(13, 13, 13)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jtManPredicciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtamPrediccion)
                                    .addComponent(jtSemilla)
                                    .addComponent(jMinSemilla, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabel3))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel4))))))
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(38, 38, 38))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtSemilla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jMinSemilla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtamPrediccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtManPredicciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 23, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        jTabbedPane1.addTab("Seleccionar conjunto", jPanel1);

        jButton4.setText("Nuevo fichero");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Nuevo directorio");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Nuevo html");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Borrar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Aceptar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Se debe tener un conjunto de datos cargado para poder añadir documentos.");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton8)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton8)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jButton7))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Añadir documentos", jPanel2);

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
     * Solicitar al servidor eliminar un conjunto de datos seleccionado
     *
     * @param evt Accion del boton
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (this.tablaConjuntos.getSelectedRow() != -1) {
            System.out.println(this.tablaConjuntos.getSelectedRow());
            String lista;
            try {
                lista = this.protocolo.enviarMensaje(3, this.tablaConjuntos.getValueAt(this.tablaConjuntos.getSelectedRow(), 0).toString());
                System.out.println("Lista: " + lista);
                this.modeloTablaConjuntos = new DefaultTableModel();
                this.modeloTablaConjuntos.addColumn(this.config.getPalabra(40));
                this.modeloTablaConjuntos.addColumn(this.config.getPalabra(20));
                this.tablaConjuntos.setModel(modeloTablaConjuntos);
                if (!"".equals(lista)) {
                    System.out.println(lista);
                    if (!"-1".equals(lista)) {
                        lista = lista.substring(1, lista.length() - 1);
                        String[] parts = lista.split(", ");
                        String[] part2;
                        for (String part : parts) {
                            part2 = part.split("#");
                            this.nuevaFilaTablaConjuntos(part2[0], part2[1]);
                        }
                        this.tablaConjuntos.setRowSelectionInterval(0, 0);
                    }
                }
                jTextField1.setText(this.config.getPalabra(62));
                jButton4.setEnabled(false);
                jButton5.setEnabled(false);
                jButton6.setEnabled(false);
                jButton7.setEnabled(false);
                jButton8.setEnabled(false);
                jLabel7.setVisible(true);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Se ha perdido la conexión con el servidor.", "Error de conexion", JOptionPane.ERROR_MESSAGE);
                this.interfaz.errorConexion();
                this.dispose();
                Logger.getLogger(ConfigurarPrediccion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * Solicitar al servidor crear un determinado conjunto de datos
     *
     * @param evt Accion del boton
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int tMax = (int) jtSemilla.getValue();
        int tMin = (int) jMinSemilla.getValue();
        if (tMax < tMin) {
            int aux = tMax;
            tMax = tMin;
            tMin = aux;
        }
        String textoAEnviar = jTextField2.getText() + "#" + jComboBox1.getSelectedItem().toString() + "#" + tMax
                + "#" + tMin + "#" + (int) jtamPrediccion.getValue()
                + "#" + (int) jtManPredicciones.getValue();

        System.out.println("Conjunto a crear:" + textoAEnviar);
        String lista;
        try {
            lista = this.protocolo.enviarMensaje(2, textoAEnviar);

            System.out.println("lista:" + lista);
            this.modeloTablaConjuntos = new DefaultTableModel();
            this.modeloTablaConjuntos.addColumn(this.config.getPalabra(40));
            this.modeloTablaConjuntos.addColumn(this.config.getPalabra(20));
            this.tablaConjuntos.setModel(modeloTablaConjuntos);
            jTextField2.setText("");
            jButton3.setEnabled(false);

            if (!"".equals(lista)) {
                lista = lista.substring(1, lista.length() - 1);
                String[] parts = lista.split(", ");
                String[] part2;
                for (String part : parts) {
                    part2 = part.split("#");
                    this.nuevaFilaTablaConjuntos(part2[0], part2[1]);
                }
                this.tablaConjuntos.setRowSelectionInterval(0, 0);
            }
        } catch (IOException ex) {
            this.interfaz.errorConexion();
            JOptionPane.showMessageDialog(this, "Se ha perdido la conexión con el servidor.", "Error de conexion", JOptionPane.ERROR_MESSAGE);
            this.dispose();
            Logger.getLogger(ConfigurarPrediccion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * Permite seleccionar un fichero
     *
     * @param evt Accion del boton
     */
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        FileNameExtensionFilter filter = new FileNameExtensionFilter(".pdf", "pdf", "text");
        JFileChooser chooser = new JFileChooser();

        chooser.setFileFilter(filter);
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("choosertitle");
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            this.nuevaFilaTablaFicheros("Fichero", chooser.getSelectedFile().toString());
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * Permite seleccionar un directorio
     *
     * @param evt Accion del boton
     */
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        JFileChooser chooser = new JFileChooser();

        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("choosertitle");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            this.nuevaFilaTablaFicheros("Directorio", chooser.getSelectedFile().toString());
        } else {
            System.out.println("No Selection ");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * Permite abrir una ventana de seleccion de url
     *
     * @param evt Accion del boton
     */
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        nuevaURLFrame n = new nuevaURLFrame(this, true, this);
        n.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    /**
     * Elimina una fila seleccionada de la tabla
     *
     * @param evt Accion del boton
     */
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        int filaselecionada = jTable1.getSelectedRow();
        if (filaselecionada >= 0) {
            this.modeloTablaFicheros.removeRow(filaselecionada);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    /**
     * Almacena los diferentes ficheros y los envía al servidor
     *
     * @param evt Accion del boton
     */
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        ArrayList<String> ficheros = new ArrayList();
        ArrayList<String> urls = new ArrayList();
        int index;
        for (int i = 0; i < modeloTablaFicheros.getRowCount(); i++) {
            switch (modeloTablaFicheros.getValueAt(i, 0).toString()) {
                case "Fichero":
                    if (!ficheros.contains(modeloTablaFicheros.getValueAt(i, 1).toString())) {
                        ficheros.add(modeloTablaFicheros.getValueAt(i, 1).toString());
                    }
                    break;
                case "Directorio":
                    File f = new File(modeloTablaFicheros.getValueAt(i, 1).toString());
                    if (f.exists()) {
                        File[] fich = f.listFiles();
                        for (File fich1 : fich) {
                            index = fich1.getName().lastIndexOf('.');
                            if (index != -1) {
                                if (".pdf".equals(fich1.getName().substring(index, fich1.getName().length()).toLowerCase())) {
                                    if (!ficheros.contains(modeloTablaFicheros.getValueAt(i, 1).toString() + "\\" + fich1.getName())) {
                                        ficheros.add(modeloTablaFicheros.getValueAt(i, 1).toString() + "\\" + fich1.getName());
                                    }
                                }
                            }
                        }
                    }
                    break;
                case "URL":
                    urls.add(modeloTablaFicheros.getValueAt(i, 1).toString());
                    break;
            }
        }
        enviarTextos(ficheros, urls);
        this.dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    /**
     * Solicitar al servidor cargar un conjunto de datos seleccionado
     *
     * @param evt Accion del boton
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (this.tablaConjuntos.getSelectedRow() != -1) {
            try {
                jTextField1.setText(this.protocolo.enviarMensaje(5, this.modeloTablaConjuntos.getValueAt(this.tablaConjuntos.getSelectedRow(), 0).toString()));
                jButton4.setEnabled(true);
                jButton5.setEnabled(true);
                jButton6.setEnabled(true);
                jButton7.setEnabled(true);
                jButton8.setEnabled(true);
                jLabel7.setVisible(false);
            } catch (IOException ex) {
                this.interfaz.errorConexion();
                JOptionPane.showMessageDialog(this, "Se ha perdido la conexión con el servidor.", "Error de conexion", JOptionPane.ERROR_MESSAGE);
                this.dispose();
                Logger.getLogger(ConfigurarPrediccion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSpinner jMinSemilla;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JSpinner jtManPredicciones;
    private javax.swing.JSpinner jtSemilla;
    private javax.swing.JSpinner jtamPrediccion;
    private javax.swing.JTable tablaConjuntos;
    // End of variables declaration//GEN-END:variables

    /**
     * Establece el idioma indicado en la configuracion
     */
    private void setIdiomaInterfaz() {
        jTabbedPane1.setTitleAt(0, this.config.getPalabra(45));
        jTabbedPane1.setTitleAt(1, this.config.getPalabra(46));
        jButton1.setText(this.config.getPalabra(47));
        jButton2.setText(this.config.getPalabra(48));
        jLabel1.setText(this.config.getPalabra(49));
        jButton3.setText(this.config.getPalabra(50));
        jLabel2.setText(this.config.getPalabra(51));
        jLabel8.setText(this.config.getPalabra(52));
        jLabel3.setText(this.config.getPalabra(53));
        jLabel4.setText(this.config.getPalabra(54));
        jLabel5.setText(this.config.getPalabra(55));
        jLabel6.setText(this.config.getPalabra(56));
        jLabel7.setText(this.config.getPalabra(57));
        jButton4.setText(this.config.getPalabra(58));
        jButton5.setText(this.config.getPalabra(59));
        jButton6.setText(this.config.getPalabra(60));
        jButton7.setText(this.config.getPalabra(61));
        jButton8.setText(this.config.getPalabra(21));
    }

    /**
     * Configura la interfaz con la lista de conjunttos disponibles en el
     * servidor, el conjunto activo actualmene y bloquea los botones de
     * seleccion.
     */
    private void configuracionInicial() {
        File miDir = new File(".\\idioma");
        File f;
        try {
            f = new File(miDir.getCanonicalPath());
            if (f.exists()) {
                File[] ficheros = f.listFiles();
                for (File fichero : ficheros) {
                    jComboBox1.addItem(fichero.getName());
                }
                jComboBox1.addItem(this.config.getPalabra(63));
            }
        } catch (IOException ex) {
            Logger.getLogger(ConfigurarPrediccion.class.getName()).log(Level.SEVERE, null, ex);
        }

        /////////////////
        /////////////////
        this.modeloTablaConjuntos = new DefaultTableModel();
        this.modeloTablaConjuntos.addColumn(this.config.getPalabra(40));
        this.modeloTablaConjuntos.addColumn(this.config.getPalabra(20));
        this.tablaConjuntos.setModel(modeloTablaConjuntos);

        ///////////////////
        ///////////////////
        modeloTablaFicheros = new DefaultTableModel();
        modeloTablaFicheros.addColumn("Tipo");
        modeloTablaFicheros.addColumn("Dirección");
        this.jTable1.setModel(modeloTablaFicheros);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        this.jTable1.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        TableColumnModel cm = this.jTable1.getColumnModel();
        cm.getColumn(1).setPreferredWidth(450);

        /////////////////////
        /////////////////////
        jButton3.setEnabled(false);
        String cargado;
        try {
            cargado = this.protocolo.enviarMensaje(4, "");
            if ("-1".equals(cargado)) {
                jTextField1.setText(this.config.getPalabra(62));
                jButton4.setEnabled(false);
                jButton5.setEnabled(false);
                jButton6.setEnabled(false);
                jButton7.setEnabled(false);
                jButton8.setEnabled(false);
                jLabel7.setVisible(true);
            } else {
                jTextField1.setText(cargado);
                jLabel7.setVisible(false);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Se ha perdido la conexión con el servidor.", "Error de conexion", JOptionPane.ERROR_MESSAGE);
            this.interfaz.errorConexion();
            this.dispose();
            Logger.getLogger(ConfigurarPrediccion.class.getName()).log(Level.SEVERE, null, ex);
        }

        String lista;
        try {
            lista = this.protocolo.enviarMensaje(1, "");
            if (!"".equals(lista)) {
                for (int i = 0; i < this.modeloTablaConjuntos.getRowCount(); i++) {
                    this.modeloTablaConjuntos.removeRow(i);
                }
                lista = lista.substring(1, lista.length() - 1);
                String[] parts = lista.split(", ");
                String[] part2;
                for (String part : parts) {
                    part2 = part.split("#");
                    this.nuevaFilaTablaConjuntos(part2[0], part2[1]);
                }
                this.tablaConjuntos.setRowSelectionInterval(0, 0);
            }
            this.jTextField2.addKeyListener(new listenerCrearConjunto(this.jTextField2, jButton3));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Se ha perdido la conexión con el servidor.", "Error de conexion", JOptionPane.ERROR_MESSAGE);
            this.interfaz.errorConexion();
            this.dispose();
            Logger.getLogger(ConfigurarPrediccion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Añade una fila a la tabla de ficheros
     *
     * @param tipo "fichero" o "directorio"
     * @param ruta Ruta del documento
     */
    public void nuevaFilaTablaFicheros(String tipo, String ruta) {
        String[] datos = new String[2];
        datos[0] = tipo;
        datos[1] = ruta;
        modeloTablaFicheros.addRow(datos);
    }

    /**
     * Añade una fila a la tabla de conjunos
     *
     * @param nombre Nombre del conjunto
     * @param idioma Idioma del conjunto
     */
    public void nuevaFilaTablaConjuntos(String nombre, String idioma) {
        String[] datos = new String[2];
        datos[0] = nombre;
        datos[1] = idioma;
        this.modeloTablaConjuntos.addRow(datos);
    }

    /**
     * Envía los ficheros a un hilo de lectura para transmitirselos al servidor
     *
     * @param ficheros Direcciones de los ficheros
     * @param urls Direcciones web
     */
    private void enviarTextos(ArrayList<String> ficheros, ArrayList<String> urls) {
        if (!ficheros.isEmpty() || !urls.isEmpty()) {
            HiloLecturaFicheros hilo = new HiloLecturaFicheros(this.protocolo, ficheros, urls);
            Thread th = new Thread(hilo);
            th.start();
        }
    }

    /**
     * Listener que evita el uso ciertos caracteres en el nombre de los
     * conjuntos y desbloquea el botón de crear conjunto
     */
    private static class listenerCrearConjunto implements KeyListener {

        private final JTextField jt;
        private final JButton boton;

        /**
         * Consructor parametrizado
         *
         * @param jt JTextField de escritura del nombre del conjunto
         * @param bot Boton para crear el conjunto
         */
        public listenerCrearConjunto(JTextField jt, JButton bot) {
            this.jt = jt;
            this.boton = bot;
        }

        /**
         * Evento de pulsar y soltar una tecla
         *
         * @param ke Evento de tecla
         */
        @Override
        public void keyTyped(KeyEvent e) {
            if (e.getKeyChar() == '~' || e.getKeyChar() == '\\' || e.getKeyChar() == '/'
                    || e.getKeyChar() == ':' || e.getKeyChar() == '*' || e.getKeyChar() == '?'
                    || e.getKeyChar() == '"' || e.getKeyChar() == '<' || e.getKeyChar() == '>'
                    || e.getKeyChar() == '|' || e.getKeyChar() == '#') {
                e.consume();
            }
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
         * Evento de soltar una tecla
         *
         * @param ke Evento de tecla
         */
        @Override
        public void keyReleased(KeyEvent e) {
            if (!"".equals(this.jt.getText())) {
                this.boton.setEnabled(true);
            } else {
                this.boton.setEnabled(false);
            }
        }
    }

}
