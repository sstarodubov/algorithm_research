def four_number_sum(nums: [int], target: int):
    pairs_sums = {}
    quadruplets = []

    for i in range(1, len(nums) - 1):
        for j in range(i + 1, len(nums)):
            current_sum = nums[i] + nums[j]
            diff = target - current_sum
            if diff in pairs_sums:
                for pair in pairs_sums[diff]:
                    quadruplets.append(pair + [nums[i], nums[j]])
        for k in range(0, i):
            current_sum = nums[i] + nums[k]
            if current_sum not in pairs_sums:
                pairs_sums[current_sum] = [[nums[k], nums[i]]]
            else:
                pairs_sums[current_sum].append([nums[k], nums[i]])
    return quadruplets


print(four_number_sum([7, 6, 4, -1, 1, 2], 16))
