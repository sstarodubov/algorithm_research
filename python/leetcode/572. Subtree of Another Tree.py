from collections import deque
from typing import Optional

from leetcode.tree_node import TreeNode


class Solution:
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        self.ans = False

        def is_same(n1: TreeNode, n2: TreeNode):
            if n1 != n2:
                return False
            d1 = deque([])
            d2 = deque([])
            d1.append(n1)
            d2.append(n2)

            while d1 and d2:
                x1 = d1.popleft()
                x2 = d2.popleft()


                if x1 and x2:
                    if x1.val != x2.val:
                        return False
                    d1.append(x1.left)
                    d1.append(x1.right)
                    d2.append(x2.left)
                    d2.append(x2.right)

                elif not x1 and not x2:
                    continue
                else:
                    return False

            return len(d2) == len(d1)

        def dfs(node: TreeNode):
            if self.ans:
                return
            if not node:
                return

            r = is_same(node, subRoot)

            if r:
                self.ans = True
                return
            dfs(node.left)
            dfs(node.right)

        dfs(root)

        return self.ans
