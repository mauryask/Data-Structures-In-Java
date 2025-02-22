/*
** https://www.geeksforgeeks.org/check-two-nodes-cousins-binary-tree/
** T(n) : O(n) 
** S(n) : O(n)
 */
import java.util.*;

class Node {

    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        right = left = null;
    }
}

public class CheckIfTwoNodesAreCousins {

    //DFS aproach
    static class NodeInfo {

        int level;
        int parent;

        NodeInfo(int level, int parent) {
            this.level = level;
            this.parent = parent;
        }
    }

    static boolean aFound = false;
    static boolean bFound = false;

    void findParent(Node root, int parent, Map<Integer, NodeInfo> map, int level, int a, int b) {
        if (root == null) {
            return;
        }

        map.put(root.data, new NodeInfo(level, parent));

        if (root.data == a) {
            aFound = true;
        } else if (root.data == b) {
            bFound = true;
        }

        if (aFound && bFound) {
            return;
        }

        findParent(root.left, root.data, map, level + 1, a, b);
        findParent(root.right, root.data, map, level + 1, a, b);
    }

    //BFS Apperoach (Best approach)
    static boolean isCousinUtil(Node root, int a, int b) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {
            // As the both nodes going to be at same level
            // Good idea to declare variables here only
            int aParent = -1, bParent = -1;
            boolean aFound = false, bFound = false;
            int count = q.size();

            while (count-- > 0) {
                root = q.poll();

                if (root.left != null) {
                    if (root.left.data == a) {
                        aParent = root.data;
                        aFound = true;
                    } else if (root.left.data == b) {
                        bFound = true;
                        bParent = root.data;
                    }
                    
					//You need to push it even if some node is found
                    q.add(root.left);
                }

                if (root.right != null) {
                    if (root.right.data == a) {
                        aParent = root.data;
                        aFound = true;
                    } else if (root.right.data == b) {
                        bFound = true;
                        bParent = root.data;
                    }
                    
					//You need to push it even if some node is found to get another node
                    q.add(root.right);
                }

                if (aFound && bFound && aParent != bParent) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean isCousins(Node root, int a, int b) {
        Map<Integer, NodeInfo> map = new HashMap<>();
        aFound = false;
        bFound = false;
        findParent(root, -1, map, 0, a, b);

        return map.containsKey(a) && map.containsKey(b)
                && map.get(a).parent != map.get(b).parent
                && map.get(a).level == map.get(b).level;
    }
}
