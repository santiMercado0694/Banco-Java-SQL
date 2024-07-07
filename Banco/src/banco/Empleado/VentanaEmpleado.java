/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.Empleado;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import quick.dbtable.DBTable;

/**
 *
 * @author chant
 */
public class VentanaEmpleado extends javax.swing.JFrame {

    private String legajo;
    private String password;
    private EmpleadoLogin empleadoL;
    private DBTable tabla;
    private Connection conexionBD;
    private int nro_cliente;
    private int nro_prestamo;
    private VentanaPrestamo ventanaPrestamo;
    
    public VentanaEmpleado(String leg, String clave, EmpleadoLogin el, Connection c, DBTable t) {
        super();
        legajo = leg;
        password = clave;
        empleadoL = el;
        conexionBD = c;
        tabla = t;
        initComponents();
        GUI();
    }
    
    private void GUI() {
        setPreferredSize(new Dimension(1200, 800));
        this.setBounds(0, 0, 1200, 800);
        setVisible(true);
        BorderLayout thisLayout = new BorderLayout();
        this.setTitle("Panel Empleado");
        getContentPane().setLayout(thisLayout);
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        
        // Tabla clientes
        this.refrescarTablaCliente();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaCliente = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        campoTipo = new javax.swing.JTextField();
        campoNumD = new javax.swing.JTextField();
        botonIngresar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        botonMostrarCliMoroso = new javax.swing.JButton();
        botonCrearPrestamo = new javax.swing.JButton();
        botonCuotasImpagas = new javax.swing.JButton();
        botonReset = new javax.swing.JButton();
        panelCuotas = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaCuotas = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        botonRegistrarPago = new javax.swing.JButton();
        botonFinalizarRegistroPago = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        panelMorosos = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaMorosos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setVisible(true);
        jLabel1.setText("Clientes del banco");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 14, -1, 36));

        btnCerrarSesion.setText("Cerrar sesión");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });
        getContentPane().add(btnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(952, 6, -1, -1));

        TablaCliente = new javax.swing.JTable(){
            public boolean isCellEditable (int rowIndex, int colIndex){
                return false;
            }
        };
        TablaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Cliente", "Tipo", "Número de documento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaCliente.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TablaCliente);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 70, -1, 85));

        jLabel2.setText("Tipo:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(602, 75, -1, -1));

        jLabel3.setText("Número de documento:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(503, 117, -1, -1));

        campoTipo.setNextFocusableComponent(campoNumD);
        getContentPane().add(campoTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(647, 71, 80, -1));
        getContentPane().add(campoNumD, new org.netbeans.lib.awtextra.AbsoluteConstraints(647, 113, 80, -1));

        botonIngresar.setText("Ingresar");
        botonIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIngresarActionPerformed(evt);
            }
        });
        getContentPane().add(botonIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(756, 89, -1, -1));

        jLabel4.setText("Seleccionar cliente ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(627, 33, -1, 32));

        botonMostrarCliMoroso.setText("Mostrar clientes morosos");
        botonMostrarCliMoroso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMostrarCliMorosoActionPerformed(evt);
            }
        });
        getContentPane().add(botonMostrarCliMoroso, new org.netbeans.lib.awtextra.AbsoluteConstraints(757, 6, -1, -1));

        botonCrearPrestamo.setText("Crear préstamo");
        botonCrearPrestamo.setEnabled(false);
        botonCrearPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearPrestamoActionPerformed(evt);
            }
        });
        getContentPane().add(botonCrearPrestamo, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 180, 130, -1));

        botonCuotasImpagas.setText("Cuotas Impagas");
        botonCuotasImpagas.setEnabled(false);
        botonCuotasImpagas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCuotasImpagasActionPerformed(evt);
            }
        });
        getContentPane().add(botonCuotasImpagas, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 180, 130, -1));

        botonReset.setText("Reset");
        botonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonResetActionPerformed(evt);
            }
        });
        getContentPane().add(botonReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(846, 89, -1, -1));

        panelCuotas.setVisible(false);
        panelCuotas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TablaCuotas = new javax.swing.JTable(){
            public boolean isCellEditable (int rowIndex, int colIndex){
                return false;
            }
        };
        TablaCuotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Número de cuota", "Valor", "Fecha de vencimiento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaCuotas.getTableHeader().setReorderingAllowed(false);
        TablaCuotas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaCuotasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TablaCuotas);

        panelCuotas.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 377, 85));

        jLabel5.setText("Registrar pago de cuota");
        panelCuotas.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(524, 6, -1, 30));

        botonRegistrarPago.setText("Registrar pago");
        botonRegistrarPago.setEnabled(false);
        botonRegistrarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarPagoActionPerformed(evt);
            }
        });
        panelCuotas.add(botonRegistrarPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 50, -1, -1));

        botonFinalizarRegistroPago.setText("Finalizar");
        botonFinalizarRegistroPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonFinalizarRegistroPagoActionPerformed(evt);
            }
        });
        panelCuotas.add(botonFinalizarRegistroPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 50, -1, -1));

        jLabel7.setText("Cuotas impagas");
        panelCuotas.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 140, 20));

        getContentPane().add(panelCuotas, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 217, -1, -1));

        panelMorosos.setVisible(false);
        panelMorosos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TablaMorosos = new javax.swing.JTable(){
            public boolean isCellEditable (int rowIndex, int colIndex){
                return false;
            }
        };
        TablaMorosos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Numero de cliente", "Tipo", "Numero de documento", "Nombre", "Apellido", "Numero de prestamo", "Monto", "Cantidad de meses", "Valor de la cuota", "Cuotas atrasadas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaMorosos.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(TablaMorosos);

        panelMorosos.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 26, 1051, 86));

        getContentPane().add(panelMorosos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, 1060, 140));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        desconectarBD();
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void botonIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIngresarActionPerformed
      if(setNroCliente()){
        if(this.tienePrestamo()){
            JOptionPane.showMessageDialog(null, "El cliente tiene un préstamo vigente");
            botonCuotasImpagas.setEnabled(true);
            botonIngresar.setEnabled(false);
            botonMostrarCliMoroso.setEnabled(false);
            campoTipo.setEnabled(false);
            campoNumD.setEnabled(false);
            panelMorosos.setVisible(false);
        }
        else
            {
             JOptionPane.showMessageDialog(null, "El cliente no tiene préstamos vigentes");
             botonCrearPrestamo.setEnabled(true);
             botonIngresar.setEnabled(false);
             botonMostrarCliMoroso.setEnabled(false);
             campoTipo.setEnabled(false);
             campoNumD.setEnabled(false);
             panelMorosos.setVisible(false);
            }
      }
    }//GEN-LAST:event_botonIngresarActionPerformed

    private void botonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonResetActionPerformed
            botonIngresar.setEnabled(true);
            botonCrearPrestamo.setEnabled(false);
            botonCuotasImpagas.setEnabled(false);
            panelMorosos.setVisible(false);
            campoTipo.setEnabled(true);
            campoNumD.setEnabled(true);
            campoTipo.setText("");
            campoNumD.setText("");
            botonMostrarCliMoroso.setEnabled(true);
    }//GEN-LAST:event_botonResetActionPerformed

    private void botonCuotasImpagasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCuotasImpagasActionPerformed
        botonCuotasImpagas.setEnabled(false);
        panelCuotas.setVisible(true);
        botonReset.setEnabled(false);
        this.refrescarTablaCuotas();
    }//GEN-LAST:event_botonCuotasImpagasActionPerformed

    private void botonRegistrarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarPagoActionPerformed

        int [] filas = this.TablaCuotas.getSelectedRows();
        for (int i = 0; i < filas.length; i++) {
            int nro_cuota = Integer.parseInt(this.TablaCuotas.getModel().getValueAt(filas[i], 0).toString());
            System.out.println("nro_cuota: "+nro_cuota);
            this.pargarCuota(nro_cuota);
        }        
        this.refrescarTablaCuotas();
    }//GEN-LAST:event_botonRegistrarPagoActionPerformed

    private void botonFinalizarRegistroPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonFinalizarRegistroPagoActionPerformed
        panelCuotas.setVisible(false);
        botonIngresar.setEnabled(true);
        campoTipo.setEnabled(true);
        campoNumD.setEnabled(true);
        campoTipo.setText("");
        campoNumD.setText("");
        botonMostrarCliMoroso.setEnabled(true);
        botonReset.setEnabled(true);
    }//GEN-LAST:event_botonFinalizarRegistroPagoActionPerformed

    private void botonMostrarCliMorosoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMostrarCliMorosoActionPerformed
        panelMorosos.setVisible(true);
        this.refrescarTablaMorosos();
    }//GEN-LAST:event_botonMostrarCliMorosoActionPerformed

    private void botonCrearPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearPrestamoActionPerformed
        
        this.setVisible(false);
        this.ventanaPrestamo = new VentanaPrestamo(this.legajo, this.nro_cliente, this, this.conexionBD, this.tabla);     
        this.botonResetActionPerformed(evt);
    }//GEN-LAST:event_botonCrearPrestamoActionPerformed

    private void TablaCuotasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaCuotasMouseClicked
        this.botonRegistrarPago.setEnabled(true);
    }//GEN-LAST:event_TablaCuotasMouseClicked

    private void desconectarBD() {
        try {
            tabla.close();
            this.setVisible(false);
            empleadoL.setVisible(true);
                        JOptionPane.showMessageDialog(null,
						"Sesión Finalizada con éxito.");
        } catch (SQLException ex) {          
        }
    }
    
   private boolean setNroCliente() {
       
     try{   
            PreparedStatement ps = null;
            ResultSet rs = null;           
            
            int nroDoc=Integer.parseInt(campoNumD.getText());
            String sql = "SELECT DISTINCT nro_cliente FROM cliente  Where tipo_doc='"+campoTipo.getText()+"' AND nro_doc="+nroDoc+";";
            ps = conexionBD.prepareStatement(sql);
            rs = ps.executeQuery();
            
            if(rs.next()){
               nro_cliente = rs.getInt("nro_cliente");
               return true;
            }
     }
      catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Tipo y/o número de documento incorrecto.");
            return false;
        }
      catch (NumberFormatException e) {         
            JOptionPane.showMessageDialog(null,"Tipo y/o número de documento incorrecto.");
            return false;
        }
      JOptionPane.showMessageDialog(null, "No se encontró el cliente.");
      return false;
    }
   
   private boolean tienePrestamo() {
       
     try{   
            PreparedStatement ps = null;
            ResultSet rs = null;         

            String sql = "SELECT DISTINCT prestamo.nro_prestamo\n" +
                         "FROM prestamo\n" +
                         "INNER JOIN pago ON (pago.nro_prestamo = prestamo.nro_prestamo AND ISNULL(pago.fecha_pago))\n" +
                         "WHERE prestamo.nro_cliente="+nro_cliente+";";
            ps = conexionBD.prepareStatement(sql);
            rs = ps.executeQuery();
            
            if(rs.next()){
                nro_prestamo = rs.getInt("nro_prestamo");
                return true;
            }
     }
      catch (SQLException ex) {         
            JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(this),
                    ex.getMessage() + "\n",
                    "Error.",
                    JOptionPane.ERROR_MESSAGE);
        }
      
     return false;
    }
    
    private void refrescarTablaCliente() {
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            TablaCliente.setModel(modelo);

            PreparedStatement ps = null;
            ResultSet rs = null;          

            String sql = "SELECT nro_cliente ,tipo_doc ,nro_doc FROM banco.cliente";
            ps = conexionBD.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("Cliente");
            modelo.addColumn("Tipo");
            modelo.addColumn("Numero de documento");

            while (rs.next()) {

                Object[] filas = new Object[cantidadColumnas];

                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }

                modelo.addRow(filas);
            }

        } catch (SQLException ex) {           
            JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(this),
                    ex.getMessage() + "\n",
                    "Error al ejecutar la consulta.",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void refrescarTablaCuotas() {
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            TablaCuotas.setModel(modelo);

            PreparedStatement ps = null;
            ResultSet rs = null;          

            String sql = "SELECT pago.nro_pago, prestamo.valor_cuota, pago.fecha_venc \n" +
                         "FROM prestamo \n" +
                         "INNER JOIN pago ON (pago.nro_prestamo = prestamo.nro_prestamo AND ISNULL(pago.fecha_pago))\n" +
                         "WHERE prestamo.nro_cliente="+nro_cliente;
            ps = conexionBD.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("Numero de cuota");
            modelo.addColumn("Valor");
            modelo.addColumn("Fecha de vencimiento");

            while (rs.next()) {

                Object[] filas = new Object[cantidadColumnas];

                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }

                modelo.addRow(filas);
            }

        } catch (SQLException ex) {           
            JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(this),
                    ex.getMessage() + "\n",
                    "Error al ejecutar la consulta.",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void actualizarTablaCuotas() {
        try {
            
            Statement st = null;
            int rs;
            int[] cuotas = this.TablaCuotas.getSelectedRows();
            int cuota = 0;
            for (int i = 0; i <= cuotas.length; i++) {
                cuota = Integer.parseInt(TablaCuotas.getModel().getValueAt(cuotas[i], 0).toString());
                System.out.println("cuotas[i]: "+cuotas[i]);
                System.out.println("cuota: "+cuota);
                String sql = "UPDATE pago SET fecha_pago=CURDATE() WHERE nro_prestamo="+this.nro_prestamo+" AND nro_pago="+cuota;
                st = conexionBD.createStatement();
                rs = st.executeUpdate(sql);
            }
        } catch (SQLException ex) {           
            JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(this),
                    ex.getMessage() + "\n",
                    "Error al ejecutar la consulta.",
                    JOptionPane.ERROR_MESSAGE);
        }
        catch (NumberFormatException e) {         
            JOptionPane.showMessageDialog(null,"Ingrese un número de cuota");
        }
    }
    
    private void refrescarTablaMorosos() {
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            TablaMorosos.setModel(modelo);
            TablaMorosos.setAutoCreateRowSorter(true);

            PreparedStatement ps = null;
            ResultSet rs = null;          

            String sql = "SELECT cliente.nro_cliente, cliente.tipo_doc, cliente.nro_doc, cliente.nombre, cliente.apellido, prestamo.nro_prestamo, prestamo.monto, \n" +
                         "prestamo.cant_meses, prestamo.valor_cuota, COUNT(pago.nro_pago) AS CuotasAtrasadas\n" +
                         "FROM prestamo \n" +
                         "LEFT JOIN pago ON (pago.nro_prestamo = prestamo.nro_prestamo AND ISNULL(pago.fecha_pago) AND pago.fecha_venc < CURDATE())\n" +
                         "LEFT JOIN cliente ON (cliente.nro_cliente = prestamo.nro_cliente)\n" +
                         "WHERE pago.nro_pago > 0  AND 1 GROUP BY prestamo.nro_prestamo ORDER BY nro_cliente ASC";
            System.out.println("consulta: "+sql);
            ps = conexionBD.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("Numero de cliente");
            modelo.addColumn("Tipo");
            modelo.addColumn("Numero de documento");
            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido");
            modelo.addColumn("Numero de prestamo");
            modelo.addColumn("Monto");
            modelo.addColumn("Cantidad de meses");
            modelo.addColumn("Valor de la cuota");
            modelo.addColumn("Cuotas atrasadas");

            while (rs.next()) {

                Object[] filas = new Object[cantidadColumnas];

                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }

                modelo.addRow(filas);
            }

        } catch (SQLException ex) {           
            JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(this),
                    ex.getMessage() + "\n",
                    "Error al ejecutar la consulta.",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void pargarCuota(int nro_cuota) {
        try {
            Statement st = null;
            int rs;
            String sql = "UPDATE pago SET fecha_pago=CURDATE() WHERE nro_prestamo="+this.nro_prestamo+" AND nro_pago="+nro_cuota;
            st = conexionBD.createStatement();
            rs = st.executeUpdate(sql);
        } catch (SQLException ex) {           
            JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(this),
                    ex.getMessage() + "\n",
                    "Error al realizar el pago: "+nro_cuota+".",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaCliente;
    private javax.swing.JTable TablaCuotas;
    private javax.swing.JTable TablaMorosos;
    private javax.swing.JButton botonCrearPrestamo;
    private javax.swing.JButton botonCuotasImpagas;
    private javax.swing.JButton botonFinalizarRegistroPago;
    private javax.swing.JButton botonIngresar;
    private javax.swing.JButton botonMostrarCliMoroso;
    private javax.swing.JButton botonRegistrarPago;
    private javax.swing.JButton botonReset;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JTextField campoNumD;
    private javax.swing.JTextField campoTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel panelCuotas;
    private javax.swing.JPanel panelMorosos;
    // End of variables declaration//GEN-END:variables
}
