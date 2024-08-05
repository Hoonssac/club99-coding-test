import java.util.HashMap;
import java.util.Map;

class TrieNode {
    Map<Character, TrieNode> children;
    Map<String, Integer> map;

    public TrieNode() {
        children = new HashMap<>();
        map = new HashMap<>();
    }

    public void insert(String key, int weight) {
        map.put(key, Math.max(map.getOrDefault(key, -1), weight));
        TrieNode node = this;
        for (char c : key.toCharArray()) {
            node = node.children.computeIfAbsent(c, k -> new TrieNode());
            node.map.put(key, Math.max(node.map.getOrDefault(key, -1), weight));
        }
    }

    public int search(String key) {
        TrieNode node = this;
        for (char c : key.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return -1;
            }
            node = node.children.get(c);
        }
        return node.map.getOrDefault(key, -1);
    }
}

class WordFilter {
    private TrieNode root;

    public WordFilter(String[] words) {
        root = new TrieNode();
        for (int weight = 0; weight < words.length; weight++) {
            String word = words[weight];
            for (int i = 0; i <= word.length(); i++) {
                String prefix = word.substring(0, i);
                for (int j = 0; j <= word.length(); j++) {
                    String suffix = word.substring(j);
                    root.insert(prefix + "#" + suffix, weight);
                }
            }
        }
    }
    
    public int f(String pref, String suff) {
        return root.search(pref + "#" + suff);
    }
}

public class LeetCode_745 {
    public static void main(String[] args) {
        String[] words = {"apple", "app", "apricot"};
        WordFilter wordFilter = new WordFilter(words);
        
        System.out.println(wordFilter.f("ap", "e")); // Output: 0
        System.out.println(wordFilter.f("ap", "t")); // Output: -1
    }
}
