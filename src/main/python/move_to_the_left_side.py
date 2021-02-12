"""
дан массив с числами и число n
нужно переместить все числа вправо в массиве значение которых равно n
"""
nums = [2, 1, 2, 2, 2, 3, 4, 2]
target = 2

# Time O(n) Space (n)
def move_target_to_left(numbers: [int], num: int):
    result = []
    for n in range(len(numbers) - 1, -1, -1):
        if nums[n] == num:
            result.append(nums[n])
        else: result.insert(0, nums[n])
    return result


