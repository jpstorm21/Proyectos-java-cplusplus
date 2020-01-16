#include <cstdlib>
#include <stdio.h>
#include <iostream>
using namespace std;

int main(int argc, char** argv) {
    int n;
    cout<<"ingrese N : ";
    cin>>n;
    for(int i = 2;i<n;i++){
        if( i %2 != 0){
            cout<<i<<endl;
        }else if( i%i == 0){
            cout<<i<<endl;
        }
    }
    return 0;
}

