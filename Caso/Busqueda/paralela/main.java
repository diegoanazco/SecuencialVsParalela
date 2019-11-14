package Paralelo;

public class main {
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
		// TODO Auto-generated method stub
	    int tam=10;
	    int[] arr=new int[tam];
	    fill(arr,tam);
	    print(arr,tam);
        System.out.println("Busqueda Paralela del 7");

        int NTHREADS = Runtime.getRuntime().availableProcessors();
        System.out.println("nucleos logicos" +NTHREADS); 
        
        int block=(tam)/NTHREADS;

        int i,j;
        for (i = 0,  j = 0 ; j < NTHREADS-1 ; i = i + block, j++){
            new search_thread( arr, i, i+block, 7).start();
        }
        new search_thread(arr, i, tam, 7).start();

	}
}
