#include <iostream>
#include <vector>
#include <chrono>
using namespace std;


void printList(vector<int> list)
{
	for (auto it = list.begin(); it != list.end(); it++) 
        cout << *it << " "; 
}

double maxNumber(vector<int> list, int size)
{
	auto start = std::chrono::high_resolution_clock::now();
	for(int i=1;i<=size;i++)
	{
		list.push_back(i);
	}
	int max = list.at(0);
	for(int i=1; i< size;i++)
	{
		if(list.at(i)> max)
			max = list.at(i);	
	}
	auto finish = std::chrono::high_resolution_clock::now();
	return std::chrono::duration_cast<std::chrono::nanoseconds>(finish-start).count();
}

int main()
{
	vector<int> lista;
	int size = 10000;

	//printList(lista);
	cout << maxNumber(lista,size);
	return 0;
}
