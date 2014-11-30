/* 
 * Cosmin Lungu
 * CS 201 - 01
 * Final Project
 * working with Matt Montequin
 */

package MainPack;

public class Calculations extends Objects{


	private Object arr[] = super.getArray();

	public void sort(int c)
	{
		Object aux;
		int min = 999, poz = 0;
		
		for(int i = 0; i < super.getIndex() - 1; i ++)
		{
			for(int j = i; j < super.getIndex(); j ++)
			{	
				if( ((Product)arr[j]).getBarCode() < min)
				{
					min = ((Product)arr[j]).getBarCode();
					poz = j;
				}
			}
			aux = arr[i];
			arr[i] = arr[poz];
			arr[poz] = aux;
		}
	}

	public void sort(double d)
	{
		Object aux;
		int poz = 0;
		double min = 999.9;
		
		for(int i = 0; i < super.getIndex() - 1; i ++)
		{
			for(int j = i; j < super.getIndex(); j ++)
				if(((Product)arr[j]).getPrice() < min)
				{
					min = ((Product)arr[j]).getPrice();
					poz = j;
				}
			aux = arr[i];
			arr[i] = arr[poz];
			arr[poz] = aux;
		}
	}
	
	public Object search(int b)
	{
		int i;
		for(i = 0; i < super.getIndex(); i ++)
			if(b == ((Product)arr[i]).getBarCode())
				return arr[i];
		return arr[i];
	}

	
}
