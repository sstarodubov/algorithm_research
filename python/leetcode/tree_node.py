from collections import deque
from typing import List

def _print(node, p):
    if not node:
        print(f"{('|' * p)}{'$'}")
    else:
        print(f"{('|' * p)}{node.val}:")
        _print(node.left, p + 1)
        _print(node.right,p + 1)

class TreeNode:
    def __init__(self, val: int = 0, left: 'TreeNode' = None, right: 'TreeNode' = None):
        self.val = val
        self.left: 'TreeNode' = left
        self.right: 'TreeNode' = right

    def print(self):
        _print(self, 0)

    def __eq__(self, other):
        return self.val == other.val

    @staticmethod
    def build_tree(nums: List[int]) -> 'TreeNode':
        if not nums:
            raise Exception("len nums is 0")
        p = 0
        q = deque()
        root = TreeNode(nums[0])
        q.append(root)
        while q:
            cur: 'TreeNode' = q.popleft()
            if not cur:
                raise Exception("cur is null")

            if cur.left is None:
                p += 1
                if p >= len(nums):
                    return root
                if nums[p] is not None:
                    node = TreeNode(nums[p])
                    cur.left = node
                    q.append(node)

            if cur.right is None:
                p += 1
                if p >= len(nums):
                    return root
                if nums[p] is not None:
                    node = TreeNode(nums[p])
                    cur.right = node
                    q.append(node)
        return root
