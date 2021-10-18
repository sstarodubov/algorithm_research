# bit operations

n - number

1. get last bit -> num & 1
2. erase last 1s bit -> (num - 1) & num. (100100 - 1) & 100100 = 100000
3. extract last set of 1s bit -> n &\~(n - 1). 10010 &~ (10010 - 1) = 10
4. get bit by idx -> (n << idx) & 1

# combinatorics

1. amount of combinations: ((n-1) * (n)) / 2
