from typing import Optional

from leetcode.tree_node import TreeNode


class Solution:
    def mergeTrees(self, root1: Optional[TreeNode], root2: Optional[TreeNode]) -> Optional[TreeNode]:
        if not root1 and not root2:
            return None

        if not root1 and root2:
            return root2

        if not root2 and root1:
            return root1

        root1.val += root2.val

        root1.left = self.mergeTrees(root1.left, root2.left)
        root1.right = self.mergeTrees(root1.right, root2.right)

        return root1


res = Solution().mergeTrees(root1=TreeNode.build_tree([1, 3, 2, 5]), root2=TreeNode.build_tree([2, 1, 3, None, 4, None, 7]))
print(res)