/*
* Same as the max sum BST in Bimary Tree
* T(n) : O(n) 
* S(n) : O(n)
*/

class NodeInfo{
    int max;
    int min;
    int size;
    boolean isBST;
    
    NodeInfo(int max, int min, boolean isBST, int size){
        this.max = max;
        this.min = min;
        this.size = size;
        this.isBST = isBST;
    }
    
    NodeInfo(){}
}

public class LargestBSTInBinaryTree{
    static int maxSize = 0;
    
    static NodeInfo solve(Node root){
        if(root == null) return new NodeInfo(Integer.MIN_VALUE, Integer.MAX_VALUE, true, 0);
        
        NodeInfo ls = solve(root.left);
        NodeInfo rs = solve(root.right);
        
        NodeInfo nodeInfo = new NodeInfo();
        nodeInfo.size =  ls.size + rs.size + 1;
        
        if((ls.isBST && rs.isBST) && (root.data < rs.min && root.data > ls.max)){
            nodeInfo.max = Math.max(root.data, Math.max(ls.max, rs.max));
            nodeInfo.min = Math.min(root.data, Math.min(ls.min, rs.min));
            nodeInfo.isBST = true;
            maxSize = Math.max(maxSize, nodeInfo.size);
        }else{
            nodeInfo.isBST = false;
        }
        
        return nodeInfo;
    }
}
