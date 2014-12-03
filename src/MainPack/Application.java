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
	
		//instantiate objects array
		Objects array = new Objects(200);
		
		//instantiate the read file
		ReadWrite reed = new ReadWrite();
		
		//read and put it into the array
		reed.read(array);
		
		//assign the counters
		array.setFoodCounter(reed.getFoodCounter() - 1);
		array.setClothesCounter(reed.getClothesCounter() - 1);
		
		//default product for handling errors
		Product p = new Product();
		array.insert(197, p);
		array.setIndex(array.getIndex() - 1);
		
		//instantiate the menu
		Menu menu = new Menu(array);
		
		
	}
}
