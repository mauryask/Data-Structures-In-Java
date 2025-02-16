/*
* T(n) : O(no of words * max word length)
* S(n) : O(no of words * max word length)
 */

import static java.lang.System.*;

class Node {
    // word-end = 1, indicates the end of a word

    int we = 0;
    Node chArr[] = new Node[26];
}

public class TrieImplementation {

    // T(n) : O(word-length)
    static void insertWord(Node root, String word) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (root.chArr[ch - 'a'] == null) {
                Node temp = new Node();
                root.chArr[ch - 'a'] = temp;
                root = temp;
            } else {
                root = root.chArr[ch - 'a'];
            }
        }

        root.we += 1;
    }

    // T(n) : O(word-length)
    static boolean searchWord(Node root, String word) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (root.chArr[ch - 'a'] != null) {
                root = root.chArr[ch - 'a'];
            } else {
                return false;
            }
        }

        return root.we > 0;
    }

    // T(n) : O(word-length)
    static void deleteWord(Node root, String word) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (root.chArr[ch - 'a'] != null) {
                root = root.chArr[ch - 'a'];
            } else {
                out.println("The requested word is not found");
                return;
            }
        }

        if (root.we > 0) {
            root.we--;
            out.println("Word deleted successfully!");
            return;
        }

        out.println("Word is not found!");
    }

    //T(n) : O(n) : Here n is total number of characters across all the words
    static void printAllTheWords(Node root, String result) {
        if (root == null) {
            return;
        }

        if (root.we > 0) {
            out.println(result);
        }

        for (int i = 0; i < 26; i++) {
            if (root.chArr[i] != null) {
                printAllTheWords(root.chArr[i], result + (char) (i + 'a'));
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node();

        insertWord(root, "abc");
        insertWord(root, "abd");
        insertWord(root, "abb");
        insertWord(root, "abd");
        insertWord(root, "bcd");
        insertWord(root, "cde");

        out.println(searchWord(root, "abd"));
        //out.println(searchWord(root, "bca"));
        //out.println(searchWord(root, "abcd"));

        /*deleteWord(root, "abc");*/
        deleteWord(root, "ab");
        /*out.println(searchWord(root, "ab"));*/
    }
}
