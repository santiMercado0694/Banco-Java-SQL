package banco.ATM;

import banco.Fechas;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import quick.dbtable.DBTable;

public class VentanaATM extends javax.swing.JFrame {

    private String tarjeta;
    private String PIN;
    private int nro_caja;
    private ATMLogin ventanaLoginAtm;
    private DBTable tabla;
    private Connection conexionBD;
    private Date fecha;
    private Date fechaS;
    private Date fechaI;
    private Date fechaH;
    private java.sql.Time horaS;
    private java.sql.Time hora;

    public VentanaATM(String tarj, String clave, ATMLogin vl, Connection c, DBTable t) {
        super();
        GUI();
        tarjeta = tarj;
        PIN = clave;
        ventanaLoginAtm = vl;
        conexionBD = c;
        tabla = t;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cajaOpciones = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollBar1 = new javax.swing.JScrollBar();
        PanelSaldo = new javax.swing.JPanel();
        ScrollSaldo = new javax.swing.JScrollPane();
        TablaSaldo = new javax.swing.JTable();
        PanelTransacciones = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaResumen = new javax.swing.JTable();
        PanelResumen = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaPeriodo = new javax.swing.JTable();
        PanelFechas = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        CampoFechaDesde = new javax.swing.JTextField();
        CampoFechaHasta = new javax.swing.JTextField();
        btnResumen = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        botonTransferencia = new javax.swing.JButton();
        botonExtraccion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        cajaOpciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar opción", "Consulta de saldo", "Últimos movimientos", "Movimiento por periodos" }));
        cajaOpciones.setToolTipText("Opciones del cajero automatico");
        cajaOpciones.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cajaOpciones.setName(""); // NOI18N
        cajaOpciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaOpcionesActionPerformed(evt);
            }
        });

        jLabel1.setText("ATM(Cajero Automático)");

        PanelSaldo.setVisible(false);

        TablaSaldo = new javax.swing.JTable(){
            public boolean isCellEditable (int rowIndex, int colIndex){
                return false;
            }
        };
        TablaSaldo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Caja de ahorro", "Tarjeta", "Saldo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaSaldo.getTableHeader().setReorderingAllowed(false);
        ScrollSaldo.setViewportView(TablaSaldo);

        javax.swing.GroupLayout PanelSaldoLayout = new javax.swing.GroupLayout(PanelSaldo);
        PanelSaldo.setLayout(PanelSaldoLayout);
        PanelSaldoLayout.setHorizontalGroup(
            PanelSaldoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelSaldoLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(ScrollSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        PanelSaldoLayout.setVerticalGroup(
            PanelSaldoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSaldoLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(ScrollSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        PanelTransacciones.setVisible(false);

        tablaResumen = new javax.swing.JTable(){
            public boolean isCellEditable (int rowIndex, int colIndex){
                return false;
            }
        };
        tablaResumen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Fecha", "Hora", "Tipo de transacción", "Monto", "Código caja ", "Destino"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaResumen.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaResumen);

        javax.swing.GroupLayout PanelTransaccionesLayout = new javax.swing.GroupLayout(PanelTransacciones);
        PanelTransacciones.setLayout(PanelTransaccionesLayout);
        PanelTransaccionesLayout.setHorizontalGroup(
            PanelTransaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTransaccionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        PanelTransaccionesLayout.setVerticalGroup(
            PanelTransaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTransaccionesLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        PanelResumen.setVisible(false);

        tablaPeriodo = new javax.swing.JTable(){
            public boolean isCellEditable (int rowIndex, int colIndex){
                return false;
            }
        };
        tablaPeriodo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Fecha", "Hora", "Tipo de transaccion", "Monto", "Codigo caja", "Destino"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaPeriodo.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tablaPeriodo);

        javax.swing.GroupLayout PanelResumenLayout = new javax.swing.GroupLayout(PanelResumen);
        PanelResumen.setLayout(PanelResumenLayout);
        PanelResumenLayout.setHorizontalGroup(
            PanelResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelResumenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelResumenLayout.setVerticalGroup(
            PanelResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelResumenLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
        );

        PanelFechas.setVisible(false);

        jLabel2.setText("Fecha Desde: ");

        CampoFechaDesde.setToolTipText("Formato de fecha: DD-MM-AAAA o DD/MM/YYYY");

        CampoFechaHasta.setToolTipText("Formato de fecha: DD-MM-AAAA o DD/MM/YYYY");

        btnResumen.setText("Mostrar Resumen");
        btnResumen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResumenActionPerformed(evt);
            }
        });

        jLabel3.setText("Fecha Hasta:");

        javax.swing.GroupLayout PanelFechasLayout = new javax.swing.GroupLayout(PanelFechas);
        PanelFechas.setLayout(PanelFechasLayout);
        PanelFechasLayout.setHorizontalGroup(
            PanelFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFechasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CampoFechaHasta)
                    .addComponent(CampoFechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(btnResumen)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelFechasLayout.setVerticalGroup(
            PanelFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFechasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelFechasLayout.createSequentialGroup()
                        .addGroup(PanelFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CampoFechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CampoFechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelFechasLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnResumen)))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jButton1.setText("Cerrar sesión");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        botonTransferencia.setText("Transferencia");
        botonTransferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonTransferenciaActionPerformed(evt);
            }
        });

        botonExtraccion.setText("Extraccion");
        botonExtraccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonExtraccionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(PanelResumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1887, Short.MAX_VALUE)
                        .addComponent(jScrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(133, 133, 133)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(PanelSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addComponent(cajaOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(botonTransferencia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botonExtraccion)
                                .addGap(120, 120, 120)
                                .addComponent(jButton1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(103, 103, 103))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelTransacciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelFechas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cajaOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(botonTransferencia)
                    .addComponent(botonExtraccion))
                .addGap(31, 31, 31)
                .addComponent(PanelSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PanelTransacciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PanelFechas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(PanelResumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(63, Short.MAX_VALUE))))
        );

        cajaOpciones.getAccessibleContext().setAccessibleDescription("Opciones del cajero automático");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cajaOpcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaOpcionesActionPerformed
        if (cajaOpciones.getSelectedIndex() == 1) {
            PanelSaldo.setVisible(true);
            PanelTransacciones.setVisible(false);
            PanelResumen.setVisible(false);
            PanelFechas.setVisible(false);
            this.refrescarTablaSaldo();
        }
        if (cajaOpciones.getSelectedIndex() == 2) {
            PanelTransacciones.setVisible(true);
            PanelResumen.setVisible(false);
            PanelFechas.setVisible(false);
            PanelSaldo.setVisible(false);
            this.refrescarTablaResumen();
        }
        if (cajaOpciones.getSelectedIndex() == 3) {
            PanelTransacciones.setVisible(false);
            PanelResumen.setVisible(false);
            PanelFechas.setVisible(true);
            PanelSaldo.setVisible(false);
        }
    }//GEN-LAST:event_cajaOpcionesActionPerformed

    private void btnResumenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResumenActionPerformed
        try {
            PanelResumen.setVisible(true);
            String fechaIni = CampoFechaDesde.getText();
            String fechaFin = CampoFechaHasta.getText();
            
             if(Fechas.validar(fechaIni))//Si el formato de fecha es dd/MM/yyyy
                 fechaI=Fechas.convertirStringADateSQL(fechaIni);
            else{//Si el formato de fecha es dd-MM-yyyy
                 //Convierto fecha Ini a Date SQL
                 SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
                 java.util.Date date = sdf1.parse(fechaIni);
                 fechaI = new java.sql.Date(date.getTime());
                }
             if(Fechas.validar(fechaFin)){//Si el formato de fecha es dd/MM/yyyy
                 fechaH=Fechas.convertirStringADateSQL(fechaFin);
             }
            else{//Si el formato de fecha es dd-MM-yyyy
                 //Convierto fecha Fin a Date SQL
                 SimpleDateFormat sdf12 = new SimpleDateFormat("dd-MM-yyyy");
                 java.util.Date date2 = sdf12.parse(fechaFin);
                 fechaH = new java.sql.Date(date2.getTime());
             }
            //Muestro la tabla con las transacciones entre las 2 fechas ingresadas
            this.refrescarTablaPeriodo();
        } catch (ParseException ex) {
            Logger.getLogger(VentanaATM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnResumenActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        desconectarBD();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void botonTransferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonTransferenciaActionPerformed
         VentanaTransferencia vTransferencia=new VentanaTransferencia(tarjeta, conexionBD, this);
         vTransferencia.setVisible(true);
         this.setVisible(false);
    }//GEN-LAST:event_botonTransferenciaActionPerformed

    private void botonExtraccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonExtraccionActionPerformed
         VentanaExtraccion vExtraccion=new VentanaExtraccion(tarjeta, conexionBD,this);
         vExtraccion.setVisible(true);
         this.setVisible(false);
    }//GEN-LAST:event_botonExtraccionActionPerformed

    private void GUI() {
        setPreferredSize(new Dimension(1200, 800));
        this.setBounds(0, 0, 1200, 800);
        setVisible(true);
        BorderLayout thisLayout = new BorderLayout();
        this.setTitle("Panel ATM(Caja de ahorro)");
        getContentPane().setLayout(thisLayout);     
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);       
     
    }

    private void desconectarBD() {
        try {
            tabla.close();
            this.setVisible(false);
            ventanaLoginAtm.setVisible(true);
                        JOptionPane.showMessageDialog(null,
						"Sesión Finalizada con éxito.");
        } catch (SQLException ex) {        
        }
    }

    private void refrescarTablaSaldo() {
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            TablaSaldo.setModel(modelo);

            PreparedStatement ps = null;
            ResultSet rs = null;        

            String sql = "SELECT distinct nro_ca , nro_tarjeta , saldo  FROM trans_cajas_ahorro NATURAL JOIN banco.tarjeta where banco.tarjeta.nro_tarjeta=" + tarjeta;
            ps = conexionBD.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("Caja de ahorro");
            modelo.addColumn("Tarjeta");
            modelo.addColumn("Saldo");

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

    private void refrescarTablaResumen() {
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            tablaResumen.setModel(modelo);

            PreparedStatement ps = null;
            ResultSet rs = null;         

            String sql = "SELECT DISTINCT fecha, hora, tipo, IF( (tipo='Extraccion' OR tipo='Transferencia' OR tipo='Debito'), CONCAT('-', monto), monto ) AS monto, cod_caja, destino FROM trans_cajas_ahorro WHERE nro_ca="+getNro_caja()+" ORDER BY fecha DESC LIMIT 15;";
            ps = conexionBD.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("Fecha");
            modelo.addColumn("Hora");
            modelo.addColumn("Tipo de transaccion");
            modelo.addColumn("Monto");
            modelo.addColumn("Codigo caja");
            modelo.addColumn("Destino");

            /*Habia un bug que se habia manifestado en la clase donde al recuperar las fechas y horas de una transferencia
            estas figuraban con 1 dia menos, en mi caso al menos se le restaba 1 dia y horas, por ej tenia una transferencia
            creada el 2018-10-25 a las 16:26:37 y en la BD figuraba correctamente y cuando lo recuperaba en la aplicacion
            aparecian todos los datos correctos salvo la fecha y la hora el cual figuraba 2018-10-24 a las 13:26:37.Entonces
            la solucion que opte fue que cada vez que vaya a insetar en la tabla una fecha a esta se le debe sumar 1 dia y
            cuando se va a insertar una hora a esta se le debe sumar 3 horas y de esta manera la informacion es consistente
            con la base de datos.Todo esto surgio aparentemente de un BUG que los mismos ayudantes dijieron que se habia 
            manifestado este cuatrimestre*/
            while (rs.next()) {

                Object[] filas = new Object[cantidadColumnas];

                for (int i = 0; i < cantidadColumnas; i++) {
                    //Si es una fecha le sumo 1 dia
                    if(i+1==1 || i+1==7 || i+1==13 || i+1==19 || i+1==25 || i+1==31 || i+1==37 || i+1==43 || i+1==49 || i+1==55 || i+1==61 || i+1==67 || i+1==73 || i+1==79 || i+1==85){   
                        fechaS = (Date) rs.getObject(i + 1);
                        fecha = new java.sql.Date(fechaS.getTime()+ TimeUnit.DAYS.toMillis( 1 ));
                        filas[i] = fecha;
                    }
                 else
                     //Si es una hora le sumo 3 horas
                     if(i+1==2 || i+1==8 || i+1==14 || i+1==20 || i+1==26 || i+1==32 || i+1==38 || i+1==44 || i+1==50 || i+1==56 || i+1==62 || i+1==68 || i+1==74 || i+1==80 || i+1==86){   
                        horaS = (java.sql.Time) rs.getObject(i + 1);
                        hora = new java.sql.Time(horaS.getTime()+ TimeUnit.HOURS.toMillis( 3 ));
                        filas[i] = hora;
                     }
                 else
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

     private void refrescarTablaPeriodo() {
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            tablaPeriodo.setModel(modelo);

            PreparedStatement ps = null;
            ResultSet rs = null;         

            String sql = "SELECT DISTINCT fecha, hora, tipo, IF((tipo = 'Extraccion' OR tipo = 'Transferencia' OR tipo = 'Debito'), CONCAT('-', monto), monto) AS monto, cod_caja, destino\n" +
                         "FROM trans_cajas_ahorro WHERE nro_ca ="+getNro_caja()+" AND '"+fechaI+"'<=fecha AND fecha<='"+this.fechaH+"';";
            System.out.println("consulta sql: " + sql);
            ps = conexionBD.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("Fecha");
            modelo.addColumn("Hora");
            modelo.addColumn("Tipo de transacción");
            modelo.addColumn("Monto");
            modelo.addColumn("Código caja");
            modelo.addColumn("Destino");

            /*Habia un bug que se habia manifestado en la clase donde al recuperar las fechas y horas de una transferencia
            estas figuraban con 1 dia menos, en mi caso al menos se le restaba 1 dia y horas, por ej tenia una transferencia
            creada el 2018-10-25 a las 16:26:37 y en la BD figuraba correctamente y cuando lo recuperaba en la aplicacion
            aparecian todos los datos correctos salvo la fecha y la hora el cual figuraba 2018-10-24 a las 13:26:37.Entonces
            la solucion que opte fue que cada vez que vaya a insetar en la tabla una fecha a esta se le debe sumar 1 dia y
            cuando se va a insertar una hora a esta se le debe sumar 3 horas y de esta manera la informacion es consistente
            con la base de datos.Todo esto surgio aparentemente de un BUG que los mismos ayudantes dijieron que se habia 
            manifestado este cuatrimestre*/
            while (rs.next()) {

              Object[] filas = new Object[cantidadColumnas];

                for (int i = 0; i < cantidadColumnas; i++) {
                    //Si es una fecha le sumo 1 dia
                    if(i+1==1 || i+1==7 || i+1==13 || i+1==19 || i+1==25 || i+1==31 || i+1==37 || i+1==43 || i+1==49 || i+1==55 || i+1==61 || i+1==67 || i+1==73 || i+1==79 || i+1==85){   
                        fechaS = (Date) rs.getObject(i + 1);
                        fecha = new java.sql.Date(fechaS.getTime()+ TimeUnit.DAYS.toMillis( 1 ));
                        filas[i] = fecha;
                    }
                 else
                    //Si es una hora le sumo 3 horas
                     if(i+1==2 || i+1==8 || i+1==14 || i+1==20 || i+1==26 || i+1==32 || i+1==38 || i+1==44 || i+1==50 || i+1==56 || i+1==62 || i+1==68 || i+1==74 || i+1==80 || i+1==86){   
                        horaS = (java.sql.Time) rs.getObject(i + 1);
                        hora = new java.sql.Time(horaS.getTime()+ TimeUnit.HOURS.toMillis( 3 ));
                        filas[i] = hora;
                     }
                 else
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CampoFechaDesde;
    private javax.swing.JTextField CampoFechaHasta;
    private javax.swing.JPanel PanelFechas;
    private javax.swing.JPanel PanelResumen;
    private javax.swing.JPanel PanelSaldo;
    private javax.swing.JPanel PanelTransacciones;
    private javax.swing.JScrollPane ScrollSaldo;
    private javax.swing.JTable TablaSaldo;
    private javax.swing.JButton botonExtraccion;
    private javax.swing.JButton botonTransferencia;
    private javax.swing.JButton btnResumen;
    private javax.swing.JComboBox<String> cajaOpciones;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tablaPeriodo;
    private javax.swing.JTable tablaResumen;
    // End of variables declaration//GEN-END:variables

    public int getNro_caja() {
       
     try{   
            PreparedStatement ps = null;
            ResultSet rs = null;

            String sql = "SELECT DISTINCT nro_ca  FROM trans_cajas_ahorro NATURAL JOIN banco.tarjeta where banco.tarjeta.nro_tarjeta=" + tarjeta;
            ps = conexionBD.prepareStatement(sql);
            rs = ps.executeQuery();
            
            if(rs.next())
               nro_caja = rs.getInt("nro_ca");
     }
      catch (SQLException ex) {        
            JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(this),
                    ex.getMessage() + "\n",
                    "Error al ejecutar la consulta.",
                    JOptionPane.ERROR_MESSAGE);
        }
     return nro_caja;
    }
}