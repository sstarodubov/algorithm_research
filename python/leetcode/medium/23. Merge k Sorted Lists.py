from typing import List, Optional

from utils.ListNode import ListNode


class Solution:

    def merge(self, n1, n2):
        ptr1, ptr2 = n1, n2
        dummy = ListNode(-1)
        cur = dummy

        while ptr1 and ptr2:
            if ptr1.val < ptr2.val:
                tmp = ptr1
                ptr1 = ptr1.next
                cur.next = tmp
                cur = cur.next
                tmp.next = None
            else:
                tmp = ptr2
                ptr2 = ptr2.next
                cur.next = tmp
                cur = cur.next
                tmp.next = None

        while ptr2:
            tmp = ptr2
            ptr2 = ptr2.next
            cur.next = tmp
            cur = cur.next
            tmp.next = None

        while ptr1:
            tmp = ptr1
            ptr1 = ptr1.next
            cur.next = tmp
            cur = cur.next
            tmp.next = None

        return dummy.next

    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        if len(lists) == 0:
            return None
        if len(lists) == 1:
            return lists[0]

        md = len(lists) // 2

        ln = self.mergeKLists(lists[:md])
        rn = self.mergeKLists(lists[md:])

        return self.merge(ln, rn)


ans = Solution().mergeKLists([ListNode.build([1, 4, 5]), ListNode.build([1, 3, 4]), ListNode.build([2, 6])])
print(ans)
