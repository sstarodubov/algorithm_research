# space O(1) and time O(n)
def quick_select(array: [int], k: int) -> int:
    position = k - 1
    return quick_select_helper(array, 0, len(array) - 1, position)


def quick_select_helper(array: [int], start_idx: int, end_idx: int, position: int) -> int:
    while True:
        if start_idx > end_idx:
            raise Exception("some gets wrong")
        pivot_idx = start_idx
        left_idx = start_idx + 1
        right_idx = end_idx
        while left_idx <= right_idx:
            if array[left_idx] > array[pivot_idx] and array[right_idx] < array[pivot_idx]:
                array[left_idx], array[right_idx] = array[right_idx], array[left_idx]
            if array[left_idx] <= array[pivot_idx]:
                left_idx += 1
            if array[right_idx] >= array[pivot_idx]:
                right_idx -= 1
        array[pivot_idx], array[right_idx] = array[right_idx], array[pivot_idx]
        if right_idx == position:
            return array[right_idx]
        elif right_idx < position:
            start_idx = right_idx + 1
        else:
            end_idx = right_idx - 1

assert 5 == quick_select([8, 5, 2, 9, 7, 6, 3], 3), "3"
assert 2 == quick_select([8, 5, 2, 9, 7, 6, 3], 1), "2"
assert 6 == quick_select([8, 5, 2, 9, 7, 6, 3], 4), "6"
assert 9 == quick_select([8, 5, 2, 9, 7, 6, 3], 7), "9"

print("tests passed")