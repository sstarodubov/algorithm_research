from collections import deque


class Node:
    def __init__(self, val=0, neighbors=None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []

    def __str__(self):
        return f"Node({self.val})"


class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if not node:
            return None

        vals = {}

        def bfs(n: Node):
            vals[n.val] = Node(n.val)
            dq = deque([n])
            visited = set()

            while dq:
                cur = dq.popleft()
                if cur in visited:
                    continue
                visited.add(cur)
                for neighbor in cur.neighbors:
                    if neighbor.val not in vals:
                        vals[neighbor.val] = Node(neighbor.val)
                    new_node = vals[cur.val]
                    new_node.neighbors.append(vals[neighbor.val])
                    if neighbor not in visited:
                        dq.append(neighbor)

        bfs(node)

        return vals[node.val]


n1 = Node(1)
n2 = Node(2)
n3 = Node(3)
n4 = Node(4)

n1.neighbors = [n2, n4]
n2.neighbors = [n1, n3]
n3.neighbors = [n2, n4]
n4.neighbors = [n1, n3]

ans = Solution().cloneGraph(n1)
print(ans)
