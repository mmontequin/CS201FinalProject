/* 
 * Cosmin Lungu
 * CS 201 - 01
 * Final Project
 * working with Matt Montequin
 */

package MainPack;

public class Menu {
	
	public static void start()
	{
		//output the 1. admin 2. costumer thing
	}
	
	//admin
	public static void adminCheck()
	{
		int pass = 0;
		System.out.println("What is the password?");
		//read pass
		if(pass == 1845)
			Menu.pannel();
		else
		{
			System.out.println("The password was wrong!");
			Menu.start();
		}
	}
	
	public static void pannel()
	{
		/*
		 * 1. Search
		 * 2. Sort (by price)
		 * 3. Add
		 * 4. Delete
		 * 5. Update/Edit
		 * */
	}
	
	public static void search()
	{
		//insert the barcode
		//output the product
		//go back to pannel
		Menu.pannel();
	}
	
	public static void sort()
	{
		//1. low to high
		//2. high to low
		//**do the sorting/output
		//go back to pannel
	}
	
	public static void add()
	{
		//insert the data in the folloing format:...
		//manufacturer format:...
		//**get the data, add it...
		//you have added the folloing product:...
		//go back to pannel
	}
	
	public static void delete()
	{
		//enter the barcode
		//are you sure you want to delete prod:...
		//1. yes 2. no
		//the product was (not) deleted
		//go back to pannel
	}

	public static void update()
	{
		//enter the barcode of the product you want to update
		//this is the product:
		//what would you like to update?
		//1. name/type
		//etc
		//**do the stuff to update it
	}	
	
	//costumer
	public static void costumerPannel()
	{
		//1.show food products
		//2. show clothes products
		//3. go back
	}
	
	public static void listFood()
	{
		//list food
		//1. sort
		//2. proceed to checkout
		//3. go back
	}
	
	public static void listClothes()
	{
		//list clothes
		//1.sort
		//2.proceed to checkout
		//3.go back
	}
	
	public static void checkout1()
	{
		//enter the barcodes of the products;
		//enter -1 when you are done
	}
	
	public static void checkout2()
	{
		//you have chose the following
		//output the thing
		//your total is:
		//your tax is:
		//your grand total is:
		
		//thanks for shopping with us
	}
	
}
