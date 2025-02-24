/*
* T(n) : O(n) 
* S(n) : O(1)
** https://www.geeksforgeeks.org/number-turns-reach-one-node-binary-tree/
 */

import static java.lang.System.*;
import java.util.*;

class Node {

    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class MinimumTurnsNeededToReachFromOneNodeToAnother {
    // Get the LCA
    static Node lca(Node root, int m, int n) {
        if (root == null) {
            return null;
        }

        if (root.data == m || root.data == n) {
            return root;
        }

        Node left = lca(root.left, m, n);
        Node right = lca(root.right, m, n);

        if (left != null && right != null) {
            return root;
        }

        return left == null ? right : left;
    }

    static int turnCount = 0;
    static int prev = -1;
    // 0 : left turn
    // 1 : right turn

    static boolean nodeToRootPath(Node root, int value) {
        if (root == null) {
            return false;
        }

        if (root.data == value) {
            return true;
        }

        boolean left = nodeToRootPath(root.left, value);

        if (left) {
            // If prev turn is not 0 it means a turn taken
            if (prev != 0) {
                turnCount++;
            }
            prev = 0;
            return true;
        }

        boolean right = nodeToRootPath(root.right, value);

        if (right) {
            // If prev turn is not 1 it means a turn taken
            if (prev != 1) {
                turnCount++;
            }
            prev = 1;
            return true;
        }

        return false;
    }

    static int numberOfTurns(Node root, int first, int second) {        
        if(root == null) return -1;
        Node lcaNode = lca(root, first, second);        
        if(lcaNode == null) return -1;
        turnCount = 0;
        prev = -1;
        nodeToRootPath(lcaNode, first);
        //Reset prev turn for another value
        prev = -1;
        nodeToRootPath(lcaNode, second);
        return turnCount - 1 == 0 ? -1 : turnCount - 1;
    }
}
