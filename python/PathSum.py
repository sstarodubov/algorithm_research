from binarytree import build
from binarytree import Node

TreeNode = Node

"""
Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that 
adding up all the values along the path equals targetSum.
A leaf is a node with no children.
"""


class Solution:

    # CPU O(n) and RAM O(log d) d - height of the tree
    def hasPathSum(self, root: TreeNode, targetSum: int) -> bool:

        def helper(node: TreeNode, curSum: int = 0) -> bool:
            if node is not None:
                curSum += node.val
                if curSum == targetSum and node.left is None and node.right is None:
                    return True
                left = helper(node.left, curSum)
                if left: return True
                right = helper(node.right, curSum)
                if right: return True
                return False
            return False

        return helper(root)


s = Solution()

assert not s.hasPathSum(root=build([1, 2, 3]), targetSum=5), "3"
assert not s.hasPathSum(root=build([1, 2]), targetSum=1), "3"
assert not s.hasPathSum(root=build([1, 2, 3]), targetSum=5), "1"
assert s.hasPathSum(root=build([5, 4, 8, 11, None, 13, 4, 7, 2, None, None, None, None, 1]), targetSum=22), "0"
print("tests passed")
