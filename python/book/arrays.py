from typing import List, TypeAlias


# cpu O(n) and ram O(1)
def reorder_even_first(arr: List[int]) -> None:
    def is_even(n):
        return not n & 1

    odd_ptr = 0
    while is_even(arr[odd_ptr]) and odd_ptr < len(arr):
        odd_ptr += 1

    ptr = odd_ptr + 1

    while ptr < len(arr):
        if is_even(arr[ptr]):
            arr[ptr], arr[odd_ptr] = arr[odd_ptr], arr[ptr]
            while is_even(arr[odd_ptr]) and odd_ptr < len(arr):
                odd_ptr += 1
        ptr += 1


"""
Write a program that takes an array A and an index i into A, and rearranges the elements such
that all elements less than A[i] (the "pivot") appear first, followed by elements equal to the pivot,
followed by elements greater than the pivot.
"""


# ram O(1) , cpu O(n)
def dutch_national_flag_problem(arr: List[int], pivotidx: int) -> None:
    lptr = 0
    rptr = len(arr) - 1
    pivot = arr[pivotidx]
    while lptr < rptr:
        if arr[rptr] > pivot and arr[lptr] >= pivot:
            rptr -= 1
        elif arr[lptr] >= pivot and arr[rptr] < pivot:
            arr[lptr], arr[rptr] = arr[rptr], arr[lptr]
            lptr += 1
        elif arr[lptr] > pivot:
            arr[lptr], arr[rptr] = arr[rptr], arr[lptr]
            rptr -= 1
        elif arr[rptr] > pivot:
            rptr -= 1
        elif arr[rptr] < pivot:
            arr[rptr], arr[lptr] = arr[lptr], arr[rptr]
            lptr += 1
        elif arr[lptr] < pivot:
            lptr += 1


def dutch(arr: List[int], pidx: int):
    pivot = arr[pidx]
    small_idx = 0
    for i in range(len(arr)):
        if arr[i] < pivot:
            arr[i], arr[small_idx] = arr[small_idx], arr[i]
            small_idx += 1

    great_idx = len(arr) - 1
    for i in reversed(range(len(arr))):
        if arr[i] < pivot:
            break
        elif arr[great_idx] > pivot:
            arr[great_idx], arr[i] = arr[i], arr[great_idx]
            great_idx -= 1


def dutch2(arr: List[int], pidx: int):
    pivot = arr[pidx]
    eq = 0
    sm = 0
    lg = len(arr)

    while eq < lg:
        if arr[eq] < pivot:
            arr[sm], arr[eq] = arr[eq], arr[sm]
            sm += 1
            eq += 1
        elif arr[eq] == pivot:
            eq += 1
        else:
            lg -= 1
            arr[lg], arr[eq] = arr[eq], arr[lg]


# cpu O(n) and ram O(1)
def increment_arr_as_number(arr: List[int]):
    size = len(arr)
    power = size - 1
    cur_num = 0
    for n in arr:
        cur_num += n * (10 ** power)
        power -= 1
    next_num = cur_num + 1
    remain = next_num
    idx = 0
    while remain:
        cur_num = remain % 10
        remain //= 10
        if idx < size:
            arr[idx] = cur_num
            idx += 1
        else:
            arr.append(cur_num)
    arr.reverse()


# cpu O(len(xs) * len(ys)) and ram  O(len(xs) + len(ys))
def multiply_nums(xs: List[int], ys: List[int]) -> List[int]:
    ans = [0] * (len(xs) + len(ys))
    xs.reverse()
    ys.reverse()
    start = 0
    for y in ys:
        idx = start
        for x in xs:
            ans[idx] += x * y
            ans[idx + 1] += ans[idx] // 10
            ans[idx] %= 10
            idx += 1
        start += 1
    while ans[len(ans) - 1] == 0:
        ans.pop()
    ans.reverse()
    return ans


# int_arr: TypeAlias = List[int]
# arr: int_arr = [1, 2]
# match arr:
#     case [x, y]:
#         print(x, y)
#     case _:
#         print("unknown")

# cpu O(n) and ram O(1)
def advance_step(arr: List[int]) -> bool:
    cur = 0
    while cur < len(arr) - 1:
        next_step = 0
        idx = 0
        right = cur + arr[cur] + 1 if cur + arr[cur] + 1 < len(arr) else len(arr)
        left = cur + 1 if cur + 1 < len(arr) else len(arr)
        for i in range(left, right):
            if next_step < arr[i]:
                idx = i
                next_step = arr[i]
        cur = idx
        if next_step == 0:
            return False

    return True


# cpu O(n) and ram O(n)
def delete_duplicates_from_arr(arr: List[int]) -> List[int]:
    count_dupl = 0
    ans = [arr[0]]
    for i in range(1, len(arr)):
        last = ans[len(ans) - 1]
        if last == arr[i]:
            count_dupl += 1
        else:
            ans.append(arr[i])

    while count_dupl != 0:
        count_dupl -= 1
        ans.append(0)

    return ans


# cpu O(n) and ram O(1)
def delete_duplicates_from_arr2(arr: List[int]) -> List[int]:
    prev = 0
    for cur in range(1, len(arr)):
        if arr[prev] == arr[cur]:
            arr[cur] = 0
        else:
            prev = cur

    cur_zero = 0
    while arr[cur_zero] != 0:
        cur_zero += 1
    cur_el = cur_zero
    while arr[cur_el] == 0:
        cur_el += 1

    while cur_el < len(arr):
        arr[cur_zero], arr[cur_el] = arr[cur_el], arr[cur_zero]
        while arr[cur_zero] != 0:
            cur_zero += 1
        while cur_el < len(arr) and arr[cur_el] == 0:
            cur_el += 1

    return arr


# cpu O(n) and ram O(1)
def stock_once(arr: List[int]):
    lptr, rptr, profit = 0, 1, 0
    while rptr < len(arr):
        cur_profit = arr[rptr] - arr[lptr]
        profit = max(cur_profit, profit)
        if arr[rptr] < arr[lptr]:
            lptr = rptr
        rptr += 1
    return profit


# cpu O(n log n) and ram O(n)
def stock_twice(arr: List[int]):
    lptr, rptr, profit = 0, 1, 0
    profits = []
    while rptr < len(arr):
        cur_profit = arr[rptr] - arr[lptr]
        profit = max(cur_profit, profit)
        profits.append((cur_profit, lptr))
        if arr[rptr] < arr[lptr]:
            lptr = rptr
        rptr += 1

    m = {}

    for p in profits:
        if p[1] not in m:
            m[p[1]] = p[0]
        else:
            m[p[1]] = max(m[p[1]], p[0])
    profits = list(m.values())
    profits.sort()
    f = profits.pop()
    s = profits.pop()
    return max(f, s, f + s)


# cpu O(n) and ram O(n)
def buy_and_sell_stock_twice(prices):
    max_total_profit, min_price_so_far = 0, float('inf')
    first_buy_sell_profits = [0] * len(prices)
    # Forward phase. For each day, we record maximum profit if we sell on that
    # day.
    for i, price in enumerate(prices):
        min_price_so_far = min(min_price_so_far, price)
        max_total_profit = max(max_total_profit, price - min_price_so_far)
        first_buy_sell_profits[i] = max_total_profit
    # Backward phase. For each day, find the maximum profit if we make the
    # second buy on that day.
    max_price_so_far = float('-inf')
    rev = list(enumerate(prices[1:], 1))
    for i, price in reversed(rev):
        max_price_so_far = max(max_price_so_far, price)
        max_total_profit = max(max_total_profit, max_price_so_far - price + first_buy_sell_profits[i - 1])
    return max_total_profit



