# space O(n) time O(n)
def find_min_number_of_coins(amount: int, coins: [int]):
    coin_denam_ptr = len(coins) - 1
    used_coins = []
    rest_of_money = amount
    while rest_of_money != 0:
        cur_used_coin = coins[coin_denam_ptr]
        if rest_of_money >= cur_used_coin:
            change = rest_of_money % cur_used_coin
            used_sum = rest_of_money - change
            amount_of_coin = int(used_sum / cur_used_coin)
            used_coins.append((cur_used_coin, amount_of_coin))
            rest_of_money = change
        else:
            coin_denam_ptr -= 1
    return used_coins


# dynamic programming

def find_min_amount_of_coin(amount: int, coin_denams: [int]):
    coins_amount = [float("inf") for x in range(amount + 1)]
    coins_amount[0] = 0
    for denam in coin_denams:
        for cur_sum in range(len(coins_amount)):
            if denam <= cur_sum:
                rest_sum = cur_sum - denam
                coins_amount[cur_sum] = min(1 + coins_amount[rest_sum], coins_amount[cur_sum])

    return coins_amount.pop()
