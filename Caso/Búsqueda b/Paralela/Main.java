package binary_search;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

public class Main extends Thread {
	
	int array[];
	int startindex;
	int endindex;
	int key;
	int result;
	long time;
	
	public Main(int[] array, int startindex, int endindex, int key) {
		super();
		this.array = array;
		this.startindex = startindex;
		this.endindex = endindex;
		this.key = key;
	}

	int binarySearch(int arr[], int l, int r, int x) 
    { 
        if (r >= l) { 
            int mid = l + (r - l) / 2; 
  
           
            if (arr[mid] == x) 
                return mid;
            if (arr[mid] > x) 
                return binarySearch(arr, l, mid - 1, x); 
  
            return binarySearch(arr, mid + 1, r, x); 
        } 
  
        return -1; 
    } 
	
	public void run()
	{
		long start = System.nanoTime();
		result = binarySearch(array, startindex, endindex, key);
		this.time = System.nanoTime() - start;
	}
  
	public long getTime()
	{
		return this.time;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		FileOutputStream os1 = new FileOutputStream("result1kjava.txt");
		FileOutputStream os5 = new FileOutputStream("result5kjava.txt");
		FileOutputStream os10 = new FileOutputStream("result10kjava.txt");
		FileOutputStream os15 = new FileOutputStream("result15kjava.txt");
		
		PrintStream ps1 = new PrintStream(os1);
		PrintStream ps5 = new PrintStream(os5);
		PrintStream ps10 = new PrintStream(os10);
		PrintStream ps15 = new PrintStream(os15);
		long acumulador = 0;
		int pruebas[] = {1000, 5000, 10000, 15000};
		
		for(int i = 0; i < pruebas.length; i++)
		{
			int n = pruebas[i]; 
			int[] arr = new int[n];
			for(int j = 0; j < n; j++)
			{
				arr[j] = j;
			}
			
			Arrays.sort(arr);
			
	      //  int x = (int) (Math.random()*pruebas[i] + 1);
	        int x = n - 1;
			ArrayList<Main> hilos = new ArrayList<Main>();

			
			for(int k = 0; k < 4; k++)
			{
				hilos.add(new Main(arr, k * (n/4), (k + 1 ) * (n / 4), x));
			}
			
			
			for(int k = 0; k < 4; k++)
			{
				hilos.get(k).run();
			}
			
			while(!hilos.isEmpty())
			{
				for(int k = 0; k < hilos.size(); k ++)
				{
					if(!hilos.get(k).isAlive())
					{
						if(hilos.get(k).result != -1)
						{
							acumulador += hilos.get(k).getTime();
						}
						hilos.remove(k);
					}
				}
			}
			
			System.out.println( n + "\t" + (acumulador/1000.00));
			if(n == 1000)
	        {
	        	ps1.println( pruebas[i] + "\t" +  (acumulador/1000.00));
	        }
	        else if(n == 5000)
	        {
	        	ps5.println( pruebas[i] + "\t" +  (acumulador/1000.00));
	        }
	        
	        else if(n == 10000)
	        {
	        	ps10.println( pruebas[i] + "\t" +  (acumulador/1000.00));
	        }
	        
	        else if(n == 15000)
	        {
	        	ps15.println( pruebas[i] + "\t" +  (acumulador/1000.00));
	        }
	        
 		}
        
	}

}
