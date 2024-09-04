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


def inverse_2x2_matrix(mtx):
    det = (mtx[0][0] * mtx[1][1]) - (mtx[0][1] * mtx[1][0])
    adj = [
        [mtx[1][1], -mtx[0][1]],
        [-mtx[1][0], mtx[0][0]]
    ]
    ret = [
        [mtx[1][1], -mtx[0][1]],
        [-mtx[1][0], mtx[0][0]]
    ]
    for i in range(2):
        for j in range(2):
            adj[i][j] = f"{adj[i][j]}/{det}"
            ret[i][j] = ret[i][j] * (1/ det)

    return adj, ret


print(inverse_2x2_matrix([
    [1.5, 2.5],
    [1, 2]
]))
