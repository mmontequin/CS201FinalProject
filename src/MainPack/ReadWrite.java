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
	public Scanner in;
	public int index;
	
	// Default Constructor
	public ReadWrite() throws IOException {
		in = new Scanner(new File("input.txt"));
	}
	
	// Nondefault Constructor
	public ReadWrite (String fileName) throws IOException {
		in = new Scanner(new File(fileName));
	}
	
	private static Manufacturer splitManufacturer (String manufacturer) {
		String [] manArray = manufacturer.split(";");
		Manufacturer returnMan = new Manufacturer(manArray[0],manArray[1],manArray[2]);
		return returnMan;
	}
	
	// read()
	// reads String into Product
	private Product read (String lineIn) {
		String [] prodArray = lineIn.split(",");
		int category = Integer.parseInt(prodArray[0]);
		switch (category) {
		case 0:
			Food foodItem = new Food(0,prodArray[1],Double.parseDouble(prodArray[2]),
					splitManufacturer(prodArray[3]),0.0,Integer.parseInt(prodArray[4]));
			return foodItem;
		case 1:
			Clothes clothesItem = new Clothes(0,prodArray[1],Double.parseDouble(prodArray[2]),
					splitManufacturer(prodArray[3]),prodArray[4],prodArray[5]);
			return clothesItem;
		default:
			System.out.println("An error has occurred");
			return new Product();
		}
	}
	
	// write()
	// writes file to array
	public Objects write() {
		// instantiating object
		Objects objectArray = new Objects();
		
		// loop until end of file
		while ((in.hasNextLine())) {
			if (in.nextLine().charAt(0) != '#') {	// '#' is our comment symbol
				// stores in line by line in array
				objectArray.add(read(in.nextLine()));
			}
		}
		
		// close input file
		in.close();
		
		return objectArray;
	}
	
}
