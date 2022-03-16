class Solution:
    def reverseOnlyLetters(self, s: str) -> str:
        arr = list(s)
        l, r = 0, len(arr) - 1
        while l < r:

            while not arr[l].isalpha():
                l += 1
                if l >= len(arr):
                    return "".join(arr)
            while not arr[r].isalpha():
                r -= 1
                if r < 0:
                    return "".join(arr)
            if l >= r:
                break
            arr[l], arr[r] = arr[r], arr[l]
            r -= 1
            l += 1
        return "".join(arr)


assert Solution().reverseOnlyLetters("?6C40E") == "?6E40C"
assert Solution().reverseOnlyLetters("7_28]") == "7_28]"
assert Solution().reverseOnlyLetters("a-bC-dEf-ghIj") == "j-Ih-gfE-dCba"
