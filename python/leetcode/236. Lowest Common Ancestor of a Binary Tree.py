from typing import Optional

from leetcode.tree_node import TreeNode


class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':

        def dfs(node: TreeNode) -> Optional[TreeNode]:
            if not node:
                return None
            if node.val == p.val:
                return p
            if node.val == q.val:
                return q
            lr = dfs(node.left)
            rr = dfs(node.right)
            if lr and rr:
                return node
            if lr:
                return lr
            if rr:
                return rr
            return None

        ans = dfs(root)

        return ans


assert Solution().lowestCommonAncestor(root=TreeNode.build_tree([3, 5, 1, 6, 2, 0, 8, None, None, 7, 4]), p=TreeNode(5),
                                       q=TreeNode(1)).val == 3

assert Solution().lowestCommonAncestor(root=TreeNode.build_tree([3, 5, 1, 6, 2, 0, 8, None, None, 7, 4]), p=TreeNode(4),
                                       q=TreeNode(6)).val == 5

print("tests passed")
