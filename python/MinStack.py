class MinStack:

    def __init__(self):
        self.arr = []
        self.min = float("inf")

    def push(self, val: int) -> None:
        self.min = min(self.min, val)
        self.arr.append(val)

    def pop(self) -> None:
        self.arr.pop()
        if self.arr:
            self.min = min(self.arr)
        else:
            self.min = float("inf")

    def top(self) -> int:
        return self.arr[len(self.arr) - 1]

    def getMin(self) -> int:
        return self.min

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()