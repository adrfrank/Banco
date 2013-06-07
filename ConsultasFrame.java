import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ConsultasFrame extends JFrame implements WindowListener, ItemListener
{

	AdministradorCuentas admCuentas;
	Panel controls,pnlTipo;
	JTable 	tblcuentas;
	CheckboxGroup cbg;
	Checkbox  cbConCheques, cbConInversion;
	
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