package binary_search.secuencial;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

public class Main {

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
		Main ob = new Main(); 
		
		int pruebas[] = {1000, 5000, 10000, 15000};
		
		for(int i = 0; i < pruebas.length; i++)
		{
			int[] arr = new int[pruebas[i]];
			for(int j = 0; j < arr.length; j++)
			{
				arr[j] = j;
			}
			
			Arrays.sort(arr);
			int n = pruebas[i]; 
	        int x = n - 1; 
	        long start = System.nanoTime();
	        int result = ob.binarySearch(arr, 0, n - 1, x); 
	        long time = System.nanoTime() - start;
	        System.out.println(pruebas[i] + "\t" +  (time/1000.00));
	        if(n == 1000)
	        {
	        	ps1.println( pruebas[i] + "\t" +  (time/1000.00));
	        }
	        else if(n == 5000)
	        {
	        	ps5.println( pruebas[i] + "\t" +  (time/1000.00));
	        }
	        
	        else if(n == 10000)
	        {
	        	ps10.println( pruebas[i] + "\t" +  (time/1000.00));
	        }
	        
	        else if(n == 15000)
	        {
	        	ps15.println( pruebas[i] + "\t" +  (time/1000.00));
	        }
 		}
        
	}

}
