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
		
		
		System.out.println(array.getObject(5));
		
	}
}
