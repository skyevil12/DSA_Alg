/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
 */
 /* My guess
 Time: O(N)
 Space: Stack frame O(N)
 */
class Tree
{
    int height(Node node) 
    {
         if(null == node) {
             return 0;
         }
         
         int r = height(node.right);
         int l = height(node.left);
         if(r < l) {
             return l + 1;
         } else if (r > l) {
             return r + 1;
         } else {
             return l + 1;
         }
    }   
}
