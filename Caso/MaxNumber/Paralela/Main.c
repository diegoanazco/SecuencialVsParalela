
#include <pthread.h>
#include <stdio.h> 
#include <stdlib.h> 
#include <time.h>

// gcc -pthread paralelo.c

#define size 100000000
#define Th_max 4

int max_num[Th_max] = {0};
int thread_no = 0;
int a[size];


void maxNumber(void* arg)
{
	for(int i=0;i<=size;i++)
	{
		a[i] = i;
	}
	int num = thread_no++;
	int max = 0;
	
	for (int i = num *(size/4); i < (num +1) * (size / 4); i++)
	{
		if (a[i] > max)
			max = a[i];
	}
	
	max_num[num] = max;
}

int main()
{
	int max = 0;
	pthread_t threads[Th_max];
	clock_t t;
	t = clock();

	for(int i=0; i<Th_max; i++)
	{
		pthread_create(&threads[i],NULL,maxNumber,(void*)NULL);
	}
	
	for(int i=0; i<Th_max;i++)
	{
		pthread_join(threads[i],NULL);
	}
	
	for(int i=0; i<Th_max;i++)
	{
		if(max_num[i] > max)
			max= max_num[i];
	}
	
	t = clock() - t;
	double time_taken = ((double)t);
	printf("fun() took %f seconds to execute \n", time_taken); 
	return 0;
}
