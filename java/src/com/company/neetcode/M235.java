package com.company.neetcode;

import com.company.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class M235 {

    public static void main(String[] args) {
        new M235().lowestCommonAncestor(TreeNode.buildBinaryTree(new Integer[] {6,2,8,0,4,7,9,null,null,3,5}), new TreeNode(3), new TreeNode(9));
    }
    boolean found = false;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        var pl = new ArrayList<TreeNode>();
        path(root, p, pl);

        found = false;
        var ql = new ArrayList<TreeNode>();
        path(root, q, ql);

        TreeNode ret = null;
        for (int i = 0; i < ql.size() && i < pl.size(); i++) {
           if (ql.get(i).val == pl.get(i).val)  {
               ret = ql.get(i);
           }
        }
        return ret;
    }

    void path(TreeNode root, TreeNode target, List<TreeNode> path) {
       if (root == null || found) {
           return;
       }

       if (root.val == target.val) {
           path.add(root);
           found = true;
           return;
       }

       path.add(root);
       path(root.left, target, path);
       path(root.right, target, path);


       if (!found && !path.isEmpty()) {
           path.remove(path.size() - 1);
       }
    }
}
