/**
 * @(#)CuentaDeInversion.java
 *
 *
 * @author Adrian Francisco Gonzalez Gutierrez
 * @version 1.00 2013/4/23
 */


public class CuentaDeInversion extends CuentaBancaria {
	//Atributo
	String plazo;

    public CuentaDeInversion(int ncuenta, double sactual, String npropietario, String plazo) {
    	super(ncuenta,sactual,npropietario);
    	this.plazo = plazo;
    }
    
    public void mostrarPlazo(){
    	System.out.println("Plazo = "+plazo);
    }
    
    public void cambiarPlazo(String plazo){
    	this.plazo = plazo;
    }
    
    public String regresarPlazo(){
    	return plazo;
    }
    
    public String toString(){
    	return numcuenta+"\t\t\t"+saldoactual+"\t\t\t"+nombrepropietario+"\t\t\t"+plazo;
    }
    
    
}