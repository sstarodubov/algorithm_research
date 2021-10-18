# time O(n ^ 2) Space O(1)
def min_number_jumps(array: [int]):
    cur_idx = 0
    bound_idx = cur_idx + array[cur_idx]
    max_idx_val = 0
    jumps_count = 0
    while cur_idx < len(array):
        if cur_idx > bound_idx:
            cur_idx = max_idx_val
            jumps_count += 1
            bound_idx = cur_idx + array[cur_idx]
            max_idx_val += 1
            cur_idx += 1
        else:
            if array[max_idx_val] < array[cur_idx]:
                max_idx_val = cur_idx
            cur_idx += 1

    jumps_count += 1
    return jumps_count


# space O(n) and time O (n ^2)
def min_number_jumps_dp(array: [int]):
    jumps = [float("inf") for x in array]
    jumps[0] = 0
    for i in range(1, len(array)):
        for j in range(0, i):
            if array[j] + j >= i:
                jumps[i] = min(jumps[j] + 1, jumps[i])
    return jumps[-1]

#Space O(1) and Time O(n)
def min_number_of_jumps(array:[int]):
    if len(array) == 1:
        return 0
    jumps = 0
    max_reach = array[0]
    steps = array[0]
    for i in range(1, len(array) - 1):
        max_reach = max(max_reach, i + array[i])
        steps -= 1
        if steps == 0:
            jumps += 1
            steps = max_reach - i
    return jumps + 1

print(min_number_of_jumps([3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 3]))
