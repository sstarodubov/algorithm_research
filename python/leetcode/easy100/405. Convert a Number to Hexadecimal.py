class Solution:
    def toHex(self, num: int) -> str:
        hm = [ "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" ]

        if num < 0:
            num = abs(num)
            num = ~num
            num += 1

        arr, count = [], 0
        while count < 8:
            last = num & 15
            arr += hm[last % 16]
            num = num >> 4
            count += 1

        arr.reverse()

        for i in range(len(arr)):
            if arr[i] != '0':
                return "".join(arr[i:])

        return "0"


print(Solution().toHex(-2))