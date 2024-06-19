# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from typing import Optional

from neetcode_all_course.leetcode import TreeNode


class Solution:

    # time O(n^2) , space O(1)
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        self.swapped = False

        def swap(x: TreeNode, y: TreeNode):
            x.val, y.val = y.val, x.val

        def validate(node: TreeNode, mn: TreeNode, mx: TreeNode) -> bool:
            if self.swapped:
                return False
            if not node:
                return True
            if node.val >= mx.val:
                self.swapped = True
                swap(node, mx)
                return False
            if node.val <= mn.val:
                self.swapped = True
                swap(node, mn)
                return False

            return validate(node.left, mn, node) and validate(node.right, node, mx)

        is_valid = validate(root, TreeNode(float("-inf")), TreeNode(float("inf")))

        while not is_valid:
            self.swapped = False
            is_valid = validate(root, TreeNode(float("-inf")), TreeNode(float("inf")))


aa_tree = TreeNode.build_tree([2, 3, 1])
Solution().recoverTree(aa_tree)

tree = TreeNode.build_tree([1, 3, None, None, 2])
Solution().recoverTree(tree)

another_tree = TreeNode.build_tree([3, 1, 4, None, None, 2])
Solution().recoverTree(another_tree)
print(tree)
