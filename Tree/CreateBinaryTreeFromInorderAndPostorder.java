/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class CreateBinaryTreeFromInorderAndPostorder
{
    class Test 
    {
        int index = 0;
    }

    TreeNode getRoot(int[] po, Map<Integer, Integer> map, Test test, int start, int end)
    {
           if(start > end)
             return null;
           
           TreeNode root = new TreeNode(po[test.index--]);

           if(start == end)
             return root;

           int inorderIndex = map.get(root.val);

           root.right = getRoot(po, map, test, inorderIndex+1, end);
           root.left = getRoot(po, map, test, start, inorderIndex-1);  

           return root;    
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) 
    {
        Map<Integer, Integer> map = new HashMap<>();
        Test test = new Test();
        test.index = inorder.length - 1;
        for(int i=0; i<inorder.length; i++)
          map.put(inorder[i], i);
        return getRoot(postorder, map, test, 0, inorder.length-1);  
    }
}