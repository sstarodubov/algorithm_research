from typing import List, Counter as C

"""
Given a string s, partition s such that every substring of the partition is a palindrome. 
Return all possible palindrome partitioning of s.

A palindrome string is a string that reads the same backward as forward.

Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]

Example 2:

Input: s = "a"
Output: [["a"]]
"""


class Solution:
    # cpu O(n ^2) and ram O(n)
    def partition(self, s: str) -> List[List[str]]:
        def is_palindrome(word: str) -> bool:
            left_ptr = 0
            right_ptr = len(word) - 1
            while left_ptr <= right_ptr:
                if word[left_ptr] != word[right_ptr]:
                    return False
                left_ptr += 1
                right_ptr -= 1
            return True

        result = []

        def helper(comb: List[str] = [], start=0):
            if start >= len(s):
                result.append(comb[:])
                return
            for end in range(start, len(s)):
                cur = s[start:end + 1]
                if is_palindrome(cur):
                    comb.append(cur)
                    helper(comb, end + 1)
                    comb.pop()

        helper()
        return result


s = Solution()
assert s.partition("aab") == [["a", "a", "b"], ["aa", "b"]]
print("tests passed")
