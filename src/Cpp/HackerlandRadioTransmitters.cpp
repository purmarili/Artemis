#include <bits\stdc++.h>
using namespace std;


int main(){
	int n, k;
	cin >> n >> k;
	int arr [n];
	for (int i=0; i<n; i++)
		cin >> arr[i];
		
	sort(arr, arr + n);	
	int i = 0;
	int res = 0;
	// 1 2 3 5 9
	while (i < n){
		res++;
		int toplace = arr[i] + k;
		while (i < n && toplace >= arr[i]) i++;
		i--;
		toplace = arr[i] + k;
		while (i < n && toplace >= arr[i]) i++;
	}
	cout << res << endl;
	
	return 0;
}
