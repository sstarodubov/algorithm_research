from typing import List

"""
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the
number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

Example 2:

Input: digits = ""
Output: []

Example 3:

Input: digits = "2"
Output: ["a","b","c"]


"""


class Solution:

    #cpu O(2^n *n) and ram O(n)
    def letterCombinations(self, digits: str) -> List[str]:
        if not digits:
            return []
        result = []

        m = {
            "2": "abc",
            "3": "def",
            "4": "ghi",
            "5": "jkl",
            "6": "mno",
            "7": "pqrs",
            "8": "tuv",
            "9": "wxyz"
        }
        l = ""
        for d in digits:
            l += m[d]

        def dfs(comb, letters, cur_button_idx, start):
            if cur_button_idx >= len(digits):
                result.append("".join(comb))
                return
            if start > len(letters):
                return
            for i in range(start, len(letters)):
                cur_letter = letters[i]
                if cur_letter in m[digits[cur_button_idx]]:
                    cur_comb = "".join(comb) + cur_letter
                    if cur_comb not in result:
                        comb.append(cur_letter)
                        dfs(comb, letters, cur_button_idx + 1, i + 1)
                        comb.pop()

        dfs([], l, 0, 0)
        return result


s = Solution()

assert ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"] == s.letterCombinations("23")
