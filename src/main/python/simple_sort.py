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
    right_p = len(arr) - 2
    while True:
        cur_inx = 0
        swap = False
        while cur_inx <= right_p:
            if arr[cur_inx] > arr[cur_inx + 1]:
                arr[cur_inx], arr[cur_inx + 1] = arr[cur_inx + 1], arr[cur_inx]
                swap = True
            cur_inx += 1
        right_p -= 1
        if not swap: return arr


def bubble_sort2(arr: [int]):
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


print(bubble_sort2(arr))
