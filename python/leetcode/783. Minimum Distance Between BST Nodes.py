from typing import Optional

from neetcode_all_course.leetcode import TreeNode


class Solution:

    # cpu O(n) and ram O(log d)
    def minDiffInBST(self, root: Optional[TreeNode]) -> int:
        self.prev = None
        self.cur = None
        self.diff = 10 ** 9

        def helper(node: TreeNode):
            if not node:
                return
            helper(node.left)
            if self.prev is None:
                self.prev = node.val
            elif self.cur is None:
                self.cur = node.val
                self.diff = self.cur - self.prev
            else:
                self.prev = self.cur
                self.cur = node.val
                self.diff = min(self.diff, self.cur - self.prev)
            helper(node.right)

        helper(root)
        return self.diff


assert Solution().minDiffInBST(TreeNode.build_tree([0, None, 2236, 1277, 2776, 519])) == 519
assert Solution().minDiffInBST(TreeNode.build_tree([90, 69, None, 49, 89, None, 52])) == 1
assert Solution().minDiffInBST(TreeNode.build_tree([27, None, 34, None, 58, 50, None, 44])) == 6
assert Solution().minDiffInBST(TreeNode.build_tree([4, 2, 6, 1, 3])) == 1
assert Solution().minDiffInBST(TreeNode.build_tree([1, 0, 48, None, None, 12, 49])) == 1
print("tests passed")
