package banco.Administrador;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import quick.dbtable.DBTable;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class VentanaAdmin extends javax.swing.JFrame{
    
	private JPanel panel;
	private JTextArea consulta;
	private JButton enviarConsulta;
	private JButton botonLogout;
	private DBTable tabla;
	private DBTable lista;
	private Connection conexionBD;
	private JScrollPane scrConsulta;
	private String pw;
	private JTable table;
	private DefaultTableModel model;
        private adminLogin ventanaAdminLogin;

	
	public VentanaAdmin (String password, adminLogin al ,Connection c, DBTable t, DBTable l) {
		super();
		pw = password;
                ventanaAdminLogin = al;
                conexionBD = c;
                tabla = t;
                lista = l;
		GUI();
	}

	private void GUI() {
		setPreferredSize(new Dimension(1200, 800));
		this.setBounds(0, 0, 1200, 800);
		setVisible(true);
		BorderLayout thisLayout = new BorderLayout();
		this.setTitle("Panel del alministrador");
		getContentPane().setLayout(thisLayout);	
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);				

		// Lista
		getContentPane().add(lista, BorderLayout.EAST);
		lista.setEditable(false);
		lista.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				filaListaMouseClicked(evt);
			}
		});

		// Tabla		
		getContentPane().add(tabla, BorderLayout.SOUTH);
		tabla.setEditable(false);    

		// Panel
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);

		// Scroll
		scrConsulta = new JScrollPane();
		panel.add(scrConsulta);

		// TextArea editable para consulta SQL
		consulta = new JTextArea();
		scrConsulta.setViewportView(consulta);
		consulta.setTabSize(3);
		consulta.setColumns(80);
		consulta.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
		consulta.setText("SELECT * FROM empleado;");
		consulta.setFont(new java.awt.Font("Monospaced",0,12));
		consulta.setRows(10);

		// Boton ejecutar
		enviarConsulta = new JButton();
		panel.add(enviarConsulta);
		enviarConsulta.setText("Ejecutar");
		enviarConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				ejecutarActionPerformed(evt);
			}
		});
                
                // Boton cerrarSesion
		botonLogout = new JButton();
		panel.add(botonLogout);
		botonLogout.setText("Cerrar sesión");
		botonLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				desconectarBD();
			}
		});
                
		// Table
		model = new DefaultTableModel();
		table = new JTable(model);
		table.setVisible(true);
		getContentPane().add(table, BorderLayout.CENTER);
                setLocationRelativeTo(null);
				
	}

	private void desconectarBD()
	{
		try
		{
			tabla.close();
			lista.close();
                        this.setVisible(false);
                        ventanaAdminLogin.setVisible(true);
                        JOptionPane.showMessageDialog(null,
						"Sesión Finalizada con éxito.");
		}
		catch (SQLException ex)
		{			
		}      
	}

	private void refrescarTabla() {
		try
		{    			
			String sql = this.consulta.getText().trim();
			Statement stmt = this.conexionBD.createStatement(); 
			stmt.execute(sql); /*ejecuta la consulta/update/insert/etc*/
			ResultSet rs = stmt.getResultSet();
			tabla.refresh(rs);						
		}
		catch (SQLException ex)
		{						
			JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(this),
					ex.getMessage() + "\n", 
					"Error al ejecutar la consulta.",
					JOptionPane.ERROR_MESSAGE);			
		}
	}

	public void refrescarLista() {
		
		try
		{    				
			String listaP = "SELECT table_name \n" +				
					"FROM information_schema.tables \n" +                                       
					"where table_schema='banco';"; 
			//String listaP = "show tables;"; EQUIVALENTE A ARRIBA
			
			lista.setSelectSql(listaP.trim());
			lista.createColumnModelFromQuery();

			// actualizamos el contenido de la tabla.   	     	  
			lista.refresh();
			
		}
		catch (SQLException ex)
		{		
			JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(this),
					ex.getMessage() + "\n", 
					"Error al ejecutar la consulta.",
					JOptionPane.ERROR_MESSAGE);
			ex.printStackTrace();

		}
		
	}

	private void refrescarAtributosLista () {
		String fila = this.lista.getValueAt(this.lista.getSelectedRow(), 0).toString();
		String sql = "DESCRIBE "+fila;
		Vector vector = new Vector();		
		try {
			Statement stmt = this.conexionBD.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			model = new DefaultTableModel();
			table = new JTable(model);
			table.setVisible(true);
			getContentPane().add(table, BorderLayout.CENTER);			
			
			while (rs.next()) {
				model.addColumn(rs.getString("Field"));
				vector.add(rs.getString("Field"));
			}
			model.addRow(vector);
		} 
		catch (SQLException ex) {			
			JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(this),
					ex.getMessage() + "\n", 
					"Error al ejecutar la consulta.",
					JOptionPane.ERROR_MESSAGE);
			ex.printStackTrace();
		}
	}

	
	private void ejecutarActionPerformed(ActionEvent evt) {
		this.refrescarTabla();
		this.refrescarLista();
	}
	private void thisComponentHidden(ComponentEvent evt) 
	{
		this.desconectarBD();          
	}
	private void filaListaMouseClicked (MouseEvent ev) {
		this.refrescarAtributosLista();
	}
}
