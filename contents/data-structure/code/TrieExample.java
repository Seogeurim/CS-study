public class TrieExample {

    public static void main(String[] args) {
        Trie t = new Trie();

        /* insert words */
        t.insert("a");
        t.insert("inn");
        t.insert("to");
        t.insert("tea");
        t.insert("ted");
        t.insert("ten");

        /* search words */
        System.out.println(t.checkWord("inn"));
        System.out.println(t.checkWord("tea"));
        System.out.println(t.checkWord("tee"));
        System.out.println(t.checkWord("te"));
    }
}

class Trie {
    TrieNode root = new TrieNode();

    void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!current.hasChild(c)) {
                current.children[c - 'a'] = new TrieNode();
            }
            current = current.getChild(c);
        }
        current.isEnd = true;
    }

    boolean checkWord(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (current.hasChild(c)) {
                current = current.getChild(c);
            } else {
                return false;
            }
        }
        return current.isEnd;
    }
}

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd;

    TrieNode getChild(char c) {
        return children[c - 'a'];
    }

    boolean hasChild(char c) {
        return children[c - 'a'] != null;
    }
}