package Secuencial;

public class main {
	static void search_array(int[] A, int ini , int fin,  int num)
	{
	    for( ; ini<fin  ; ini++){
	       if(A[ini]==num){
	            System.out.println("Posicion "+ini);
	       }
	    }
	}
	
	public static void fill(int[] arr, int tam){
	    for(int i = 0; i < tam; i++)
	        arr[i]=(int)(Math.random() * 10) + 1;
	}
	public static void print(int[] arr, int tam)
	{
	    for(int i = 0; i < tam; i++)
            System.out.print(arr[i]+" - ");
        System.out.println();
	}
	
	public static void main(String[] args) {
	    int tam=100;
	    int[] arr=new int[tam];
	    fill(arr,tam);
	    print(arr,tam);
        System.out.println("Busqueda del 7");
	    search_array(arr,0,tam,7);

	}
}
