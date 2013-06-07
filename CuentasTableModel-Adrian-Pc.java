/**
 * @(#)CuentasTableModel.java
 *
 *
 * @author 
 * @version 1.00 2013/6/5
 */


public class CuentasTableModel {

    public CuentasTableModel() {
    }
    
    @Override
        public int getRowCount()
        {
            return data.length;
        }
        
        @Override
        public int getColumnCount()            
        {
            return columnNames.length;
        }
        
        @Override
        public Object getValueAt(int row, int column)
        {        
            return data[row][column];
        }
        
        //Used by the JTable object to set the column names
        @Override
        public String getColumnName(int column) {
            return columnNames[column];
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
           if (column == 0 || column == 1)
	   {
	        return false;
	   }
	   else
	   {
		return true;
	   }
        }

    
    
}