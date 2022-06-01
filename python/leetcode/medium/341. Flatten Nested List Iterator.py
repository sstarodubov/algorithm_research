from collections import deque


class NestedInteger:
    def __init__(self, val=None, xs=None):
        self.val = val
        self.list = xs

    def isInteger(self) -> bool:
        return self.val is not None

    def getInteger(self) -> int:
        return self.val

    def getList(self) -> ['NestedInteger']:
        return self.list

    def __str__(self):
        if self.isInteger():
            return f"Integer{self.val}"
        return f"Nested{self.list}"


class NestedIterator:

    def flatten(self, node: [NestedInteger], rs):
        if not node:
            return

        if type(node) == list:
            head = node.pop()
            self.flatten(head, rs)
            self.flatten(node, rs)
        else:
            if node.isInteger():
                rs.append(node.getInteger())
            else:
                self.flatten(node.getList(), rs)


    def __init__(self, nestedList: [NestedInteger]):
        xs = []
        self.flatten(nestedList, xs)
        xs.reverse()
        self.dq = deque(xs)


    def next(self) -> int:
        return self.dq.popleft()


    def hasNext(self) -> bool:
        return len(self.dq) != 0


# [[1,1],2,[1,1]]
xs = [NestedInteger(xs=[NestedInteger(val=1), NestedInteger(val=1)]), NestedInteger(val=2),
      NestedInteger(xs=[NestedInteger(val=1), NestedInteger(val=1)])]

iter = NestedIterator(xs)

result = []

while iter.hasNext():
    result.append(iter.next())

print(result)
assert result == [1, 1, 2, 1, 1]
