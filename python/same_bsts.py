
bst1 = [10, 15, 8, 12,94, 81, 5, 2, 11]
bst2 = [10, 8, 5, 15, 2, 12, 11, 94, 81]


def same_bsts(bst_a:[int], bst_b:[int]):
    if not bst_a and not bst_b:
        return True

    if not bst_a or not bst_b:
        return False

    if len(bst_a) == 1 and len(bst_b) == 1:
        return bst_a[0] == bst_b[0]

    if len(bst_a) != len(bst_b):
        return False

    head_a, *tail_a = bst_a
    head_b, *tail_b = bst_b

    if head_a != head_b:
        return False

    new_bst_right_a = []
    new_bst_left_a = []

    new_bst_right_b = []
    new_bst_left_b = []

    for a in tail_a:
        if a >= head_a:
            new_bst_right_a.append(a)
        else:
            new_bst_left_a.append(a)

    for a in tail_b:
        if a >= head_b:
            new_bst_right_b.append(a)
        else:
            new_bst_left_b.append(a)

    return same_bsts(new_bst_left_a, new_bst_left_b) and same_bsts(new_bst_right_a, new_bst_right_b)

print(same_bsts(bst1, bst2))