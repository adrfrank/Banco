/**
 * @(#)CuentaDeCheques.java
 *
 *
 * @author Adrian Francisco González Gutierrez
 * @version 1.00 2013/4/23
 */


public class CuentaDeCheques extends CuentaBancaria {
	int numcheques;

    public CuentaDeCheques(int ncuenta, double sactual,String npropietario, int ncheques) {
    	super(ncuenta,sactual,npropietario);
    	numcheques = ncheques;
    }
    
    public void mostrarNumCheques(){
    	System.out.println("Numero de cheques = "+numcheques);
    }
    
    public void cambiarNumCheques(int ncheques){
    	numcheques=ncheques;
    }
    
    public int regresarNumCheques(){
    	return numcheques;
    }
    
    public String toString(){
    	return numcuenta+"\t\t\t"+saldoactual+"\t\t\t"+nombrepropietario+"\t\t\t"+numcheques;
    }
    
}