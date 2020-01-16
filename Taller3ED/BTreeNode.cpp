

#include "BTreeNode.h"
#include <iostream>
using namespace std;

BTreeNode::BTreeNode(int t1, bool leaf1) {
    t = t1;
    leaf = leaf1;
    keys = new int[2 * t -1 ];
    C = new BTreeNode *[2 * t];
    n = 0;
}


void BTreeNode::traverse() {  
    cout << endl;
    int i;
    for (i = 0; i < n; i++) {
        if (leaf == false) {
          C[i]->traverse();        
        }
         cout << " " << keys[i];    
    }
    if (leaf == false) {      
        C[i]->traverse();
    }
    cout << endl;
}



BTreeNode *BTreeNode::search(int k) {

    int i = 0;
    while (i < n && k > keys[i])
        i++;
    if (keys[i] == k)
        return this;

    if (leaf == true)
        return NULL;
    return C[i]->search(k);
}

