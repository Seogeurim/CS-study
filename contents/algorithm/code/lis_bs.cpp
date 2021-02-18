#include <iostream>
using namespace std;
int arr[1000001],ans[1000001]={0,};

int bs(int low,int high,int key){
    if(low > high) return low;
    int mid = (low+high)/2;
    if(key < ans[mid]) return bs(low,mid-1,key);
    else if(key > ans[mid]) return bs(mid+1,high,key);
    else return mid;
}

int main(){
  int n,idx=1;
  cin >> n;
  for(int i=0;i<n;i++) scanf("%d",&arr[i]);
  ans[0] = arr[0];
  for(int i=0;i<n;i++){
      if(arr[i]>ans[idx-1]){
          ans[idx++] = arr[i];
      }
      else{
          int a = bs(0,idx-1,arr[i]);
          ans[a] = arr[i];
      }
  }
  cout << idx;

  return 0;
}
