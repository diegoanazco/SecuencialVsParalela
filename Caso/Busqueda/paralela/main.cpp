#include <iostream>
#include <cstdlib>
#include <thread>
#include <math.h>
#include <ctime>
using namespace std;
unsigned t0, t1;

void search_array(int* A, int ini , int fin,  int num)
{
    for( ; ini<fin  ; ini++){
       if(A[ini]==num){
            cout<<"Posicion "<<ini<<endl;
       }
    }
}
void search_parallel(int * A,int tam, int num)
{
    cout<<"entro"<<endl;
    int NTHREADS = thread::hardware_concurrency(); //NUMERO DE NUCLEOS LOGICOS DEL COMPUTADOR
    //cout<<"NTHREADS "<<NTHREADS<<endl;
    int block=(tam)/NTHREADS;
    //cout<<"bloques"<<block<<endl;
    thread* vec_ths = new thread[NTHREADS];
    int i,j;

    for (i = 0,  j = 0 ; j < NTHREADS-1 ; i = i + block, j++){
        vec_ths[j] = thread(search_array, ref(A), i, i+block, num);
    }
    vec_ths[NTHREADS-1] = thread(search_array, ref(A), i, tam, num);
    for (i = 0; i < NTHREADS; i++)
        vec_ths[i].join();
}
void fill(int* arr, int tam){
    for(int i = 0; i < tam; i++)
        arr[i]=(rand()%15);
}
void print(int* arr, int tam)
{
    for(int i = 0; i < tam; i++)
        cout<<arr[i]<<" - ";
    cout<<endl;
}
int main()
{
    srand((unsigned)time(NULL));
    int tam=40;
    int* arr=new int[tam];
 //   int num=7; // numero a buscar
    fill(arr,tam);
    print(arr,tam);
    cout <<"Busqueda"<< endl;
    //search_array(arr,0,tam,7);
    cout <<"Busqueda paralela"<<endl;
    search_parallel(arr,tam,7);
    return 0;
}
