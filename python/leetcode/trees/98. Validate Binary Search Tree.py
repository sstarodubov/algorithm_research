from typing import Optional

from neetcode_all_course.leetcode import TreeNode


class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return True

        def dfs(n: TreeNode, max: int, min: int):
            if not n:
                return True

            if n.val >= max:
                return False
            if n.val <= min:
                return False

            return dfs(n.left, n.val, min) and dfs(n.right, max, n.val)

        return dfs(root.left, root.val, float("-inf")) and dfs(root.right, float("inf"), root.val)


assert Solution().isValidBST(TreeNode.build_tree([3, 1, 5, 0, 2, 4, 6]))
assert not Solution().isValidBST(TreeNode.build_tree([2, 2, 2]))
assert not Solution().isValidBST(TreeNode.build_tree([5, 1, 4, None, None, 3, 6]))
assert Solution().isValidBST(TreeNode.build_tree([2, 1, 3]))
