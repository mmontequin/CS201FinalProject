/* 
 * Cosmin Lungu
 * CS 201 - 01
 * Final Project
 * working with Matt Montequin
 */

package MainPack;

import java.util.Scanner;

public class Menu{
	
	private Objects arr;
	private int counter=0;
	int[] bcArr = new int[200];
	double total=0, tax=0;
	
	public Menu(Objects a)
	{
		arr = a;
		start();
	}
	
	public void start()
	{
		//output the 1. admin 2. costumer thing
		System.out.println("Welcome!");
		System.out.println("In frot of every command there will be a number. Please imput that number to access that command");
		
		System.out.println("1. ADMIN");
		System.out.println("2. Costumer");
		
		Scanner in = new Scanner(System.in);
		int x = in.nextInt();
		
		if(x == 1)
			adminCheck();
		else costumerPannel();
	}
	
	//admin
	public void adminCheck()
	{
		int pass = 0;
		System.out.println("What is the password?");
		//read pass
		if(pass == 1845)
			pannel();
		else
		{
			System.out.println("The password was wrong!");
			start();
		}
	}
	
	public void pannel()
	{
		/*
		 * 1. Search
		 * 2. Sort (by price)
		 * 3. Add
		 * 4. Delete
		 * 5. Update/Edit
		 * */
	}
	
	public void search()
	{
		//insert the barcode
		//output the product
		//go back to pannel
		pannel();
	}
	
	public void sort()
	{
		//1. low to high
		//2. high to low
		//**do the sorting/output
		//go back to pannel
	}
	
	public void add()
	{
		//insert the data in the folloing format:...
		//manufacturer format:...
		//**get the data, add it...
		//you have added the folloing product:...
		//go back to pannel
	}
	
	public void delete()
	{
		//enter the barcode
		//are you sure you want to delete prod:...
		//1. yes 2. no
		//the product was (not) deleted
		//go back to pannel
	}

	public void update()
	{
		//enter the barcode of the product you want to update
		//this is the product:
		//what would you like to update?
		//1. name/type
		//etc
		//**do the stuff to update it
	}	
	
	//costumer
	public void costumerPannel()
	{
		//1.show food products
		System.out.println("1. Show food products");
		//2. show clothes products
		System.out.println("2. Show clothes products");
		//3. show everything
		System.out.println("3. Show all the products");
		//4. go back
		System.out.println("4. Go back");
		
		Scanner in = new Scanner(System.in);
	    int x = in.nextInt();
	    
	    if(x == 1)//print food
	    {
	    	listFood();
	    }
	    else if (x == 2)//print clothes
	    {
	    	listClothes();
	    }
	    else if (x == 3)//print everything
	    {
	    	listAll();
	    }
	    else//go back
	    {
	    	this.start();
	    }
	}
	
	public void listFood()
	{
		//list food
		arr.printFood();
		//1. sort
		System.out.println("1. Sort: Low to High");
		System.out.println("2. Sort: High to Low");
		//2. proceed to checkout
		System.out.println("3. Proceed to checkout");
		//3. go back
		System.out.println("4. Go back");
		
		Scanner in = new Scanner(System.in);
	    int x = in.nextInt();
	    
	    if(x == 1)//sort l - H
	    {
	    	arr.sort(3.2, 1);
	    	listFood();
	    }
	    else if (x == 2)// sort H - l
	    {
	    	arr.sort(1,1);
	    	listFood();
	    }
	    else if(x == 3)//checkout
	    {
	    	checkout1();
	    }
	    else
	    {
	    	costumerPannel();
	    }
		
	}
	
	public void listClothes()
	{
		//list clothes
		arr.printClothes();
		//1.sort
		System.out.println("1. Sort: Low to High");
		System.out.println("2. Sort: High to Low");
		//2.proceed to checkout
		System.out.println("3. Proceed to checkout");
		//3.go back
		System.out.println("4. Go back");
		
		Scanner in = new Scanner(System.in);
	    int x = in.nextInt();
	    
	    if(x == 1)//sort l - H
	    {
	    	arr.sort(3.2, 2);
	    	listClothes();
	    }
	    else if(x == 2)//sort H - l
	    {
	    	arr.sort(1, 2);
	    	listClothes();
	    }
	    else if(x == 3)//checkout
	    {
	    	checkout1();
	    }
	    else
	    {
	    	costumerPannel();
	    }
	}
	
	public void listAll()
	{
//REMEMBER TO ADD HERE
	}
	
	public void checkout1()
	{
		//enter the barcodes of the products;
		System.out.println("Enter the barcodes for the products, separated by space");
		//enter -1 when you are done
		System.out.println("Enter -1 when you're done");
		
		Scanner in = new Scanner(System.in);
	    int x = in.nextInt();
	    
	    while(x != -1)
	    {
	    	bcArr[counter] = x;
	    	counter++;
	    	x = in.nextInt();
	    }
	    
	    checkout2();
	}
	
	public void checkout2()
	{
		Object x;
		//you have chose the following
		System.out.println("You have chose the following products:");
		//output the thing
	    for(int i = 0; i < counter; i++)
	    {
	    	x = arr.search(bcArr[i]);
	    	System.out.println(x.toString());
	    	total = total + ((Product)x).getPrice();
	    	tax = tax + ((Product)x).getTax() * ((Product)x).getPrice() / 100;
	    }
		//your total is:
	    System.out.println("Your Total is: " + total);
		//your tax is:
	    System.out.println("The tax is: " + tax);
		//your grand total is:
	    System.out.println("The Grand Total is: " + (total + tax));
		
		//thanks for shopping with us
	    System.out.println("Thank you for shopping with us!");
	}
	
}
