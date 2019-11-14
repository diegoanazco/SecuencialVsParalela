#include <iostream> 
#include <pthread.h>
#include <time.h>
#define canprimos 100
using namespace std;
int t1=canprimos;

bool nprimos[canprimos];

void *rellenar(void*data){
	int *s= (int *)data;
	for(int i =0;i<(*s);i++){
		nprimos [i]=true;
	}
}

void *primo(void *data){
	int *n = (int*) data;
	for(int i =2;i<(*n);i++){
		if(nprimos[i]){
			for (int j = 2; i*j < (*n); j++){
				nprimos [i * j] = false;
			}
		}
	}
}
 
 
int main() {
	float time;
    
	
	pthread_t hilo1;
	pthread_t hilo2;
	pthread_create (&hilo1, NULL, &rellenar, &t1);
	pthread_create (&hilo2, NULL, &primo, &t1);
	
	time=clock();
	pthread_join(hilo1,NULL);
	pthread_join(hilo2,NULL);
	time = clock() - time;
	
//	for(int i = 2;i< canprimos;i++){
//		if(nprimos[i]==true)
//			cout<<i<<"-";
//	}
//	
	cout<<time;
	
   return 0;
}
