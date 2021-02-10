import string

word = "xyz"
key = 2

alphabet = {}
for i in range(len(string.ascii_lowercase)):
    alphabet[string.ascii_lowercase[i]] = i

alpha_list = string.ascii_lowercase
# Time O(n) Space O(n)
def caesar_cipher(word: str, key: int) -> str:
    result = ""
    for n in word:
        cur_inx = alphabet.get(n)
        new_inx = cur_inx + key
        if new_inx > 25:
            new_inx %= len(alpha_list)
        new_letter = alpha_list[new_inx]
        result += new_letter
    return result

def caesar_cipher2(word: str, key: int) :
    new_letters = []
    new_key = key % 26
    for letter in word:
        new_letters.append(get_new_letter(letter, new_key))
    return new_letters

def get_new_letter(letter, key):
    new_letter_code = ord(letter) + key
    return chr(new_letter_code) if new_letter_code <= 122 else chr(96 + new_letter_code % 122)

print(caesar_cipher2(word, key))