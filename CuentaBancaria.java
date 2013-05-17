/**
 * @(#)CuentaBancaria.java
 * Practica individual
 *
 * @author Adrian Francisco Gonzalez
 * @version 1.00 2013/4/23
 */


public class CuentaBancaria {
	//Atributos
	int numcuenta;
	double saldoactual;
	String nombrepropietario;
	
    public CuentaBancaria(int numcuenta, double saldoactual, String nombrepropietario) {
    	this.numcuenta = numcuenta;
    	this.saldoactual = saldoactual;
    	this.nombrepropietario = nombrepropietario;
    }
    
    //Familia de métodos mostrar
    public void mostrarNumCuenta(){
    	System.out.println("Numero de cuenta = "+numcuenta);
    }
    
    public void mostrarSaldoActual(){
    	System.out.println("Saldo actual = "+saldoactual);
    }
    
    public void mostrarNombrePropietario(){
   		System.out.println("Nombre propietario = "+nombrepropietario); 
   	}
   	
   	//Familia de metodos cabiar
   	public void cambiarNumCuenta(int numcuenta){
   		this.numcuenta = numcuenta;
   	}
   	
   	public void cambiarSaldoActual(double saldoactual){
   		this.saldoactual = saldoactual;
   	}
   	
   	public void cambiarNombrePropietario(String nombrepropietario){
   		this.nombrepropietario = nombrepropietario;
   	}
   	
   	//familia de métodos regresar
   	public int regresarNumCuenta(){
   		return numcuenta;
   	}
   	
   	public double regrearSaldoActual(){
   		return saldoactual;
   	}
   	
   	public String regresarNombrePropietario(){
   		return nombrepropietario;
   	}   	
   	
   	
   	public void depositar(double cantidad){
   		if(cantidad>0)
   		{
   			saldoactual += cantidad;
   			System.out.println("El deposito se realizó satisfactoriamente");
   			this.mostrarSaldoActual();
   		}else
   			System.out.println("Cantidad no válida");
   	}
   	
   	public boolean retirar(double cantidad){
		if(cantidad>=saldoactual)   	
		{
			saldoactual-=cantidad;
			
			return true;
		}
		return false;
   	}		
   		
   		
   	public static void main(String args[])
   	{
   		AdministradorCuentas adm = new AdministradorCuentas();
   		adm.init();   		
   	}
   		
}