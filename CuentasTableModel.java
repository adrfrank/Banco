/**
 * @(#)CuentasTableModel.java
 *
 *
 * @author 
 * @version 1.00 2013/6/5
 */
 
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;
import javax.swing.DefaultCellEditor;


public class CuentasTableModel extends AbstractTableModel{

	Class cuentaclase;
	CuentaBancaria[] cuentas;
	String[] camposInv={"Saldo actual", "Num cuenta", "Nombre Propietario", "Plazo" }, 
		camposCh={"Saldo actual", "Num cuenta", "Nombre Propietario", "Num Cheques" };	
		
	
    public CuentasTableModel(CuentaDeCheques[] ctas) {
    	cuentas=ctas;
    }
    
    public CuentasTableModel(CuentaDeInversion[] ctas) {
    	cuentas=ctas;
    }
    
    @Override
    public int getRowCount()
    {
        return cuentas.length;
    }
    
    @Override
    public int getColumnCount()            
    {
        return 4;
    }
    
    @Override
    public Object getValueAt(int row, int column)
    {   
    		CuentaBancaria c = cuentas[row];
    		if(c instanceof CuentaDeCheques)
    		{
    			switch(column)		{
    				case 0:
    					return c.regrearSaldoActual();	
    				case 1:
    					return c.regresarNumCuenta();
    				case 2:
    					return c.regresarNombrePropietario();
    				case 3:
    					return ((CuentaDeCheques)c).regresarNumCheques();
    			}
    		}else{//Cuentas de inversion
    			switch(column)		{
    				case 0:
    					return c.regrearSaldoActual();	
    				case 1:
    					return c.regresarNumCuenta();
    				case 2:
    					return c.regresarNombrePropietario();
    				case 3:
    					return ((CuentaDeInversion)c).regresarPlazo();
    			}
    		}
        return null;
    }
    
    //Used by the JTable object to set the column names
    @Override
    public String getColumnName(int column) {
    	if(cuentas instanceof CuentaDeInversion[] )
        	return camposInv[column];
        else return camposCh[column];
    }
    
    //Used by the JTable object to render different
    //functionality based on the data type
    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
    
    @Override
    public boolean isCellEditable(int row, int column)
    {
       /*if (column == 0 || column == 1)
	   {
	        return false;
	   }
	   else
	   {
		return true;
	   }*/
	   	return false;
    }

}