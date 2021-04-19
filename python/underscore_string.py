# space O(n) and time O(n^2)
def underscore_string(s: str, word: str) -> str:
    buffer: [str] = []
    str_prt = s.find(word)
    end_ptr = str_prt + len(word) if str_prt != -1 else -1
    cur_ptr = 0
    while cur_ptr < len(s):
        if cur_ptr == end_ptr:
            if end_ptr != str_prt:
                buffer.append("_")
            end_ptr = str_prt + len(word) if str_prt != 1 else -1

        if cur_ptr == str_prt:
            if s.find(word, str_prt - len(word)) != str_prt - len(word):
                buffer.append("_")
            str_prt = s.find(word, cur_ptr + 1)

        buffer.append(s[cur_ptr])
        cur_ptr += 1
    return "".join(buffer)


s = "testthis is a testtest to see if testtesttest it works"
assert "_test_this is a _testtest_ to see if _testtesttest_ it works" == underscore_string(s, "test")
print("tests passed")
