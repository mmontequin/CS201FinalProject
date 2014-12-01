/* 
 * Cosmin Lungu
 * CS 201 - 01
 * Final Project
 * working with Matt Montequin
 */

package MainPack;

public class Objects {
	
	//instance variables
	private Object array[];
	private int MAX_SIZE = 200, index,size,pointer = 0;

	//default constructor
	public Objects()
	{
		size = MAX_SIZE;
		index = 0;
		array = new Object[size];
	}
	
	//usual constructor
	public Objects(int s)
	{
		size = s;
		index = 0;
		array = new Object[size];
	}
	
	//complicated/ in dept constructor
	public Objects(Object[] anArray, int s, int i)
	{
		size = s;
		index = i;
		array = anArray;
	}
	
	//set the array
	public void setArray(Objects [] arr)
	{
		array = arr;
	}
	
	//set the index
	public void setIndex(int i)
	{
		index = i;
	}
	
	//set the size
	public void setSize(int s)
	{
		size = s;
	}
	
	//set the pointer
	public void setPointer(int p)
	{
		pointer = p;
	}
	
	//get the array
	public Object[] getArray()
	{
		return array;
	}
	
	//get the index
	public int getIndex()
	{
		return index;
	}
	
	//get the size
	public int getSize()
	{
		return size;
	}
	//get the pointer
	public int getPointer()
	{
		return pointer;
	}
	
	//get the Object at a specific position
	public Object getObject(int pos)
	{
		return array[pos];
	}
	
	//add an Object to the end of the array
	public void add(Object obj)
	{
		if(!this.isFull())
		{
			array[index] = obj;
			index++;
		}
	}
	
	//insert an Object at a specific position
	public void insert(int pos, Objects obj)
	{
		int i;
		if(!this.isFull())
		{
			for(i = index - 1; i >= pos; i--)
				array[i+1] = array[i];
			array[pos] = obj;
			index++;
		}
	}
	
	//delete the Object at the specific position
	public void delete(int pos)
	{
		int i;
		for(i = pos; i < index; i++)
			array[i] = array[i+1];
		index--;
	}
	
	//delete a certain Object
	public void delete(Objects obj)
	{
		int i = this.isThere(obj);
		if(i >= 0)
			delete(i);
	}
	
	//check if there is a certain Object
	public int isThere(Objects obj)
	{
		int i;
		for(i=0; i<index; i++)
			if(array[i] == obj)
				return i;
		return -1;
	}
	
	//check if the array is full
	public boolean isFull()
	{
		if(index == size - 1)
			return true;
		else return false;
	}
	
	//check if the array is empty
	public boolean isEmpty()
	{
		if(index == 0)
			return true;
		else return false;
	}
	
	//clear the array aka delete everything
	public void clear()
	{
		for(int i = 0; i < index; i++)
			array[i] = null;
		index = 0;
	}
	
	//trim the empty spaces in an array
	public void trim()
	{
		size = index;
		Object[] some = new Object[size];
		for(int i = 0; i < index; i++)
			some[i] = array[i];
		array = some;
	}
	
	//put more cappacity to the array
	public void moreCapacity(double d)
	{
		size = (int) Math.floor(size*d);
		Object[] some = new Object[size];
		for(int i = 0; i < index; i++)
			some[i] = array[i];
		array = some;
	}
	
	//reset the pointer to 0
	public void resetPointer()
	{
		pointer = 0;
	}
	
	//check if it has a next object
	public boolean hasNext()
	{
		if(pointer < index - 1)
			return true;
		else return false;
	}
	
	//get next Object
	public Object getNext()
	{
		pointer++;
		return array[pointer - 1];
	}
	
	//low to high sort, by barcode
	public void sort()
	{
		Object aux;
		int min = 999, poz = 0;
		
		for(int i = 0; i < index - 1; i ++)
		{
			for(int j = i; j < index; j ++)
			{	
				if( ((Product)array[j]).getBarCode() < min)
				{
					min = ((Product)array[j]).getBarCode();
					poz = j;
				}
			}
			aux = array[i];
			array[i] = array[poz];
			array[poz] = aux;
			min = 999;
		}
	}

	//low to high sort, by price
	public void sort(double lowToHigh)
	{
		Object aux;
		int poz = 0;
		double min = 999.9;
		
		for(int i = 0; i < index - 1; i ++)
		{
			for(int j = i; j < index; j ++)
				if(((Product)array[j]).getPrice() < min)
				{
					min = ((Product)array[j]).getPrice();
					poz = j;
				}
			aux = array[i];
			array[i] = array[poz];
			array[poz] = aux;
			min = 999.9;
		}
	}
	
	//high to low sort, by price
	public void sort(int HighToLow)
	{
		Object aux;
		int poz = 0;
		double max = 0.0;
		for(int i = 0; i < index - 1; i ++)
		{
			for(int j = i; j< index; j++)
				if(((Product)array[j]).getPrice() > max)
				{
					max = ((Product)array[j]).getPrice();
					poz = j;
				}
			aux = array[i];
			array[i] = array[poz];
			array[poz] = aux;
			max = 0.0;
		}
	}
	
	//search, by barCode
	public Object search(int b)
	{
		int i;
		for(i = 0; i < index; i ++)
			if(b == ((Product)array[i]).getBarCode())
				return array[i];
		return array[i];
	}
	
	//put everything in a String
	public String toString()
	{
		String bigString = "The size is " + size 
				+ ", the index is " + index 
				+ ", the objects are: \n";
		for(int i = 0; i < index; i++)
			bigString = bigString + array[i] + "\n";
		return bigString;
	}
	
	//see if two array are equal to eachother
	public boolean equals(Objects arr)
	{
		for(int i=0; i < index; i++)
			if(this.array[i] != arr.array[i])
				return false;
		return this.index == arr.index && this.size == arr.size;
	}

}
