from typing import List

"""
Given a characters array letters that is sorted in non-decreasing order and a character target, return the smallest 
character in the array that is larger than target.
Note that the letters wrap around.
For example, if target == 'z' and letters == ['a', 'b'], the answer is 'a'.
"""


class Solution:

    # cpu O(log n) and ram O(1)
    def nextGreatestLetter(self, letters: List[str], target: str) -> str:
        left = 0
        right = len(letters) - 1
        while left <= right:
            middle = (left + right) // 2
            if ord(letters[middle]) <= ord(target):
                left = middle + 1
            else:
                right = middle - 1
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
