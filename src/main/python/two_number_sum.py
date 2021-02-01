# Найти два числа в массиве numbers , сумма которых должна равнятся target_sum
numbers = [3, 5, -4, 8, 11, 1, 2, 7, -1, 6]
target_sum = 10


# O(n) space(n)
def find_second(nums, s):
    hash_table = {}
    for first in numbers:
        second = target_sum - first
        if hash_table.get(second) is not None:
            print(f"{first} + {second} = {target_sum}")
        else:
            hash_table[first] = True


# O(n Lg n) Space(1)
def find_second_v2(nums, s):
    sorted_nums = sorted(nums)
    p_left = 0
    p_right = len(sorted_nums) - 1

    def find_rec(list_in, left, right):
        if right == left:
            return None
        result = list_in[right] + list_in[left]
        if result == s:
            print(f"{list_in[right]} + {list_in[left]} = {s}")
            right = right - 1
        elif result < s: left = left + 1
        else: right = right - 1

        return find_rec(list_in, left, right)

    return find_rec(sorted_nums, p_left, p_right)
