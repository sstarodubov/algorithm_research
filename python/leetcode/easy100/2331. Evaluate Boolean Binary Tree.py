from typing import Optional

from leetcode.tree_node import TreeNode

OR = 2
AND = 3
TRUE = 1
FALSE = 0

class Solution:
    def evaluateTree(self, node: Optional[TreeNode]) -> bool:
        if not node:
            return False

        if not node.left and not node.right:
            return node.val == TRUE

        left_eval = self.evaluateTree(node.left)
        right_eval = self.evaluateTree(node.right)

        if node.val == OR:
            return left_eval or right_eval

        return left_eval and right_eval
