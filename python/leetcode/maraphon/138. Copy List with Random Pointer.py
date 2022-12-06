from typing import Optional

from leetcode.build_ll_from_array import Node


class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':

        cur = head
        map = {}
        while cur is not None:
            map[cur] = Node(cur.val)
            cur = cur.next

        cur = head

        while cur is not None:
            map[cur].next = None if cur.next is None else map[cur.next]
            map[cur].random = None if cur.random is None else map[cur.random]
            cur = cur.next

        return map[head]

n7 = Node(7)
n7.origin = "origin"
n13 = Node(13)
n13.origin = "origin"
n11 = Node(11)
n11.origin = "origin"
n10 = Node(10)
n10.origin = "origin"
n1 = Node(1)
n1.origin = "origin"

n7.next = n13

n13.next = n11
n13.random = n7

n11.next = n10
n11.random = n1

n10.next = n1
n10.random = n11

n1.random = n7

Solution().copyRandomList(n7)





