# time O(n) space O(n)
def nth_fibonacci(n: int, memoize: {} = {}):
    if n in memoize:
        return memoize[n]
    if n == 1:
        return 0
    if n == 2:
        return 1
    memoize[n] = nth_fibonacci(n - 1, memoize) + nth_fibonacci(n - 2, memoize)
    return memoize[n]


# time O(n^2) Space O(n)
def nth_fibonacci_stupid(n: int):
    if n == 1:
        return 0
    if n == 2:
        return 1
    return nth_fibonacci_stupid(n - 1) + nth_fibonacci_stupid(n - 2)

# time o(n) space o(1)
def nth_fibonacci_loop(n: int):
    store = (0, 1)
    if n == 0: return store[0]
    if n == 1: return store[1]
    count = 2
    while count != n:
        first = store[0]
        second = store[1]
        new_fib_number = first + second
        store = second, new_fib_number
        count += 1
    return store[1]


res = nth_fibonacci_loop(3)
print(res)
