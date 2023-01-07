#include <iostream>
#include <queue>
#include <vector>
#include <string.h>
#pragma warning(disable: 4996)
using namespace std;

int n,m;
int arr[50][50];
bool check[50][50];
	
int t;
int k;
int a,b;
int cnt;


int dx[4] = { 0, 0, 1, -1 };
int dy[4] = { 1, -1, 0, 0 };

bool in_range(int x, int y) {
	if (x >= 0 && y >= 0 && x < m && y < n)
		return 1;
	else return 0;
}


int dfs(int r, int c) {

	int ret = 1;

	for (int k = 0; k < 4; k++) {
		int nr = r + dx[k];
		int nc = c + dy[k];
		if (in_range(nr,nc) && check[nr][nc] == false && arr[nr][nc] == 1) {
			check[nr][nc] = 1;
			ret += dfs(nr, nc);
		}
	}
	return ret;
}
vector<int> ans;
int main() {
	
	
	cin >> t;
	for(int i=0;i<t;i++){
		cin >> m >> n >> k;
		for(int j=0;j<k;j++){
			
			cin >> a >> b;
			arr[a][b] = 1;
		}
		cnt = 0;
		for (int x = 0; x < m; x++) {
			for (int y = 0; y < n; y++) {
				if (check[x][y] == 0 && arr[x][y] == 1) {
					check[x][y] = 1;
					ans.push_back(dfs(x, y));
					cnt += 1;
				}
			}
		}
		cout << cnt << endl;
		memset(arr, false, sizeof(arr));
		memset(check, false, sizeof(check));
	}
	
	return 0;
}