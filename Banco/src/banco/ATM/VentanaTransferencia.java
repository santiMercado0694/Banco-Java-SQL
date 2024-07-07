package banco.ATM;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class VentanaTransferencia extends JFrame {
	
	private JPanel panel;
	private JLabel labelDestino;
	private JLabel labelMonto;
	private JTextField numCajaD;
	private JTextField monto;
	private JButton aceptar;
	private JButton cancelar;
        private Connection cnx;
        private ResultSet rs;
        private String tarjeta;
        private String numero_cajaOrigen;
        private String num_cliente;
        private VentanaATM ventanaATM;
	
	public VentanaTransferencia(String numTarjeta, Connection cnx2, VentanaATM vATM){
		super();
		initGUI();
		tarjeta=numTarjeta;
		cnx=cnx2;
                ventanaATM = vATM;
	}

	private void initGUI() {
		setPreferredSize(new Dimension(600, 400));
		this.setBounds(0, 0, 600, 400);
		setVisible(true);
		this.setTitle("Transferencia");
		this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		{
			panel= new JPanel();
			getContentPane().add(panel,BorderLayout.CENTER);
		}
		{
			labelDestino= new JLabel("Ingrese la caja destino: ");
			panel.add(labelDestino);
		}
		{
			numCajaD = new JTextField(15);
			panel.add(numCajaD);
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
                        		"call transferir("+monto.getText()+", "+numero_cajaOrigen+", "+numCajaD.getText()+", 1, "+num_cliente+")");
                       
                       if (rs.next()){
                    	   JOptionPane.showMessageDialog(new JFrame(), rs.getString("resultado"));
                    	   numCajaD.setText("");
                    	   monto.setText("");
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
		
	
	private VentanaTransferencia getFrame(){
		   return this;
	   }
}

