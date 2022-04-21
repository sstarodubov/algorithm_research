from typing import List, Optional


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        def bs(arr: List[int], start: int, end: int, trg: int) -> Optional[int]:
            lp, rp = start, end
            while lp <= rp:
                md = (lp + rp) // 2
                if arr[md] == trg:
                    return md
                elif arr[md] < trg:
                    lp = md + 1
                else:
                    rp = md - 1
            if lp > rp:
                return None
            if arr[lp] == trg:
                return lp
            if arr[rp] == trg:
                return rp
            return None

        lp, rp = 0, len(nums) - 1

        while lp <= rp:
            md = (lp + rp) // 2
            if nums[md] == target:
                return md
            elif md + 1 < len(nums) and nums[md] > nums[md + 1]:
                lr = bs(nums, 0, md, target)
                rr = bs(nums, md + 1, len(nums) - 1, target)
                if lr is not None:
                    return lr
                if rr is not None:
                    return rr
                return -1

            elif nums[md] < nums[0]:
                rp = md - 1
            else:
                lp = md + 1

        ans = bs(nums, 0, len(nums) - 1, target)
        if ans is not None:
            return ans
        return -1


assert 0 == Solution().search([1, 3, 5], 1)
assert -1 == Solution().search([1], 0)
assert -1 == Solution().search(nums=[4, 5, 6, 7, 0, 1, 2], target=3)
assert 4 == Solution().search(nums=[4, 5, 6, 7, 0, 1, 2], target=0)
