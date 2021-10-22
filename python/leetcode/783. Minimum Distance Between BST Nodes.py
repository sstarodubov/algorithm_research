from typing import Optional

from leetcode.tree_node import TreeNode


class Solution:

    # cpu O(n) and ram O(n)
    def minDiffInBST(self, node: Optional[TreeNode]) -> int:
        diff = 999999999999
        nodes = []

        def helper(n: TreeNode):
            if not n:
                return
            helper(n.left)
            nodes.append(n.val)
            helper(n.right)

        helper(node)
        if len(nodes) == 1:
            return nodes[0]
        f, s = 0, 1
        while s < len(nodes):
            cur_diff = nodes[s] - nodes[f]
            diff = min(cur_diff, diff)
            f += 1
            s += 1

        return diff


assert Solution().minDiffInBST(TreeNode.build_tree([4, 2, 6, 1, 3])) == 1
assert Solution().minDiffInBST(TreeNode.build_tree([1, 0, 48, None, None, 12, 49])) == 1
print("tests passed")
