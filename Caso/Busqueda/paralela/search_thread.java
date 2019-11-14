package Paralelo;

public class search_thread extends Thread {
	int[] mA;
	int mini;
	int mfin;
	int mnum;
	public search_thread(int[] A, int ini , int fin,  int num) {
		mA=A;
		mini=ini;
		mfin=fin;
		mnum=num;
	}
	public void run() {
	    for( ; mini<mfin  ; mini++){
		       if(mA[mini]==mnum){
		            System.out.println("Posicion "+mini);
		       }
		    }	
	}
}
