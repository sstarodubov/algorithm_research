class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children


class Solution:
    def maxDepth(self, root: 'Node') -> int:
        if not root:
            return 0
        self.ans = float("-inf")

        def dfs(node: Node, depth: int):
            if not node:
                return

            if not node.children:
                self.ans = max(self.ans, depth)
                return

            for child in node.children:
                dfs(child, depth + 1)

        dfs(root, 1)
        return self.ans


n1 = Node(1)
n2 = Node(2)
n3 = Node(3)
n4 = Node(4)
n5 = Node(5)
n6 = Node(6)

n1.children = [n2, n3, n4]
n3.children = [n5, n6]

assert 3 == Solution().maxDepth(n1)
