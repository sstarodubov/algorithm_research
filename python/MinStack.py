class MinStack:

    def __init__(self):
        self.arr = []
        self.min = []

    def push(self, val: int) -> None:
        if not self.min:
            self.min.append(val)
        else:
            self.min.append(min(self.min[len(self.min) - 1], val))
        self.arr.append(val)

    def pop(self) -> None:
        self.min.pop()
        self.arr.pop()

    def top(self) -> int:
        return self.arr[len(self.arr) - 1]

    def getMin(self) -> int:
        return self.min[len(self.min) - 1]

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
