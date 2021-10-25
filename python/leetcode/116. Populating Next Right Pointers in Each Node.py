from collections import deque
from typing import List, Optional


class Node:
    def __init__(self, val, left: 'Node' = None, right: 'Node' = None):
        self.val = val
        self.left: 'Node' = left
        self.right: 'Node' = right
        self.next: Optional['Node'] = None

    def __str__(self):
        return f"Node({self.val})"

    @staticmethod
    def build_tree(nums: List[int]) -> 'Node':
        if not nums:
            raise Exception("len nums is 0")
        p = 0
        q = deque()
        root = Node(nums[0])
        q.append(root)
        while q:
            cur: 'Node' = q.popleft()
            if not cur:
                raise Exception("cur is null")

            if cur.left is None:
                p += 1
                if p >= len(nums):
                    return root
                if nums[p] is not None:
                    node = Node(nums[p])
                    cur.left = node
                    q.append(node)

            if cur.right is None:
                p += 1
                if p >= len(nums):
                    return root
                if nums[p] is not None:
                    node = Node(nums[p])
                    cur.right = node
                    q.append(node)
        return root


class Solution:
    # cpu O(n) and ram O(n)
    def connect(self, root: 'Node') -> 'Node':
        q = deque()
        q.append(root)
        rows = {root: 0}
        nodes = {0: [root]}

        while q:
            cur_node: Node = q.popleft()
            left_child = cur_node.left
            right_child = cur_node.right
            depth = rows[cur_node] + 1
            node_list = nodes.get(depth, [])
            if left_child:
                q.append(left_child)
                rows[left_child] = depth
                left_child.next = right_child
                if depth in nodes:
                    prev_hor_node = nodes[depth][len(nodes[depth]) - 1]
                    prev_hor_node.next = left_child
                node_list.append(left_child)
                nodes[depth] = node_list
            if right_child:
                q.append(right_child)
                rows[right_child] = depth
                node_list.append(right_child)
                nodes[depth] = node_list
        return root


node = Solution().connect(Node.build_tree([1, 2, 3, 4, 5, 6, 7]))
print(node)
