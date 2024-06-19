from typing import Optional

from neetcode_all_course.leetcode import TreeNode


class Solution:

    # cpu O(nodes) ram O(depth)
    def isValidBST(self, root: Optional[TreeNode]) -> bool:

        def helper(node: TreeNode, min_bound: int, max_bound: int):
            if not node:
                return True
            if node.val >= max_bound:
                return False
            if node.val <= min_bound:
                return False
            return helper(node.left, min_bound, node.val) and helper(node.right, node.val, max_bound)

        return helper(root, float("-inf"), float("inf"))


assert not Solution().isValidBST(TreeNode.build_tree([5, 4, 6, None, None, 3, 7]))
assert not Solution().isValidBST(TreeNode.build_tree([2, 2, 2]))
assert Solution().isValidBST(TreeNode.build_tree([10, 5, 11, 2, 9, None, None, None, 3]))
assert Solution().isValidBST(TreeNode.build_tree([2, 1, 3]))
assert not Solution().isValidBST(TreeNode.build_tree([5, 1, 4, None, None, 3, 6]))
print("tests passed")
