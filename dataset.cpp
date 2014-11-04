#include <iostream>
#include <set>
#include <time.h>
#include <stdlib.h>
#include <algorithm>
#include <cmath>
#include <cstdio>
using namespace std;

int main(){
    freopen("dataset.txt","w",stdout);
    srand(time(NULL));
    int cases = 100;
    cout << cases << endl;
    for(;cases>=1; cases--){
        int n = max(5,(rand() % 1000));
        int k = rand() % (n*n);
        cout << n <<" "<< k << endl;
        set<int> s;
        for(int i=0; i<n; i++){
            int x = rand();
            while( s.count(x) != 0 ){
                x = rand() % n*100;
            }
            cout << x;
            if( i != n-1 )
                cout << " ";

            s.insert(x);
        }

        cout << endl;
        for(int i=0; i<n; i++){
            int x = rand();
            while( s.count(x) != 0 ){
                x = rand() % n*100;
            }
            cout << x;
            if( i != n-1 )
                cout << " ";
            s.insert(x);
        }

        cout << endl << endl;
    }

}
