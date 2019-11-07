package binary_search;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

public class binary_search_secuencial {

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
		FileOutputStream os = new FileOutputStream("binary_search_secuencial_java.txt");
		PrintStream ps = new PrintStream(os);
		
		binary_search_secuencial ob = new binary_search_secuencial(); 
		
		int pruebas[] = {1000, 5000, 10000, 15000};
		
		for(int i = 0; i < pruebas.length; i++)
		{
			int[] arr = new int[pruebas[i]];
			for(int j = 0; j < arr.length; j++)
			{
				arr[j] = (int) (Math.random()*pruebas[i] + 1);
			}
			
			Arrays.sort(arr);
			int n = arr.length; 
	        int x = 10; 
	        long start = System.nanoTime();
	        int result = ob.binarySearch(arr, 0, n - 1, x); 
	        long time = System.nanoTime() - start;
	        System.out.println(pruebas[i] + "\t" +  time);
	        ps.println( pruebas[i] + "\t" +  time);
	        
 		}
        
	}

}
