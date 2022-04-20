from typing import Optional

from utils.ListNode import ListNode


class Solution:
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head:
            return None
        if not head.next:
            return head
        dummy = ListNode(-1)
        dummy.next = head
        p, c, n = dummy, head, head.next

        while n:
            p.next = n
            tmp = n.next
            n.next = c
            c.next = tmp

            p = p.next.next
            if not c.next or not c.next.next:
                return dummy.next
            c = c.next.next
            n = n.next.next
            c, n = n, c

        return dummy.next


xn = Solution().swapPairs(ListNode.build([1, 2, 3, 4, 5]))
print(xn)
