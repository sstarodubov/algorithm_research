arr = [-1, -1, -10, -1100, -1100, -1101, -1102, -9001]
increasing_arr = [1, 1, 3, 4, 5, 6, 7, 8]
another = [1, 1, 1, 1, 1, 1]


# time O(n) space O(1)
def is_monotonic(ar: [int]):
    global decreasing
    global left, right

    if ar[0] == ar[1]:
        left = 0
        right = 1
        while ar[left] == ar[right]:
            left += 1
            right += 1
            if right == len(ar): return False
        decreasing = ar[left] > ar[right]
    else:
        decreasing = ar[0] > ar[1]
        left = 0
        right = 1

    if decreasing:
        while right < len(ar):
            if ar[left] < ar[right]:
                return False
            left += 1
            right += 1
        return True
    else:
        while right < len(ar):
            if ar[left] > ar[right]:
                return False
            left += 1
            right += 1
        return True


print(is_monotonic(arr))
