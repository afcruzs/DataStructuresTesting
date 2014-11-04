#include <iostream>
#include <set>
#include <time.h>
#include <stdlib.h>
#include <algorithm>
#include <cmath>
#include <cstdio>
#include <vector>
using namespace std;

int rand_range( int minm, int maxm ){
     return minm + (rand() % (int)(maxm - minm + 1));
}

int main(){
    freopen("dataset.txt","w",stdout);
    srand(time(NULL));
    int cases = 100;
    cout << cases << endl;
    for(;cases>=1; cases--){
        int n = rand_range(2,10000);
        int k = rand_range(0,n*n-1);
        vector<int> a,b;
        cout << n <<" "<< k << endl;
        set<int> s;
        for(int i=0; i<n; i++){
            int x = rand_range(0,3*n);
            while( s.count(x) != 0 ){
                x = rand_range(0,3*n);
            }
            a.push_back(x);

            s.insert(x);
        }


        for(int i=0; i<n; i++){
            int x = rand_range(0,3*n);
            while( s.count(x) != 0 ){
                x = rand_range(0,3*n);
            }
            b.push_back(x);
            s.insert(x);
        }

        sort(a.rbegin(),a.rend());
        sort(b.rbegin(),b.rend());
        for(int i=0; i<n; i++)
            if( i != n-1 )
                cout << a[i] << " ";
            else
                cout << a[i];
        cout << endl;

        for(int i=0; i<n; i++)
            if( i != n-1 )
                cout << b[i] << " ";
            else
                cout << b[i];
        cout << endl << endl;
    }

}
