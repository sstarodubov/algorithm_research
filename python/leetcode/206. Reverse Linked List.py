from typing import Optional

from utils.ListNode import ListNode


class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode()
        cur = head
        tmp: ListNode = None
        while cur:
            tmp = cur.next
            cur.next = dummy.next
            dummy.next = cur
            cur = tmp

        return dummy.next


ans = Solution().reverseList(ListNode.build([5, 4, 3, 2, 1]))
print(ans)
