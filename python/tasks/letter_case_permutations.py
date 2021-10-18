from typing import List

"""
Given a string s, we can transform every letter individually to be lowercase or uppercase to create another string.

Return a list of all possible strings we could create. You can return the output in any order.
Example 1:

Input: s = "a1b2"
Output: ["a1b2","a1B2","A1b2","A1B2"]

Example 2:

Input: s = "3z4"
Output: ["3z4","3Z4"]

Example 3:

Input: s = "12345"
Output: ["12345"]

Example 4:

Input: s = "0"
Output: ["0"]

"""


class Solution:
    def letterCasePermutation(self, s: str) -> List[str]:
        ans = [s]

        def helper(word: [str], idx: int, result: List[str]):
            for i in range(idx, len(word)):
                if word[i].isalpha():
                    if word[i].isupper():
                        word[i] = word[i].lower()
                    else:
                        word[i] = word[i].upper()
                    result.append("".join(word))
                    helper(word, i + 1, result)

                    if word[i].isupper():
                        word[i] = word[i].lower()
                    else:
                        word[i] = word[i].upper()

        helper(list(s), 0, ans)
        return ans


s = Solution()

assert s.letterCasePermutation("C") == ["c", "C"]
assert s.letterCasePermutation("a1b2") == ["a1b2", "a1B2", "A1b2", "A1B2"]
print("tests passed")
