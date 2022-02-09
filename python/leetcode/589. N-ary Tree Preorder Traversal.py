from typing import List


class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children


class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        self.ans = []

        def dfs(node: Node):
            if not node:
                return

            self.ans.append(node.val)
            for child in node.children:
                dfs(child)
        dfs(root)
        return self.ans
