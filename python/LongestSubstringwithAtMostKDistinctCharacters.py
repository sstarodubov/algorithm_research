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

    # cpu O(n) and ram O(n)
    # def lengthOfLongestSubstringKDistinct(self, s, k):
    #     unique_count = 0
    #     m = {}
    #     left_bound = -1
    #     ans = 0
    #     right_bound = 0
    #     while right_bound < len(s):
    #
    #         cur_right_el = s[right_bound]
    #         cur_count = m.get(cur_right_el, 0)
    #         if cur_count <= 0:
    #             unique_count += 1
    #
    #         if cur_right_el in m:
    #             m[cur_right_el] += 1
    #         else:
    #             m[cur_right_el] = 1
    #         if unique_count > k:
    #             ans = max(ans, right_bound - left_bound - 1)
    #             while unique_count > k:
    #                 left_bound += 1
    #                 cur_left_el = s[left_bound]
    #                 m[cur_left_el] -= 1
    #                 cc = m[cur_left_el]
    #                 if cc == 0:
    #                     unique_count -= 1
    #
    #         right_bound += 1
    #     return ans


s = Solution()

assert s.lengthOfLongestSubstringKDistinct(s="eceba", k=2) == 3, 1
assert s.lengthOfLongestSubstringKDistinct(s="eceba", k=3) == 4, 2
assert s.lengthOfLongestSubstringKDistinct(s="WORLD", k=4) == 4, 3
print("tests passed")
