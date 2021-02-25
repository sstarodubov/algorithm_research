
#Space O(1) Time O(n)
def kadene_algorithm(nums: [int]) -> int:
    max_subset_sum = 0
    cur_sum = 0
    for idx in range(len(nums)):
        if idx != 0:
            if nums[idx] + cur_sum > nums[idx]:cur_sum += nums[idx]
            else: cur_sum = nums[idx]
        else: cur_sum += nums[idx]
        if max_subset_sum < cur_sum: max_subset_sum = cur_sum
    return max_subset_sum


print(kadene_algorithm([3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4]))
