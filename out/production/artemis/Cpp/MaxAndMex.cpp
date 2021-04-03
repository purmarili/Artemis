#include <bits\stdc++.h>
using namespace std;

int findmax(map<int, int> * mp){
	map<int, int>::iterator it;
	int max = 0;
	for (it=mp->begin(); it!=mp->end(); it++){
		if (it->first > max) max = it->first;
	}
	return max;
}

int findmex(map<int, int> * mp){
	int i = 0;
	while (mp->count(i) != 0)
		i++;
	return i;
}


int main(){
	int t, n, k, a, mex, max, currmin;
	cin >> t;
	while (t--){
		map<int, int> mp;
		cin >> n >> k;
		currmin = INT_MAX;
		for (int i=0; i<n; i++){
			cin >> a;
			if (mp.count(a) != 0)
				mp[a]++;
			else
				mp[a] = 1;
		}
		// O(n) + O(K*m)
		for (int p = 0; p < k; p++){
			max = findmax(&mp);
			mex = findmex(&mp);
			int res = (max + mex) / 2;
			if (res * 2 < (max + mex)) res++;
			mp[res]++;
		}
		cout << mp.size() << endl;
	}
	
	return 0;
}
