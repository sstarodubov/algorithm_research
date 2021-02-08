arr = [8, 5, 2, 9, 5, 6, 3]


def insertion_sort(arr: [int]) -> [int]:
    for current in range(1, len(arr)):
        prev = current - 1
        while prev >= 0 and arr[prev] > arr[current]:
            arr[current], arr[prev] = arr[prev], arr[current]
            prev -= 1
            current -= 1
    return arr


print(insertion_sort(arr))
