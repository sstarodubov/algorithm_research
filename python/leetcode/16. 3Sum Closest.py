from typing import List


class Solution:

    def threeSumClosest(self, nums: List[int], target: int) -> int:
        nums.sort()
        ans = float("inf")
        diff = None
        for i, a in enumerate(nums):
            if i > 0 and a == nums[i - 1]:
                continue

            l, r = i + 1, len(nums) - 1

            while l < r:
                cur_sum = a + nums[l] + nums[r]
                if cur_sum > target:
                    r -= 1
                elif cur_sum < target:
                    l += 1
                else:
                    return cur_sum

                if diff is None:
                    diff = abs(target - cur_sum)
                    ans = cur_sum
                else:
                    if abs(target - cur_sum) < diff:
                        diff = abs(target - cur_sum)
                        ans = cur_sum

        return ans


assert Solution().threeSumClosest([1, 1, -1, -1, 3], 3) == 3
assert Solution().threeSumClosest(nums=[0, 0, 0], target=1) == 0
assert Solution().threeSumClosest([1, 1, 1, 0], -100) == 2
assert Solution().threeSumClosest(nums=[-1, 2, 1, -4], target=1) == 2
assert Solution().threeSumClosest([1, 1, -1, -1, 3], -1) == -1
