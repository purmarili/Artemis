#include <bits\stdc++.h>
using namespace std;

#define ll long long

ll get_ans(ll hor, ll vert){
	if (hor == 1 || ver == 1) return 0;
	
	ll ans = min(hor, vert/2);
	ans--;
	
	ans += min(vert, hor/2);
	ans--;
	
	return ans;	
}

ll solve(){
	
	ll n, m, res = 0;
	cin >> n >> m;
	vector< vector<ll> > grid (n, vector<ll>(m, 0));
	
	vector< vector<ll> > up(n, vector<ll>(m, 0));
	vector< vector<ll> > down(n, vector<ll>(m, 0));
	vector< vector<ll> > left(n, vector<ll>(m, 0));
	vector< vector<ll> > right(n, vector<ll>(m, 0));
	
	for (int i=0; i<n; i++)
		for (int j=0; j<m; j++)
			cin >> grid[i][j];
	
			
	for (int j=0; j<m; j++){
		for (int i=0; i<n; i++){
			if (grid[i][j] == 0) continue;
			
			if (i == 0) down[i][j] = 1;
			else down[i][j] = 1 + down[i - 1][j];
		}
	}
	
	for (int j=0; j<m; j++){
		for (int i=n - 1; i>=0; i--){
			if (grid[i][j] == 0) continue;
			
			if (i == n - 1) up[i][j] = 1;
			else up[i][j] = 1 + up[i + 1][j];
		}
	}
	
	for (int i=0; i<n; i++){
		for (int j=0; j<m; j++){
			if (grid[i][j] == 0) continue;
			
			if (j == 0) left[i][j] = 1;
			else left[i][j] = 1 + left[i][j - 1];
		}
	}
	
	for (int i=0; i<n; i++){
		for (int j=m - 1; j>=0; j--){
			if (grid[i][j] == 0) continue;
			
			if (j == m - 1) right[i][j] = 1;
			else right[i][j] = 1 + right[i][j + 1];
		}
	}
	
	for (int i=0; i<n; i++){
		for (int j=0; j<m; j++){
			if (grid[i][j] == 0) continue;
			
			res += get_ans(down[i][j], left[i][j]);
			res += get_ans(down[i][j], right[i][j]);
			res += get_ans(up[i][j], left[i][j]);
			res += get_ans(up[i][j], right[i][j]);
		}
	}
	
	return res;
	
	return 0;
}


int main(){
	
	int t;
	cin >> t;
	solve();
	
	return 0;
}
