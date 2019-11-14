package secuencial;

import java.util.*;


public class Main {
	
	
	public static void setList(ArrayList<Integer> lista, int size)
	{
		for (int i=1; i<=size; i++){
			lista.add(i); 
		}
		
	}
	
	public static void printList(ArrayList<Integer> lista)
	{
		Iterator<Integer> it = lista.iterator();
		while(it.hasNext()) {
			int elemento = it.next();
			System.out.println(elemento);
		}
	}
	
	public static int maxNumber(ArrayList<Integer> lista)
	{
		int max = lista.get(0);
		

		for(int i=0; i< lista.size();i++)
		{
			if(lista.get(i) > max)
				max = lista.get(i);
		}
		return max;
		
	}
	
	public static void main(String[] args) 
	{
		ArrayList<Integer> lista = new ArrayList<Integer>();
		int size = 100000000;
		long start = System.nanoTime();
		setList(lista,size);
		maxNumber(lista);
		System.out.println(System.nanoTime() -start);
	}

}
