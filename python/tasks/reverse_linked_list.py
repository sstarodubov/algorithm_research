class Node:
    def __init__(self, val):
        self.val = val
        self.next = None

    def __str__(self):
        return f"Node({self.val})"

n1 = Node(1)
n2 = Node(2)
n3 = Node(3)
n4 = Node(4)
n5 = Node(5)

n1.next = n2
n2.next = n3
n3.next = n4
n4.next = n5

# Time O(n) and Space O(1)
def reverse_linked_list(node: Node):
        buffer = [None, node, node.next]

        while buffer[2] is not None:
            child = buffer[0]
            parent = buffer[1]
            parent.next = child

            buffer[0], buffer[1] = buffer[1], buffer[0]
            buffer[1] = buffer[2]
            buffer[2] = buffer[2].next

        buffer[1].next = buffer[0]
        return buffer[1]


r = reverse_linked_list(n1)
print(r)