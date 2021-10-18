
# Time O(n * lg(n)) and Space O(1)
def is_word_anagram(original, word:str):
    return sorted(original) == sorted(word)

def find_group(array:[str], word:str):
    group = [word]
    removed_indexes = []
    for el_idx in range(len(array)):
        if is_word_anagram(word, array[el_idx]):
            group.append(array[el_idx])
            removed_indexes.append(el_idx)
    for idx in reversed(removed_indexes):
        del array[idx]
    return group


#  Time O(n^2 * lg(n)) and Space O(n)
def group_anagrams(array):
    result = []
    while array:
        word = array.pop()
        group = find_group(array, word)
        result.append(group)
    return result


print(group_anagrams(["yo", "act", "blop", "tac", "cat", "oy", "olbp"]))






