package tries;

public class RTrie {

    public static void main(String[] args) {
        var rTrie = new RTrie();
        rTrie.put("hello", 1);
        rTrie.put("hell", 2);
        rTrie.put("gog", 3);
        System.out.println(rTrie.get("hello"));
        System.out.println(rTrie.get("hell"));
        System.out.println(rTrie.get("gog"));
    }

    private final static int R = 256;

    static class Node {
        Integer val;
        Node[] next = new Node[R];
    }

    private final Node root = new Node();

    public void put(String key, int val) {
        put(root, key, val, 0);
    }

    private Node put(Node node, String key, int val, int d) {
        if (node == null) {
            node = new Node();
        }
        if (d == key.length()) {
            node.val = val;
            return node;
        }
        char c = key.charAt(d);
        node.next[c] = put(node.next[c], key, val, d + 1);
        return node;
    }

    public Integer get(String key) {
        return get(root, key, 0);
    }


    private Integer get(Node node, String key, int d) {
        if (node == null) return null;
        if (d == key.length()) {
            return node.val;
        }
        char c = key.charAt(d);
        return get(node.next[c], key, d + 1);
    }
}
