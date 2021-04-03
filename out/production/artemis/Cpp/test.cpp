#include <bits/stdc++.h> 
using namespace std; 

// function to find minimum number of 
// operations required 
int minOpeartions(int arr[], int n, int x) 
{ 
	int k = x, i = 0; 
	while (n--) { 

		// if the element is less than x. 
		if (arr[n] < x) 
			k--; 

		// if the element equals to x. 
		if (arr[n] == x) 
			k++; 
	} 
	return k; 
} 

// driver function 
int main() 
{ 
	int arr[] = { 0,1,3,4 }; 
	int n = sizeof(arr) / sizeof(arr[0]); 
	int x = 1; 
	// output 
	cout << minOpeartions(arr, n, x) << endl; 
} 
