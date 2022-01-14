package prysegundoa;

import prysegundoa.Objetos.*;
import javax.swing.JOptionPane;
import logica.logicaUsuario;

public class FrmLogin extends javax.swing.JFrame {

    private Usuario usuario1;
    private int contadorLogin = 0;

    public FrmLogin() {
        initComponents();
        this.setLocationRelativeTo(null);
        datosUsuario();
        lblContador.setText(String.valueOf(contadorLogin));
        //Hola desde Git
    }

    private void datosUsuario() {
        usuario1 = new Usuario();
        usuario1.modificarCorreo("smejia");
        usuario1.modificarClave("12345");
        usuario1.modificarApellido("Mejia");
        usuario1.modificarNombre("Stalin");

        Rol rol1 = new Rol();
        rol1.setCodigoRol(1);
        rol1.setDescripcion("Administrador");

        usuario1.setRol(rol1);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        lblClave = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        txtClave = new javax.swing.JPasswordField();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        lblContador = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitulo.setText("Login");

        lblCorreo.setText("Correo");

        lblClave.setText("Contraseña");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAceptar.setText("Ingresar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(lblTitulo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(lblCorreo))
                                    .addComponent(lblClave))
                                .addGap(22, 22, 22)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblContador)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnCancelar)
                                .addGap(52, 52, 52)
                                .addComponent(btnAceptar)))))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCorreo)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClave)
                    .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(lblContador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnAceptar))
                .addGap(48, 48, 48))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        login();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void login() {
        String correo = txtCorreo.getText();
        String clave = String.valueOf(txtClave.getPassword());

        logica.logicaUsuario logicaUser = new logicaUsuario();

        Usuario usuario = new Usuario();

        usuario = logicaUser.obtenerUsuariosLoginRol(correo, clave);

        if (usuario != null) {
            JOptionPane.showMessageDialog(this, "Bienvenido al Sistema \n" + usuario.toString() + "\n ", "Sistema XYZ", JOptionPane.OK_OPTION);

            //Instancia o a crear un nuevo objeto del formulario principal
            FrmPrincipal frmprincipal = new FrmPrincipal();
            this.setVisible(false);
            frmprincipal.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(this, "Usuario o clave incorrecta", "Sistema XYZ", JOptionPane.OK_OPTION);
            contadorLogin = contadorLogin + 1;
            lblContador.setText(String.valueOf(contadorLogin));
            if (contadorLogin == 3) {
                JOptionPane.showMessageDialog(this, "Ha superado el número de intentos \nPor favor comuniquese con el administrador del sistema", "Sistema XYZ", JOptionPane.OK_OPTION);
                System.exit(0);

            }
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblClave;
    private javax.swing.JLabel lblContador;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPasswordField txtClave;
    private javax.swing.JTextField txtCorreo;
    // End of variables declaration//GEN-END:variables
}
