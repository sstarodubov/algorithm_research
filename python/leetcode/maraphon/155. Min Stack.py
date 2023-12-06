class MinStack:

    def __init__(self):
        self.stack = []
        self.xs = []

    def push(self, val: int) -> None:
        if not self.xs:
            self.xs.append(val)
        else:
            top = self.xs[-1]
            self.xs.append(min(top, val))
        self.stack.append(val)

    def pop(self) -> None:
        self.xs.pop()
        self.stack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.xs[-1]
