#include <iostream>
#define pb push_back
using namespace std;

int dp[1001];
int arr[1001];

int main(){
  ios::sync_with_stdio(0);
  cin.tie(0);
	int n, top = -1, top_i;
	cin >> n;
	dp[0] = 0; dp[0] = 0;
	for(int i=1;i<=n;i++) cin >> arr[i];

	for(int i=1;i<=n;i++) {
		dp[i] = 1;
		for(int j=1;j<=i;j++) {
			if(arr[j] < arr[i] && dp[j] +1 > dp[i]) {
				dp[i] = dp[j]+1;
			}

			if(dp[i] > top) {
				top = dp[i];
				top_i = i;
			}
		}
	}

	cout << top << '\n';
}