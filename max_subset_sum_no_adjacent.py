nums = [7, 10, 12, 7, 9, 14]

# Time O(n) Space O(n)
def find_max_subset_no_adjacent(numbers:[int], idx:int = 0, max_sums:[int] = []):
    if idx >= len(numbers):
        return max_sums.pop()
    if idx == 0 or idx == 1:
        max_sums.append(numbers[idx])
        idx += 1
        return find_max_subset_no_adjacent(numbers, idx, max_sums)
    maximum = max(max_sums[idx - 1], max_sums[idx - 2] + numbers[idx])
    max_sums.append(maximum)
    idx += 1
    return find_max_subset_no_adjacent(numbers, idx, max_sums)

# Time O(n) Space O(1)
def find_max_subset_no_adjacent_v2(numbers:[int]):
    max_sums = [0,0]
    for i in range(len(numbers)):
        if i == 0 or i == 1:
            max_sums[i] = numbers[i]
            continue
        cur = max_sums[1]
        prev = max_sums[0] + numbers[i]

        if cur >= prev:
            max_sums = [prev, cur]
        else:
            max_sums = [cur, prev]
    return max_sums.pop()

print(find_max_subset_no_adjacent_v2(nums))
