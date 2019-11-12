#include <iostream>
#include <time.h>
#define canprimos 1000
using namespace std;


int primos[canprimos];
bool esPrimo(int a){
	int contador = 0;
	for(int i = 1; i <= a; i++){
		if(a%i==0)
			contador++;
	}
	bool respuesta = (contador == 2 ) ? true : false;
	return respuesta;
}

void listaPrimos(int n){
	int inicio=2;
	int i = 0;
	while(i<n){
		if(esPrimo(inicio)){
			primos[i]=inicio;
			i++;
			//cout<<inicio<<endl;	
		}
		inicio++;
	}
}

int main()
{
	long time;
	time=clock();
	listaPrimos(canprimos);
	time=clock()-time;
	for (int i = 0; i < canprimos; i++){
		cout<<"primo "<<i+1<<" = "<< primos[i]<<endl;
	}
	cout <<"tiempo"<<time;
	return 0;
}
