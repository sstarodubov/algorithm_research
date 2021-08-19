from collections import deque
from typing import Deque, Optional

from binarytree import build, Node

TreeNode = Node

"""

Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q 
as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

"""


class Solution:

    # CPU O(n) ram O(n)
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        def bfs(node: TreeNode):
            nonlocal p, q
            mp = {}
            dq: Deque[(TreeNode, int, Optional[TreeNode])] = deque([(node, 0, None)])
            while dq:
                cur, d, parent = dq.popleft()
                mp[cur.val] = (d, parent)
                lc = cur.left
                rc = cur.right
                if lc: dq.append((lc, d + 1, cur))
                if rc: dq.append((rc, d + 1, cur))
            return mp

        graph = bfs(root)
        cur_ancestor_q = q
        cur_ancestor_p = p
        if graph[cur_ancestor_p.val][0] > graph[cur_ancestor_q.val][0]:
            while graph[cur_ancestor_p.val][0] != graph[cur_ancestor_q.val][0]:
                cur_ancestor_p = graph[cur_ancestor_p.val][1]
        elif graph[cur_ancestor_p.val][0] < graph[cur_ancestor_q.val][0]:
            while graph[cur_ancestor_q.val][0] != graph[cur_ancestor_p.val][0]:
                cur_ancestor_q = graph[cur_ancestor_q.val][1]

        while cur_ancestor_p.val != cur_ancestor_q.val:
            cur_ancestor_p = graph[cur_ancestor_p.val][1]
            cur_ancestor_q = graph[cur_ancestor_q.val][1]
        return cur_ancestor_p


s = Solution()

assert 2 == (
    s.lowestCommonAncestor(root=build([6, 2, 8, 0, 4, 7, 9, None, None, 3, 5]), p=TreeNode(2), q=TreeNode(4))).val

assert 6 == (
    s.lowestCommonAncestor(root=build([6, 2, 8, 0, 4, 7, 9, None, None, 3, 5]), p=TreeNode(5), q=TreeNode(9))).val

assert 6 == (
    s.lowestCommonAncestor(root=build([6, 2, 8, 0, 4, 7, 9, None, None, 3, 5]), p=TreeNode(2), q=TreeNode(9))).val

assert 2 == (
    s.lowestCommonAncestor(root=build([6, 2, 8, 0, 4, 7, 9, None, None, 3, 5]), p=TreeNode(0), q=TreeNode(4))).val, "1"

print("tests passed")
