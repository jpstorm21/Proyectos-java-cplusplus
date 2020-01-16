

#ifndef BTREE_H
#define BTREE_H
#include "BTreeNode.h"
#include <iostream>
using namespace std;
class BTree
{
    BTreeNode *root;
    int t; 
public:

    BTree(int _t)
    {  root = NULL;  t = _t; }

    void traverse()
    {  if (root != NULL) root->traverse(); }

    BTreeNode* search(int k)
    {  return (root == NULL)? NULL : root->search(k); }
    void insert(int k);
};

#endif /* BTREE_H */

