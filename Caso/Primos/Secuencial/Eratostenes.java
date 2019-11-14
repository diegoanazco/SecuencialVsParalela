package pp;

import java.util.ArrayList;
import java.util.List;

public class Eratostenes {
	static int cantidad=1000000;
	static List<Boolean>nprimos=new ArrayList<Boolean>();
	
	public static void primos() {
	for(int i =0;i<cantidad;i++) {
		nprimos.add(true);
		
	}
	for(int j =2 ;j<cantidad;j++) {
		if(nprimos.get(j)) {
			for(int k = 2;j*k<cantidad;k++) {
				nprimos.set(j*k, false);
				//System.out.println(nprimos.get(j*k));
			}
		}
	}
	
	/*for (int l=2;l<cantidad;l++) {
		if(nprimos.get(l)) {
			System.out.println(nprimos.get(l)+": "+l);
		}
	}*/
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long InicioIiempo=java.util.Calendar.getInstance().getTimeInMillis();
		primos();
		long FinTiempo=java.util.Calendar.getInstance().getTimeInMillis(); 
		long TotalTiempo = (FinTiempo - InicioIiempo); 
		System.out.println("Fin de programa  en "+TotalTiempo/1000+ " milisegundos");
	}

}
