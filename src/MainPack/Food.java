/* 
 * Cosmin Lungu
 * CS 201 - 01
 * Final Project
 * working with Matt Montequin
 */

package MainPack;

public class Food extends Product{

	private String name;
	private double quantity, tax = 1.25;
	private int quality;
	
	public Food()
	{
		super.setBarCode(-1);
		super.setPrice(0.0);
		super.setTax(tax);
		name = "no name";
		quantity = 0.0;
		quality = 0;
	}
	
	public Food(int b, double p, String n, double q, int ql)
	{
		super.setBarCode(b);
		super.setPrice(p);
		super.setTax(tax);
		name = n;
		quantity = q;
		quality = ql;
	}
	
	public void setName(String n)
	{
		name = n;
	}
	
	public void setQuantity(double q)
	{
		quantity = q;
	}
	
	public void setQuality(int q)
	{
		quality = q;
	}
	
	public String getName()
	{
		return name;
	}
	
	public double getQuantity()
	{
		return quantity;
	}
	
	public int getQuality()
	{
		return quality;
	}
	
	public String toString()
	{
		return super.toString()
				+ ", the name is " + name
				+ ", the quantity is " + quantity
				+ ", the quality is " + quality;
	}
	
	public boolean equals(Food f)
	{
		return super.equals(f) 
				&& this.name == f.name
				&& this.quantity == f.quantity
				&& this.quality == f.quality;
	}
}
