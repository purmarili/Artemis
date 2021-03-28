#include <bits\stdc++.h>
using namespace std;

int main(){
	int row, col, ind = 0;
	string s;
	cin >> s;
	
	row = floor(sqrt(s.length()));
	col = ceil(sqrt(s.length()));
	if (row * col < s.length()) row++;
	cout << row << " " << col << endl;
	
	char arr [row][col];
	for (int i=0; i<row; i++){
		for (int j=0; j<col; j++){
			if (ind >= s.length())
				arr[i][j] = ' ';
			else
				arr[i][j] = s[ind];
			ind++;
		}
	}
	for (int i=0; i<col; i++){
		for (int j=0; j<row; j++){
			cout << arr[j][i];
		}
		cout << " ";
	}
	return 0;
}
