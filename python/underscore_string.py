
# time O(n) space O(1)
def indexof(s: str, w: str, start: int = 0) -> int:
    try:
        return s.index(w, start)
    except:
        return -1

# space O(n) and time O(n^2)
def underscore_string(s: str, word: str) -> str:
    out = ""
    str_prt = s.index(word)
    end_ptr = str_prt + len(word) if str_prt != -1 else -1
    cur_ptr = 0
    while cur_ptr < len(s):
        if cur_ptr == end_ptr:
            if end_ptr != str_prt:
                out += "_"
            end_ptr = str_prt + len(word) if str_prt != 1 else -1

        if cur_ptr == str_prt:
            if indexof(s, word, str_prt - len(word)) != str_prt - len(word):
                out += "_"
            str_prt = indexof(s, word, cur_ptr + 1)

        out += s[cur_ptr]
        cur_ptr += 1
    return out


s = "testthis is a testtest to see if testtesttest it works"
assert "_test_this is a _testtest_ to see if _testtesttest_ it works" == underscore_string(s, "test")
print("tests passed")
