#include <iostream> 
#include <vector>
#include <bits/stdc++.h>
#include <stdlib.h>     /* srand, rand */
#include <time.h>       /* time */
#include <sys/time.h> 
#include <fstream>

using namespace std; 



struct my_struct{
	vector<int> vect;
	int x;
	bool found;
	int low;
	int high;
	
};


void* binary_search(void* arg) 
{ 
	
	
	struct my_struct *ms = (struct my_struct * ) arg; 
	vector<int> a = (*ms).vect; 
	int key = (*ms).x; 

	int size = a.size(); 
	int mid; 
	int low = (*ms).low;
	int high = (*ms).high;

	while (low < high && !(*ms).found)  { 
  
        mid = (high - low) / 2 + low; 
       
        if (a[mid] == key)  { 
            (*ms).found = true; 
          //  cout<<"encontrado"<<"\n";
            break; 
        } 
  
        else if (a[mid] > key) 
            high = mid - 1; 
        else
            low = mid + 1; 
    } 
	
	
} 


int main() 
{ 
	pthread_t threads[4]; 
	double acumulador = 0;
	ofstream out1("result1kcpp.txt");
	ofstream out5("result5kcpp.txt");
	ofstream out10("result10kcpp.txt");
	ofstream out15("result15kcpp.txt");
	
	
  	int pruebas[] = {1000,5000,10000,15000};
  	
  	for(int it = 0; it < 4; it++)
  	{
  		
  		int n = pruebas[it];
  		struct my_struct td;
  		
  		for(int i = 0; i < n; i++)
  		{
  			td.vect.push_back(i);
  			
		}
		
		td.x = n-1;
	//cout<<td.x<<"\n";
		sort(td.vect.begin(), td.vect.end());
	
		td.found = false;
		for (int i = 0; i < 4; i++) 
		{
		
			td.low = i * (td.vect.size() / 4 );
			td.high = (i + 1) * (td.vect.size() / 4 );
			pthread_create(&threads[i], NULL, binary_search, (void*)&td); 	
		}
	
		for (int i = 0; i < 4; i++) 
		{
			clock_t start = clock();

			pthread_join(threads[i], NULL); 
			//cout<<i<<"\t"<<td.found<<"\n";
			clock_t end = clock();		
			acumulador = acumulador + (1000.00 * double(end-start))/double(CLOCKS_PER_SEC);

		}
		cout<<n<<"\t"<<acumulador<<"\n";
		
		if(n == 1000)
		{
			out1<<n<<"\t"<<acumulador<<"\n";
		}

		else if(n == 5000)
		{
			out5<<n<<"\t"<<acumulador<<"\n";
		}	
		
		else if(n == 10000)
		{
			out10<<n<<"\t"<<acumulador<<"\n";
		}
			
		else if(n == 15000)
		{
			out15<<n<<"\t"<<acumulador<<"\n";
		}
	}

	return 0; 
} 
