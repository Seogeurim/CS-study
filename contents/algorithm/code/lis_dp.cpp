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
				// LIS길이 최댓값을 갖는 인덱스를 top_i에 저장한다.
			}
		}
	}

	cout << top << '\n';
	
	// 위에서 저장한 top_i 인덱스부터 시작해서 거꾸로 탐색하면 LIS를 구성하는 요소들을 출력할 수 있다.
	for(int i=top_i;i>=1;i--) {
		if(dp[i] == top) {
			s.push(arr[i]);
			top--;
		}
	}

	while(!s.empty())  {
		cout << s.top() << ' ';
		s.pop();
	}
}
