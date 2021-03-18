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


largest_range_v1([1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6])
