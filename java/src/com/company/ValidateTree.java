package com.company;

import java.util.*;

public class ValidateTree {
    private final List<Hook> hooks;
    public ValidateTree(List<Hook> hooks) {
       this.hooks = Collections.unmodifiableList(hooks);
    }

    record Hook(String pid, String cardId, String terminalId) {}

    public static void main(String[] args) {
       final var tree = new ValidateTree(List.of(
               new Hook("1", null, null),
               new Hook("1", "3", null)
       ));
        System.out.println("final result: %s".formatted(tree.isValid()));
    }

    public static final class Node {
        public final String val;
        public final List<Node> children;
        public boolean leaf = false;
        private final List<Hook> refList;

        public Node(String val) {
            this.val = val;
            this.children = new ArrayList<>();
            this.refList = new ArrayList<>();
        }

        void put(Node node) {
            this.children.add(node);
        }

        Node get(String val) {
           for (var child : children) {
               if (child.val.equals(val)) {
                   return child;
               }
           }

           return null;
        }
    }


    private final Node root = new Node("");

    public List<Hook> isValid() {
        var list = new ArrayList<String>(3);
        for (var h : hooks) {
            list.clear();
            if (h.pid != null) {
                list.add(h.pid);
                if (h.cardId != null) {
                    list.add(h.cardId);
                    if (h.terminalId != null) {
                        list.add(h.terminalId);
                    }
                }
            }
            var errHooks = tryAdd(list, h);
            if (!errHooks.isEmpty()) {
                System.out.println("false");
                return errHooks;
            } else {
                System.out.println("true");
            }
        }

        return Collections.emptyList();
    }

    List<Hook> tryAdd(final List<String> values, Hook hook) {
        Node cur = this.root;
        for (final var value : values) {
            var node = cur.get(value);
            if (node == null) {
               node = new Node(value);
               cur.put(node);
            }
            if (cur.leaf) {
                return cur.refList; //err
            }
            cur = node;
            cur.refList.add(hook);
        }
        if (cur.leaf) {
            return cur.refList; //err
        } else {
            cur.leaf = true;
            if (cur.children.isEmpty()) {
                return Collections.emptyList();
            } else {
                return cur.refList;//err
            }
        }
    }
}
