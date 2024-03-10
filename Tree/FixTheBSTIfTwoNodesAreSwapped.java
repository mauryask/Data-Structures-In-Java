/*
* T(n) : O(n)
* S(n) : O(n)
*/
class Solution {
        void inorder(TreeNode root, List<Integer> list)    
    {
        if(root == null)
            return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
    
    void fixOrder(List<Integer> list)
    {
        int index1 = -1;
        int index2 = -1;
        int n = list.size();         

        for(int i=0; i<n; i++)
        {
            if((i==0 && i+1<n && list.get(i) > list.get(i+1)) 
				|| (i==n-1 && i-1 >=0 && list.get(i) < list.get(i-1)) 
			    || (i-1 >=0 && i+1 < n && !(list.get(i) > list.get(i-1) && list.get(i) < list.get(i+1))))
            {
                if(index1 == -1)
                     index1 = i;
                 else 
                     index2 = i;    
            } 
        }
 
            int temp = list.get(index1);
            list.set(index1, list.get(index2));
            list.set(index2, temp);
    }

    int index = 0;
    
    void fixTree(TreeNode root, List<Integer> list)
    {
        if(root == null)
          return;

        fixTree(root.left, list);
        root.val = list.get(index++);
        fixTree(root.right, list);  
    }

    public void recoverTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        fixOrder(list);
        fixTree(root, list);
    }
}