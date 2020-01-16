

#ifndef BTREENODE_H
#define BTREENODE_H

class BTreeNode
{
    int *keys;  
    int t;      
    BTreeNode **C; 
    int n;   
    bool leaf; 
public:
    BTreeNode(int _t, bool _leaf);  
    void insertNonFull(int k);
    void splitChild(int i, BTreeNode *y);
    void traverse();  
    BTreeNode *search(int k); 
friend class BTree;
    };

#endif /* BTREENODE_H */

