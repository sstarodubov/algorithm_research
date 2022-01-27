from typing import Optional

from utils.ListNode import ListNode


class Solution:
    def removeElements(self, head: Optional[ListNode], val: int) -> Optional[ListNode]:
        dummy = ListNode()
        dummy.next = head
        prev = dummy
        cur = head
        while cur:
            if cur.val != val:
                cur = cur.next
                prev = prev.next
            else:
                prev.next = cur.next
                cur = cur.next
        return dummy.next
