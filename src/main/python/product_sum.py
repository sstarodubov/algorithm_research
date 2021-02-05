products = [5, 2, [7, -1], 3, [6, [-13, 8], 4]]


def sum_up_products(prods: [], depth: int = 1):
    if not prods: return 0
    head, *tail = prods
    if type(head) is list:
        head_sum = sum_up_products(head, depth + 1)
        return (head_sum * depth) + sum_up_products(tail, depth)

    return (head * depth) + sum_up_products(tail, depth)


print(sum_up_products(products))
