from typing import Optional

from utils.ListNode import ListNode


class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        visited = set()
        cur = headA
        while cur:
            visited.add(cur)
            cur = cur.next
        cr: ListNode = headB
        while cr:
            if cr in visited:
                return cr
            cr = cr.next

        return None

