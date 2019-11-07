#include <iostream> 
#include <vector>
using namespace std; 

#define MAX 16 

#define MAX_THREAD 4 


int key = 110; 
bool found = false; 
int part = 0; 

void* binary_search(void* arg) 
{ 

	
	int *a = (int*)arg;
	size_t n = (&a)[1] - a;
	cout<< n << "\n";
	//std::vector<int> const* a = static_cast<std::vector<int> const*>( arg );
	
	int size = 16; 
	int thread_part = part++;  
	int mid; 

	int low = thread_part * (size / 4); 
	int high = (thread_part + 1) * (size / 4); 

	
	while (low < high && !found) { 

		mid = (high - low) / 2 + low; 

		if (a[mid] == key) { 
			found = true; 
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
	pthread_t threads[MAX_THREAD]; 
	int arr[] = { 1, 5, 7, 10, 12, 14, 15, 18, 20, 22, 25, 27, 30, 64, 110, 220 }; 
	vector<int> vect(arr, arr + 16);


	for (int i = 0; i < MAX_THREAD; i++) 
		pthread_create(&threads[i], NULL, binary_search, (void*)arr); 

	for (int i = 0; i < MAX_THREAD; i++) 
		pthread_join(threads[i], NULL); 

	if (found) 
		cout << key << " found in array" << endl; 

	else
		cout << key << " not found in array" << endl; 

	return 0; 
} 

