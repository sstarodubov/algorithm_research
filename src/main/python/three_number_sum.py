nums = [12, 3, 1, 2, -6, 5, -8, 6]
target = 0


def find_three_sum(arr: [int], goal: int, window: [int] = [0, 1], result=[]):
    if window[0] > len(arr) - 1:
        return result
    first_inx = window[0]
    second_inx = window[1]
    window_great_goal = arr[first_inx] > goal and arr[second_inx] > goal
    window_less_goal = arr[first_inx] < goal and arr[second_inx] < goal
    ptr = second_inx
    while ptr != first_inx:
        if window_great_goal and arr[ptr] > goal:
            ptr += 1
            if ptr > len(arr) - 1: ptr = 0
            continue
        if window_less_goal and arr[ptr] < goal:
            ptr += 1
            if ptr > len(arr) - 1: ptr = 0
            continue
        if arr[first_inx] + arr[second_inx] + arr[ptr] == goal:
            result.append((arr[first_inx], arr[second_inx], arr[ptr]))
        ptr += 1
        if ptr > len(arr) - 1: ptr = 0

    window[0] += 1
    window[1] += 1
    if window[1] > len(arr) - 1:
        window[1] = 0

    return find_three_sum(arr, goal, window, result)


print(find_three_sum(nums, target))
