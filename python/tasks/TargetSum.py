from typing import List

"""
You are given an integer array nums and an integer target.

You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and
then concatenate all the integers.

For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate 
them to build the expression "+2-1".

Return the number of different expressions that you can build, which evaluates to target.


Example 1:

Input: nums = [1,1,1,1,1], target = 3
Output: 5
Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3
"""


class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        memo = {}

        def helper(sum, idx, ans, depth):

            if idx == len(nums):
                if sum == target:
                    return 1
                else:
                    return 0
            else:
                cur_num = nums[idx]
                if depth in memo:
                    if sum in memo[depth]:
                        return memo[depth][sum]
                pr = helper(sum + cur_num, idx + 1, ans, depth + 1)
                lr = helper(sum - cur_num, idx + 1, ans, depth + 1)
                if idx not in memo:
                    memo[depth] = {sum: lr + pr}
                else:
                    memo[depth][sum] = lr + pr
                return memo[idx][sum]

        a = helper(0, 0, 0, 0)
        return a


s = Solution()
assert s.findTargetSumWays([1, 1, 1, 1, 1], 3) == 5
assert s.findTargetSumWays(nums=[1], target=1) == 1
assert 5756 == s.findTargetSumWays([7, 46, 36, 49, 5, 34, 25, 39, 41, 38, 49, 47, 17, 11, 1, 41, 7, 16, 23, 13], 3)

print("tests passed")
