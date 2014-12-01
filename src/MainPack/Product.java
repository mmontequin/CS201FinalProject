/* 
 * Cosmin Lungu
 * CS 201 - 01
 * Final Project
 * working with Matt Montequin
 */

package MainPack;

public class Product {

	//instance variables
	private int barCode;
	private double price,tax;
	
	//default constructor
	public Product()
	{
		barCode = 0;
		price = 0;
		tax = 0;
	}
	
	//usual constructor
	public Product(int b, double p, double t)
	{
		barCode = b;
		price = p;
		tax = t;
	}

	//set the barcode
	public void setBarCode(int b)
	{
		barCode = b;
	}
	
	//set the price
	public void setPrice(double p)
	{
		price = p;
	}
	
	//set the tax
	public void setTax(double t)
	{
		tax = t;
	}
	
	//get the barcode
	public int getBarCode()
	{
		return barCode;
	}

	//get the price
	public double getPrice()
	{
		return price;
	}
	
	//get the tax
	public double getTax()
	{
		return tax;
	}
	
	//put everything in a string
	public String toString()
	{
		return "The barcode is " + barCode
				+ ",the price is " + price
				+ ",the tax is " + tax;
	}
	
	//see if one Product is equal to another
	public boolean equals(Product p)
	{
		return this.barCode == p.barCode
				&& this.price == p.price
				&& this.tax == p.tax;
	}
}

