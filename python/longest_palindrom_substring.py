def is_palindrome(word: str, left_ptr, right_ptr) -> bool:
    while left_ptr <= right_ptr:
        if word[left_ptr] != word[right_ptr]:
            return False
        left_ptr += 1
        right_ptr -= 1
    return True

# time O(n^2) space O(1)
def longest_palindrome_substring(word: str):
    left_ptr = 0
    right_ptr = len(word) - 1
    max_length = 0
    longest_substring:str
    while left_ptr < len(word):
        palindrome = is_palindrome(word, left_ptr, right_ptr)
        if not palindrome:
            right_ptr -= 1
            if left_ptr == right_ptr:
                left_ptr += 1
                right_ptr = len(word) - 1
        else:
            diff = right_ptr - left_ptr
            if diff > max_length:
                max_length = max(diff, max_length)
                longest_substring = word[left_ptr:(right_ptr + 1)]
            left_ptr += 1
            right_ptr = len(word) - 1
    return longest_substring

print(longest_palindrome_substring("abaxyzzyxb"))