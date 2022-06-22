from collections import deque


class Solution:
    def connect(self, root):
        if not root:
            return None
        dq = deque([(0, root)])
        arr = []

        while dq:
            t = dq.popleft()
            arr.append(t)
            d, n = t
            if n.left:
                dq.append((d + 1, n.left))
            if n.right:
                dq.append((d + 1, n.right))

        for i in range(1, len(arr)):
            prev = arr[i - 1]
            cur = arr[i]

            if prev[0] == cur[0]:
                prev[1].next = cur[1]

        return root

