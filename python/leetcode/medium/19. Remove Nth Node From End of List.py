from typing import Optional

from utils.ListNode import ListNode


class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        dummy = ListNode(-1)
        dummy.next = head
        slow, fast, prev = dummy, dummy, None

        for i in range(n):
            fast = fast.next

        while fast:
            prev = slow
            slow = slow.next
            fast = fast.next
        prev.next = slow.next
        slow = None

        return dummy.next


Solution().removeNthFromEnd(ListNode.build([1, 2, 3, 4, 5]), 2)
