/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import static interfaz.frmInventario.archivo;
import static interfaz.frmInventario.cadena;
import static interfaz.frmVenta.Conectar;
import static interfaz.frmVenta.con;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author casa
 */
public class frmVerVentas extends javax.swing.JFrame {

    /**
     * Creates new form frmVerVentas
     */
    DefaultListModel modelo2;
    public frmVerVentas() {
        initComponents();    
    }
    DefaultTableModel modelo;
     //DECLARAR UNA VARIABLE (OBJETO) PARA REALIZAR LA CONEXION
    static Connection con=null;
    
    //DECLARAR UNA VARIABLE (OBJETO) PARA TRAER LOS REGISTROS DE LA BASE DE DATOS
    static ResultSet rs=null;
    
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
        public static void BuscarDatos(Connection con,String nom){
        try{
            //CREAR UNA VARIABLE PARA ALMACENAR LA INSTRUCCION SQL PARA INSERTAR
            String SQL="SELECT * FROM venta_articulo WHERE nombre_ven='" + nom+"'";
            //PARA PODER LOS DATOS EN LA BASE DATOS, SE DEBE CREAR UNA VARIABLE STATAMENT
            Statement stmt=con.createStatement();
            rs=stmt.executeQuery(SQL);
            if(rs.next()){
                //TRAER LOS CAMPOS DE LA BASE DE DATOS Y MOSTRARLOS EN LOS TEXTBOX
                lblnombre.setText(rs.getString("articulo_vend"));
                lblcantidadbodega.setText(rs.getString("cantidad_ven"));
                lblprecioven.setText(rs.getString("valor_total"));
                lblfecha.setText(rs.getString("fecha"));
                lblhora.setText(rs.getString("hora"));
            }else{
                JOptionPane.showMessageDialog(null, "El empleado no existe");
            }
            rs.close();
            stmt.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }
            public static void Buscarproductos(Connection con,String nom){
        try{
            //CREAR UNA VARIABLE PARA ALMACENAR LA INSTRUCCION SQL PARA INSERTAR
            String SQL="SELECT * FROM venta_articulo WHERE articulo_vend='" + nom+"'";
            //PARA PODER LOS DATOS EN LA BASE DATOS, SE DEBE CREAR UNA VARIABLE STATAMENT
            Statement stmt=con.createStatement();
            rs=stmt.executeQuery(SQL);
            if(rs.next()){
                //TRAER LOS CAMPOS DE LA BASE DE DATOS Y MOSTRARLOS EN LOS TEXTBOX
                lblnombrep.setText(rs.getString("nombre_ven"));             
                lblfechap.setText(rs.getString("fecha"));
                lblhorap.setText(rs.getString("hora"));
            }else{
                JOptionPane.showMessageDialog(null, "El empleado no existe");
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
        String[] titulos = {"Codigo","Pelicula", "Nombre ven", "Cantidad", "Valor Total","Fecha","Hora"};
        String[] registro = new String[7];
        //Se cargan los títulos de las columnas a la tabla
        modelo=new DefaultTableModel(null,titulos);
        //Se usa la conexion para establecer contacto con la base de datos de MySQL
        //Connection cn = Conectar();
        //Hay que guardar en la variable la instrucción que "pasaremos" a MySQL
        String SQL = "SELECT * FROM venta_articulo";
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
                registro[0] = rs.getString("cod");
                registro[1] = rs.getString("articulo_vend");
                registro[2] = rs.getString("nombre_ven");
                registro[3] = rs.getString("cantidad_ven");
                registro[4] = rs.getString("valor_total");
                registro[5] = rs.getString("fecha");
                registro[6] = rs.getString("hora");
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
     *
     */

 
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nombre = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblnombre = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblprecioven = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lblcantidadbodega = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        txtnombre = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        lblhora = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lblfecha = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lblnombrep = new javax.swing.JLabel();
        btnbudcarpro = new javax.swing.JButton();
        txtnombrep = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        lblhorap = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lblfechap = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Video Tienda");

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/onlineshop_78377 (3).png"))); // NOI18N

        nombre.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        nombre.setForeground(new java.awt.Color(255, 255, 255));
        nombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombre.setText("Ventas Realizadas");

        jButton1.setText("Menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(0, 102, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel12.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Nombre vendedor:");

        jLabel13.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Pelicula:");

        lblnombre.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 14)); // NOI18N
        lblnombre.setForeground(new java.awt.Color(255, 255, 204));
        lblnombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblnombre.setText("?");

        jLabel15.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Valor Total");

        lblprecioven.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 14)); // NOI18N
        lblprecioven.setForeground(new java.awt.Color(255, 255, 204));
        lblprecioven.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblprecioven.setText("0");

        jLabel19.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Cantidad Bodega:");

        lblcantidadbodega.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 14)); // NOI18N
        lblcantidadbodega.setForeground(new java.awt.Color(255, 255, 204));
        lblcantidadbodega.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblcantidadbodega.setText("0");

        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Hora:");

        lblhora.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 14)); // NOI18N
        lblhora.setForeground(new java.awt.Color(255, 255, 204));
        lblhora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblhora.setText("0");

        jLabel18.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Fecha:");

        lblfecha.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 14)); // NOI18N
        lblfecha.setForeground(new java.awt.Color(255, 255, 204));
        lblfecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblfecha.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(93, 93, 93)
                        .addComponent(lblhora, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel15))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblprecioven, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtnombre, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                                .addComponent(lblnombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblfecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblcantidadbodega, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(lblnombre)
                    .addComponent(jLabel19)
                    .addComponent(lblcantidadbodega))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(lblprecioven)
                    .addComponent(jLabel18)
                    .addComponent(lblfecha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(lblhora))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(0, 102, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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
        jScrollPane3.setViewportView(tblDatos);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 535, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jButton3.setText("Mostrar Ventas");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(0, 102, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel14.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Nombre Producto");

        jLabel17.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Vendedor");

        lblnombrep.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 14)); // NOI18N
        lblnombrep.setForeground(new java.awt.Color(255, 255, 204));
        lblnombrep.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblnombrep.setText("?");

        btnbudcarpro.setText("Mostrar");
        btnbudcarpro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbudcarproActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Hora:");

        lblhorap.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 14)); // NOI18N
        lblhorap.setForeground(new java.awt.Color(255, 255, 204));
        lblhorap.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblhorap.setText("0");

        jLabel23.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Fecha:");

        lblfechap.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 14)); // NOI18N
        lblfechap.setForeground(new java.awt.Color(255, 255, 204));
        lblfechap.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblfechap.setText("0");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                        .addComponent(lblhorap, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel17)
                            .addComponent(jLabel23))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtnombrep, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                            .addComponent(lblnombrep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblfechap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnbudcarpro, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtnombrep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(lblnombrep))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(lblfechap)))
                    .addComponent(btnbudcarpro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(lblhorap))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(215, 215, 215)
                                .addComponent(jButton3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(nombre)
                        .addGap(37, 37, 37)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
              frmPrincipal verformulario4=new frmPrincipal();
        verformulario4.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Conectar();
            BuscarDatos(con,(txtnombre.getText()));
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
         
            CargarTabla();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnbudcarproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbudcarproActionPerformed
        // TODO add your handling code here:
        Conectar();
            Buscarproductos(con,(txtnombrep.getText()));
    }//GEN-LAST:event_btnbudcarproActionPerformed

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
            java.util.logging.Logger.getLogger(frmVerVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmVerVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmVerVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmVerVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
       

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmVerVentas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbudcarpro;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane3;
    private static javax.swing.JLabel lblcantidadbodega;
    private static javax.swing.JLabel lblfecha;
    private static javax.swing.JLabel lblfechap;
    private static javax.swing.JLabel lblhora;
    private static javax.swing.JLabel lblhorap;
    private static javax.swing.JLabel lblnombre;
    private static javax.swing.JLabel lblnombrep;
    private static javax.swing.JLabel lblprecioven;
    private javax.swing.JLabel nombre;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtnombrep;
    // End of variables declaration//GEN-END:variables

   
}
