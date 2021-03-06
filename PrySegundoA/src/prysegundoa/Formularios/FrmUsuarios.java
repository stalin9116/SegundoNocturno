package prysegundoa.Formularios;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.logicaRol;
import logica.logicaUsuario;
import prysegundoa.Objetos.*;

public class FrmUsuarios extends javax.swing.JFrame {

    private ArrayList<Usuario> listaUsuarios = new ArrayList<>();

    public FrmUsuarios() {
        //Carga todos los contrle UI botones, etiquetas, combobox, jtable
        initComponents();
        this.setLocationRelativeTo(null);
        cargarDatos();
        cargarRoles();
        menuJtableUsuario();
    }

    private void menuJtableUsuario() {
        TableUsuarios.setComponentPopupMenu(jPopupMenuUsuarios);
    }

    private String mensaje = "";

    private void cargarDatos() {
        logicaUsuario logicUsuario = new logicaUsuario();
        //Objeto asignar el resultado de la logica
        List<Usuario> ListUsuario = new ArrayList<>();

        ListUsuario = logicUsuario.obtenerUsuariosActivosRol();
        if (ListUsuario.size() > 0 && ListUsuario != null) {
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Codigo");
            modelo.addColumn("Correo");
            modelo.addColumn("Apellidos");
            modelo.addColumn("Nombres");
            modelo.addColumn("Rol");
            modelo.addColumn("Estado");

            for (Usuario item : ListUsuario) {
                modelo.addRow(new Object[]{
                    item.obtenerCodigo(),
                    item.obtenerCorreo(),
                    item.obtenerApellido(),
                    item.obtenerNombre(),
                    item.getRol().getDescripcion(),
                    item.obtenerEstado()
                });
            }
            TableUsuarios.setModel(modelo);

        }

    }

    private void cargarRoles() {
        logicaRol logicRol = new logicaRol();
        List<Rol> ListRol = new ArrayList<>();
        ListRol = logicRol.obtenerRoles();
        if (ListRol.size() > 0 && ListRol != null) {
            DefaultComboBoxModel model = new DefaultComboBoxModel();

            for (Rol item : ListRol) {
                model.addElement(new ComboboxItems(String.valueOf(item.getCodigoRol()), item.getDescripcion()));
            }

            cmbRol.setModel(model);
        }

    }

    private void limpiar() {
        txtApellidos.setText("");
        txtNombres.setText("");
        txtCodigo.setText("");
        txtCorreo.setText("");
        txtClave.setText("");
        txtClave2.setText("");
    }

    private boolean validaciones() {
        boolean resultado = false;

        if (txtNombres.getText().length() == 0) {
            mensaje = mensaje + "Nombre camnpo obligatorio\n";
            //System.out.println("Validacion nombre");
            resultado = true;
        }
        if (txtApellidos.getText().length() == 0) {
            mensaje = mensaje + "Apellidos camnpo obligatorio\n";
            //System.out.println("Validacion apellidos");
            resultado = true;
        }
        if (txtCorreo.getText().length() == 0) {
            mensaje = mensaje + "Correo camnpo obligatorio\n";
            System.out.println("Validacion apellidos");
            resultado = true;
        }

        return resultado;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenuUsuarios = new javax.swing.JPopupMenu();
        jMenuItemEditar = new javax.swing.JMenuItem();
        jMenuItemEliminar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableUsuarios = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        cmbRol = new javax.swing.JComboBox<>();
        txtCodigo = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtClave = new javax.swing.JPasswordField();
        txtClave2 = new javax.swing.JPasswordField();
        Imprimir = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();

        jMenuItemEditar.setText("Editar");
        jMenuItemEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEditarActionPerformed(evt);
            }
        });
        jPopupMenuUsuarios.add(jMenuItemEditar);

        jMenuItemEliminar.setText("Eliminar");
        jMenuItemEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEliminarActionPerformed(evt);
            }
        });
        jPopupMenuUsuarios.add(jMenuItemEliminar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Usuarios");

        lbl.setText("Codigo");

        TableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(TableUsuarios);

        jLabel2.setText("Correo");

        jLabel3.setText("Clave");

        jLabel4.setText("Confirmar Clave");

        jLabel5.setText("Apellidos");

        jLabel6.setText("Nombres");

        jLabel7.setText("Rol");

        cmbRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");

        Imprimir.setText("Imprimir");
        Imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImprimirActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(351, 351, 351)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(lbl)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel4)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txtClave2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cmbRol, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnCancelar)
                                .addGap(18, 18, 18)
                                .addComponent(btnLimpiar)
                                .addGap(18, 18, 18)
                                .addComponent(btnGuardar)
                                .addGap(18, 18, 18)
                                .addComponent(btnModificar)
                                .addGap(24, 24, 24)
                                .addComponent(btnEliminar)
                                .addGap(14, 14, 14)
                                .addComponent(Imprimir)
                                .addGap(114, 114, 114))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar)))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7)
                    .addComponent(cmbRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtClave2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar)
                    .addComponent(btnGuardar)
                    .addComponent(btnEliminar)
                    .addComponent(btnCancelar)
                    .addComponent(Imprimir)
                    .addComponent(btnModificar))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        GuardarUsuario();

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void GuardarUsuario() {
        try {
            Usuario usuario1 = new Usuario();

            usuario1.modificarApellido(txtApellidos.getText());
            usuario1.modificarNombre(txtNombres.getText());
            usuario1.modificarCorreo(txtCorreo.getText());
            usuario1.modificarClave(txtClave.getText());

            //Obtener el codigo del combobox
            Object rolSeleccionado = cmbRol.getSelectedItem();
            String rolCodigo = ((ComboboxItems) rolSeleccionado).getCodigo();

            Rol rolUsuario1 = new Rol();
            rolUsuario1.setCodigoRol(Integer.parseInt(rolCodigo));
            usuario1.setRol(rolUsuario1);

            if (validaciones()) {
                System.out.println(mensaje);
            }

            logicaUsuario logicUsuario = new logicaUsuario();
            boolean resulInsert = logicUsuario.guardarUsuario(usuario1);
            if (resulInsert) {
                JOptionPane.showMessageDialog(this, "Usuario registrado correctamente", "Sistema XYZ", JOptionPane.CANCEL_OPTION);
                cargarDatos();
                limpiar();
            } else {
                JOptionPane.showMessageDialog(this, "Error al registrar usuario", "Sistema XYZ", JOptionPane.CANCEL_OPTION);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    private void ModificarUsuario() {
        try {

            int verificar = JOptionPane.showConfirmDialog(null, "En realidad desea modificar ?");

            if (verificar == JOptionPane.YES_OPTION) {
                Usuario usuario1 = new Usuario();

                usuario1.modificarCodigo(Integer.parseInt(txtCodigo.getText()));
                usuario1.modificarApellido(txtApellidos.getText());
                usuario1.modificarNombre(txtNombres.getText());
                usuario1.modificarCorreo(txtCorreo.getText());
                usuario1.modificarClave(txtClave.getText());

                //Obtener el codigo del combobox
                Object rolSeleccionado = cmbRol.getSelectedItem();
                String rolCodigo = ((ComboboxItems) rolSeleccionado).getCodigo();

                Rol rolUsuario1 = new Rol();
                rolUsuario1.setCodigoRol(Integer.parseInt(rolCodigo));
                usuario1.setRol(rolUsuario1);

                if (validaciones()) {
                    System.out.println(mensaje);
                }

                logicaUsuario logicUsuario = new logicaUsuario();
                boolean resulInsert = logicUsuario.modificarUsuario(usuario1);
                if (resulInsert) {
                    JOptionPane.showMessageDialog(this, "Usuario modificado correctamente", "Sistema XYZ", JOptionPane.CANCEL_OPTION);
                    cargarDatos();
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(this, "Error al modificar usuario", "Sistema XYZ", JOptionPane.CANCEL_OPTION);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }


    private void ImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImprimirActionPerformed
        for (Usuario varUsuario : listaUsuarios) {
            System.out.println(varUsuario.toString() + "\n");
        }
    }//GEN-LAST:event_ImprimirActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        /*String datoBuscar = txtApellidos.getText();
        for (Usuario varUsuario : listaUsuarios) {
        if (varUsuario.obtenerApellido().equals(datoBuscar)) {
        System.out.println("Existe");
        System.out.println(varUsuario.toString() + "\n");
        }
        }*/

        String datoBuscar = txtBuscar.getText();

        List<Usuario> ListUsuario = new ArrayList<>();
        ListUsuario = logicaUsuario.obtenerUsuariosActivosXNombres(datoBuscar);

        if (ListUsuario.size() > 0 && ListUsuario != null) {
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Codigo");
            modelo.addColumn("Correo");
            modelo.addColumn("Apellidos");
            modelo.addColumn("Nombres");
            modelo.addColumn("Rol");
            modelo.addColumn("Estado");

            for (Usuario item : ListUsuario) {
                modelo.addRow(new Object[]{
                    item.obtenerCodigo(),
                    item.obtenerCorreo(),
                    item.obtenerApellido(),
                    item.obtenerNombre(),
                    item.getRol().getDescripcion(),
                    item.obtenerEstado()
                });
            }
            TableUsuarios.setModel(modelo);

        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        ModificarUsuario();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void EliminarUsuario(int codigoUsuario) {
        try {

            int verificar = JOptionPane.showConfirmDialog(null, "En realidad desea eliminar ?");

            if (verificar == JOptionPane.YES_OPTION) {
                Usuario usuario1 = new Usuario();
                usuario1.modificarCodigo(codigoUsuario);
                //Integer.parseInt(txtCodigo.getText()));
                logicaUsuario logicUsuario = new logicaUsuario();
                boolean resulInsert = logicUsuario.eliminarUsuarioFisica(usuario1.obtenerCodigo());
                if (resulInsert) {
                    JOptionPane.showMessageDialog(this, "Usuario Eliminado correctamente", "Sistema XYZ", JOptionPane.CANCEL_OPTION);
                    cargarDatos();
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(this, "Error al eliminar usuario", "Sistema XYZ", JOptionPane.CANCEL_OPTION);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        EliminarUsuario(Integer.parseInt(txtCodigo.getText()));
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jMenuItemEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEditarActionPerformed
        int fila = TableUsuarios.getSelectedRow();
        if (fila >= 0) {

            //Capturar informaci??n de JTable
            String codigo = TableUsuarios.getValueAt(fila, 0).toString();
            String correo = TableUsuarios.getValueAt(fila, 1).toString();
            String apellidos = TableUsuarios.getValueAt(fila, 2).toString();
            String nombres = TableUsuarios.getValueAt(fila, 3).toString();
            String rol = TableUsuarios.getValueAt(fila, 4).toString();

            //Obtener el codigo de Rol desde la base de datos
            Rol rolBase = new Rol();
            rolBase = logicaRol.obtenerRolesXDescripcion(rol);

            //Agregamos el modelo combobox para seleccionar item del rol
            if (rolBase != null) {
                cmbRol.getModel().setSelectedItem(new ComboboxItems(String.valueOf(rolBase.getCodigoRol()), rolBase.getDescripcion()));
            }

            cmbRol.setSelectedItem(rol);

            //mostramos la informaci??n en las cajas y label del formulario
            txtCodigo.setText(codigo);
            txtCorreo.setText(correo);
            txtApellidos.setText(apellidos);
            txtNombres.setText(nombres);
        }

    }//GEN-LAST:event_jMenuItemEditarActionPerformed

    private void jMenuItemEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEliminarActionPerformed
        int fila = TableUsuarios.getSelectedRow();
        if (fila >= 0) {
            String codigo = TableUsuarios.getValueAt(fila, 0).toString();
            EliminarUsuario(Integer.parseInt(codigo));
        }
    }//GEN-LAST:event_jMenuItemEliminarActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Imprimir;
    private javax.swing.JTable TableUsuarios;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> cmbRol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuItem jMenuItemEditar;
    private javax.swing.JMenuItem jMenuItemEliminar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenuUsuarios;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JPasswordField txtClave;
    private javax.swing.JPasswordField txtClave2;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombres;
    // End of variables declaration//GEN-END:variables
}
