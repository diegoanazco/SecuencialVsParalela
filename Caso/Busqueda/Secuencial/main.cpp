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
void fill(int* arr, int tam){
    for(int i = 0; i < tam; i++)
        arr[i]=(rand()%100);
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
    int tam=100000000;
    int* arr=new int[tam];
 //   int num=7; // numero a buscar
    fill(arr,tam);
 //   print(arr,tam);
    cout <<"Busqueda"<< endl;
    t0=clock();
    search_array(arr,0,tam,7);
    cout<<"fin"<<endl;
    t1 = clock();


    double time = (double(t1-t0)/CLOCKS_PER_SEC);
    cout << "Execution Time: " << time << endl;
    return 0;
}
