from typing import Optional

from utils.ListNode import ListNode


class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head:
            return head
        dummy = ListNode(-101)
        dummy.next = head

        uniq, back, front = dummy, head, head.next

        while front:
            if back.val != front.val:
                uniq = uniq.next
                back = back.next
                front = front.next
            else:
                cv = front.val
                while front.next and front.next.val == cv:
                    front = front.next
                tmp = front.next
                if not tmp:
                    uniq.next = None
                    return dummy.next
                else:
                    front.next = None
                    uniq.next = tmp
                    front = tmp.next
                    back = tmp

        return dummy.next


Solution().deleteDuplicates(ListNode.build([0, 0,0, 1, 2, 3, 3, 3, 4, 5, 5, 5]))
