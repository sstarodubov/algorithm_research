class MyQueue:

    def __init__(self):
        self.s = []

    def push(self, x: int) -> None:
        self.s.append(x)

    def pop(self) -> int:
        if self.empty():
            return None
        tmp = self.s[:]
        self.s.reverse()
        ans = self.s.pop()
        self.s.clear()
        for i in range(len(tmp)):
            if i == 0:
                continue
            self.s.append(tmp[i])
        return ans

    def peek(self) -> int:
        if self.empty():
            return None
        return self.s[0]

    def empty(self) -> bool:
        return len(self.s) == 0


q = MyQueue()
q.push(1)
q.push(2)
print(q.peek())
print(q.pop())
print(q.empty())
print(q.s)
