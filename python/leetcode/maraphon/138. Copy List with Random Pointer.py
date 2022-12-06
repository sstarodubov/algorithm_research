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





