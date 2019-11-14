package pp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/*
 *  
 * 2-A.-Hacer un programa que ayude a crear la lista de los 100 primeros números primos, mediante 4 hilos. Cada hilo buscará el siguiente número 
 * 		natural, y si éste es primo lo deberá almacenar en un vector que contendra los numeros primos obtenidos. Intentar evitar que se almacenen 
 * 		números primos repetidos. Al acabar su ejecución se debe mostrar el resultado acumulado en el vector de primos. Buscar la estrategia más 
 * 		óptima. 
 * 
 */

public class EratostenesThreads extends Thread{
	static int cantidad=1000000;
	static List<Boolean>nprimos=new ArrayList<Boolean>();
	
	public static synchronized void primos() {
		for(int i =0;i<cantidad;i++) {
			nprimos.add(true);
			
		}
		for(int j =2 ;j<cantidad;j++) {
			if(nprimos.get(j)) {
				for(int k = 2;j*k<cantidad;k++) {
					nprimos.set(j*k, false);
				}
			}
		}
	    }
	
	public  void run() {  // En run no se puede poner static synchronized 
		primos();
	}
	
	public static void main(String[] args) throws InterruptedException {
		//primos = new int[nPrimos];
	  	long InicioIiempo=java.util.Calendar.getInstance().getTimeInMillis();  
	    
		Thread h1 = new EratostenesThreads();	Thread h2 = new EratostenesThreads();	
		h1.start();			h2.start();			
		h1.join();			h2.join();			
		
		long FinTiempo=java.util.Calendar.getInstance().getTimeInMillis(); 
		long TotalTiempo = (FinTiempo - InicioIiempo);  
		
		/*for(int i=2;i<cantidad;i++) { 
			if(nprimos.get(i))
				System.out.println(" - "+i);
		}*/
		System.out.println("Fin de programa  en "+TotalTiempo+ " milisegundos");
	}
}