#include <stdlib.h>
#include <pthread.h>
#include <stdio.h>
#include <iostream>
#include <time.h>
#define canprimos 100
using namespace std;

int primos[canprimos];

int n1=canprimos/4;
int n2=n1*2;
int n3=n1*3;
int n4=canprimos;
int inicio=2;
int i=0;

bool esPrimo(int a){
	int contador = 0;
	for(int i = 1; i <= a; i++){
		if(a%i==0)
			contador++;
	}
	bool respuesta = (contador == 2 ) ? true : false;
	return respuesta;
}

void *lista(void * data){
	int *n = (int *)data;
	while(i<(*n)){
		if(esPrimo(inicio)){
			primos[i]=inicio;
			i++;
		}
		inicio++;
	}
}


int main()
{
	long time;
	
	pthread_t hilo1;
	pthread_t hilo2;
	pthread_t hilo3;
	pthread_t hilo4;
	pthread_create (&hilo1, NULL, &lista, &n1);
	pthread_create (&hilo2, NULL, &lista, &n2);
	pthread_create (&hilo3, NULL, &lista, &n3);
	pthread_create (&hilo4, NULL, &lista, &n4);

	time = clock();
	pthread_join(hilo1,NULL);
	pthread_join(hilo2,NULL);
	pthread_join(hilo4,NULL);
	pthread_join(hilo3,NULL);
	time = clock() - time;

	cout << time;
	
	
	return 0;
}
