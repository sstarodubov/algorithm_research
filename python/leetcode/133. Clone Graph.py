class Node:
    def __init__(self, val=0, neighbors=None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []


class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':

        def dfs(cur_node: 'Node', adj_graph, visited: set[int]):
            if not cur_node:
                return adj_graph
            adj_graph[cur_node.val] = []
            visited.add(cur_node.val)
            children = cur_node.neighbors
            for child in children:
                adj_graph[cur_node.val].append(child.val)
                if child.val in visited:
                    continue
                dfs(child, adj_graph, visited)
            return adj_graph

        graph = dfs(node, {}, set())
        graph_nodes = {key: Node(key) for key in graph.keys()}
        ans = None
        for key in graph.keys():
            empty_node: Node = graph_nodes[key]
            if not ans:
                ans = empty_node
            for kk in graph[key]:
                empty_node.neighbors.append(graph_nodes[kk])

        return ans


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
