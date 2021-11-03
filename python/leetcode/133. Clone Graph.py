class Node:
    def __init__(self, val=0, neighbors=None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []


class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        old_to_new = {}

        def dfs(cur_node: 'Node'):
            if cur_node in old_to_new:
                return old_to_new[cur_node]
            copy = Node(cur_node.val)
            old_to_new[cur_node] = copy
            for nei in cur_node.neighbors:
                copy.neighbors.append(dfs(nei))
            return copy

        return dfs(node) if node else None


n1 = Node(1)
n2 = Node(2)
n3 = Node(3)
n4 = Node(4)
n1.neighbors = [n2, n4]
n2.neighbors = [n1, n3]
n3.neighbors = [n2, n4]
n4.neighbors = [n1, n3]

node = Solution().cloneGraph(n1)
print(node)
print("Tests passed")
