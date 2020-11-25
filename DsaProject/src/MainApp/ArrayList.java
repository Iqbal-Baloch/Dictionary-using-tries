package MainApp;

import java.util.Arrays;

public class ArrayList 
{
	private String[] data;
	private int count = 0;
	private int FIXED_SIZE = 10;

	public ArrayList() 
	{
		data = new String[10];
	}

	public String get(int index) {
		if (index < count) 
		{
			return data[index];
		} else 
		{
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	public void add(String value) {
		if (data.length - count <= data.length / 2) {
			this.reSizeArray();
		}

		data[count++] = value;
	}


	public String remove(int index) {
		if (index < count) {
			String obj = data[index];
			int temp = index;
			data[index] = null;

			while (temp < count) {
				data[temp] = data[temp + 1];
				data[temp + 1] = null;
				temp++;
			}

			count--;
			return obj;
		} 
		else 
		{
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	public void reSizeArray() 
	{
		data = Arrays.copyOf(data, data.length * 2);
	}

	public int size() 
	{
		return count;
	}
	public String [] ArrayListToArray()
	{
		String array[] = new String[count] ;
		for(int i = 0 ; i< size() ; i++)
		{
			array[i] = get(i) ;
		}
		return array ;
	}
	public int indexOf(String key)
	{
		for(int i = 0 ; i<count ; i++)
		{
			if(key.equals(data[i]))
				return i ;
		}
		return -1 ;
	}
	public String getNext(String key)
	{
		int index = indexOf(key) ;
		if(index ==-1 || index+1 >= count)
		{
			return null ;
		}
		else
			return data[index+1] ;
	}
	public String getPrev(String key)
	{
		int index = indexOf(key) ;
		if(index ==-1 || index == 0)
		{
			return null ;
		}
		else
			return data[index-1] ;
	}
	public int range(String key1 , String key2)
	{
		int index1 = indexOf(key1) ;
		int index2 = indexOf(key2) ;
		if(index1 == -1 || index2 == -1 || index1 > count || index2 > count)
			return -1 ;
		return Math.abs(index2 - index1) -1 ;
	}
	public String toString()
	{
		String a = "[ " ;
		for(int i = 0; i< count ; i++)
		{
			a = a+ data[i]+" , ";
		}
		a = a+"]" ;
		return a ;
	}

	
}
