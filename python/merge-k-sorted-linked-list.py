# Definition for singly-linked list.
from typing import List


class ListNode:
    def __init__(self, val=None, next=None):
        self.val = val
        self.next = next

    def __str__(self):
        return f"Node({self.val})"

    def __cmp__(self, other):
        return 1 if self.val > other.sum else -1


n1 = ListNode(1)
n2 = ListNode(4)
n3 = ListNode(5)

n1.next = n2
n2.next = n3


l1 = ListNode(1)
l2 = ListNode(3)
l3 = ListNode(4)
l1.next = l2
l2.next = l3

p1 = ListNode(2)
p2 = ListNode(6)
p1.next = p2

lists = [n1, l1, p1]
print(lists)


class Solution:

    # Time O (n * lg n) and Space O (n)
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        if not lists:
            return ListNode()
        # Space O(l1 + l2) and Time (l1 + l2)
        def merge(l1:ListNode, l2:ListNode) -> ListNode:
            ptr1 = l1
            ptr2 = l2
            hd = ListNode(l1.val) if l1.val < l2.val else ListNode(l2.val)
            if hd.val == l1.val: ptr1 = l1.next
            else: ptr2 = l2.next
            cur = hd
            while ptr1 is not None or ptr2 is not None:
                if ptr1 is not None and ptr2 is not None:
                    if ptr1.val < ptr2.val:
                        cur.next = ListNode(ptr1.val)
                        ptr1 = ptr1.next
                        cur = cur.next
                    else:
                        cur.next = ListNode(ptr2.val)
                        ptr2 = ptr2.next
                        cur = cur.next
                elif ptr1 is None:
                    cur.next = ListNode(ptr2.val)
                    ptr2 = ptr2.next
                    cur = cur.next
                elif ptr2 is None:
                    cur.next = ListNode(ptr1.val)
                    ptr1 = ptr1.next
                    cur = cur.next
            return hd

        def mergeListsHelper(lists, start, end):
            if not lists:
                return ListNode()
            if end <= start:
                return lists[end]

            middle = (start + end) // 2
            l = mergeListsHelper(lists, start, middle)
            r = mergeListsHelper(lists, middle + 1, end)
            return merge(l, r)

        return mergeListsHelper(lists, 0, len(lists) -1)

s = Solution()


