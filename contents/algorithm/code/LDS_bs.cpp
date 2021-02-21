#include <iostream>

using namespace std;

int N;
int arr[1001];
int LDS[1001];

int search(int start, int end, int target){
    int ans;

    while(start <= end){
        int mid = (start + end) / 2;

        if(LDS[mid] <= target){
            ans = mid;
            end = mid - 1;
        }
        else
            start = mid + 1;
    }

    return ans;
}

int main(void){
    ios::sync_with_stdio(false);
    cin.tie(0);

    cin>>N;
    for(int i=0; i<N; i++)
        cin>>arr[i];
    
    int end = 0;
    LDS[end] = arr[0];
    for(int i=1; i<N; i++){
        if(LDS[end] <= arr[i]){
            int idx = search(0, end, arr[i]);
            LDS[idx] = arr[i];
        }
        else
            LDS[++end] = arr[i];
    }

    cout<<end+1<<"\n";

    return 0;
}