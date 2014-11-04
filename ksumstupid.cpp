#include <iostream>
#include <set>
#include <time.h>
#include <stdlib.h>
#include <algorithm>
#include <cmath>
#include <cstdio>
#include <functional>

using namespace std;

int main(){
    freopen("dataset.txt","r",stdin);
    freopen("outksum.txt","w",stdout);
    int n,m,k;
    cin >> n;
    while(n--){
        cin >> m >> k;
        int a[m];
        int b[m];
        int c[m*m];

        for(int i=0; i<m; i++)
            cin >> a[i];
        for(int i=0; i<m; i++)
            cin >> b[i];

        int idx = 0;
        for(int i=0; i<m; i++)
            for(int j=0; j<m; j++)
                c[idx++] = a[i]+b[j];

        sort(c,c+m*m,greater<int>());
        /*for(int i=0; i<m*m; i++)
                cout << i << " " << c[i] << endl;*/
        cout << c[k] << endl;
    }
}
