package secuencial;

import java.awt.datatransfer.SystemFlavorMap;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Main5 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		//int x = (int)(Math.random()*30)+1;
		int x =1000;
		
		FileOutputStream os = new FileOutputStream("Tiempos.txt");
		PrintStream ps = new PrintStream(os);
		
		for(int i = 1; i <= x; i++) {
			System.out.println(nPrimos(i));
			ps.println(nPrimos(i));
		}	
	}
	public static int esPrimo(int x) {
		int i;
		int contador = 0;
		for(i = 1; i <= x; i++) {
			if(x % i == 0) contador++;
		}
		if(contador > 2) { 
			return 0;
		}
		return x;
		
	}
	public static long nPrimos(int x) {
		int numero = 2;
		int i = 0;
		long start = System.nanoTime();
		while (i < x) {
			if(esPrimo(numero) != 0) {
				i++;
			}
			numero++;
			
		}
		return System.nanoTime()- start;
			
	}

}
