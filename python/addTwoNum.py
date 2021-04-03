# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

    def __str__(self):
        return f"Node({self.val})"


class Solution:

    #Space O(n) Time O(n)
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        arr1 = []
        cur_node = l1
        while cur_node is not None:
            arr1.insert(0, cur_node.val)
            cur_node = cur_node.next

        cur_node = l2
        arr2 = []
        while cur_node is not None:
            arr2.insert(0, cur_node.val)
            cur_node = cur_node.next

        a1 = int("".join(str(a) for a in arr1))
        a2 = int("".join(str(a) for a in arr2))
        r = str(a1 + a2)
        out = ListNode(int(r[-1]))
        cur_node = out
        for i in reversed(range((len(r) - 1))):
            new_node = ListNode(int(r[i]))
            cur_node.next = new_node
            cur_node = new_node

        return out


l12 = ListNode(2)
l14 = ListNode(4)
l13 = ListNode(3)

l12.next = l14
l14.next = l13

l25 = ListNode(5)
l26 = ListNode(6)
l24 = ListNode(4)

l25.next = l26
l26.next = l24

sol = Solution()
sol.addTwoNumbers(l12, l25)
