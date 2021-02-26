# Space O(1) Time O(n)
def kadene_algorithm(nums: [int]) -> int:
    max_subset_sum = nums[0]
    cur_sum = nums[0]
    for idx in range(1, len(nums)):
        if nums[idx] + cur_sum > nums[idx]:
            cur_sum += nums[idx]
        else:
            cur_sum = nums[idx]
        if max_subset_sum < cur_sum: max_subset_sum = cur_sum
    return max_subset_sum
