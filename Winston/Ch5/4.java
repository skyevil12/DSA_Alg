/* A Binary Search Tree node */
/* class Node
{
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/
class BST
{   
    Node LCA(Node node, int n1, int n2) 
    {
        int max = n1 > n2 ? n1 : n2;
        int min = n1 > n2 ? n2 : n1;
        
        Node[] n1T = find(node, n1);
        Node[] n2T = find(node, n2);
        
        Node[] shorter = null, longer = null;
        
        if(n1T[99].data < n2T[99].data) {
            shorter = n1T;
            longer= n2T;
        } else {
            shorter = n2T;
            longer = n1T;
        }
        
        for(int i = shorter[99].data - 1; i >= 0; i--) {
            if(shorter[i].data > max || shorter[i].data < min) {
                continue;
            }
            
            for(int j = longer[99].data - 1; j >= 0; j--) {
                if(longer[j].data > max || longer[j].data < min) {
                    continue;
                }
                
                if(shorter[i] == longer[j]) {
                    return shorter[i];
                }
            }
        }
        
        return null;
    }
    
    Node[] find(Node node, int n) {
        Node[] rt = new Node[100];
        
        int i = 0;
        
        Node tmp = node;
        while(null != tmp) {
          rt[i++] = tmp;
          if(n > tmp.data) {
            tmp = tmp.right;
          } else if(n < tmp.data) {
            tmp = tmp.left;
          } else {
              rt[99] = new Node(i);
            return rt;
          }
        }
        
        return null;
    }
    
}
