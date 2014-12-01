/* 
 * Cosmin Lungu
 * CS 201 - 01
 * Final Project
 * working with Matt Montequin
 */

package MainPack;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Application {

	public static void main(String args[]) throws FileNotFoundException, IOException
	{
		
		
		Objects array = new Objects(200);
		ReadWrite reed = new ReadWrite();
		
		reed.read(array);
		
		for(int i = 0; i <= array.getIndex() - 1; i++)
			if(((Product)array.getObject(i)).getBarCode() < 200)
				System.out.println(((Food)array.getObject(i)).toString());
			else System.out.println(((Clothes)array.getObject(i)).toString());
		
		
	}
}
