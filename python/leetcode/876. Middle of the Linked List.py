from typing import Optional

from utils.ListNode import ListNode


class Solution:
    def middleNode(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head:
            return None

        sl, ft = head, head.next

        while ft:
            sl = sl.next

            ft = ft.next
            if not ft:
                break

            ft = ft.next

        return sl


assert Solution().middleNode(ListNode.build([1, 2, 3, 4, 5])).val == 3
assert Solution().middleNode(ListNode.build([1, 2, 3, 4, 5, 6])).val == 4
