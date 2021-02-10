word: str = "abcdacba"

# Time O(n) Space O(1)
def is_palindrome(word: str) -> bool:
    left_ptr = 0
    right_ptr = len(word) - 1
    while left_ptr <= right_ptr:
        if word[left_ptr] != word[right_ptr]:
            return False
        left_ptr += 1
        right_ptr -= 1
    return True
