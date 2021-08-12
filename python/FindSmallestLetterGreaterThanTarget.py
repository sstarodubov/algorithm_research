from typing import List


class Solution:

    # cpu O(log n) and ram O(1)
    def nextGreatestLetter(self, letters: List[str], target: str) -> str:
        left = 0
        right = len(letters) - 1

        while left <= right:
            m = (left + right) // 2
            if ord(letters[m]) == ord(target):
                idx = m
                while idx < len(letters) and letters[idx] == letters[m]:
                    idx += 1
                if idx >= len(letters) - 1:
                    if idx < len(letters) and ord(target) < ord(letters[idx]):
                        return letters[idx]
                    if ord(target) == ord(letters[idx - 1]):
                        return letters[0]
                    else:
                        return letters[0]
                return letters[idx]
            elif ord(letters[m]) > ord(target):
                right = m - 1
            elif ord(letters[m]) < ord(target):
                left = m + 1
        if left >= len(letters):
            return letters[0]
        return letters[left]


s = Solution()

assert s.nextGreatestLetter(letters=["c", "f", "j"], target="j") == "c", "((("
assert s.nextGreatestLetter(["e", "e", "e", "k", "q", "q", "q", "v", "v", "y"], "v") == "y", "001"
assert s.nextGreatestLetter(letters=["c", "f", "j"], target="c") == "f", "?"
assert s.nextGreatestLetter(["e", "e", "e", "e", "e", "e", "n", "n", "n", "n"], "e") == "n", "01"
assert s.nextGreatestLetter(["c", "f", "j"], "k") == "c", "00"
assert s.nextGreatestLetter(letters=["c", "f", "j"], target="a") == "c", "!"
assert s.nextGreatestLetter(letters=["c", "f", "j"], target="d") == "f", "*"
assert s.nextGreatestLetter(letters=["c", "f", "j"], target="g") == "j", "("

print("tests passed")
