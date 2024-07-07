package banco.ATM;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class VentanaExtraccion extends JFrame {
	
    private JPanel panel;
    private JPanel panel2;
    private JLabel labelMonto;
    private JLabel labelSaldo;
    private JTextField monto;
    private JTextField saldo;
    private JButton aceptar;
    private JButton cancelar;
    private Connection cnx;
    private ResultSet rs;
    private String tarjeta;
    private String numero_cajaOrigen;
    private String num_cliente;
    private VentanaATM ventanaATM;

	
	public VentanaExtraccion(String numTarjeta, Connection cnx2,VentanaATM vATM){
		super();		
		cnx=cnx2;
                ventanaATM = vATM;
                initGUI();
		tarjeta= numTarjeta;
                
	}

	private void initGUI() {
		setPreferredSize(new Dimension(600, 400));
		this.setBounds(0, 0, 600, 400);
		setVisible(true);
		this.setTitle("Extraccion");
		this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		{
			panel= new JPanel();
                        panel2= new JPanel();
			getContentPane().add(panel,BorderLayout.CENTER);
                        getContentPane().add(panel2,BorderLayout.SOUTH);
		}
		{
			labelMonto = new JLabel("Monto: ");
			panel.add(labelMonto);
		}
		{
			monto = new JTextField(15);
			panel.add(monto);
                        
		}
                {
                        labelSaldo = new JLabel("Saldo actual: ");
			panel2.add(labelSaldo);
		}
		{
			saldo = new JTextField(10);
                        saldo.setEnabled(false);
			panel2.add(saldo);
                        mostrarSaldoCaja();
                        
		}
                
		{
			aceptar = new JButton("Confirmar");
			panel.add(aceptar);
			aceptar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt){
                	try {
                		rs=cnx.createStatement().executeQuery(
                                "SELECT t.nro_ca, t.nro_cliente FROM TARJETA as t WHERE t.nro_tarjeta="+tarjeta);
                        if (rs.next()){
                        		numero_cajaOrigen=rs.getString("nro_ca");
                        		num_cliente= rs.getString("nro_cliente");
                        }
                        else{
                        	//Muestro error si los datos son incorrectos
                            JOptionPane.showMessageDialog(new JFrame(),"Datos incorrectos");
                        }
                        
                        
                        
                       rs= cnx.createStatement().executeQuery(
                        		"call extraccion("+monto.getText()+", "+numero_cajaOrigen+", 1, "+num_cliente+")");
                       
                       if (rs.next()){
                    	   JOptionPane.showMessageDialog(new JFrame(), rs.getString("resultado"));
                    	   monto.setText("");
                           mostrarSaldoCaja();
                    	   }
                   
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                }
			});
		}
		{
			cancelar = new JButton("Cancelar");
			panel.add(cancelar);
			cancelar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt){
					try{	
                                            getFrame().dispose();
                                            ventanaATM.setVisible(true);
					}
					catch(Exception e){
						
					}
				}
			});
		}
	}
	
	private VentanaExtraccion getFrame(){
		   return this;
	   }
        private void mostrarSaldoCaja(){
            try {
                    PreparedStatement ps = null;
                    ResultSet rs = null;              
                     String sql = "SELECT c.saldo FROM caja_ahorro as c WHERE c.nro_ca="+ventanaATM.getNro_caja();
                     System.out.println(sql);
                     ps = cnx.prepareStatement(sql);
                     rs = ps.executeQuery();
                     
                    if (rs.next())
                      saldo.setText(rs.getString("saldo"));
                    
            } catch (Exception e) {
                    System.out.println(e.getMessage());
                }        
        }
}

