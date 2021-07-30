
from binarytree import Node
from binarytree import build

"""Given the root of a binary tree, return the length of the longest path, where each node in the path has the same 
value. This path may or may not pass through the root.

The length of the path between two nodes is represented by the number of edges between them.

 """

TreeNode = Node


class Solution(object):
    def longestUnivaluePath(self, root):
        self.ans = 0

        def helper(node):
            if not node: return 0
            leftLength = helper(node.left)
            rightLength = helper(node.right)
            leftSum = 0
            rightSum = 0
            if node.left and node.left.val == node.val:
                leftSum = leftLength + 1
            if node.right and node.right.val == node.val:
                rightSum = rightLength + 1
            self.ans = max(self.ans, leftSum + rightSum)
            return max(leftSum, rightSum)

        helper(root)
        return self.ans


s = Solution()

assert 3 == s.longestUnivaluePath(build([1, 4, 5, 4, 4, 5, 6, 1, None, 10, 4, 4])), "1"
assert 2 == s.longestUnivaluePath(build([1, 4, 5, 4, 4, 5])), "2"
assert 2 == s.longestUnivaluePath(build([1, 2, 2, 2, 2, 2])), "0"
assert 2 == s.longestUnivaluePath(root=build([5, 4, 5, 1, 1, 5])), "1"

print("tests passed")
