def is_palindrome(word: str, left_ptr, right_ptr) -> bool:
    while left_ptr <= right_ptr:
        if word[left_ptr] != word[right_ptr]:
            return False
        left_ptr += 1
        right_ptr -= 1
    return True


# time O(n^2) space O(n)
def longest_palindrome_substring(word: str):
    left_ptr = 0
    right_ptr = len(word) - 1
    max_length = 0
    longest_substring: str
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


# =========================================
# Space O(1) and Time O(n^2)
def longestPolyndromSubstring(string):
    cur_longest = [0, 1]
    for i in range(1, len(string)):
        odd = getLongestPalindromeFrom(string, i - 1, i + 1)
        even = getLongestPalindromeFrom(string, i - 1, i)
        longest = max(odd, even, key=lambda x: x[1] - x[0])
        cur_longest = max(longest, cur_longest, key=lambda x: x[1] - x[0])
    return string[cur_longest[0]: cur_longest[1]]


def getLongestPalindromeFrom(string, left, right):
    while left >= 0 and right < len(string):
        if string[left] != string[right]:
            break
        left -= 1
        right += 1
    return [left + 1, right]