#include <bits/stdc++.h>

#define f first
#define s second
#define ll long long
#define db double
#define pb push_back
#define p_q priority_queue
 
using namespace std;
 
const int N = 6e5, Mod = 998244353, INF = 1e9+7;
 
vector < pair < int, int > > g[N];
int ans, n, fix[N], ans1, a, b, c, d, fix1[N];
pair < int,  int > p[N], p1[N];
 

 
int main() {
	
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);
	
	cout << h << endl;
	int t = 1;
//	cin >> t;
	while (t --) {
		cin >> n;
		for (int i = 1; i <= n; i ++) {
			cin >> p[i].f;
			p1[i].f = p[i].f;
			
			p[i].s = i;
			p1[i].s = i;
			
		}
		
		sort (p+1, p+n+1);
		sort (p1+1, p1+n+1);
		for (int i = 1; i <= n; i ++) {
			p[i].f = i;
			p1[i].f = i;
			
			swap (p[i].f, p[i].s);
			swap (p1[i].f, p1[i].s);
		}
		// (4, 1), (1, 2), (3, 3), (2, 4)
		sort (p+1, p+n+1);
		sort (p1+1, p1+n+1);
		// (1, 2), (2, 4), (3, 3), (4, 1)
		// (1, 1), (2, 4), (3, 3), (4, 2)
		
		for (int i = 1; i <= n; i ++) {
			fix[p[i].s] = i;
			fix1[p1[i].s] = i;
		}
		// [ 4, 1, 3, 2 ]
		// [ 1, 4, 3, 2 ]
		
		for (int i = 1; i <= n; i ++) {
			if (p[i].s != i) {
			//	if (i == 5) cout << p[i].s << endl;
				int a, b, c, d;
				// a = 1, b = 2, c = 4, d 1
				a = p[fix[i]].s; b = p[i].s; c = fix[i]; d = i;
				
				swap (p[fix[i]].s, p[i].s);
				fix[b] = c;
				fix[a] = d;
				
				ans ++;
			}
				
		}
		
		for (int i = 1; i <= n; i ++) {
			if (p1[i].s != n-i+1) {
				
				int a, b, c, d;
				a = p1[fix1[n-i+1]].s; b = p1[i].s; c = fix1[n-i+1]; d = i;
				
				swap (p1[fix1[n-i+1]].s, p1[i].s);
				fix1[b] = c;
				fix1[a] = d;
				
				ans1 ++;
			}
				
		}
	
	
		cout << min(ans, ans1);
	
	}
}


