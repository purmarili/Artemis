#include <bits\stdc++.h>
using namespace std;


int main(){
	
	int t, lastr, answ;
	string s;
	cin >> t;
	
	for (int i=0; i<t; i++){
		lastr = -1;
		answ = 0;
		cin >> s;
		
		for (int j=0; j<=s.size(); j++){
			if (j == s.size() || s[j] == 'R'){
				answ = max(answ, j - lastr);
				lastr = j;
			}
		}
		cout << answ << endl;
	}
	
	return 0;
}
