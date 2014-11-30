/* 
 * Cosmin Lungu
 * CS 201 - 01
 * Final Project
 * working with Matt Montequin
 */

package MainPack;

public class Product {

	private int barCode;
	private double price,tax;
	
	public Product()
	{
		barCode = 0;
		price = 0;
		tax = 0;
	}
	
	public Product(int b, double p)
	{
		barCode = b;
		price = p;
	}

	public void setBarCode(int b)
	{
		barCode = b;
	}
	
	public void setPrice(double p)
	{
		price = p;
	}
	
	public void setTax(double t)
	{
		tax = t;
	}
	
	public int getBarCode()
	{
		return barCode;
	}

	public double getPrice()
	{
		return price;
	}
	
	public double getTax()
	{
		return tax;
	}
	
	public String toString()
	{
		return "";
	}
	
	public boolean equals(Product p)
	{
		return this.barCode == p.barCode
				&& this.price == p.price
				&& this.tax == p.tax;
	}
}

