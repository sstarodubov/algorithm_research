denominations = [1, 5, 10, 25]
target_amount = 10


def find_ways_to_make_change(denam: [int], amount: int):
    ways = [0 for x in range(amount + 1)]
    ways[0] = 1
    for coin in denam:
        for i in range(len(ways)):
            if i >= coin:
                ways[i] += ways[i - coin]
    return ways.pop()


print(find_ways_to_make_change(denominations, target_amount))
