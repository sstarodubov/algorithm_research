from typing import Optional

from utils.ListNode import ListNode


class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode(-1)
        dummy.next = head

        prev, cur = dummy, head

        while cur:
            if prev.val != cur.val:
                cur = cur.next
                prev = prev.next
            else:
                tmp = cur.next
                cur.next = None
                prev.next = tmp
                cur = tmp

        return dummy.next


Solution().deleteDuplicates(ListNode.build([1, 1, 2, 3, 3]))
