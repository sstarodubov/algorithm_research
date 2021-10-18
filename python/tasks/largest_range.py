# Time O(n * lg n) Space O(1)
def largest_range_v1(arr: [int]):
    arr.sort()
    start_idx = 0
    end_idx = 0
    cur_result = (0, 0)

    while end_idx < len(arr):
        if end_idx == len(arr) - 1:
            cur_ele = arr[end_idx - 1]
            next_ele = arr[end_idx]
            if cur_ele - next_ele == 1:
                new_diff = end_idx - start_idx
                cur_diff = cur_result[1] - cur_result[0]
                if new_diff > cur_diff:
                    cur_result = (start_idx, end_idx)
            break
        else:
            cur_ele = arr[end_idx]
            next_ele = arr[end_idx + 1]
            if next_ele - cur_ele != 1:
                new_diff = end_idx - start_idx
                cur_diff = cur_result[1] - cur_result[0]
                if new_diff > cur_diff:
                    cur_result = (start_idx, end_idx)
                start_idx = end_idx
            end_idx += 1
    print(cur_result)


# Time O(n) Space O(n)
def largest_range_v2(arr:[int]):
    storage = {}
    minimum = float("inf")
    maximum = float("-inf")
    for a in arr:
        minimum = min(minimum, a)
        maximum = max(maximum, a)
        storage[a] = a
    return largest_range_v2_helper(storage, minimum, minimum, (0,0), maximum)


def largest_range_v2_helper(storage:{}, start:int, end:int, cur_result:(), limit):
    if end == limit:
        return cur_result
    next_element = storage.get(end + 1)
    if next_element is not None:
        return largest_range_v2_helper(storage, start, next_element, cur_result, limit)
    cur_element = storage.get(end)
    if cur_element is None:
        return largest_range_v2_helper(storage, start, end + 1, cur_result, limit)
    old_diff = cur_result[1] - cur_result[0]
    new_diff = end - start
    if new_diff > old_diff:
        cur_result = (start, end)
    return largest_range_v2_helper(storage, cur_element, cur_element + 1, cur_result, limit)

# Time O(n) | Space O(n)
def largest_range_v3(array:[int]):
    best_range = ()
    longest_length = 0
    nums = {}
    for a in array:
        nums[a] = True

    for num in array:
        if not nums[nums]:
            continue
        nums[num] = False
        cur_length = 1
        left = num - 1
        right = num + 1
        while left in nums:
            nums[left] = False
            cur_length += 1
            left -= 1
        while right in nums:
            nums[right] = False
            cur_length += 1
            right += 1
        if cur_length > longest_length:
            longest_length = cur_length
            best_range = (left, right)
    return best_range