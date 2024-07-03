from typing import Optional

from utils.ListNode import ListNode


class Solution:

    def mergeTwoLists(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        d = ListNode(-1)
        cur = d
        while l1 and l2:
            if l1.val < l2.val:
                t = l1.next
                l1.next = None
                cur.next = l1
                l1 = t
            else:
                t = l2.next
                l2.next = None
                cur.next = l2
                l2 = t
            cur = cur.next
        while l1:
            t = l1.next
            l1.next = None
            cur.next = l1
            l1 = t
            cur = cur.next
        while l2:
            t = l2.next
            l2.next = None
            cur.next = l2
            l2 = t
            cur = cur.next
        return d.next


Solution().mergeTwoLists(ListNode.build([1, 2, 4]), ListNode.build([1, 3, 4]))
