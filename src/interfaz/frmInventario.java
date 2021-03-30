/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.*;
import com.microsoft.sqlserver.jdbc.*;
import static interfaz.frmRegistrar.con;
import static interfaz.frmRegistrar.rs;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author casa
 */
 
public class frmInventario extends javax.swing.JFrame {

    /**
     * Creates new form frmInventario
     */
    public frmInventario() {
        initComponents();
    }
     DefaultTableModel modelo;
    //DECLARAR UNA VARIABLE (OBJETO) PARA REALIZAR LA CONEXION
        static Connection con=null;
    
    //DECLARAR UNA VARIABLE (OBJETO) PARA TRAER LOS REGISTROS DE LA BASE DE DATOS
    static ResultSet rs=null;
    static String[] cadena;
    public static File archivo;
   //CREAR EL METODO PARA CONECTAR A LA BASE DE DATOS
    public static void Conectar(){
        try{
            //CADENA DE CONEXION
            String cadenaConexion="jdbc:sqlserver://;database=Peliculas;integratedSecurity=true;";
            con=DriverManager.getConnection(cadenaConexion);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }
  public static void Buscar(String dato){
        archivo=null;
        FileReader fr=null;
        BufferedReader br=null;
        try{
            archivo=new File("./src/Recursos/pelicula.txt");
            fr=new FileReader(archivo);
            br=new BufferedReader(fr);
            String linea;
            boolean encontro=false;
            while((linea=br.readLine()) != null){
                //CORTAR LA CADENA QUE ALMACENA EN LINEA Y ALMACENARLO EN EL VECTOR
                cadena=linea.split(",");
                if(cadena[0].equals(dato)){
                    encontro=true;
                    break;
                }
            }
            if(encontro){
                lblnombre.setText(cadena[1]);
                lblgenero.setText(cadena[2]);
                lblprecioven.setText(cadena[3]);
                lblcantidadbodega.setText(cadena[4]);
               // txtapellido.setText(cadena[2]);
            }else{
               JOptionPane.showMessageDialog(null,"La pelicula no existe"); 
            }
            fr.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Se produjo un error al intentar escribir en el archivo");
        }  
    }
  
    public static void BuscarDatos(Connection con,int cod){
        try{
            //CREAR UNA VARIABLE PARA ALMACENAR LA INSTRUCCION SQL PARA INSERTAR
            String SQL="SELECT * FROM inventario WHERE cod_peliculas=" + cod;
            //PARA PODER LOS DATOS EN LA BASE DATOS, SE DEBE CREAR UNA VARIABLE STATAMENT
            Statement stmt=con.createStatement();
            rs=stmt.executeQuery(SQL);
            if(rs.next()){
                //TRAER LOS CAMPOS DE LA BASE DE DATOS Y MOSTRARLOS EN LOS TEXTBOX
                lblnombre.setText(rs.getString("nom_pelicula"));
                lblgenero.setText(rs.getString("genero"));
                lblprecioven.setText(rs.getString("precio_venta"));
                lblcantidadbodega.setText(rs.getString("can_bodega"));
            }else{
                JOptionPane.showMessageDialog(null, "El cliente no existe");
            }
            rs.close();
            stmt.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }
     void CargarTabla(){      
        Conectar();
        //Se crean 2 arrays para guardar datos extraidos de la base de datos
        //En uno de los arrays se declaran los nombres de las columnas MANUALMENTE
        String[] titulos = {"Codigo", "Nombre", "Genero", "Precio","Cantidad"};
        String[] registro = new String[5];
        //Se cargan los títulos de las columnas a la tabla
        modelo=new DefaultTableModel(null,titulos);
        //Se usa la conexion para establecer contacto con la base de datos de MySQL
        //Connection cn = Conectar();
        //Hay que guardar en la variable la instrucción que "pasaremos" a MySQL
        String SQL = "SELECT * FROM inventario";
        try 
        {
            /*HAy que mandar la instrucción a MySQL con el Statement y el resultado de ese 
            comando se guarda en un ResulSet(ambos pertenecen a la libreria IMPORT JAVA.SQL )*/
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);    
           /* El ResultSet se explora y se extraen los datos para guardarlos
              en los arrays creados anteriormente*/
            while (rs.next())
            {
                registro[0] = rs.getString("cod_peliculas");
                registro[1] = rs.getString("nom_pelicula");
                registro[2] = rs.getString("genero");
                registro[3] = rs.getString("precio_venta");
                registro[4] = rs.getString("can_bodega");
               // Al "modelo" de la jTable se mandan los datos guardados en los arrays
                modelo.addRow(registro);
            }
            //Una vez se ha terminado el llenado del modelo, este se manda a la jTable
            tblDatos.setModel(modelo);
        } 
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
     
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        btnverlistado = new javax.swing.JButton();
        btnregistrar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        lblnombre = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblprecioven = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lblgenero = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lblcantidadbodega = new javax.swing.JLabel();
        btnmenu = new javax.swing.JButton();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inventario de Peliculas");

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/onlineshop_78377 (3).png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Control Inventario");

        jPanel2.setBackground(new java.awt.Color(0, 102, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblDatos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 533, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 193, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(34, Short.MAX_VALUE)))
        );

        btnverlistado.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        btnverlistado.setText("Ver Listado");
        btnverlistado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnverlistadoActionPerformed(evt);
            }
        });

        btnregistrar.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        btnregistrar.setText("Registrar Pelicula");
        btnregistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistrarActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(0, 102, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel12.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Codigo Pelicula: ");

        txtcodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcodigoKeyPressed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Pelicula:");

        lblnombre.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 14)); // NOI18N
        lblnombre.setForeground(new java.awt.Color(255, 255, 204));
        lblnombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblnombre.setText("?");

        jLabel15.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Precio Venta:");

        lblprecioven.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 14)); // NOI18N
        lblprecioven.setForeground(new java.awt.Color(255, 255, 204));
        lblprecioven.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblprecioven.setText("0");

        jLabel17.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Genero: ");

        lblgenero.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 14)); // NOI18N
        lblgenero.setForeground(new java.awt.Color(255, 255, 204));
        lblgenero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblgenero.setText("?");

        jLabel19.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Cantidad Bodega:");

        lblcantidadbodega.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 14)); // NOI18N
        lblcantidadbodega.setForeground(new java.awt.Color(255, 255, 204));
        lblcantidadbodega.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblcantidadbodega.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblnombre, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                    .addComponent(lblprecioven, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtcodigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblgenero, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblcantidadbodega, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(lblnombre)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblgenero)
                            .addComponent(jLabel17))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(lblprecioven)
                    .addComponent(jLabel19)
                    .addComponent(lblcantidadbodega))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        btnmenu.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        btnmenu.setText("Menu");
        btnmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnmenu)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnverlistado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnregistrar))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(42, 42, 42)))
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnverlistado)
                    .addComponent(btnregistrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnmenu)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmenuActionPerformed
        // TODO add your handling code here:
          frmPrincipal verformulario4=new frmPrincipal();
        verformulario4.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnmenuActionPerformed

    private void btnregistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrarActionPerformed
        // TODO add your handling code here:
          frmRegistrar verformulario5=new frmRegistrar();
        verformulario5.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnregistrarActionPerformed

    private void btnverlistadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnverlistadoActionPerformed
        // TODO add your handling code here:
        CargarTabla();
        
    }//GEN-LAST:event_btnverlistadoActionPerformed

    private void txtcodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodigoKeyPressed
        // TODO add your handling code here:
        
        
             if(evt.getKeyCode()==evt.VK_ENTER){
                 Conectar();
            BuscarDatos(con,Integer.parseInt(txtcodigo.getText()));
        }
       
    }//GEN-LAST:event_txtcodigoKeyPressed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(frmInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmInventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnmenu;
    private javax.swing.JButton btnregistrar;
    private javax.swing.JButton btnverlistado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private static javax.swing.JLabel lblcantidadbodega;
    private static javax.swing.JLabel lblgenero;
    private static javax.swing.JLabel lblnombre;
    private static javax.swing.JLabel lblprecioven;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtcodigo;
    // End of variables declaration//GEN-END:variables
}
