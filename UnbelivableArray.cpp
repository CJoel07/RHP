#include <iostream>
using namespace std;
int main(){
	ios_base::sync_with_stdio(false);
    cin.tie(NULL);
	int t;
	cin>>t;
	for(int ctr=1;ctr<=t;ctr++){
		cout<<"Case "<<ctr<<":"<<endl;
	int n,q;
	cin>>n>>q;
	int arr[n+1];
	for(int i=1;i<=n;i++){
		cin>>arr[i];
	}
	for(int i=0;i<q;i++){
		int qt,x,y;
		cin>>qt;
		if(qt==1){
			cin>>x>>y;
			for(int i=1;i<n;i++){
				if(arr[i]==x){
					arr[i]=y;
				}
			}
		}else{
			cin>>x;
			cout<<arr[x]<<endl;
		}
	}
}
}
