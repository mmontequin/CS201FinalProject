/* 
 * Cosmin Lungu
 * CS 201 - 01
 * Final Project
 * working with Matt Montequin
 */

package MainPack;

public class Clothes extends Product{

	private String type, size, color;
	private double tax = 7.5;
	
	public Clothes()
	{
		super.setBarCode(-1);
		super.setPrice(0.0);
		super.setTax(tax);
		type = "no type";
		size = "no size";
		color = "no color";
	}
	
	public Clothes(int b, double p, String t,Manufacturer m, String s, String c)
	{
		super.setBarCode(b);
		super.setPrice(p);
		super.setTax(tax);
		type = t;
		//manufacturer
		size = s;
		color = c;
	}
	
	public void setType(String t)
	{
		type = t;
	}
	
	public void setSize(String s)
	{
		size = s;
	}
	
	public void setColor(String c)
	{
		color = c;
	}
	
	public String getType()
	{
		return type;
	}
	
	public String getSize()
	{
		return size;
	}
	
	public String getColor()
	{
		return color;
	}
	
	public String toString()
	{
		return super.toString()
				+ ", the type is " + type
				+ ", the size is " + size
				+ ", the color is " + color; 
	}
	
	public boolean equals(Clothes c)
	{
		return super.equals(c)
				&& this.type == c.type
				&& this.size == c.size
				&& this.color == c.color;
	}
	
}
