
import static java.lang.System.*;
import java.util.*;

class TrieNode {
    // prefix-count 

    int pc = 0;
    TrieNode chArr[] = new TrieNode[26];
}

public class CountNumberOfStringsWithGivenPrefix {
    // T(n) : O(word-length)

    static void word(TrieNode root, String word) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (root.chArr[ch - 'a'] == null) {
                TrieNode temp = new TrieNode();
                root.chArr[ch - 'a'] = temp;
                root = temp;
            } else {
                root = root.chArr[ch - 'a'];
            }
            // for each characer increse this value
            root.pc++;
        }
    }

    // T(n) : O(prefix-length)
    static int countString(TrieNode root, String prefix) {
        char arrChar[] = prefix.toCharArray();

        for (char ch : arrChar) {
            if (root.chArr[ch - 'a'] != null) {
                root = root.chArr[ch - 'a'];
            } else {
                return 0;
            }
        }

        return root.pc;
    }

    public static void main(String[] args) {
        TrieNode root = new TrieNode();

        word(root, "abc");
        word(root, "bca");
        word(root, "ab");
        word(root, "fcda");
        word(root, "pfet");
        word(root, "flex");

        out.println(countString(root, "fcd"));
    }
}
