from collections import defaultdict


class Solution:
    # the same as below but simpler
    def lengthOfLongestSubstringKDistinct(self, s, k):
        left = 0
        result = 0
        counter = defaultdict(int)

        for right in range(len(s)):
            counter[s[right]] = + 1
            while len(counter) > k:
                counter[s[left]] -= 1
                if counter[s[left]] == 0:
                    del counter[s[left]]
                left += 1

            result = max(result, right - left + 1)
        return result

s = Solution()

assert s.lengthOfLongestSubstringKDistinct(s="eceba", k=2) == 3, 1
assert s.lengthOfLongestSubstringKDistinct(s="eceba", k=3) == 4, 2
assert s.lengthOfLongestSubstringKDistinct(s="WORLD", k=4) == 4, 3
print("tests passed")
