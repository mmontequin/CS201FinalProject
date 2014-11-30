/* 
 * Cosmin Lungu
 * CS 201 - 01
 * Final Project
 * working with Matt Montequin
 */

package MainPack;

public class Clothes extends Product{

	private String type, size, color;
	
	public Clothes()
	{
		barCode = 0;
		price = 0.0;
		manufacturerInfo = new Manufacturer();
		type = "no type";
		size = "no size";
		color = "no color";
	}
	
	public Clothes(int b, String t, double p, Manufacturer aManufacturer, String s, String c)
	{
		barCode = 0;
		price = 0.0;
		manufacturerInfo = new Manufacturer();
		type = t;
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
