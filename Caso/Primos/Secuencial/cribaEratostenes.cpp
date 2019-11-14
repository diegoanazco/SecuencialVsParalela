#include <iostream> 
#include <time.h>
using namespace std;
 
int main() {
    long N=1000000;
 	float time;
 	time = clock();
    bool primo[N];
 	for (int i=0;i<N;i++){
 		primo[i]=true;
	 }
    for (long i = 2; i < N; i++) {
    	if (primo [i]==true){
		
	        for (long j = 2; i * j < N; j++) {
	            primo[i * j] = false; // Identifica los Multiplos: i*2, i*3, i*4, i*5
	        }
		}
    }
//	for(int i = 2;i< N;i++){
//		if(primo[i]==true)
//			cout<<i<<"-";
//	}
 	time = clock() - time;
 	cout<<time;
   	return 0;
}
