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
		super(0,0.0,-1);
		name = "no name";
		quality = 0;
	}
	
	public Food(int b, double p, String n,Manufacturer m, int q)
	{
		super(b,p,1.25);
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
