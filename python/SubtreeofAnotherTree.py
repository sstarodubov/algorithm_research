from collections import deque
from typing import Optional, Deque
from binarytree import build, Node

TreeNode = Node

"""
Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure
and node values of subRoot and false otherwise.

A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants.
The tree tree could also be considered as a subtree of itself.
"""


class Solution:

    # CPU O(n ^ 2) , RAM O(n)
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        def is_same_tree(n1: TreeNode, n2: TreeNode) -> bool:
            q: Deque[(TreeNode, TreeNode)] = deque([(n1, n2)])
            while q:
                cn1, cn2 = q.popleft()
                if cn1 and cn2:
                    if cn1.val != cn2.val:
                        return False
                    q.append((cn1.left, cn2.left))
                    q.append((cn1.right, cn2.right))
                elif cn1 and not cn2:
                    return False
                elif cn2 and not cn1:
                    return False

            return True

        q = deque([root])
        while q:
            cur = q.popleft()
            if cur.val == subRoot.val:
                if is_same_tree(cur, subRoot):
                    return True
            if cur.left:
                q.append(cur.left)
            if cur.right:
                q.append(cur.right)

        return False


s = Solution()

assert not s.isSubtree(build([3, 4, 5, 1, 2, None, None, None, None, 0]), build([4, 1, 2]))
assert s.isSubtree(root=build([3, 4, 5, 1, 2]), subRoot=build([4, 1, 2]))

print("tests passed")
