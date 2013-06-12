import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ConsultasFrame extends JFrame implements WindowListener, ItemListener
{

	AdministradorCuentas admCuentas;
//<<<<<<< HEAD
	//Panel controls;	
	Label lblNumCuenta, lblSactual, lblTipo, lblNombrePropi, lblPlazo, lblNumCheques;
	
	TextField txtNumCuenta, txtSaldoActual, txtTipo, txtNomPropietario, txtPlazo, txtNumCheques;
	
//=======
	Panel controls,pnlTipo;
	JTable 	tblcuentas;
//>>>>>>> 9c50ad994a71f92c3d708df7a25351025444f91d
	CheckboxGroup cbg;
	Checkbox  cbConCheques, cbConInversion;
	
	Button btnConsultar;
	
	public ConsultasFrame(AdministradorCuentas c)
	{
		System.out.println("Cuentas de cheques en consultas: "+c.cuentasDeChequesActuales());
		admCuentas= c;
		initControls();
		this.addWindowListener(this);		
		setTitle("Banco - Consultas");
		this.setSize(400,200);
		this.setResizable(true);		
	}
	
	public void initControls()
	{
		controls= new Panel();
		pnlTipo = new Panel();
		cbg= new CheckboxGroup();
		cbConCheques=new Checkbox("Cuentas de cheques",cbg,false);
		cbConInversion=new Checkbox("Cuentas de Inversion",cbg,false);
//<<<<<<< HEAD
		
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
		btnConsultar=new Button("Consultar");
		controls.add(btnConsultar);
		this.add(controls,BorderLayout.CENTER);
				
//=======
		cbConCheques.addItemListener(this);
		cbConInversion.addItemListener(this);
		tblcuentas =  new JTable();	
		pnlTipo.setLayout(new FlowLayout());
		pnlTipo.add(cbConInversion);
		pnlTipo.add(cbConCheques);
		controls.add(tblcuentas);		
		this.add(controls,BorderLayout.CENTER);
		this.add(pnlTipo,BorderLayout.NORTH);
			controls.add(tblcuentas);	
	}
	
	void initTable(boolean EsCheques){
		System.out.println("initTable: "+EsCheques);
		if(EsCheques)
			tblcuentas.setModel(new CuentasTableModel(admCuentas.getCuentasCheques()));
		else
			tblcuentas.setModel(new CuentasTableModel(admCuentas.getCuentasInversion()));
		tblcuentas.setAutoCreateRowSorter(true);
		tblcuentas.setShowGrid(false);        
	}
	
		
	public void itemStateChanged(ItemEvent ie){
		if(((Checkbox) ie.getSource()).getLabel()=="Cuentas de cheques")
			initTable(true);
		else
			initTable(false);
		System.out.println(((Checkbox) ie.getSource()).getLabel()=="Cuentas de cheques");
//>>>>>>> 9c50ad994a71f92c3d708df7a25351025444f91d
	}
	
	public void windowClosing(WindowEvent we){
    	this.setVisible(false);
    }
    public void windowOpened(WindowEvent we){}
    public void windowIconified(WindowEvent we){}    
    public void windowDeiconified(WindowEvent we){}    
    public void windowClosed(WindowEvent we){}
    public void windowActivated(WindowEvent we){
    	
    }    
    public void windowDeactivated(WindowEvent we){}    

	
}//Fin de clase