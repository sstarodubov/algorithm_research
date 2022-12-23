from typing import Optional

from utils.ListNode import ListNode


class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:

        d = ListNode(-1)
        d.next = head
        p, k = d, head

        while n != 0:
            k = k.next
            n -= 1

        while k:
            k = k.next
            p = p.next

        r = p.next
        p.next = r.next
        r.next = None
        return d.next


Solution().removeNthFromEnd(head=ListNode.build([1, 2, 3, 4, 5]), n=5)
