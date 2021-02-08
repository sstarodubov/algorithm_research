arr = [8, 5, 2, 9, 5, 6, 3]


# time O(n^2) space O(1)
def insertion_sort(arr: [int]) -> [int]:
    for current in range(1, len(arr)):
        prev = current - 1
        while prev >= 0 and arr[prev] > arr[current]:
            arr[current], arr[prev] = arr[prev], arr[current]
            prev -= 1
            current -= 1
    return arr


def bubble_sort(arr: [int]):
    sorted = False
    count = 0
    while not sorted:
        sorted = True
        for n in range(len(arr) - 1 - count):
            if arr[n] > arr[n + 1]:
                arr[n], arr[n + 1] = arr[n + 1], arr[n]
                sorted = False
        count += 1
    return arr


def selection_sort(arr: [int]):
    left_ptr = 0
    while left_ptr < len(arr) - 1:
        smallest_idx = left_ptr
        for i in range(left_ptr, len(arr)):
            if arr[i] < arr[smallest_idx]:
                smallest_idx = i
        arr[smallest_idx], arr[left_ptr] = arr[left_ptr], arr[smallest_idx]
        left_ptr += 1
    return arr

print(selection_sort(arr))
