from typing import Optional

from neetcode_all_course.leetcode import TreeNode
from utils.ListNode import ListNode


class Solution:
    def sortedListToBST(self, head: Optional[ListNode]) -> Optional[TreeNode]:
        if not head:
            return None

        def find_center(xn: ListNode):
            dummy, slow, fast = ListNode(-1), xn, xn
            dummy.next = xn
            prev = dummy
            while fast and fast.next:
                prev = prev.next
                slow = slow.next
                if not fast.next:
                    break
                fast = fast.next.next
            prev.next = None
            tmp = slow.next
            slow.next = None

            return dummy.next, slow, tmp

        def divide_and_concur(node: ListNode) -> Optional[TreeNode]:
            if not node:
                return None
            xl, xc, xr = find_center(node)
            tn = TreeNode(xc.val)
            tn.left = divide_and_concur(xl)
            tn.right = divide_and_concur(xr)
            return tn

        return divide_and_concur(head)


xn = Solution().sortedListToBST(ListNode.build([0, 1, 2, 3, 4, 5, 6, 7]))
print(xn)
