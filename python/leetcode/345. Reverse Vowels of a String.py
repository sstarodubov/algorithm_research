class Solution:
    def reverseVowels(self, s: str) -> str:
        arr = list(s)
        vowels = set(["e", "u", "i", "o", "a", "o"])
        if len(arr) == 1:
            return s
        l, r = 0, len(arr) - 1
        while l < r:
            while r >= 0 and arr[r].lower() not in vowels:
                r -= 1
            while l < len(arr) and arr[l].lower() not in vowels:
                l += 1
            if l >= r:
                return "".join(arr)

            if arr[r].lower() in vowels and arr[l].lower() in vowels:
                arr[l], arr[r] = arr[r], arr[l]
            r -= 1
            l += 1

        return "".join(arr)


assert "Aa" == Solution().reverseVowels("aA")
assert ".," == Solution().reverseVowels(".,")
assert " " == Solution().reverseVowels(" ")
assert "holle" == Solution().reverseVowels("hello")
assert Solution().reverseVowels("leetcode") == "leotcede"
