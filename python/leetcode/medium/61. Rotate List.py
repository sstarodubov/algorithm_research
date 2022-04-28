from typing import Optional

from utils.ListNode import ListNode


class Solution:
    def rotateRight(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if not head:
            return head
        cur = head
        L = 0
        while cur:
            cur = cur.next
            L += 1
        k = k % L

        def find_end(node: ListNode):
            prev, cur = None, node
            while cur.next:
                prev = cur
                cur = cur.next
            return prev, cur

        dummy = ListNode(-1)
        dummy.next = head

        for i in range(k):
            pe, e = find_end(dummy.next)
            pe.next = None
            e.next = dummy.next
            dummy.next = e

        return dummy.next

Solution().rotateRight(head = ListNode.build([0,1,2]), k = 4)
Solution().rotateRight(head=ListNode.build([1, 2, 3, 4, 5]), k=2)