from typing import Optional

from neetcode_all_course.leetcode import TreeNode


class Solution:
    def searchBST(self, root: Optional[TreeNode], val: int) -> Optional[TreeNode]:
        if not root:
            return None

        if root.val == val:
            return root

        if root.val < val:
            return self.searchBST(root.right, val)

        return self.searchBST(root.left, val)

