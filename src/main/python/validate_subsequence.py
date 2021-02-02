# Проверить является ли need_validate_sub
# валидной последовательностью init_sub

init_sub = [5, 1, 22, 25, 6, -1, 8, 10]
need_validate_sub = [1, 6, -1, 10]


def is_valid_sub(source_sub, valid_sub):
    pointer = 0
    for num in source_sub:
        if valid_sub[pointer] == num:
            pointer = pointer + 1
        if pointer == len(valid_sub):
            return True

    return False


def is_valid_sub_rec(source_sub, valid_sub, pointer=0):
    if pointer == len(valid_sub):
        return True
    if not source_sub:
        return False
    head, *tail = source_sub
    if head == valid_sub[pointer]:
        pointer = pointer + 1
    return is_valid_sub_rec(tail, valid_sub, pointer)
