from typing import Optional

from tree_node import TreeNode


class Solution:
    def trimBST(self, root: Optional[TreeNode], low: int, high: int) -> Optional[TreeNode]:
        def dfs(node: TreeNode, parent: TreeNode):
            if not node:
                return

            dfs(node.left, node)
            dfs(node.right, node)

            if node.val < low:
                if node == parent.right:
                    parent.right = node.right
                elif node == parent.left:
                    parent.left = node.right
            elif node.val > high:
                if node == parent.right:
                    parent.right = node.left
                elif node == parent.left:
                    parent.left = node.left
        dummy = TreeNode(-1)
        dummy.right = root
        dfs(root, dummy)

        if dummy.left:
            return dummy.left

        if dummy.right:
            return dummy.right

        if low <= root.val <= high:
            return root
        return None


xs = Solution().trimBST(TreeNode.build_tree([1, None, 2]), 2, 4)
Solution().trimBST(TreeNode.build_tree([3, 1, 4, None, 2]), 3, 4)
Solution().trimBST(TreeNode.build_tree([3]), 2, 2)
Solution().trimBST(root=TreeNode.build_tree([3, 0, 4, None, 2, None, None, 1]), low=1, high=3)

print(xs)
