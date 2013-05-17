/**
 * @(#)Entradas.java
 *
 *
 * @author 
 * @version 1.00 2013/4/23
 */
import java.io.*;

public class MyReader {
	InputStreamReader is;
	BufferedReader br;
	
    public MyReader() {
    	is =  new InputStreamReader(System.in);
    	br = new BufferedReader(is);
    }
    
    public int getInt() throws IOException
    {
    	return Integer.parseInt(br.readLine());
   	}
    
    public String getString() throws IOException
    {
    	return br.readLine();
    }
    
    public double getDouble() throws IOException{
    	return Double.parseDouble(br.readLine());
    }
}