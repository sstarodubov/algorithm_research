
"""
Дан массив состоящий из числе и других вложенных массивов
нужн посчитать сумму элемтнов, умножая сумму массива на его глубину, например
[2, [1,2, [1,2,3]]] = 2 * 1 + (1 + 2 + (1 + 2 + 3) * 3) * 2
"""
products = [5, 2, [7, -1], 3, [6, [-13, 8], 4]]


# time O(n) where n is amount of all elements in all arrays
# space O(n) where n is max depth
def sum_up_products(prods: [], depth: int = 1):
    if not prods: return 0
    head, *tail = prods
    if type(head) is list:
        head_sum = sum_up_products(head, depth + 1)
        return (head_sum * depth) + sum_up_products(tail, depth)

    return (head * depth) + sum_up_products(tail, depth)

#
# print(sum_up_products(products))


def product_sum(prods: [], depth: int = 1):
    sum = 0
    for element in prods:
        if type(element) is list:
            sum += product_sum(element, depth + 1)
        else:
            sum += element
    return sum * depth

print(product_sum(products))
