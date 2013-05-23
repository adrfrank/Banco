import java.awt.*;
import java.awt.event.*;

public class BajasFrame extends Frame implements WindowListener
{
	AdministradorCuentas admCuentas;
	
	Panel pnlControls;
	
	Label lblNumCuenta;
	
	TextField txtNumCuenta;
	
	Button btnEliminar;
	
	public BajasFrame(AdministradorCuentas c)
	{
		initControls();
		this.addWindowListener(this);
		admCuentas=c;
		setTitle("Banco - Bajas");
		this.setSize(400,300);
		this.setResizable(false);
	}
	
	public void initControls()
	{
		pnlControls = new Panel();
		
		lblNumCuenta = new Label("Numero de cuenta: ");
		btnEliminar=new Button("Eliminar");
		txtNumCuenta= new TextField("Ingrese No.de cuenta a eliminar", 20);
		
		pnlControls.setLayout(new GridLayout(4,2));
		pnlControls.add(lblNumCuenta);
		pnlControls.add(txtNumCuenta);
		pnlControls.add(btnEliminar);
		this.add(pnlControls,BorderLayout.CENTER);
	}
	
	public void windowClosing(WindowEvent we){
    	this.setVisible(false);
    }
    public void windowOpened(WindowEvent we){}
    public void windowIconified(WindowEvent we){}    
    public void windowDeiconified(WindowEvent we){}    
    public void windowClosed(WindowEvent we){}
    public void windowActivated(WindowEvent we){}    
    public void windowDeactivated(WindowEvent we){}    
	
}//Fin de la clase