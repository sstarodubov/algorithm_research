from typing import List



class Solution:


    def uniq(self, arr:str):
        self.buf.clear()
        for s in arr:
            for ch in s:
                if ch in self.buf:
                    return -1
                else:
                    self.buf.add(ch)
        return len(self.buf)


    def maxLength(self, arr: List[str]) -> int:
        self.buf = set()
        self.arr = arr
        self.ret = 0
        self.backtrack([], 0)
        return self.ret

    def backtrack(self, comb, idx):
        if idx > len(self.arr):
            return
        self.ret = max(self.ret, self.uniq(comb))

        for i in range(idx, len(self.arr)):
            comb.append(self.arr[i])

            self.backtrack(comb, i + 1)
            comb.pop()


print(Solution().maxLength(arr = ["un","iq","ue"]))