
import static java.lang.System.*;

public class AutoCompleteFeature {

    static class Node {

        int we;
        Node[] arr = new Node[26];
    }

    static void createTrie(Node root, String word) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (root.arr[ch - 'a'] == null) {
                Node node = new Node();
                root.arr[ch - 'a'] = node;
                root = node;
            } else {
                root = root.arr[ch - 'a'];
            }
        }

        root.we++;
    }

    static void suggestWord(Node root, String prefix, int suggestionCount) {
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);

            if (root.arr[ch - 'a'] != null) {
                root = root.arr[ch - 'a'];
            } else {
                out.println("No word foudn!!");
                return;
            }
        }

        suggesUtil(root, suggestionCount, prefix);
    }

    static int count = 0;

    static void suggesUtil(Node root, int suggestionCount, String word) {
        if (root == null || count == suggestionCount) {
            return;
        }

        if (root.we > 0) {
            out.println(word);
            count++;
        }

        for (int i = 0; i < 26; i++) {
            if (root.arr[i] != null) {
                suggesUtil(root.arr[i], suggestionCount, word + (char) (i + 'a'));
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node();
        createTrie(root, "abc");
        createTrie(root, "abd");
        createTrie(root, "abfd");
        createTrie(root, "agtr");
        String prefix = "ag";
        suggestWord(root, prefix, 3);
    }
}
