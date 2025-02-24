/*
* T(n) : O(n)
* S(n) : O(n)
 */
class Solution {
// Approach: 1 => Through sorting: O(|N| * log|N|)
/*
    void recordInorder(Node root, List<Integer> list){
        if(root == null) return;
        recordInorder(root.left, list);
        list.add(root.data);
        recordInorder(root.right, list);
    }
    
    static int index = 0;
    
    void repopulateBST(Node root, List<Integer> list){
        if(root == null) return;
        repopulateBST(root.left, list);
        root.data = list.get(index++);
        repopulateBST(root.right, list);
    }
    
    void correctBST(Node root) {
        List<Integer> list =  new ArrayList<>();
        recordInorder(root, list);
        Collections.sort(list);
        index = 0;
        repopulateBST(root, list);
    }
**/

//Approach - 02 : O(n) time complexity
    Node prev = null, first = null, mid = null, last = null;

    // Inorder traversal
    void solve(Node root) {
        if (root == null) {
            return;
        }

        solve(root.left);

        if (prev != null && prev.data > root.data) {
            if (first == null) {
                first = prev;
                mid = root;
            } else {
                last = root;
            }
        }

        prev = root;
        solve(root.right);
    }

    void swap(Node first, Node second) {
        int temp = first.data;
        first.data = second.data;
        second.data = temp;
    }

    void recoverBST(Node root) {
        prev = mid = last = first = null;
        solve(root);
        //The case when nodes are not adjacent to each other
        if (first != null && last != null) {
            swap(first, last);
        } else { //The case when both nodes are adjacent to each other in inorder traversal
            swap(first, mid);
        }
    }
}
