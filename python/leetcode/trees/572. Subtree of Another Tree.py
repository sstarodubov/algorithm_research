from typing import Optional

from leetcode.tree_node import TreeNode


class Solution:
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        def serialize(n, s):
            if not n:
                s.append('$')
                return

            s.append("+")
            s.append(str(n.val))
            serialize(n.left, s)
            serialize(n.right, s)

        rr = []
        serialize(root, rr)
        r = "".join(rr)

        ss = []
        serialize(subRoot, ss)
        s = "".join(ss)

        return s in r


assert Solution().isSubtree(root=TreeNode.build_tree([3, 4, 5, 1, 2]), subRoot=TreeNode.build_tree([4, 1, 2]))
