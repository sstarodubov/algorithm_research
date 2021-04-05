class Node:

    def __init__(self, val:int):
        self.val = val
        self.next = None

    def __str__(self):
        return f"Node({self.val})"



n1 = Node(1)
n2 = Node(2)
n3 = Node(3)
n4 = Node(4)
n5 = Node(5)
n6 = Node(6)
n7 = Node(7)
n8 = Node(8)
n9 = Node(9)

n1.next = n2
n2.next = n3
n3.next = n4
n4.next = n5
n5.next = n6
n6.next = n7
n7.next = n8
n8.next = n9
n9.next = n4


# Time O(n^2) and Space O(1)
def find_loop(head:Node):
    count = 1
    n = 2
    target = head.next
    cur = head

    while True:
        while count != n or target is not None:
            if n == count and cur == target:
                target = cur.next
                cur = head
                count = 1
                n += 1
            elif target is None:
                return None
            elif cur == target:
                return cur
            else:
                cur = cur.next
                count += 1


print(find_loop(n1))
