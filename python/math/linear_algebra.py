def add_vectors(a, b):
    result = []

    for i in range(len(a)):
        result[i] = a[i] + b[i]

    return result


def subtract_vectors(a, b):
    result = []

    for i in range(len(a)):
        result[i] = a[i] - b[i]

    return result


def multiply_vector_by_scalar(v, s):
    result = []

    for i in range(len(v)):
        result[i] = v[i] * s

    return result
