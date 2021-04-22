#include <bits/stdc++.h>
using namespace std;

vector<vector<char>> v(401, vector<char> (401, '.'));
int test, n, t;


int main()
{
	cin >> test;
	while(test--){

		cin >> n;
		for (int i=0; i<n; i++){
			for (int j=0; j<n; j++){
				cin >> v[i][j];
			}
		}

		int firstX = -1, firstY = -1, secondX = -1, secondY = -1;
		bool found = false;

		for (int i=0; i<n; i++){
			for (int j=0; j<n; j++){
				if (v[i][j] == '*'){
					if (firstX == -1){
						firstX = i;
						firstY = j;
					} else if (secondX == -1){
						secondX = i;
						secondY = j;
						found = true;
						break;
					}
				}
			}
			if (found) break;
		}
		* . .
		. . .
		* . .

		if (firstX == secondX){
			if (firstX != 0){
				v[firstX - 1][firstY] = '*';
				v[firstX - 1][secondY] = '*';
			} else {
				v[firstX + 1][firstY] = '*';
				v[firstX + 1][secondY] = '*';
			}
		} else if (firstY == secondY){
			if (firstY != 0){
				v[firstX][firstY - 1] = '*';
				v[secondX][firstY - 1] = '*';
			} else {
				v[firstX][firstY + 1] = '*';
				v[secondX][firstY + 1] = '*';
			}
		} else {
			v[firstX][secondY] = '*';
			v[secondX][firstY] = '*';	
		}

		for (int i=0; i<n; i++){
			for (int j=0; j<n; j++){
				cout << v[i][j];
			}
			cout << endl;
		}
	}



	return 0;
}