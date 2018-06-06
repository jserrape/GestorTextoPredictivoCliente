/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import java.awt.Component;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JPopupMenu.Separator;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.UndoableEditEvent;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import javax.swing.undo.UndoManager;
import util.Configuracion;
import util.PopUpMenu;
import util.Posicion;
import util.ProtocoloConexion;

/**
 *
 * @author jcsp0003
 */
public class InterfazFrame extends javax.swing.JFrame {

    private Font font;
    private Configuracion config;
    private ProtocoloConexion protocolo;
    private PopUpMenu popUp;

    private UndoManager undo;

    private boolean registrado;

    /**
     * Construcor por defecto
     *
     * @throws javax.swing.text.BadLocationException Ubicación incorrecta dentro
     * de un modelo de documento
     * @throws java.io.FileNotFoundException Intento de abrir el archivo
     * denotado por un nombre de ruta especificado ha fallado.
     */
    public InterfazFrame() throws BadLocationException, FileNotFoundException {
        initComponents();
        setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/iconos/icono.png")));
        inicializar("-1");
        addWindowListener(new listenerCerrarVentana(protocolo, this.config));
    }

    /**
     * Construcor parametrizado
     *
     * @param ip Ip del servidor
     * @throws javax.swing.text.BadLocationException Ubicación incorrecta dentro
     * de un modelo de documento
     * @throws java.io.FileNotFoundException Intento de abrir el archivo
     * denotado por un nombre de ruta especificado ha fallado.
     */
    public InterfazFrame(String ip) throws BadLocationException, FileNotFoundException {
        initComponents();
        setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/iconos/icono.png")));
        inicializar(ip);
        addWindowListener(new listenerCerrarVentana(protocolo, this.config));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jToolBar1 = new javax.swing.JToolBar();
        botonNuevo = new javax.swing.JButton();
        botonAbrir = new javax.swing.JButton();
        botonGuardar = new javax.swing.JButton();
        botonGuardarComo = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        botonCortar = new javax.swing.JButton();
        botonCopiar = new javax.swing.JButton();
        botonPegar = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        botonDeshacer = new javax.swing.JButton();
        botonRehacer = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        botonError = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemNuevo = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        itemGuardar = new javax.swing.JMenuItem();
        ItemGuardarComo = new javax.swing.JMenuItem();
        separadorSesion = new javax.swing.JPopupMenu.Separator();
        itemCerrarSesion = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        itemDeshacer = new javax.swing.JMenuItem();
        itemRehacer = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        itemCortar = new javax.swing.JMenuItem();
        itemCopiar = new javax.swing.JMenuItem();
        itemPegar = new javax.swing.JMenuItem();
        itemEliminar = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        itemBuscar = new javax.swing.JMenuItem();
        itemReemplazar = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        itemSeleccionarTodo = new javax.swing.JMenuItem();
        itemFechaHora = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        botonNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/nuevo.gif"))); // NOI18N
        botonNuevo.setFocusable(false);
        botonNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevoActionPerformed(evt);
            }
        });
        jToolBar1.add(botonNuevo);

        botonAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/abrir.gif"))); // NOI18N
        botonAbrir.setFocusable(false);
        botonAbrir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonAbrir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAbrirActionPerformed(evt);
            }
        });
        jToolBar1.add(botonAbrir);

        botonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/guardar.gif"))); // NOI18N
        botonGuardar.setFocusable(false);
        botonGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(botonGuardar);

        botonGuardarComo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/guardarComo.gif"))); // NOI18N
        botonGuardarComo.setFocusable(false);
        botonGuardarComo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonGuardarComo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonGuardarComo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarComoActionPerformed(evt);
            }
        });
        jToolBar1.add(botonGuardarComo);
        jToolBar1.add(jSeparator6);

        botonCortar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/cortar.png"))); // NOI18N
        botonCortar.setFocusable(false);
        botonCortar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonCortar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonCortar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCortarActionPerformed(evt);
            }
        });
        jToolBar1.add(botonCortar);

        botonCopiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/copiar.png"))); // NOI18N
        botonCopiar.setFocusable(false);
        botonCopiar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonCopiar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonCopiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCopiarActionPerformed(evt);
            }
        });
        jToolBar1.add(botonCopiar);

        botonPegar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/pegar.png"))); // NOI18N
        botonPegar.setFocusable(false);
        botonPegar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonPegar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonPegar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPegarActionPerformed(evt);
            }
        });
        jToolBar1.add(botonPegar);
        jToolBar1.add(jSeparator7);

        botonDeshacer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/deshacer.png"))); // NOI18N
        botonDeshacer.setFocusable(false);
        botonDeshacer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonDeshacer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(botonDeshacer);

        botonRehacer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/rehacer.png"))); // NOI18N
        botonRehacer.setFocusable(false);
        botonRehacer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonRehacer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(botonRehacer);
        jToolBar1.add(jSeparator8);

        botonError.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/advertencia.png"))); // NOI18N
        botonError.setFocusable(false);
        botonError.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonError.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonError.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonErrorActionPerformed(evt);
            }
        });
        jToolBar1.add(botonError);

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
        );

        jMenu1.setText("Archivo");

        jMenuItemNuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/nuevo.gif"))); // NOI18N
        jMenuItemNuevo.setText("Nuevo");
        jMenuItemNuevo.setToolTipText("");
        jMenuItemNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemNuevoActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemNuevo);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/abrir.gif"))); // NOI18N
        jMenuItem2.setText("Abrir...");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        itemGuardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        itemGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/guardar.gif"))); // NOI18N
        itemGuardar.setText("Guardar");
        jMenu1.add(itemGuardar);

        ItemGuardarComo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/guardarComo.gif"))); // NOI18N
        ItemGuardarComo.setText("Guardar como...");
        ItemGuardarComo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemGuardarComoActionPerformed(evt);
            }
        });
        jMenu1.add(ItemGuardarComo);
        jMenu1.add(separadorSesion);

        itemCerrarSesion.setText("Cerrar sesión");
        itemCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCerrarSesionActionPerformed(evt);
            }
        });
        jMenu1.add(itemCerrarSesion);
        jMenu1.add(jSeparator1);

        jMenuItem5.setText("Salir");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Editar");

        itemDeshacer.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        itemDeshacer.setText("Deshacer");
        jMenu2.add(itemDeshacer);

        itemRehacer.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        itemRehacer.setText("Rehacer");
        jMenu2.add(itemRehacer);
        jMenu2.add(jSeparator2);

        itemCortar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        itemCortar.setText("Cortar");
        itemCortar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCortarActionPerformed(evt);
            }
        });
        jMenu2.add(itemCortar);

        itemCopiar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        itemCopiar.setText("Copiar");
        itemCopiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCopiarActionPerformed(evt);
            }
        });
        jMenu2.add(itemCopiar);

        itemPegar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        itemPegar.setText("Pegar");
        itemPegar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPegarActionPerformed(evt);
            }
        });
        jMenu2.add(itemPegar);

        itemEliminar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
        itemEliminar.setText("Eliminar");
        itemEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEliminarActionPerformed(evt);
            }
        });
        jMenu2.add(itemEliminar);
        jMenu2.add(jSeparator3);

        itemBuscar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        itemBuscar.setText("Buscar...");
        itemBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemBuscarActionPerformed(evt);
            }
        });
        jMenu2.add(itemBuscar);

        itemReemplazar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        itemReemplazar.setText("Reemplazar");
        itemReemplazar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemReemplazarActionPerformed(evt);
            }
        });
        jMenu2.add(itemReemplazar);
        jMenu2.add(jSeparator4);

        itemSeleccionarTodo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        itemSeleccionarTodo.setText("Seleccionar todo");
        itemSeleccionarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSeleccionarTodoActionPerformed(evt);
            }
        });
        jMenu2.add(itemSeleccionarTodo);

        itemFechaHora.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        itemFechaHora.setText("Hora y fecha");
        itemFechaHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemFechaHoraActionPerformed(evt);
            }
        });
        jMenu2.add(itemFechaHora);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Ajustes");

        jMenuItem17.setText("Formato");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem17);

        jMenuItem18.setText("Predicción");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem18);

        jMenuItem19.setText("Idioma");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem19);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Ayuda");

        jMenuItem1.setText("Ver la ayuda");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem1);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Botón para pegar el texto copiado en la jTextArea de escritura principal
     *
     * @param evt Evento de pulsar el un boton
     */
    private void itemPegarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPegarActionPerformed
        this.jTextArea1.paste();
    }//GEN-LAST:event_itemPegarActionPerformed

    /**
     * Botón para 'Guardar como' lo escrito
     *
     * @param evt Evento de pulsar el un boton
     */
    private void ItemGuardarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemGuardarComoActionPerformed
        FileChooserFrame fc = new FileChooserFrame(this, true, this.jTextArea1, 3);
        fc.setVisible(true);
    }//GEN-LAST:event_ItemGuardarComoActionPerformed

    /**
     * Botón para reiniciar el texto de la jTextArea de escritura principal
     *
     * @param evt Evento de pulsar el un boton
     */
    private void jMenuItemNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemNuevoActionPerformed
        jTextArea1.setText("");
    }//GEN-LAST:event_jMenuItemNuevoActionPerformed

    /**
     * Boton para desconectarse del servidor y cerrar la aplicación
     *
     * @param evt Evento de pulsar el un boton
     */
    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        int result = JOptionPane.showConfirmDialog((Component) null, "¿Desea cerrar la aplicación?", "", JOptionPane.OK_CANCEL_OPTION);
        if (result == 0) {
            try {
                this.protocolo.enviarMensaje(0, "");
                this.dispose();
            } catch (IOException ex) {
                this.errorConexion();
                JOptionPane.showMessageDialog(this, this.config.getPalabra(84), this.config.getPalabra(85), JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(InterfazFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    /**
     * Botón de apertura del frame Formato
     *
     * @param evt Evento de pulsar el un boton
     */
    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        FormatoFrame ff = new FormatoFrame(this, true, font, this, this.config);
        ff.setVisible(true);
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    /**
     * Botón de apertura del frame de registro o de configuración de la
     * predicción
     *
     * @param evt Evento de pulsar el un boton
     */
    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        if (registrado) {
            ConfigurarPrediccion conf = new ConfigurarPrediccion(this, true, this.protocolo, this, this.config);
            conf.setVisible(true);
        } else {
            LoginFrame log = new LoginFrame(this, true, this.protocolo, this, this.config);
            log.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    /**
     * Botón de apertura del frame de selección de idioma
     *
     * @param evt Evento de pulsar el un boton
     */
    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        try {
            IdiomaFrame id = new IdiomaFrame(this, false, this.config, this);
            id.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(InterfazFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    /**
     * Botón para cortar el texto seleccionado en el jTextArea de escritura
     * principal
     *
     * @param evt Evento de pulsar el un boton
     */
    private void botonCortarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCortarActionPerformed
        this.jTextArea1.cut();
    }//GEN-LAST:event_botonCortarActionPerformed

    /**
     * Botón para copiar el texto seleccionado en el jTextArea de escritura
     * principal
     *
     * @param evt Evento de pulsar el un boton
     */
    private void botonCopiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCopiarActionPerformed
        this.jTextArea1.copy();
    }//GEN-LAST:event_botonCopiarActionPerformed

    /**
     * Botón para pegar el texto copiado en el jTextArea de escritura principal
     *
     * @param evt Evento de pulsar el un boton
     */
    private void botonPegarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPegarActionPerformed
        this.jTextArea1.paste();
    }//GEN-LAST:event_botonPegarActionPerformed

    /**
     * Botón para eliminar el texo escrito en el jTextArea de escritura
     * principal
     *
     * @param evt Evento de pulsar el un boton
     */
    private void botonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevoActionPerformed
        this.jTextArea1.setText("");
    }//GEN-LAST:event_botonNuevoActionPerformed

    /**
     * Botón para cortar el texto seleccionado en el jTextArea de escritura
     * principal
     *
     * @param evt Evento de pulsar el un boton
     */
    private void itemCortarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCortarActionPerformed
        this.jTextArea1.cut();
    }//GEN-LAST:event_itemCortarActionPerformed

    /**
     * Botón para cortar el texto seleccionado en el jTextArea de escritura
     * principal
     *
     * @param evt Evento de pulsar el un boton
     */
    private void itemCopiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCopiarActionPerformed
        this.jTextArea1.copy();
    }//GEN-LAST:event_itemCopiarActionPerformed

    /**
     * Botón para eliminar el texto seleccionado en el jTextArea de escritura
     * principal
     *
     * @param evt Evento de pulsar el un boton
     */
    private void itemEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEliminarActionPerformed
        if (this.jTextArea1.getSelectionStart() != this.jTextArea1.getSelectionEnd()) {
            this.jTextArea1.setText(jTextArea1.getText().substring(0, this.jTextArea1.getSelectionStart())
                    + jTextArea1.getText().substring(this.jTextArea1.getSelectionEnd(), jTextArea1.getText().length()));
        }
    }//GEN-LAST:event_itemEliminarActionPerformed

    /**
     * Botón para escribir la fecha y hora actual en el jTextArea de escritura
     * principal
     *
     * @param evt Evento de pulsar el un boton
     */
    private void itemFechaHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemFechaHoraActionPerformed
        Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("HH:mm dd/MM/yyyy");
        StringBuilder sb = new StringBuilder(this.jTextArea1.getText());
        sb.insert(this.jTextArea1.getCaretPosition(), hourdateFormat.format(date));
        this.jTextArea1.setText(sb.toString());
    }//GEN-LAST:event_itemFechaHoraActionPerformed

    /**
     * Botón para seleccionar todo el texto de la jTextArea de escritura
     * principal
     *
     * @param evt Evento de pulsar el un boton
     */
    private void itemSeleccionarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSeleccionarTodoActionPerformed
        this.jTextArea1.selectAll();
    }//GEN-LAST:event_itemSeleccionarTodoActionPerformed

    /**
     * Botón para abrir frame Buscar
     *
     * @param evt Evento de pulsar el un boton
     */
    private void itemBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemBuscarActionPerformed
        BuscarFrame buscar = new BuscarFrame(this, true, this.jTextArea1, this.config);
        buscar.setVisible(true);
    }//GEN-LAST:event_itemBuscarActionPerformed

    /**
     * Botón para abrir frame Reemplazar
     *
     * @param evt Evento de pulsar el un boton
     */
    private void itemReemplazarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemReemplazarActionPerformed
        ReemplazarFrame ree = new ReemplazarFrame(this, true, this.jTextArea1);
        ree.setVisible(true);
    }//GEN-LAST:event_itemReemplazarActionPerformed

    /**
     * Botón para 'Guardar como' lo escrito
     *
     * @param evt Evento de pulsar el un boton
     */
    private void botonGuardarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarComoActionPerformed
        FileChooserFrame fc = new FileChooserFrame(this, true, this.jTextArea1, 3);
        fc.setVisible(true);
    }//GEN-LAST:event_botonGuardarComoActionPerformed

    /**
     * Botón para seleccionar un fichero de texto y abrirlo
     *
     * @param evt Evento de pulsar el un boton
     */
    private void botonAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAbrirActionPerformed
        FileChooserFrame fc = new FileChooserFrame(this, true, this.jTextArea1, 1);
        fc.setVisible(true);
    }//GEN-LAST:event_botonAbrirActionPerformed

    /**
     * Botón para seleccionar un fichero de texto y abrirlo
     *
     * @param evt Evento de pulsar el un boton
     */
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        FileChooserFrame fc = new FileChooserFrame(this, true, this.jTextArea1, 1);
        fc.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    /**
     * Boton para conecar con el servidor
     *
     * @param evt Evento de pulsar el un boton
     */
    private void botonErrorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonErrorActionPerformed
        this.config.conectar();
    }//GEN-LAST:event_botonErrorActionPerformed

    /**
     * Boton para cerrar la sesión
     *
     * @param evt Evento de pulsar el un boton
     */
    private void itemCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCerrarSesionActionPerformed
        int result = JOptionPane.showConfirmDialog((Component) null, "¿Desea cerrar sesión?", "alert", JOptionPane.OK_CANCEL_OPTION);
        if (result == 0) {
            this.registrado = false;
            itemCerrarSesion.setVisible(false);
            separadorSesion.setVisible(false);
        }
    }//GEN-LAST:event_itemCerrarSesionActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        AyudaFrame ayuda = new AyudaFrame(this, true, this.config);
        ayuda.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ItemGuardarComo;
    private javax.swing.JButton botonAbrir;
    private javax.swing.JButton botonCopiar;
    private javax.swing.JButton botonCortar;
    private javax.swing.JButton botonDeshacer;
    private javax.swing.JButton botonError;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonGuardarComo;
    private javax.swing.JButton botonNuevo;
    private javax.swing.JButton botonPegar;
    private javax.swing.JButton botonRehacer;
    private javax.swing.JMenuItem itemBuscar;
    private javax.swing.JMenuItem itemCerrarSesion;
    private javax.swing.JMenuItem itemCopiar;
    private javax.swing.JMenuItem itemCortar;
    private javax.swing.JMenuItem itemDeshacer;
    private javax.swing.JMenuItem itemEliminar;
    private javax.swing.JMenuItem itemFechaHora;
    private javax.swing.JMenuItem itemGuardar;
    private javax.swing.JMenuItem itemPegar;
    private javax.swing.JMenuItem itemReemplazar;
    private javax.swing.JMenuItem itemRehacer;
    private javax.swing.JMenuItem itemSeleccionarTodo;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItemNuevo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPopupMenu.Separator separadorSesion;
    // End of variables declaration//GEN-END:variables

    /**
     * Aplica una fuente al area de exto
     *
     * @param f Nueva fuente
     */
    public void aplicarFormato(Font f) {
        this.font = f;
        this.jTextArea1.setFont(font);
    }

    /**
     * Funcion de haber introducido usuario con conraseña correctos
     */
    public void logear() {
        this.registrado = true;
        itemCerrarSesion.setVisible(true);
        separadorSesion.setVisible(true);
    }

    /**
     * Funcion para cerrar sesion
     */
    public void deslogear() {
        this.registrado = false;
        itemCerrarSesion.setVisible(false);
        separadorSesion.setVisible(false);
    }

    /**
     * Función de haber establecido conexión con el servidor
     */
    public void conexionCorrecta() {
        botonError.setVisible(false);
        jMenuItem18.setEnabled(true);
    }

    /**
     * Función de haber producido un error en la conexión con el servidor
     */
    public void errorConexion() {
        botonError.setVisible(true);
        jMenuItem18.setEnabled(false);
        itemCerrarSesion.setVisible(false);
        separadorSesion.setVisible(false);
    }

    /**
     * Inicializa las variables a sus estados iniciales
     */
    private void inicializar(String ip) {
        itemCerrarSesion.setVisible(false);
        separadorSesion.setVisible(false);
        botonError.setVisible(false);
        jMenuItem18.setEnabled(true);
        config = new Configuracion(this, ip);
        setIdiomaInterfaz();
        registrado = false;
        protocolo = new ProtocoloConexion(config);

        font = new Font("Arial", Font.PLAIN, 20);
        this.jTextArea1.setFont(font);

        this.popUp = new PopUpMenu(this.jPopupMenu1, this.jTextArea1);

        Posicion posi = new Posicion();

        this.jTextArea1.addKeyListener(new listenerEscritura(this.popUp, posi, this.jTextArea1, this.protocolo, botonError, itemCerrarSesion, separadorSesion));
        this.jTextArea1.addCaretListener(new listenerCaret(this.jTextArea1, posi));
        this.jTextArea1.addMouseListener(new listenerPopUpCopiarPegar(this.jPopupMenu2, this.jTextArea1));

        //Para rehacer y deshacer
        undo = new UndoManager();
        botonDeshacer.setEnabled(false);
        botonRehacer.setEnabled(false);
        itemDeshacer.setEnabled(false);
        itemRehacer.setEnabled(false);

        this.jTextArea1.getDocument().addUndoableEditListener((UndoableEditEvent uee) -> {
            undo.addEdit(uee.getEdit());
            actualizarBotones();
        });

        botonDeshacer.addActionListener((ActionEvent ae) -> {
            undo.undo();
            actualizarBotones();
        });
        itemDeshacer.addActionListener((ActionEvent ae) -> {
            undo.undo();
            actualizarBotones();
        });

        botonRehacer.addActionListener((ActionEvent ae) -> {
            undo.redo();
            actualizarBotones();
        });
        itemRehacer.addActionListener((ActionEvent ae) -> {
            undo.redo();
            actualizarBotones();
        });

        //Aumentar tamaño de la fuente
        Font f = jMenu1.getFont();
        Font ff = new Font(f.getFontName(), Font.PLAIN, f.getSize() + 1);
        jMenu1.setFont(ff);
        jMenu2.setFont(ff);
        jMenu3.setFont(ff);
        jMenu4.setFont(ff);

        botonNuevo.setFont(ff);
        botonAbrir.setFont(ff);
        botonGuardar.setFont(ff);
        botonGuardarComo.setFont(ff);
        botonCortar.setFont(ff);
        botonCopiar.setFont(ff);
        botonPegar.setFont(ff);
        botonDeshacer.setFont(ff);
        botonRehacer.setFont(ff);
        jMenuBar1.setFont(ff);
        jMenuItemNuevo.setFont(ff);
        jMenuItem2.setFont(ff);
        itemGuardar.setFont(ff);
        ItemGuardarComo.setFont(ff);
        jMenuItem5.setFont(ff);
        itemDeshacer.setFont(ff);
        itemRehacer.setFont(ff);
        itemCortar.setFont(ff);
        itemCopiar.setFont(ff);
        itemPegar.setFont(ff);
        itemEliminar.setFont(ff);
        itemBuscar.setFont(ff);
        itemReemplazar.setFont(ff);
        itemSeleccionarTodo.setFont(ff);
        itemFechaHora.setFont(ff);
        jMenuItem17.setFont(ff);
        jMenuItem18.setFont(ff);
        jMenuItem19.setFont(ff);
        jMenuItem1.setFont(ff);
    }

    /**
     * Establece a los elemenos el idioma indicado en la configuracion
     */
    public void setIdiomaInterfaz() {
        jMenu1.setText(this.config.getPalabra(0));
        jMenu2.setText(this.config.getPalabra(1));
        jMenu3.setText(this.config.getPalabra(2));
        jMenu4.setText(this.config.getPalabra(3));
        jMenuItemNuevo.setText(this.config.getPalabra(4));
        jMenuItem2.setText(this.config.getPalabra(5));
        itemGuardar.setText(this.config.getPalabra(6));
        ItemGuardarComo.setText(this.config.getPalabra(7));
        jMenuItem5.setText(this.config.getPalabra(8));
        itemDeshacer.setText(this.config.getPalabra(9));
        itemCortar.setText(this.config.getPalabra(10));
        itemCopiar.setText(this.config.getPalabra(11));
        itemPegar.setText(this.config.getPalabra(12));
        itemEliminar.setText(this.config.getPalabra(13));
        itemBuscar.setText(this.config.getPalabra(14));
        itemReemplazar.setText(this.config.getPalabra(15));
        itemSeleccionarTodo.setText(this.config.getPalabra(16));
        itemFechaHora.setText(this.config.getPalabra(17));
        jMenuItem17.setText(this.config.getPalabra(18));
        jMenuItem18.setText(this.config.getPalabra(19));
        jMenuItem19.setText(this.config.getPalabra(20));
        jMenuItem1.setText(this.config.getPalabra(67));
        this.setTitle(this.config.getPalabra(34));
    }

    /**
     * Actualiza los botones de deshacer y rehacer al escribir
     */
    private void actualizarBotones() {
        botonDeshacer.setEnabled(this.undo.canUndo());
        botonRehacer.setEnabled(this.undo.canRedo());
        itemDeshacer.setEnabled(this.undo.canUndo());
        itemRehacer.setEnabled(this.undo.canRedo());
    }

    /**
     * Lisener de escriura en el area de texto
     */
    private static class listenerEscritura implements KeyListener {

        private final PopUpMenu popMenu;
        private final Posicion pos;
        private final JTextArea jt;
        private final ProtocoloConexion protocolo;
        private final JButton botonError;
        private final JMenuItem itemCerrarSesion;
        private final Separator separadorSesion;

        /**
         * Construcor paramerizado
         *
         * @param pop PopUpMenu de sugerencias
         * @param p Objeo posición del caret
         * @param jt Area de texo sobre la que se escribe
         * @param prot Proocolo de conexion
         */
        public listenerEscritura(PopUpMenu pop, Posicion p, JTextArea jt, ProtocoloConexion prot, JButton botonError, JMenuItem itemCerrarSesion, Separator separadorSesion) {
            this.popMenu = pop;
            this.pos = p;
            this.jt = jt;
            this.protocolo = prot;
            this.botonError = botonError;
            this.itemCerrarSesion = itemCerrarSesion;
            this.separadorSesion = separadorSesion;
        }

        /**
         * Evento de pulsar y soltar una tecla que hace desaparecer el PopUpMenu
         *
         * @param ke Evento de tecla
         */
        @Override
        public void keyTyped(KeyEvent ke) {
            this.popMenu.desaparecer();
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
         * Evento de soltar una tecla que solicia la prediccion
         *
         * @param ke Evento de tecla
         */
        @Override
        public void keyReleased(KeyEvent ke) {
            if (ke.getKeyCode() == 40 || ke.getKeyCode() == 38) {
                this.popMenu.darFoco();
            } else {
                //Borrar
                if (ke.getKeyCode() == 8 || ke.getKeyCode() == 127) {
                    this.popMenu.desaparecer();
                    return;
                }
                //Movimiento lateral
                if (ke.getKeyCode() == 37 || ke.getKeyCode() == 39) {
                    this.popMenu.desaparecer();
                    return;
                }
                //No hay nada
                if ("".equals(this.jt.getText().replaceAll("\n", ""))) {
                    return;
                }

                int caracteresAnteriores = 0;
                if (this.jt.getCaretPosition() - 60 >= 0) {
                    caracteresAnteriores = this.jt.getCaretPosition() - 60;
                }
                String texto = this.jt.getText().substring(caracteresAnteriores, this.jt.getCaretPosition());

                boolean acabado = false;
                if (this.jt.getCaretPosition() != 0) {
                    acabado = this.jt.getText().charAt(this.jt.getText().length() - 1) == ' ';
                }

                try {
                    String srtResultado;

                    if (acabado) {
                        srtResultado = this.protocolo.enviarMensaje(7, 1 + texto.toLowerCase());
                    } else {
                        srtResultado = this.protocolo.enviarMensaje(7, 0 + texto.toLowerCase());
                    }

                    if (srtResultado.length() > 2) {
                        srtResultado = srtResultado.substring(1, srtResultado.length() - 1);
                        this.popMenu.mostrar(ke, this.pos.getX(), this.pos.getY(), srtResultado);
                    } else {
                        this.popMenu.desaparecer();
                    }
                } catch (IOException ex) {
                    errorConexion();
                    Logger.getLogger(InterfazFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        /**
         * Función de haber producido un error en la conexión con el servidor
         */
        public void errorConexion() {
            botonError.setVisible(true);
            itemCerrarSesion.setVisible(false);
            separadorSesion.setVisible(false);
        }
    }

    /**
     * Listener de cambio de posición del caret
     */
    private class listenerCaret implements CaretListener {

        private final JTextArea jt;
        private final Posicion pos;

        /**
         * Consrucor paramerizado
         *
         * @param jt Area de texto
         * @param pos Posicion del care
         */
        listenerCaret(JTextArea jt, Posicion pos) {
            this.jt = jt;
            this.pos = pos;
        }

        /**
         * Evento que almacena la nueva posición del care al cambiar.
         *
         * @param e Evento del caret
         */
        @Override
        public void caretUpdate(CaretEvent e) {
            JTextComponent textComp = (JTextComponent) e.getSource();
            try {
                if ("".equals(this.jt.getText().replaceAll("\n", ""))) {
                    return;
                }

                Rectangle rect = textComp.getUI().modelToView(textComp, e.getDot());
                String posiciones = rect.toString();
                String[] posArr = posiciones.substring(rect.toString().indexOf("[") + 1, rect.toString().length() - 1).split(",");

                int x = Integer.parseInt(posArr[0].substring(2, posArr[0].length()));
                int y = Integer.parseInt(posArr[1].substring(2, posArr[1].length())) + Integer.parseInt(posArr[3].substring(7, posArr[3].length()));
                pos.setX(x);
                pos.setY(y);
            } catch (BadLocationException ex) {
                throw new RuntimeException("Failed to get pixel position of caret", ex);
            }
        }
    }

    /**
     * Lisener para detectar si se hace click derecho sobre el area de texto y
     * desplegar un popup menu con los items cortar, copiar y pegar
     */
    private static class listenerPopUpCopiarPegar implements MouseListener {

        private final JPopupMenu popMenu;
        private final javax.swing.JTextArea jTextArea;

        public listenerPopUpCopiarPegar(JPopupMenu pop, javax.swing.JTextArea jT) {
            this.popMenu = pop;
            this.jTextArea = jT;
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
                item.addActionListener(new ActionListenerImpl(jTextArea, 1));

                item = new JMenuItem("Copiar");
                this.popMenu.add(item);
                item.addActionListener(new ActionListenerImpl(jTextArea, 2));

                item = new JMenuItem("Pegar");
                this.popMenu.add(item);
                item.addActionListener(new ActionListenerImpl(jTextArea, 3));

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

            private final javax.swing.JTextArea jTextArea;
            private final int valor;

            /**
             * Consrucor parametrizado
             *
             * @param jT Caja de texto de la url
             * @param valor
             */
            public ActionListenerImpl(javax.swing.JTextArea jT, int valor) {
                this.jTextArea = jT;
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
                        this.jTextArea.cut();
                        break;
                    case 2: //Copiar
                        this.jTextArea.copy();
                        break;
                    case 3: //Pegar
                        this.jTextArea.paste();
                        break;
                }
            }
        }
    }

    /**
     * Lisener para cerrar la conexión con el servidor al cerrar la ventana
     */
    private static class listenerCerrarVentana extends WindowAdapter {

        private final ProtocoloConexion protocolo;
        private final Configuracion config;

        public listenerCerrarVentana(ProtocoloConexion protocolo, Configuracion conf) {
            this.protocolo = protocolo;
            this.config = conf;
        }

        @Override
        public void windowClosing(java.awt.event.WindowEvent evt) {
            UIManager.put("OptionPane.okButtonText", this.config.getPalabra(21));
            UIManager.put("OptionPane.cancelButtonText", this.config.getPalabra(22));

            int result = JOptionPane.showConfirmDialog((Component) null, this.config.getPalabra(81), "", JOptionPane.OK_CANCEL_OPTION);
            if (result == 0) {
                try {
                    this.protocolo.enviarMensaje(0, "");
                } catch (IOException ex) {
                    Logger.getLogger(InterfazFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
