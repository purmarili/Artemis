#include <bits\stdc++.h>
using namespace std;
 
int main(){
    int t, n, k;
    cin >> t;
    while(t--){
		cin >> n >> k;
        vector<int> arr (n, 0);
		if (k * 2 + 1 > n){
			cout << -1 << endl;
			continue;
		}
		for (int i=0; i<k; i++){
			arr[i*2 + 1] = n-i;
		}

		int j = 1;
		for (int i=0; i<n; i++){
			if (arr[i] == 0){
				arr[i] = j;
				j++;
			}
		}
		
		for (int i=0; i<n; i++)
			cout << arr[i] << endl;
 
	}
	return 0;
}








1 2 3 4
1 = [2 & 3 & 4]
[1 & 2] = [3 & 4]
[1 & 2 & 3] = 4