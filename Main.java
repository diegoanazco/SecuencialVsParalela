package secuencial;
/*
@file Main.java

@datetime 2019-11-11 10:14:09 a.m.
@version 1.0
@author Richart Smith Escobedo Quispe
@contact r.escobedo@ulasalle.edu.pe

@description
Simulation program in Java 8 for multiply matrices using sequential algorithm. The test cases is 1x1, 2x2,... nxn dimensions where n=TAM

@copyright 2019, Richart Smith Escobedo Quispe. All Rights Reserved.
@licence GPLv3 - https://www.gnu.org/licenses/gpl-3.0.html
*/

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import com.panayotis.gnuplot.JavaPlot;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {		
		int TAM = 1000; //1000, 5000, 10000, 15000
		
		String file = "matrSecu1kjava.txt";
        PrintWriter oS = new PrintWriter(file);
        
        long nano_startTime = System.nanoTime();
		for(int n=1; n<=TAM; n++) {
			int[][]  A = generar(n);
			oS.println(multiplicar(A,A));
		}
		long nano_endTime = System.nanoTime();
		oS.close();
		
		System.out.println("Total time execution : " + (nano_endTime - nano_startTime) + " ns");
		//1 Nanosegundos = 1.667×10-11 Minutos
		System.out.println("Total time execution : " + (nano_endTime - nano_startTime)*(1.667/0.000000000010) + " min");
		
		JavaPlot p = new JavaPlot();
		p.addPlot("\"matrSecu1kjava.txt\" with lines");
		p.plot();
	}
	
	public static int[][] generar(int n) {		
		int[][] A = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				A[i][j] = (int) Math.floor(Math.random()*10+1);
			}
		}
		return A;
	}
	
	public static long multiplicar(int[][] a, int[][] b) {		
		int[][] c = new int[a.length][b.length];
		
		long nano_startTime = System.nanoTime();
		for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < a[0].length; k++) {                    
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
		long nano_endTime = System.nanoTime();
		
		return nano_endTime - nano_startTime;
	}
	
	public void imprimir(int[][] a) {
		for(int i=0; i<a.length; i++) {
			System.out.println("\n");
			for(int j=0; j<a[0].length; j++) {
				System.out.print(a[i][j]);
				System.out.print("\t");
			}
		}		
	}
	
	

}
