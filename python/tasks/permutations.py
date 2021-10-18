def swap(arr, i, y):
    arr[i], arr[y] = arr[y], arr[i]


# =======================================
# time O (n^2 * n!) Space O(n * n!)
def get_permutations(array):
    permutations = []
    permutations_helper(array, [], permutations)
    return permutations


def permutations_helper(array: [], current_permutation: [], permutations: []):
    if not len(array) and len(current_permutation):
        permutations.append(current_permutation)
    else:
        for i in range(len(array)):
            new_array = array[:i] + array[i + 1:]
            new_permutation = current_permutation + [array[i]]
            permutations_helper(new_array, new_permutation, permutations)

###########################################
# time O (n * n!) Space O(n * n!)
def find_permutations(array):
    permutations = []
    permutations_helper_finder(0, array, permutations)
    return permutations


def permutations_helper_finder(i, array, permutations):
    if i == len(array) - 1:
        permutations.append(array[:])
    else:
        for j in range(i, len(array)):
            swap(array, i, j)
            permutations_helper_finder(i + 1, array, permutations)
            swap(array, j, i)


# =====================================

print(find_permutations([1, 2, 3]))
