
def is_pangram(s):
    st = set()
    for letter in s:
        if letter.isalpha():
            st.add(letter.lower())
    return len(st) == 26


assert is_pangram("ABCD45EFGH,IJK,LMNOPQR56STUVW3XYZ")
assert is_pangram("The quick brown fox jumps over the lazy dog")

print("tests passed")
