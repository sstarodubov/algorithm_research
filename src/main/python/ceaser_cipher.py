

word = "xyz"
key = 2

# Time O(n) Space O(n)
# a = 97 z = 122
def caesar_cipher(word: str, key: int) :
    new_letters = []
    new_key = key % 26
    for letter in word:
        new_letters.append(get_new_letter(letter, new_key))
    return new_letters

def get_new_letter(letter, key):
    new_letter_code = ord(letter) + key
    return chr(new_letter_code) if new_letter_code <= 122 else chr(96 + new_letter_code % 122)

print(caesar_cipher(word, key))