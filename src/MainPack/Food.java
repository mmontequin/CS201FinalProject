/* 
 * Cosmin Lungu
 * CS 201 - 01
 * Final Project
 * working with Matt Montequin
 */

package MainPack;

public class Food extends Product{

	private String name;
	private double tax = 1.25;
	private int quality;
	
	public Food()
	{
		super.setBarCode(-1);
		super.setPrice(0.0);
		super.setTax(tax);
		name = "no name";
		quality = 0;
	}
	
	public Food(int b, double p, String n,Manufacturer m, int q)
	{
		super.setBarCode(b);
		super.setPrice(p);
		super.setTax(tax);
		name = n;
		//manufacturer
		quality = q;
	}
	
	public void setName(String n)
	{
		name = n;
	}
	
	public void setQuality(int q)
	{
		quality = q;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getQuality()
	{
		return quality;
	}
	
	public String toString()
	{
		return super.toString()
				+ ", the name is " + name
				+ ", the quality is " + quality;
	}
	
	public boolean equals(Food f)
	{
		return super.equals(f) 
				&& this.name == f.name
				&& this.quality == f.quality;
	}
}
