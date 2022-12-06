class Node:
    def __init__(self, val: int, next=None):
        self.val = val
        self.next = next

    def __str__(self):
        return f"Node({self.val})"


def buildLinkedList(values: [int]) -> Node:
    head: Node = Node(values[0])
    cur: Node = head

    for v in range(1, len(values)):
        newNode = Node(values[v])
        cur.next = newNode
        cur = newNode

    return head
