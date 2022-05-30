from collections import deque
from typing import Optional

from utils.ListNode import ListNode


class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        dq = deque()
        cur = head
        while cur:
            dq.append(cur)
            prev = cur
            cur = cur.next
            prev.next = None

        dummy = ListNode(-1)
        prev = dummy
        begin = 1
        while dq:

            if begin:
                node = dq.popleft()
                begin = 0
            else:
                node = dq.pop()
                begin = 1

            prev.next = node
            prev = prev.next




xs = ListNode.build([1, 2, 3, 4, 5])
Solution().reorderList(xs)

print(xs)
