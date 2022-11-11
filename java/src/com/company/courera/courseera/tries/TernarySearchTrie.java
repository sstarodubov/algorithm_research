package tries;

public class TernarySearchTrie {
    private static class Node {
        private int val;
        private char c;
        private Node left, middle, right;
    }

    private Node root;

    public void put(String key, int val) {
        root = put(root, key, val, 0);
    }

    public Integer get(String key) {
        Node node = get(root, key, 0);
        if (node == null) return null;
        return node.val;
    }

    private Node get(Node node, String key, int d) {
        if (node == null) return null;
        char c = key.charAt(d);
        if (c < node.c) return get(node.left, key, d + 1);
        if (c > node.c) return get(node.right, key, d + 1);
        if (d < key.length() - 1) return get(node.middle, key, d + 1);
        return node;
    }

    private Node put(Node node, String key, int val, int d) {
        char c = key.charAt(d);
        if (node == null) {
            node = new Node();
            node.c = c;
        }

        if (c < node.c) {
            node.left = put(node.left, key, val, d + 1);
        } else if (c > node.c) {
            node.right = put(node.right, key, val, d + 1);
        } else if (d < key.length() - 1) {
            node.middle = put(node.middle, key, val, d + 1);
        } else {
            node.val = val;
        }

        return node;
    }
}
