from collections import deque
from typing import List, Optional

from leetcode.tree_node import TreeNode


class Solution:

    # cpu O(nodes) and ram O(log depth)
    def findMode(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        modes = []
        self.maximum = 0
        self.prev = None
        self.count = 0

        def helper(cur_node: TreeNode, modes):
            if not cur_node:
                return

            helper(cur_node.left, modes)

            if self.prev:
                if self.prev.val == cur_node.val:
                    self.count += 1
                else:
                    self.count = 0

            if self.count > self.maximum:
                self.maximum = self.count
                modes.clear()
                modes.append(cur_node.val)
            elif self.count == self.maximum:
                modes.append(cur_node.val)
            self.prev = cur_node

            helper(cur_node.right, modes)

        helper(root, modes)

        return modes


assert Solution().findMode(TreeNode.build_tree([1, None, 2])) == [1, 2]
assert Solution().findMode(TreeNode.build_tree([0])) == [0]
assert Solution().findMode(TreeNode.build_tree([1, None, 2, 2])) == [2]
print("tests passed")
