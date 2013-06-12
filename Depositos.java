import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Depositos extends JFrame implements ActionListener, WindowListener
{

	//JLabel lbl_cantidad;
	JTextField tf_cantidad;
	
	public Depositos(AdministradorCuentas c, CuentaBancaria cuenta)
	{
		tf_cantidad=new JTextField("Ingrese la cantidad a depositar",1);
		//lbl_cantidad=new JLabel("Ingrese la cantidad a depositar: ");
		
		//this.add(lbl_cantidad);
		this.add(tf_cantidad);
	}

	public void actionPerformed(ActionEvent ae){}

	public void windowClosing(WindowEvent we)
	{
		this.setVisible(false);
	}

	public void windowOpened(WindowEvent we){}
	public void windowIconified(WindowEvent we){}    
	public void windowDeiconified(WindowEvent we){}    
	public void windowClosed(WindowEvent we){}
	public void windowActivated(WindowEvent we){}    
	public void windowDeactivated(WindowEvent we){}  

}