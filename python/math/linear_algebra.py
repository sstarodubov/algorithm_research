def add_vectors(a, b):
    result = []

    for i in range(len(a)):
        result.append(a[i] + b[i])

    return result


def subtract_vectors(a, b):
    result = []

    for i in range(len(a)):
        result.append(a[i] - b[i])

    return result


def multiply_vector_by_scalar(v, s):
    result = []

    for i in range(len(v)):
        result.append(v[i] * s)

    return result


print(multiply_vector_by_scalar([-3, 1], -3))