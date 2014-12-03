/* 
 * Matt Montequin
 * CS 201 - 02
 * Final Project
 * working with Cosmin Lungu
 */

package MainPack;

import java.io.*;
import java.util.Scanner;

public class ReadWrite {
	// Instance variables
	private Scanner in;
	private int foodCounter = 0, clothesCounter = 0;
	private int barCode;
	
	// Default Constructor
	public ReadWrite() throws IOException,FileNotFoundException {
		in = new Scanner(new File("input.txt"));
	}
	
	// Nondefault Constructor
	public ReadWrite (String fileName) throws IOException,FileNotFoundException {
		in = new Scanner(new File(fileName));
	}
	
	private static Manufacturer splitManufacturer (String manufacturer) {
		
		if(!manufacturer.equals(""))
		{
			String [] manArray = manufacturer.split(";");
			Manufacturer returnMan = new Manufacturer(manArray[0],manArray[1],manArray[2]);
			
			return returnMan;
		}
		
		else return new Manufacturer();
	}
	
	// read()
	// reads file to array
	public void read(Objects objectArray) {
		
		String imput;
		
		// loop until end of file
		while ((in.hasNextLine())) {
			
			imput = in.nextLine();
			
			if (imput.charAt(0) == '#') {	// '#' is our comment symbol
				// stores in line by line in array
				imput = in.nextLine();
			}
			
			objectArray.add(asign(imput));
		}
		
		//close input file
		in.close();
		
	//return objectArray;
	}
	
	
	// asign()
	// asigns String into Object
	public Object asign (String lineIn) {
		String [] prodArray = lineIn.split(",");
		int category = Integer.parseInt(prodArray[0]);
		switch (category) {
		case 0:
			barCode = 100 + foodCounter;
			foodCounter ++;
			Food foodItem = new Food(barCode,Double.parseDouble(prodArray[2]),prodArray[1],
					splitManufacturer(prodArray[3]),Integer.parseInt(prodArray[4]));
			return foodItem;
		case 1:
			barCode = 200 + clothesCounter;
			clothesCounter ++;
			Clothes clothesItem = new Clothes(barCode,Double.parseDouble(prodArray[2]),prodArray[1],
					splitManufacturer(prodArray[3]),prodArray[4],prodArray[5]);
			return clothesItem;
		default:
			System.out.println("An error has occurred");
			return new Product();
		}
	}

	public int getFoodCounter()
	{
		return foodCounter;
	}
	
	public int getClothesCounter()
	{
		return clothesCounter;
	}
	
	public void setFoodCounter(int f)
	{
		foodCounter = f;
	}
	
	public void setClothesCounter(int c)
	{
		clothesCounter = c;
	}
}