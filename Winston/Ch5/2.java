/* A Binary Tree node
class Node {
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */
class Tree
{
    void preorder(Node root)
    {
       if(null == root) {
           return;
       }
       
       System.out.print(root.data + " ");
       preorder(root.left);
       preorder(root.right);
    }
}
