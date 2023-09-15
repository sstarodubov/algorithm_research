public class PatternTrie {
    public static void main(String[] args) {
        var tr = new Trie();

        tr.insert("9xxx", 1);
        tr.insert("92xx", 2);
        tr.insert("1x", 3);
        tr.insert("1", 4);
        tr.insert("91231", 5);

        System.out.println(tr.findPatterns("9211"));
    }


    private static class Trie {

        private static class Node {
            private final HashMap<Character, Node> children = new HashMap<>(5);
            private boolean end = false;
            private int id = -1;
        }

        private final Node root = new Node();

        public List<Integer> findPatterns(final String word) {
            var res = new ArrayList<Integer>();

            dfs(0, word, root, res);

            return res;
        }

        private void dfs(int idx, String word, Node n, ArrayList<Integer> res) {
            if (idx >= word.length()) {
                if (n.end) {
                    res.add(n.id);
                }
            } else {
                var children = n.children.entrySet();
                var letter = word.charAt(idx);
                for (var child : children) {
                    if (child.getKey() == 'x' || child.getKey() == letter) {
                        dfs(idx + 1, word, child.getValue(), res);
                    }
                }
            }
        }

        public void insert(String word, int id) {
            var cur = root;
            char letter;

            for (int i = 0; i < word.length(); i++) {
                letter = word.charAt(i);

                if (!cur.children.containsKey(letter)) {
                    cur.children.put(letter, new Node());
                }

                cur = cur.children.get(letter);
            }

            cur.id = id;
            cur.end = true;
        }

        public boolean search(String word) {
            var cur = root;
            char letter;
            for (int i = 0; i < word.length(); i++) {
                letter = word.charAt(i);
                if (cur.children.containsKey(letter)) {
                    cur = cur.children.get(letter);
                } else {
                    return false;
                }
            }

            return cur.end;
        }

        public boolean startsWith(String prefix) {
            var cur = root;
            char letter;
            for (int i = 0; i < prefix.length(); i++) {
                letter = prefix.charAt(i);
                if (cur.children.containsKey(letter)) {
                    cur = cur.children.get(letter);
                } else {
                    return false;
                }
            }

            return true;
        }
    }
}

