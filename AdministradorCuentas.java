/**
 * @(#)AdministradorCuentas.java
 *
 *
 * @author Adrian Francisco Gonzalez g.
 * @version 1.00 2013/4/24
 */
 import java.awt.*;
 import java.util.*;

public class AdministradorCuentas {
     MyReader l;
     CuentaDeCheques ch[];
     CuentaDeInversion inv[];
     
    
     
     
    //Constructor
    public AdministradorCuentas() {
    	l= new MyReader();
    	ch = new CuentaDeCheques[5];
    	inv = new CuentaDeInversion[5];
    	
    	
    }
    
    public void init() throws Exception{
    
    	int op=-1;
   		do{
   			showMainMenu();
   			try{
   				op=l.getInt();
   				
   			}catch(Exception e)
   			{
   				show("Problema con los datos!");
   			}
   			selectOption(op);   		
   		}while(op != 7);  
    }
    
    //Static methods
   	public static void show(String msj)
   	{
   		System.out.println(msj)	;
   	}
   	
   	public static void show(){
   		System.out.println();
   	}
   	
   	public static void showInline(String msj)
   	{
   		System.out.print(msj);
   	}
   	
   	//ShowMethods   	
   	public void showMainMenu(){
   		show();
   		show("*MENU PRINCIPAL*");
   		show();
   		show("1. Altas");
   		show("2. Bajas");
   		show("3. Cambios");
   		show("4. Consultas");
   		show("5. Depositar");
   		show("6. Retirar");
   		show("7. Salir");
   		show();
   		showInline("Elige tu opcion: ");
   		
   	}
   	
   	public void showAltasMenu(){
   		show();
   		show("*MENU ALTAS*")	;
   		show("1. Alta de cuenta de cheques");
   		show("2. Alta de cuenta de inversion");
   		show("3. Regresar al menu principal");
   		show();
   		showInline("Elige tu opcion: ");
   		int op;
   		try{
			op=l.getInt();
			if(op==1||op==2)
				altaCuenta(op);
			else
				throw new Exception("Opcion no valida");
		}catch(Exception ex){
			show("Opcion no valida!");
		}
		
   	}
   	
   	public void showBajasMenu()throws Exception{
   		int cuenta =0;
   		show();
   		show("*BAJAS*");
   		showInline("Ingrese su numero de cuenta: ");
   		try{
			cuenta=l.getInt();
		}catch(Exception ex){
			show("Opcion no valida!");
		}
		bajaCuenta(cuenta);		
   	}
   	
   	public CuentaDeCheques[] getCuentasCheques(){
   		int n = cuentasDeChequesActuales();
   		int cont=0;
   		CuentaDeCheques[] c = new CuentaDeCheques[n];
   		for(int i =0; i < ch.length;i++)
   			if(ch[i] != null)
   				c[cont++]=ch[i];
   		return c;
   	}
   	
   	public CuentaDeInversion[] getCuentasInversion(){
   		int n = cuentasDeInversionActuales();
   		int cont=0;
   		CuentaDeInversion[] c = new CuentaDeInversion[n];
   		for(int i =0; i < inv.length;i++)
   			if(inv[i] != null)
   				c[cont++]=inv[i];
   		return c;
   	}
   	
   	
   	//Consultas
   	public void showConsultasMenu(){
   		int op=4;
   		do{
   			show();
	   		show("*MENU CONSULTAS*");
	   		show("1. Consulta individual");
	   		show("2. Consultar cuentas de cheques");
	   		show("3. Consultar cuentas de inversion");
	   		show("4. Regresar al menu principal");
	   		showInline("Elige tu opcion: ");
	   		try{
				op=l.getInt();				
			}catch(Exception ex){
				show("Opcion no valida!");
			}
			switch(op){
				case 1:
					consultarCuenta();
					break;
				case 2:
					consultarCuentasCheques();
					break;
				case 3:
					consultarCuentasInversion();
					break;
			}	
   		}while(op != 4);		
   		
   	}
   	
   	public void consultarCuentasCheques(){
   		show();
   		if(cuentasDeChequesActuales()==0)
   		{
   			show("Aun no hay cuentas de este tipo");
   			return;
   		}
   		show("*Cuentas de cheques*");
   		show("Cuenta\t\t\tSaldoActual\t\t\tPropietario\t\t\tNum. Cheques");
   		for(int i=0; i < ch.length; i++)
   			if(ch[i]!=null)
   				show(ch[i].toString());
   		
   	}
   	
   	public void consultarCuentasInversion(){
   		show();if(cuentasDeInversionActuales()==0)
   		{
   			show("Aun no hay cuentas de este tipo");
   			return;
   		}
   		show("*Cuentas de cheques*");
   		show("Cuenta\t\t\tSaldoActual\t\t\tPropietario\t\t\tNum. Cheques");
   		for(int i=0; i < ch.length; i++)
   			if(inv[i]!=null)
   				show(inv[i].toString());
   		
   	}
   	
   	public void consultarCuenta()  {
   			show();
   			showInline("Ingresa el numero de cuenta: ");
   			try{
   				int ncuenta = l.getInt();
	   			CuentaBancaria c = existeCuenta(ncuenta);
	   			if(c != null)
	   			{
	   				c.mostrarNumCuenta();
	   				c.mostrarNombrePropietario();
	   				c.mostrarSaldoActual();
	   				if(c instanceof CuentaDeCheques)
	   					((CuentaDeCheques)c).mostrarNumCheques();
	   				else
	   					((CuentaDeInversion)c).mostrarPlazo();
	   			}
	   			else{
	   				show("La cuenta no existe!");
	   			}
   			}catch(Exception ex){
   				show("Entrada no valida");
   			}
   			
   			
   			
   	}
   	
   	//Cambios
   	public void showCambiosMsj(){
   		int cuenta;
   		show();
   		show("*CAMBIOS*");
   		show("Ingrese el numero de cuenta: ");
   		try{   					
			cuenta = l.getInt();
			cambiarCuenta(cuenta);  
		}catch(Exception ex){
			show("Numero de cuenta no valido");
		}
   	}   	
   	
   	public void cambiarCuenta(int ncuenta){
   		show();
   		CuentaBancaria c = existeCuenta(ncuenta);
   		if(c != null)
   		{
   			int op;
   			if(c instanceof CuentaDeInversion)
   			{
   				show("*CUENTA DE INVERSION*");
   				show("1. Nombre del propietario");
   				show("2. Plazo");
   				show("3. Regresar al menu anterior");
   				try{
	   				op=l.getInt();
	   				switch(op)
	   				{
	   					case 1:
	   						show();
	   						show("Ingrese el nuevo nombre del propietario: ");
	   						c.cambiarNombrePropietario(l.getString());
	   						break;
	   					case 2:
	   						show("Ingrese el nuevo plazo");
	   						((CuentaDeInversion)c).cambiarPlazo(l.getString());
	   						break;
	   				}
   				}catch(Exception ex){
   					show("Opcion Invalida!!");
   				}   				
   				
   			}else{
   				show("*CUENTA DE CHEQUES*");
   				show("1. Nombre del propietario");
   				show("2. Numero de cheques");
   				show("3. Regresar al menu anterior");
   				try{
   					op=l.getInt();
   					switch(op){
   						case 1: 
   							show();
   							show("Ingrese el nuevo nombre del propietario: ");
   							c.cambiarNombrePropietario(l.getString());
   							break;
   						case 2:
   							show();
   							show("Ingrese el nuevo numero de cheques: ");
   							((CuentaDeCheques)c).cambiarNumCheques(l.getInt());
   							break;
   					}   					
   				}catch(Exception ex){
   					show("Opcion Invalida!!");
   				}
   				
   			}
   		}
   		else
   			show("No existe la cuenta");
   	}
   	
   	//Depositar
   	public void showDepositarMsj(){
   		show();
   		show("Ingrese el numero de cuenta: ");
   		try{
   			int ncuenta = l.getInt();
	   		CuentaBancaria cuenta =  existeCuenta(ncuenta);
	   		if(cuenta != null){
	   			show("Ingrese la cantidad a depositar");
	   			double cant = l.getDouble();
	   			cuenta.depositar(cant);
	   		}else{
	   			show("La cuenta no existe!");
	   		}
	   	}catch(Exception ex){
	   		show("Numero no valido");
	   	}
   		
   		
   		
   	}
   	
   	//Retirar   	
   	public void showRetirarMsj(){
   		show();
   		show("Ingrese el numero de cuenta: ");
   		try{
   			int ncuenta = l.getInt();
	   		CuentaBancaria cuenta = existeCuenta(ncuenta);
	   		if(cuenta != null){
	   			show();
	   			cuenta.mostrarNumCuenta();
	   			cuenta.mostrarNombrePropietario();
	   			cuenta.mostrarSaldoActual();
	   			show();
	   			show("Ingrese la cantidad a retirar: ");
	   			double cant = l.getDouble();
	   			if(cuenta.retirar(cant))
	   			{
	   				show("El retiro se realizo satisfactoriamente");
	   				cuenta.mostrarSaldoActual();
	   			}
	   			else{
	   			
	   				show("Esta cuenta no tiene el saldo suficiente");
	   			}
	   		}else{
	   			show("La cuenta no existe!");
	   		}
   		}catch(Exception ex){
   			show("Numero de cuenta no valido");
   		}
   		
   	}
   	
   	//Methods   	
   	public CuentaBancaria existeCuenta(int ncuenta){
   		for(int i=0; i < ch.length; i++){
   			if(ch[i] != null && ncuenta == ch[i].regresarNumCuenta())
   				return ch[i];
   		}
   		for(int i=0; i < inv.length; i++)
   			if(inv[i] != null && ncuenta ==  inv[i].regresarNumCuenta())
   				return inv[i];
   		return null;
   	}
   	
   	public void agregarCuenta(CuentaBancaria c) throws Exception
   	{
   		if(c instanceof CuentaDeCheques){//Insertar cuenta de cheques
   			if(cuentasDeChequesActuales() < ch.length)
   				for(int i=0; i < ch.length; i++)
   				{
   					if(ch[i] == null)
   					{
   						ch[i] = (CuentaDeCheques)c;
   						break;
   					}
   				}
   			else
   				throw new Exception("Ya no hay espacio para mas cuentas de cheques!");
   		}else {//Insertar cuenta de inversion
   			if(cuentasDeInversionActuales() < inv.length)
   				for(int i =0; i < inv.length; i++){
   				
   					if(inv[i] == null){
   						inv[i] = (CuentaDeInversion)c;
   						break;
   					}
   				}
   			else
   				throw new Exception("Ya no hay espacio para mas cuentas de inversion!");
   		}
   	}
   	
   	public int cuentasDeChequesActuales(){
   		int cont=0;
   		for(int i=0; i < ch.length; i++)
   		{
   			if(ch[i] != null)
   				cont++;
   		}
   		return cont;
   	}
   	  	
   	public int cuentasDeInversionActuales(){
   		int cont=0;
   		for(int i=0; i < inv.length; i++)
   		{
   			if(inv[i] != null)
   				cont ++;
   		}
   		return cont;
   	}   	
   	
   	public void altaCuenta(int n)
   	{
   		int ncuenta, ncheques;
   		String npropietario, plazo;
   		double sactual;
   		if((n==1&&ch.length == cuentasDeChequesActuales())||(n==1 && inv.length == cuentasDeInversionActuales()))
   			show("Ya no hay espacio para mas cuentas de este tipo!!");
   		else
   		try{
	   		do{
				showInline("Ingrese el numero de cuenta: ");
				ncuenta=l.getInt();		
					if(existeCuenta(ncuenta)!= null)
						show("Ya existe un numero de cuenta con ese numero!");
			}while(existeCuenta(ncuenta)!= null || ncuenta < 0);
			showInline("Ingrese el saldo actual: ");
			sactual=l.getDouble();
			showInline("Ingrese el nombre del propietario: ");
			npropietario = l.getString();
	   		switch(n){
	   			case 1://cheques  				
	   				showInline("Ingrese el numero de cheques: ");
	   				ncheques = l.getInt();
	   				CuentaDeCheques c = new CuentaDeCheques(ncuenta,sactual,npropietario,ncheques);
	   				agregarCuenta(c)		;
	   				break;
	   			case 2://Inversion
	   				showInline("Ingrese el plazo: ");
	   				plazo = l.getString();
	   				CuentaDeInversion in =  new CuentaDeInversion(ncuenta,sactual,npropietario,plazo);
	   				agregarCuenta(in);
	   				break;
	   		}   			
   		}catch(Exception ex){
   			show("Datos invalidos! ");
   		}
   		
   	}
   	
   	public void bajaCuenta(int n) throws Exception{
   		boolean elim=false;
   		if(cuentasDeChequesActuales()==0&&cuentasDeInversionActuales()==0)
   		{
   			show("No hay cuentas, no hay nada para eliminar");
   			return;
   		}
   		for(int i=0; i<ch.length; i++)
   		{
   			if(ch[i]!=null&&ch[i].regresarNumCuenta()==n)	
   			{
   				ch[i] = null;
   				elim=true;
   				show("La cuenta ha sido eliminada");
   				return;
   			}
   		}   		
		for(int i=0; i < inv.length; i++)
		{
			if(inv[i]!=null && inv[i].regresarNumCuenta() == n)
			{
				inv[i]= null;
				
				show("La cuenta ha sido eliminada");
				return;
			}
		}
   		throw new Exception("No existe la cuenta");   		
   	}  	
   	   	
   	public void selectOption(int op)throws Exception{
   		MyReader l= new MyReader();
   		int cuenta 		;
   		switch(op){
   			case 1://Altas
				showAltasMenu();
				
				break;
   			case 2://Bajas    					
				showBajasMenu();				   				
   				break;
   			case 3://Cambios
   				showCambiosMsj();   				   								
   				break;
   			case 4://Consultas   				
   				showConsultasMenu();   								
   				break;
   			case 5://Depositar
   				showDepositarMsj();
   				break;
   			case 6://Retirar
   				showRetirarMsj();
   				break;
   			default://Salir (No hacer nada)   				
   				break;
   		}
   	}    
    	
   
    
}
