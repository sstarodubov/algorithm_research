from typing import Optional

from utils.ListNode import ListNode


class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode(-1)
        cur = head
        while cur:
            tmp = cur
            cur = cur.next
            nxt = dummy.next
            tmp.next = nxt
            dummy.next = tmp
        return dummy.next


Solution().reverseList(ListNode.build([1, 2, 3, 4, 5]))
