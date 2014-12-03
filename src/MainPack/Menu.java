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
	private ReadWrite reader;
	private int counter=0,idiot = 0,x;
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
		else if(x == 2)
			costumerPannel();
		else
		{
			idiot++;
			System.out.println("You have not entered neither 1 nor 2, so I am going to suppose you are a customer. \nHowever, if you are not, you can always go back. #SoryNotSory (Friendly advice: Don't do that again. Stuff like this doesn't fly with me)");
			costumerPannel();
		}
	}
	
	//admin
	public void adminCheck()
	{
		int pass = 0;
		System.out.println("What is the password?");
		Scanner in = new Scanner(System.in);
	    pass = in.nextInt();
		if(pass == 1845)
			pannel();
		else
		{
			System.out.println("The password was wrong! But don't worry, I gotch you...");
			idiot++;
			start();
		}
	}
	
	public void pannel()
	{
		//1. Search
		System.out.println("1. Search");
		//2. Sort
		System.out.println("2. Sort");
		//3. Add
		System.out.println("3. Add");
		//4. Delete
		System.out.println("4. Delete");
		//5. Update/Edit
		System.out.println("5. Update/Edit");
		//6. Go back
		System.out.println("6. Go back");
		//*7. Terminate
		System.out.println("*7. Terminate!!!");
		
		Scanner in = new Scanner(System.in);
	    x = in.nextInt();
	    
	    if(x == 1)
	    {
	    	search();
	    }
	    else if(x == 2)
	    {
	    	sort();
	    }
	    else if(x == 3)
	    {
	    	add();
	    }
	    else if(x == 4)
	    {
	    	delete();
	    }
	    else if(x == 5)
	    {
	    	update();
	    }
	    else if(x == 6)
	    {
	    	start();
	    }
	    else if(x == 7)
	    {
	    	System.out.println("Are you sure? \nAll the work that you have done will be lost!\n1. Absolutely\n2. I'll do some more stuff");
	    	x = in.nextInt();
	    	if(x == 1)
	    	{
		    	System.out.println("\nHmm... Not bad!");
	
		   		if(idiot > 0)
			    {
			    	System.out.println("*************************************************************************");
			    	System.out.println("PS: You were an idiot " + idiot + " times, but you have accomplised nothing... ntz ntz ntz...\nDon't you get it? My code is (a) ROCK! You cannot mess with it! \n\n The entertainment was brough to you by\n  \"a poor little coder\" who just needed a break from all the stupid error messages...\n   Love you! Peace!");
			
			    }
	    	}
	    	else if(x == 2)
	    	{
	    		System.out.println("Phiu... looks like I stoped you in time...");
	    		pannel();
	    	}
	    	else
	    	{
	    		idiot++;
	    		System.out.println("Really man? Realy!?");
	    		pannel();
	    	}

	    }
	    else
	    {
	    	System.out.println("Oh no you didn't!");
	    	idiot++;
	    	pannel();
	    }
	}
	
	public void search()
	{
		Object obj;
		//insert the barcode
		System.out.println("Insert the barcode:");
		
		Scanner in = new Scanner(System.in);
	    x = in.nextInt();
	    
	    obj = arr.search(x);
	    
		//output the product
    	if(((Product)obj).getBarCode() == 0)
    	{
    		idiot++;
    		System.out.println("The barcode " + x + " you have entered is not valid ***I'm watching you...");
    	}
    	else
    	{
	    	System.out.println(obj.toString());
    	}
		//go back to pannel
		pannel();
	}
	
	public void sort()
	{
		//1. Everything, by barCode
		System.out.println("1. Everything, by barCode (low to high)");
		//2. Everything, low to high
		System.out.println("2. Everything, low to high");
		//3. Everything, high to low
		System.out.println("3. Everything, high to low");
		//4. Food, low to high
		System.out.println("4. Food, low to high");
		//5. Food, high to low
		System.out.println("5. Food, high to low");
		//6. Clothes, low to high
		System.out.println("6. Clothes, low to high");
		//7. Clothes, high to low
		System.out.println("7. Clothes, high to low");
		//8. Go back
		System.out.println("8. Go back");
		
		Scanner in = new Scanner(System.in);
	    x = in.nextInt();
	    
		//do the sorting/output
		if(x == 1)
		{
			arr.sortBC();
			arr.printAll();
		}
		else if(x == 2)
		{
			arr.sortAllLH();
			arr.printAll();
		}
		else if(x == 3)
		{
			arr.sortAllHL();
			arr.printAll();
		}
		else if(x == 4)
		{
			arr.sortLH(3.2, 1);
			arr.printFood();
		}
		else if(x == 5)
		{
			arr.sortHL(1, 1);
			arr.printFood();
		}
		else if(x == 6)
		{
			arr.sortLH(3.2,2);
			arr.printClothes();
		}
		else if(x == 7)
		{
			arr.sortHL(1,2);
			arr.printClothes();
		}
		else if(x == 8)
		{
			pannel();
		}
		else
		{
			idiot++;
			System.out.println("Why do you keep doing this?! Save yourself sometime, STOP!");
			sort();
		}
		
		//go back to pannel
		pannel();
	}
//need to do add	
	public void add()
	{
		System.out.println("Insert data in the following format:");
		System.out.println("category,name/type,price,Manufacturer,quality/size,color");
		System.out.println("Category: 0 for food, 1 for clothes");
		System.out.println("Manufacturer formatted as 'company;country;date'");
		// lineIn: string
		// in: Scanner object
		lineIn = in.nextLine();
		arr.add(reader.asign(lineIn));
		System.out.println("You have added the following product:");
		((Product) (arr.getObject(arr.getIndex() - 1))).toString();
		pannel();
	}
	
	public void delete()
	{
		Object obj;
		
		//enter the barcode
		System.out.println("Enter the barcode of the object you want to delete; Enter -1 to go back");
		
		Scanner in = new Scanner(System.in);
	    x = in.nextInt();
	    
	    if(x == -1)
	    	pannel();
	    else
	    {
		    obj = arr.search(x);
	    	if(((Product)obj).getBarCode() == 0)
	    	{
	    		idiot++;
	    		System.out.println("The barcode " + x + " you have entered is not valid \n ***I'm watching you...");
	    		delete();
	    	}
	    	else
	    	{
	    		//are you sure you want to delete prod:... 1. yes 2. no
		    	System.out.println("Are you sure you want to delete: \n" + obj.toString() + "\n1. Absolutely \n2. Let me thing about it");
		    	int q = in.nextInt();
		    	if(q == 1)
		    	{
		    		//delete
		    		arr.delete(obj);
		    		//the product was (not) deleted
		    		if(((Product)arr.search(x)).getBarCode() == 0)
		    		{
		    			System.out.println("Product successfully deleted!");
		    			pannel();
		    		}
		    		else
		    		{
		    			System.out.println("Unfortunately, something went wrong :( Please try again");
		    			delete();
		    		}
		    	}
		    	else if(q == 2)
		    	{
		    		System.out.println("Phiu... looks like I stoped you in time...");
		    		delete();
		    	}
		    	else
		    	{
		    		idiot++;
		    		System.out.println("Are you kidding me?!");
		    		delete();
		    	}
	    	}
	    }

		//go back to pannel
	    pannel();
	}
//need to update
	/*
	public void update()
	{
		Object obj;
	
		//enter the barcode of the product you want to update
		System.out.println("Enter the barCode of the product you want to update; Enter -1 to go back");
		Scanner in = new Scanner(System.in);
	    x = in.nextInt();
	    if(x == -1)
	    	pannel();
	    else
	    {
	    	obj = arr.search(x);
	    	if(((Product)obj).getBarCode() == 0)
	    	{
	    		idiot++;
	    		System.out.println("The barcode " + x + " you have entered is not valid \n ***I'm watching you...");
	    		update();
	    	}
	    	else
	    	{
	    		System.out.println("This is the Product: \n" + obj.toString());
	    		//what would you like to update?
	    		System.out.println("What would you like to update?");
		    	
	    		//1. Category
	    		System.out.println("1. Category");
	    		//2. Name/Type
	    		System.out.println("2. Name(Food)/Type(Clothes)");
	    		//3. Price
	    		System.out.println("3. Price");
	    		//4. Manufacturer
	    		System.out.println("4. Manufacturer");
	    		//5. Quality/Size
	    		System.out.println("5. Quality(Food)/Size(Clothes)");
	    		//6. Color
	    		System.out.println("6. Color(Clothes)");
	    		//7. Go back
	    		System.out.println("7. Go back");
	    		
	    		int q = in.nextInt();
	    		
	    		if(q == 1)//category
	    		{
	    			//0 for Food or 1 for Clothes
	    			System.out.println("0 for Food or 1 for Clothes");
	    			q = in.nextInt();
	 //it doesn't work like this. you gotta do a whole new object with the same characteristics but from a different class	    			
	    			if(q == 0)//food
	    			{
	    				if(((Product)obj).getBarCode() < 200)//is food
	    				{
	    					System.out.println("The Product is already of type Food so there is no point in chainging it");
	    					update();
	    				}
	    				else//is clothes
	    				{
	    					//not good
	    					arr.setClothesCounter(arr.getClothesCounter() - 1);
	    					arr.setFoodCounter(arr.getFoodCounter() + 1);
	    					((Product)obj).setBarCode(100 + arr.getFoodCounter());
	    					arr.sortBC();
	    					pannel();
	    				}
	    			}
	    			else if(q == 1)//clothes
	    			{
	    				if(((Product)obj).getBarCode() >= 200)//is clothes
	    				{
	    					System.out.println("The Product is already of type Clothes so there is no point in chainging it");
	    					update();
	    				}
	    				else
	    				{
	    					arr.setClothesCounter(arr.getClothesCounter() + 1);
	    					arr.setFoodCounter(arr.getFoodCounter() - 1);
	    					((Product)obj).setBarCode(200 + arr.getClothesCounter());
	    					arr.sortBC();
	    					pannel();
	    				}
	    			}
	    			else //idiot
	    			{
	    				idiot++;
	    				System.out.println("Arghh...");
	    				update();
	    			}
	    		}
	    		else if(q == 2)//name/type
	    		{
	    			
	    		}
	    		else if(q == 3)//price
	    		{
	    			
	    		}
	    		else if(q == 4)//manufacturer
	    		{
	    			
	    		}
	    		else if(q == 5)//quality/size
	    		{
	    			
	    		}
	    		else if(q == 6)//color
	    		{
	    			
	    		}
	    		else if(q == 7)//go back
	    		{
	    			
	    		}
	    		else//idiot
	    		{
	    			
	    		}
	    	}
	    }
		//this is the product:
		//what would you like to update?
		//1. name/type
		//etc
		//**do the stuff to update it
	}	
	*/

	public void update()
	{
		System.out.println("Enter the barcode of the product you want to update:");
		lineIn = in.nextLine();
		int barCode = parseInt(lineIn);
		// lineIn: string
		// in: Scanner object
		if (arr.search(barCode) instanceof Product) {
			Product result = (Product) arr.search(barCode);
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
			// lineIn: string
			// in: Scanner objct
			// selection: int
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
	    x = in.nextInt();
	    
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
	    else if(x == 4)//go back
	    {
	    	this.start();
	    }
	    else
	    {
	    	idiot++;
	    	System.out.println("Sneaky, you tried to break the code. \nNormally I would send you back, but your hand might have just slipped, so I am going to give you another chance :D");
	    	this.costumerPannel();
	    }
	}
	
	public void listFood()
	{
		//list food
		arr.printFood();
    	arr.sortBC();
		//1. sort
		System.out.println("1. Sort, by price: Low to High");
		System.out.println("2. Sort, by price: High to Low");
		//2. proceed to checkout
		System.out.println("3. Proceed to checkout");
		//3. go back
		System.out.println("4. Go back");
		
		Scanner in = new Scanner(System.in);
	    x = in.nextInt();
	    
	    if(x == 1)//sort l - H
	    {
	    	arr.sortLH(3.2, 1);
	    	listFood();
	    }
	    else if (x == 2)// sort H - l
	    {
	    	arr.sortHL(1,1);
	    	listFood();
	    }
	    else if(x == 3)//checkout
	    {
	    	checkout1();
	    }
	    else if(x == 4)
	    {
	    	costumerPannel();
	    }
	    else
	    {
	    	idiot++;
	    	System.out.println("Not again! #IdiotProof \nI dare you to try again!");
	    	this.listFood();
	    }
		
	}
	
	public void listClothes()
	{
		//list clothes
		arr.printClothes();
    	arr.sortBC();
		//1.sort
		System.out.println("1. Sort: Low to High");
		System.out.println("2. Sort: High to Low");
		//2.proceed to checkout
		System.out.println("3. Proceed to checkout");
		//3.go back
		System.out.println("4. Go back");
		
		Scanner in = new Scanner(System.in);
	    x = in.nextInt();
	    
	    if(x == 1)//sort l - H
	    {
	    	arr.sortLH(3.2, 2);
	    	listClothes();
	    }
	    else if(x == 2)//sort H - l
	    {
	    	arr.sortHL(1, 2);
	    	listClothes();
	    }
	    else if(x == 3)//checkout
	    {
	    	checkout1();
	    }
	    else if(x == 4)
	    {
	    	costumerPannel();
	    }
	    else
	    {
	    	idiot++;
	    	System.out.println("Not again! #IdiotProof \nI dare you to try again!");
	    	this.listClothes();
	    }
	}
	
	public void listAll()
	{
		arr.printAll();
    	arr.sortBC();
		//1.sort
		System.out.println("1. Sort: Low to High");
		System.out.println("2. Sort: High to Low");
		//3.proceed to checkout
		System.out.println("3. Proceed to checkout");
		//4.go back
		System.out.println("4. Go back");
		
		Scanner in = new Scanner(System.in);
	    x = in.nextInt();
	    
	    if(x == 1)//sort l - H
	    {
	    	arr.sortAllLH();
	    	listAll();
	    }
	    else if(x == 2)//sort H - l
	    {
	    	arr.sortAllHL();
	    	listAll();
	    }
	    else if(x == 3)//checkout
	    {
	    	checkout1();
	    }
	    else if(x == 4)
	    {
	    	costumerPannel();
	    }
	    else
	    {
	    	idiot++;
	    	System.out.println("Not again! #IdiotProof \nI dare you to try again!");
	    	this.listClothes();
	    }
	}
	
	public void checkout1()
	{
		//enter the barcodes of the products;
		System.out.println("Enter the barcodes for the products, separated by space");
		//enter -1 when you are done
		System.out.println("Enter -1 when you're done");
		
		Scanner in = new Scanner(System.in);
	    x = in.nextInt();
	    
	    while(x != -1)
	    {
	    	bcArr[counter] = x;
	    	counter++;
	    	x = in.nextInt();
	    }
	    
	    checkout2();
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
	    x = in.nextInt();
	    
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
	    else if(x == 4)//go back
	    {
	    	this.start();
	    }
	    else
	    {
	    	idiot++;
	    	System.out.println("Sneaky, you tried to break the code. \nNormally I would send you back, but your hand might have just slipped, so I am going to give you another chance :D");
	    	this.costumerPannel();
	    }
	}
	
	public void listFood()
	{
		//list food
		arr.printFood();
    	arr.sortBC();
		//1. sort
		System.out.println("1. Sort, by price: Low to High");
		System.out.println("2. Sort, by price: High to Low");
		//2. proceed to checkout
		System.out.println("3. Proceed to checkout");
		//3. go back
		System.out.println("4. Go back");
		
		Scanner in = new Scanner(System.in);
	    x = in.nextInt();
	    
	    if(x == 1)//sort l - H
	    {
	    	arr.sortLH(3.2, 1);
	    	listFood();
	    }
	    else if (x == 2)// sort H - l
	    {
	    	arr.sortHL(1,1);
	    	listFood();
	    }
	    else if(x == 3)//checkout
	    {
	    	checkout1();
	    }
	    else if(x == 4)
	    {
	    	costumerPannel();
	    }
	    else
	    {
	    	idiot++;
	    	System.out.println("Not again! #IdiotProof \nI dare you to try again!");
	    	this.listFood();
	    }
		
	}
	
	public void listClothes()
	{
		//list clothes
		arr.printClothes();
    	arr.sortBC();
		//1.sort
		System.out.println("1. Sort: Low to High");
		System.out.println("2. Sort: High to Low");
		//2.proceed to checkout
		System.out.println("3. Proceed to checkout");
		//3.go back
		System.out.println("4. Go back");
		
		Scanner in = new Scanner(System.in);
	    x = in.nextInt();
	    
	    if(x == 1)//sort l - H
	    {
	    	arr.sortLH(3.2, 2);
	    	listClothes();
	    }
	    else if(x == 2)//sort H - l
	    {
	    	arr.sortHL(1, 2);
	    	listClothes();
	    }
	    else if(x == 3)//checkout
	    {
	    	checkout1();
	    }
	    else if(x == 4)
	    {
	    	costumerPannel();
	    }
	    else
	    {
	    	idiot++;
	    	System.out.println("Not again! #IdiotProof \nI dare you to try again!");
	    	this.listClothes();
	    }
	}
	
	public void listAll()
	{
		arr.printAll();
    	arr.sortBC();
		//1.sort
		System.out.println("1. Sort: Low to High");
		System.out.println("2. Sort: High to Low");
		//3.proceed to checkout
		System.out.println("3. Proceed to checkout");
		//4.go back
		System.out.println("4. Go back");
		
		Scanner in = new Scanner(System.in);
	    x = in.nextInt();
	    
	    if(x == 1)//sort l - H
	    {
	    	arr.sortAllLH();
	    	listAll();
	    }
	    else if(x == 2)//sort H - l
	    {
	    	arr.sortAllHL();
	    	listAll();
	    }
	    else if(x == 3)//checkout
	    {
	    	checkout1();
	    }
	    else if(x == 4)
	    {
	    	costumerPannel();
	    }
	    else
	    {
	    	idiot++;
	    	System.out.println("Not again! #IdiotProof \nI dare you to try again!");
	    	this.listClothes();
	    }
	}
	
	public void checkout1()
	{
		//enter the barcodes of the products;
		System.out.println("Enter the barcodes for the products, separated by space");
		//enter -1 when you are done
		System.out.println("Enter -1 when you're done");
		
		Scanner in = new Scanner(System.in);
	    x = in.nextInt();
	    
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
		Object obj;
		//you have chose the following
		System.out.println("\nYou have chose the following products:");
		//output the thing
	    for(int i = 0; i < counter; i++)
	    {
	    	obj = arr.search(bcArr[i]);
	    	if(((Product)obj).getBarCode() == 0)
	    	{
	    		idiot++;
	    		System.out.println("The barcode " + bcArr[i] + " you have entered is not valid, so we will not include this product \n ***I'm watching you...");
	    	}
	    	else
	    	{
		    	System.out.println(obj.toString());
		    	total = total + ((Product)obj).getPrice();
		    	tax = tax + ((Product)obj).getTax() * ((Product)obj).getPrice() / 100;
	    	}
	    }
		//your total is:
	    System.out.println("\nYour Total is: " + total);
		//your tax is:
	    System.out.println("The tax is: " + tax);
		//your grand total is:
	    System.out.println("The Grand Total is: " + (total + tax));
		
		//thanks for shopping with us
	    System.out.println("\nThank you for shopping with us!");
	    if(idiot > 0)
	    {
	    	System.out.println("*************************************************************************");
	    	System.out.println("PS: You were an idiot " + idiot + " times, but you have accomplised nothing... ntz ntz ntz...\nDon't you get it? My code is (a) ROCK! You cannot mess with it! \n\n The entertainment was brough to you by\n  \"a poor little coder\" who just needed a break from all the stupid error messages...\n   Love you! Peace!");
	
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
