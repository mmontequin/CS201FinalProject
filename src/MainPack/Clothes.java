/* 
 * Cosmin Lungu
 * CS 201 - 01
 * Final Project
 * working with Matt Montequin
 */

package MainPack;

public class Clothes extends Product{

	//instance variables
	private String type, size, color;
	//tax = 7.5;
	
	//default constructor
	public Clothes()
	{
		super(0,0.0,-1);
		type = "no type";
		size = "no size";
		color = "no color";
	}
	
	//usual constructor
	public Clothes(int b, double p, String t,Manufacturer m, String s, String c)
	{
		
		super(b,p,7.5);
		type = t;
		//manufacturer
		size = s;
		color = c;
	}
	
	//set the type
	public void setType(String t)
	{
		type = t;
	}
	
	//set the size
	public void setSize(String s)
	{
		size = s;
	}
	
	//set the color
	public void setColor(String c)
	{
		color = c;
	}
	
	//get the type
	public String getType()
	{
		return type;
	}
	
	//get the size
	public String getSize()
	{
		return size;
	}
	
	//get the color
	public String getColor()
	{
		return color;
	}
	
	//put everything in a string
	public String toString()
	{
		return super.toString()
				+ ", the type is " + type
				+ ", the size is " + size
				+ ", the color is " + color; 
	}
	
	//see if one Clothes is equal to another
	public boolean equals(Clothes c)
	{
		return super.equals(c)
				&& this.type == c.type
				&& this.size == c.size
				&& this.color == c.color;
	}
	
}
