import heapq

def sum_two_smallest_numbers(numbers):
    heapq.heapify(numbers)
    return heapq.heappop(numbers) + heapq.heappop(numbers)


assert sum_two_smallest_numbers([19, 5, 42, 2, 77]) == 7
assert sum_two_smallest_numbers([10, 343445353, 3453445, 3453545353453]) == 3453455
print("tests passed")