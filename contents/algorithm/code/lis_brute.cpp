#include <iostream>
#include <vector>
#include <algorithm>
#define pb push_back
#define mp make_pair
#define st first
#define nd second
#define lli long long int
using namespace std;



int lis(vector<int> arr) {
  
  if(arr.empty()) return 0;

  int len = arr.size(), answer = 1;

  for(int i=0; i < len; i++) {

    vector<int> next;

    for(int j=i+1; j < len; j++) {

      if(arr[j] > arr[i]) next.push_back(arr[j]);

    }

    answer = max(answer, 1 + lis(next));

  }

  return answer;  

}


int main(){
  ios::sync_with_stdio(0);
  cin.tie(0);
  vector<int> arr;
  int n, num;
  cin >> n;
  for(int i=0;i<n;i++) {
    cin >> num;
    arr.pb(num);
  }
  // arr.pb(10);
  // arr.pb(20);
  // arr.pb(10);
  // arr.pb(30);
  // arr.pb(20);
  // arr.pb(50);
  // arr.pb(40);
  // arr.pb(25);
  // arr.pb(20);
  // arr.pb(50);
  // arr.pb(30);
  // arr.pb(70);
  // arr.pb(85);
  
  // cout << lis(arr) << "\n";
}
