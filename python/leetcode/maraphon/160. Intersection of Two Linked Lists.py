from typing import Optional

from utils.ListNode import ListNode


class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        s = set()
        cur = headA
        while cur:
            s.add(cur)
            cur = cur.next

        cur = headB
        while cur:
            if cur in s:
                return cur
            cur = cur.next

        return cur

Solution().getIntersectionNode(ListNode.build([]))