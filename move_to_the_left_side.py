"""
дан массив с числами и число n
нужно переместить все числа вправо в массиве значение которых равно n
"""
nums = [2, 1, 2,  2, 2, 3, 4, 2]
target = 2


# Time O(n) Space (n) with order
def move_target_to_left(numbers: [int], num: int):
    result = []
    for n in range(len(numbers) - 1, -1, -1):
        if nums[n] == num:
            result.append(nums[n])
        else:
            result.insert(0, nums[n])
    return result


# Time O(n) Space O(1)
def move_without_order(numbers: [int], num: int):
    left_ptr = 0
    right_ptr = len(numbers) - 1
    while left_ptr < right_ptr:
        while left_ptr < right_ptr and numbers[right_ptr] == num:
            right_ptr -= 1
        if numbers[left_ptr] == num:
            numbers[left_ptr], numbers[right_ptr] = numbers[right_ptr], numbers[left_ptr]
        left_ptr += 1
    return numbers


