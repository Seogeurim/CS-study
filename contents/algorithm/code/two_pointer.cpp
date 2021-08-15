#include <iostream>
#include <algorithm>

using namespace std;

int N;
long long S;
int arr[100001];

int main(void){
    ios::sync_with_stdio(false);
    cin.tie(0);

    cin>>N>>S;
    for(int i=0; i<N; i++){
        cin>>arr[i];
    }
    
    int left = 0;
    int right = 0; 
    int ans = 987654321;
    int sum = arr[0];
    while(left<=right && right<N){

        if(sum < S)
            sum += arr[++right];
        else if(sum == S){
            ans = min(ans, right-left+1);
            sum += arr[++right];
        }
        else if(sum > S){
            ans = min(ans, right-left+1);
            sum -= arr[left++];
        }
    }

    if(ans == 987654321)
        cout<<"0\n";
    else  
        cout<<ans<<"\n";
    return 0;
}