/* 
 * Cosmin Lungu
 * CS 201 - 01
 * Final Project
 * working with Matt Montequin
 */

package MainPack;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Menu {
	// Instance variables
	private Objects objArray;
	private ReadWrite reader;
	
	// Class variables
	private static Scanner in = new Scanner(System.in);
	private static String lineIn;
	private static int selection;
	private static int pwCounter = 5;
	
	// Default constructor
	public Menu() throws FileNotFoundException, IOException {
		objArray = new Objects(200);
		reader = new ReadWrite();
	}
	
	// Nondefault constructor
	public Menu(Objects anObjArray, ReadWrite aReader) {
		objArray = anObjArray;
		reader = aReader;
	}
	
	public void start()
	{
		System.out.println("Are you:");
		System.out.println("1) Customer");
		System.out.println("2) Admin");
		lineIn = in.nextLine();
		selection = parseInt(lineIn);
		switch (selection) {
		case 1:
			// customer menu
			break;
		case 2:
			adminCheck();
			break;
		default:
			System.out.println("Invalid entry.");
			start();
		}
	}
	
	//admin
	public void adminCheck()
	{
		System.out.println("Enter your password: (go back at any time: 0)");
		lineIn = in.nextLine();
		selection = parseInt(lineIn);
		if (selection == 1845) {
			pannel();
		}
		else if (selection == 0) {
			start();
		}
		else if (pwCounter > 1){
			System.out.println("Incorrect password. Try again. You have " +
		pwCounter + " tries remaining.");
			pwCounter--;
			adminCheck();
		}
		else if (pwCounter == 1) {
			System.out.println("Incorrect password. Try again. You have " +
					pwCounter + " try remaining.");
			pwCounter--;
			adminCheck();
		}
		else if (pwCounter < 1) {
			System.out.println("Incorrect password. You have reached the allowed"
					+ " # of tries.");
			pwCounter += 5;
			start();
		}
	}
	
	public void pannel()
	{
		System.out.println("1) Search (by barcode)");
		System.out.println("2) Sort (by price)");
		System.out.println("3) Add");
		System.out.println("4) Delete");
		System.out.println("5) Update/Edit");
		System.out.println("0) Sign out");
		lineIn = in.nextLine();
		selection = parseInt(lineIn);
		switch (selection) {
		case 0:
			System.out.println("You have successfully been signed out.");
			start();
			break;
		case 1:
			search();
			break;
		case 2:
			sort();
			break;
		case 3:
			add();
			break;
		case 4:
			delete();
			break;
		case 5:
			update();
			break;
		default:
			System.out.println("Invalid entry.");
			pannel();
		}
	}
	
	public void search()
	{
		System.out.println("Type item barcode:");
		lineIn = in.nextLine();
		int barCode = parseInt(lineIn);
		if (objArray.search(barCode) instanceof Product) {
			Product result = (Product) objArray.search(barCode);
			System.out.println(result.toString());
		}
		else if (barCode == 0) {
			pannel();
		}
		else {
			System.out.println("An error has occurred.");
			search();
		}
		pannel();
	}
	
	public void sort()
	{
		System.out.println("1) Low to high");
		System.out.println("2) High to low");
		lineIn = in.nextLine();
		selection = parseInt(lineIn);
		switch (selection) {
		case 0:
			pannel();
			break;
		case 1:
			objArray.sort(0.0);
			break;
		case 2:
			objArray.sort(0);
			break;
		default:
			System.out.println("Invalid entry.");
			sort();
		}
		for(int i = 0; i <= objArray.getIndex() - 1; i++)
			if (((Product)objArray.getObject(i)).getBarCode() < 200)
				System.out.println(((Food)objArray.getObject(i)).toString());
			else System.out.println(((Clothes)objArray.getObject(i)).toString());
		pannel();
	}
	
	public void add()
	{
		System.out.println("Insert data in the following format:");
		System.out.println("category,name/type,price,Manufacturer,quality/size,color");
		System.out.println("Category: 0 for food, 1 for clothes");
		System.out.println("Manufacturer formatted as 'company;country;date'");
		lineIn = in.nextLine();
		objArray.add(reader.asign(lineIn));
		System.out.println("You have added the following product:");
		((Product) (objArray.getObject(objArray.getIndex() - 1))).toString();
		pannel();
	}
	
	public void delete()
	{
		int barCode;
		System.out.println("Enter the barcode of the item you wish to delete:");
		lineIn = in.nextLine();
		barCode = parseInt(lineIn);
		Object selectedObj = objArray.search(barCode);
		System.out.println("You have chosen to delete:");
		System.out.println(selectedObj.toString());
		System.out.println("Are you sure you wish to delete this item?");
		System.out.println("1) Yes");
		System.out.println("2) No");
		lineIn = in.nextLine();
		selection = parseInt(lineIn);
		switch (selection) {
		case 0:
			pannel();
			break;
		case 1:
			objArray.delete(selectedObj);
			System.out.println("The object has been deleted.");
			break;
		case 2:
			System.out.println("The object has not been deleted.");
			break;
		default:
			System.out.println("Invalid entry.");
			delete();
		}
		pannel();
	}

	public void update()
	{
		System.out.println("Enter the barcode of the product you want to update:");
		lineIn = in.nextLine();
		int barCode = parseInt(lineIn);
		if (objArray.search(barCode) instanceof Product) {
			Product result = (Product) objArray.search(barCode);
			updateProduct(result);
			pannel();
		}
		else if (barCode == 0) {
			pannel();
		}
		else {
			System.out.println("An error has occurred.");
			update();
		}
	}	
	
	public void updateProduct(Product aProduct) {
		if (aProduct instanceof Food) {
			System.out.println("Select what you wish to update:");
			System.out.println("1) Product name");
			System.out.println("2) Price");
			System.out.println("3) Manufacturer");
			System.out.println("4) Quality");
			System.out.println("0) Done editing");
			lineIn = in.nextLine();
			selection = parseInt(lineIn);
			switch (selection) {
			case 0:
				break;
			case 1:
				System.out.println("Enter new product name:");
				lineIn = in.nextLine();
				((Food) aProduct).setName(lineIn);
				updateProduct(aProduct);
				break;
			case 2:
				System.out.println("Enter new price:");
				lineIn = in.nextLine();
				aProduct.setPrice(parseDouble(lineIn));
				updateProduct(aProduct);
				break;
			case 3:
				System.out.println("Enter new manufacturer:");
				System.out.println("Valid format: company;country;MM/DD/YYYY");
				lineIn = in.nextLine();
				aProduct.setManufacturer(reader.splitManufacturer(lineIn));
				updateProduct(aProduct);
				break;
			case 4:
				System.out.println("Enter new quality:");
				lineIn = in.nextLine();
				((Food) aProduct).setQuality(parseInt(lineIn));
				updateProduct(aProduct);
				break;
			default:
				System.out.println("An error has occurred");
				updateProduct(aProduct);
				break;
			}	
		}
		else if (aProduct instanceof Clothes) {
			System.out.println("Select what you wish to update:");
			System.out.println("1) Type");
			System.out.println("2) Price");
			System.out.println("3) Manufacturer");
			System.out.println("4) Size");
			System.out.println("5) Color");
			System.out.println("0) Done editing");
			lineIn = in.nextLine();
			selection = parseInt(lineIn);
			switch (selection) {
			case 0:
				break;
			case 1:
				System.out.println("Enter new clothes type:");
				lineIn = in.nextLine();
				((Clothes) aProduct).setType(lineIn);
				updateProduct(aProduct);
				break;
			case 2:
				System.out.println("Enter new price:");
				lineIn = in.nextLine();
				aProduct.setPrice(parseDouble(lineIn));
				updateProduct(aProduct);
				break;
			case 3:
				System.out.println("Enter new manufacturer:");
				System.out.println("Valid format: company;country;MM/DD/YYYY");
				lineIn = in.nextLine();
				aProduct.setManufacturer(reader.splitManufacturer(lineIn));
				updateProduct(aProduct);
				break;
			case 4:
				System.out.println("Enter new size:");
				lineIn = in.nextLine();
				((Clothes) aProduct).setSize(lineIn);
				updateProduct(aProduct);
				break;
			case 5:
				System.out.println("Enter new quality:");
				lineIn = in.nextLine();
				((Clothes) aProduct).setColor(lineIn);
				updateProduct(aProduct);
				break;
			default:
				System.out.println("An error has occurred");
				updateProduct(aProduct);
				break;
			}
		}
	}
	
	// Class methods
	public static boolean isValidInt(String aString) {
		boolean isValid = false;
		try {
			Integer.parseInt(aString);
			isValid = true;
		}
		catch (NumberFormatException exception) {
		}
		return isValid;
	}
	
	public static boolean isValidDouble(String aString) {
		boolean isValid = false;
		try {
			Double.parseDouble(aString);
			isValid = true;
		}
		catch (NumberFormatException exception) {
		}
		return isValid;
	}
	
	public static int parseInt(String aString) {
		if (isValidInt(aString) ==  true) {
			return Integer.parseInt(aString);
		}
		else {
			System.out.println("Error: entry must be an integer");
			return 0;
		}
	}
	
	public static double parseDouble(String aString) {
		if (isValidDouble(aString) ==  true) {
			return Double.parseDouble(aString);
		}
		else {
			System.out.println("Error: entry must be a double");
			return 0;
		}
	}
}
