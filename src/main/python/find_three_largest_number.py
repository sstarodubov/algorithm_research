"""
Дан массив чисел
найти три наибольших числа и вывести их в отсортированном массиве
"""

input_arr = [141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7]

# time O(n) space O(1)
def find_three_largest_numbers(numbers: [int]) -> (int, int, int):
    three_largest = [0, 0, 0]
    for n in numbers:
        if n > three_largest[0]:
            three_largest[2] = three_largest[1]
            three_largest[1] = three_largest[0]
            three_largest[0] = n
            continue
        if n > three_largest[1]:
            three_largest[2] = three_largest[1]
            three_largest[1] = n
            continue
        if n > three_largest[2]:
            three_largest[2] = n
    return three_largest

print(find_three_largest_numbers(input_arr))