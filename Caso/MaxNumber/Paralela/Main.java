package paralelo;

import java.util.ArrayList;

public class Main extends Thread{
	
	static int size = 100000000;
	ArrayList<Integer> lista = new ArrayList<Integer>();
	

	public static synchronized int maxNumber(ArrayList<Integer> lista)
	{
		for (int i=1; i<=size; i++){
			lista.add(i); 
		}
		
		int max = lista.get(0);
		for(int i=0; i< lista.size();i++)
		{
			if(lista.get(i) > max)
				max = lista.get(i);
		}
		return max;
	}
	
	public static void main(String [] args) throws InterruptedException
	{
		long start = System.nanoTime();
		Thread t1 = new Main();
		Thread t2 = new Main();
		Thread t3 = new Main();
		Thread t4 = new Main();
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t1.join();
		t2.join();
		t3.join();
		t4.join();
		
		long time = System.nanoTime() -start;
		System.out.println(time);
		
		
	}

}
