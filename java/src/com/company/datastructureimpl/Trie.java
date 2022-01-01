package com.company.datastructureimpl;

import java.util.HashMap;
import java.util.Map;

// trie node
class TNode {
    public final Map<Character, TNode> children =
            new HashMap<>();
    public boolean endOfString = false;
}

public class Trie {

    private final TNode root = new TNode();

    // time O(L), space O(L)
    public void insert(final String word) {
        var cur = root;
        for (int i = 0; i < word.length(); i++) {
            var letter = word.charAt(i);

            if (!cur.children.containsKey(letter)) {
                cur.children.put(letter, new TNode());
            }

            cur = cur.children.get(letter);

        }
        cur.endOfString = true;
    }

    // run tests
    public static void main(String[] args) {
        var trie = new Trie();
        trie.insert("app");
        trie.insert("api");
        trie.insert("apis");
        trie.insert("s");

        assert trie.root
                .children.get('s')
                .endOfString;
        assert trie.root
                .children.get('a')
                .children.get('p')
                .children.get('i')
                .children.get('s')
                .endOfString;
        assert trie.root
                .children.get('a')
                .children.get('p')
                .children.get('i')
                .endOfString;
        assert trie.root
                .children.get('a')
                .children.get('p')
                .children.get('p')
                .endOfString;
        System.out.println("tests passed");
    }
}

