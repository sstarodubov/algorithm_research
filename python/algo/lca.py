from typing import Optional

from leetcode.tree_node import TreeNode

tree = TreeNode.build_tree([3, 6, 8, 2, 4, None, 13, None, None, 9, 5, 7])


class Solution:
    def lowestCommonAncestor(self, node: Optional['TreeNode'], p: 'TreeNode', q: 'TreeNode') -> Optional['TreeNode']:
        if not node: return None
        if node.val == p.val or node.val == q.val: return node
        left: Optional[TreeNode] = self.lowestCommonAncestor(node.left, p, q)
        right: Optional[TreeNode] = self.lowestCommonAncestor(node.right, p, q)
        if left and right: return node
        if not left and not right: return None
        return right if right else left
