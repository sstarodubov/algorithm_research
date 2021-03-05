"""
найти два числа в массиве разница между которыми минимальна
"""
num1 = [-1, 5, 10, 20, 28, 3]
num2 = [26, 134, 135, 11, 15, 17]


# Time O(n^2) space O(1)
def brutal_force_closest(arr: [int], lst: [int]):
    pair = [1000000000, 0]
    right_arr_ptr = 0
    for a in arr:
        for n in lst:
            if abs(a - n) < abs(pair[0] - pair[1]):
                pair[0] = a
                pair[1] = n
    return pair


# Time O(n log (n) + m log (m)) space O(1)
def more_smart_closest(lst1: [int], lst2: [int]):
    lst1.sort()
    lst2.sort()
    left = 0
    right = 0
    largest_number = float("inf")
    result = [largest_number, 0]
    while left < len(lst1) and right < len(lst2):
        cur_diff = abs(result[0] - result[1])
        new_diff = abs(lst1[left] - lst2[right])
        if new_diff < cur_diff:
            result[0] = lst1[left]
            result[1] = lst2[right]

        if lst1[left] == lst2[right]:
            return [lst1[left], lst2[right]]
        if lst2[right] > lst1[left]:
            if left < len(lst1):
                left += 1
        else:
            right += 1
            if right <= len(lst2):
                right += 1
    return result


print(more_smart_closest(num1, num2))
