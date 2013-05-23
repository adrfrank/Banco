import java.awt.*;
import java.awt.event.*;

public class ConsultasFrame extends Frame implements WindowListener
{
	AdministradorCuentas admCuentas;
	Panel controls;	
	Label lblNumCuenta, lblSactual, lblTipo, lblNombrePropi, lblPlazo, lblNumCheques;
	
	TextField txtNumCuenta, txtSaldoActual, txtTipo, txtNomPropietario, txtPlazo, txtNumCheques;
	
	CheckboxGroup cbg;
	Checkbox cbConIndividual, cbConCheques, cbConInversion;
	
	Button btnConsultar;
	
	public ConsultasFrame(AdministradorCuentas c)
	{
		initControls();
		this.addWindowListener(this);
		admCuentas= c;
		setTitle("Banco - Consultas");
		this.setSize(500,500);
		this.setResizable(true);
		
	}
	
	public void initControls()
	{
		controls= new Panel();
		cbg= new CheckboxGroup();
		cbConIndividual=new Checkbox("Individual",cbg,true);
		cbConCheques=new Checkbox("Cuentas de cheques",cbg,false);
		cbConInversion=new Checkbox("Cuentas de Inversion",cbg,false);
		
		lblNumCuenta= new Label("Numero de cuenta:");
		lblSactual=new Label("Saldo actual: ");
		lblTipo= new Label("Tipo de cuenta: ");
		lblNombrePropi=new Label("Nombre propietario:");
		lblPlazo=new Label("Plazo");
		lblNumCheques=new Label("Numero de cheques:");
		
		txtNumCuenta=new TextField("Ingrese numero de cuenta a consultar", 20);
		txtSaldoActual=new TextField("", 20);
		txtTipo=new TextField("", 20);
		txtNomPropietario=new TextField("", 20);
		txtPlazo=new TextField("", 20);
		txtNumCheques=new TextField("", 20);
		
		controls.setLayout(new GridLayout(8,2));
		controls.add(cbConInversion);
		controls.add(cbConCheques);
		controls.add(lblNumCuenta);
		controls.add(txtNumCuenta);
		controls.add(lblTipo);
		controls.add(txtTipo);
		controls.add(lblNombrePropi);
		controls.add(txtNomPropietario);
		controls.add(lblPlazo);
		controls.add(txtPlazo);
		controls.add(lblNumCheques);
		controls.add(txtNumCheques);
		//buttons=new Panel();
		btnConsultar=new Button("Consultar");
		//btnConsultar.addActionListener(this);
		controls.add(btnConsultar);
		//this.add(buttons,BorderLayout.CENTER);
		this.add(controls,BorderLayout.CENTER);
				
	}
	
	/*public void initButtons()
	{
		
	}*/
	
	public void windowClosing(WindowEvent we){
    	this.setVisible(false);
    }
    public void windowOpened(WindowEvent we){}
    public void windowIconified(WindowEvent we){}    
    public void windowDeiconified(WindowEvent we){}    
    public void windowClosed(WindowEvent we){}
    public void windowActivated(WindowEvent we){}    
    public void windowDeactivated(WindowEvent we){}    

	
}//Fin de clase