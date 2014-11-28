/* 
 * Cosmin Lungu
 * CS 201 - 01
 * Final Project
 * working with Matt Montequin
 */

package MainPack;

public class Object {
	
	private Object array[];
	private int MAX_SIZE = 200, index,size,pointer = 0;

	public Object()
	{
		size = MAX_SIZE;
		index = 0;
		array = new Object[size];
	}
	
	public Object(int s)
	{
		size = s;
		index = 0;
		array = new Object[size];
	}
	
	public Object(Object[] anArray, int s, int i)
	{
		size = s;
		index = i;
		array = anArray;
	}
	
	public void setArray(Object [] arr)
	{
		array = arr;
	}
	
	public void setIndex(int i)
	{
		index = i;
	}
	
	public void setSize(int s)
	{
		size = s;
	}
	
	public void setPointer(int p)
	{
		pointer = p;
	}
	
	public Object[] getArray()
	{
		return array;
	}
	
	public int getIndex()
	{
		return index;
	}
	
	public int getSize()
	{
		return size;
	}
	
	public int getPointer()
	{
		return pointer;
	}
	
	public Object getObject(int pos)
	{
		return array[pos];
	}
	
	public void add(Object obj)
	{
		if(!this.isFull())
		{
			array[index] = obj;
			index++;
		}
	}
	
	public void insert(int pos, Object obj)
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
	
	public void delete(int pos)
	{
		int i;
		for(i = pos; i < index; i++)
			array[i] = array[i+1];
		index--;
	}
	
	public void delete(Object obj)
	{
		int i = this.isThere(obj);
		if(i >= 0)
			delete(i);
	}
	
	public int isThere(Object obj)
	{
		int i;
		for(i=0; i<index; i++)
			if(array[i] == obj)
				return i;
		return -1;
	}
	
	public boolean isFull()
	{
		if(index == size - 1)
			return true;
		else return false;
	}
	
	public boolean isEmpty()
	{
		if(index == 0)
			return true;
		else return false;
	}
	
	public void clear()
	{
		for(int i = 0; i < index; i++)
			array[i] = null;
		index = 0;
	}
	
	public void trim()
	{
		size = index;
		Object[] some = new Object[size];
		for(int i = 0; i < index; i++)
			some[i] = array[i];
		array = some;
	}
	
	public void moreCapacity(double d)
	{
		size = (int) Math.floor(size*d);
		Object[] some = new Object[size];
		for(int i = 0; i < index; i++)
			some[i] = array[i];
		array = some;
	}
	
	public void reset()
	{
		pointer = 0;
	}
	
	public boolean hasNext()
	{
		if(pointer < index - 1)
			return true;
		else return false;
	}
	
	public Object getNext()
	{
		pointer++;
		return array[pointer - 1];
	}

}