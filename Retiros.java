import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Retiros extends JFrame implements ActionListener, WindowListener, ItemListener{
	AdministradorCuentas admCuentas;
	CuentaBancaria cuenta;
	JLabel  lbl_otrac;
	JTextField txt_otracantidad;
	JButton btn_retirar;
	CheckboxGroup cbg_cantidades, cbg_cantidades2;
	JPanel pnl_sur, pnl_izq, pnl_dere; 
	Checkbox cb_1,cb_2, cb_5, cb_10, cb_20;
	double monto;
	
	public Retiros(AdministradorCuentas c, CuentaBancaria cuenta)
	{
		admCuentas=c;
		this.cuenta=cuenta;
		this.addWindowListener(this);
		this.setTitle("Banco-Retiros");
		this.setSize(210,300);
		this.setResizable(false);
		ipnlizq();
		ipnlder();
		ipnlsur();
		this.add(pnl_izq,BorderLayout.NORTH);
		this.add(pnl_dere,BorderLayout.CENTER);
		this.add(pnl_sur,BorderLayout.SOUTH);
	}
	
	public void ipnlizq()
	{
		pnl_izq=new JPanel();
		cb_1=new Checkbox("$100",cbg_cantidades, false);
		cb_2=new Checkbox("$200",cbg_cantidades, false);
		cb_5=new Checkbox("$500",cbg_cantidades, false);
		pnl_izq.add(cb_1);
		pnl_izq.add(cb_2);
		pnl_izq.add(cb_5);
	}
	
	public void ipnlder()
	{
		pnl_dere=new JPanel();
		cb_10=new Checkbox("$1000",cbg_cantidades, false);
		cb_20=new Checkbox("$2000",cbg_cantidades2,false);
		lbl_otrac=new JLabel("Otra cantidad");
		txt_otracantidad=new JTextField("",10);
		pnl_dere.add(cb_10);
		pnl_dere.add(cb_20);
		pnl_dere.add(lbl_otrac);
		pnl_dere.add(txt_otracantidad);
	}
	
	public void ipnlsur()
	{
		pnl_sur=new JPanel();
		btn_retirar=new JButton("Retirar");
		btn_retirar.addActionListener(this);
		pnl_sur.add(btn_retirar);
	}
	
	public void itemStateChanged(ItemEvent ie)
	{
		if(((Checkbox)ie.getSource()).getLabel() == "$100")
			monto=100;
		if(((Checkbox)ie.getSource()).getLabel() == "$200")
			monto=200;
		if(((Checkbox)ie.getSource()).getLabel() == "$500")
			monto=500;
		if(((Checkbox)ie.getSource()).getLabel() == "$1000")
			monto=1000;
		if(((Checkbox)ie.getSource()).getLabel() == "$2000")
			monto=2000;
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if (cuenta instanceof CuentaDeCheques) {
			((CuentaDeCheques)cuenta).retirar(monto);
			JOptionPane.showMessageDialog(null,"Transaccion exitosa.");
		}
		else {
			((CuentaDeInversion)cuenta).retirar(monto);
			JOptionPane.showMessageDialog(null,"Transaccion exitosa.");
		}
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
	
}//Fin de clase