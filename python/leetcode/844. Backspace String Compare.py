class Solution:
    def backspaceCompare(self, s: str, t: str) -> bool:
        ss, st = [], []
        for letter in s:
            if letter == "#":
                if ss:
                    ss.pop()
            else:
                ss.append(letter)
        for letter in t:
            if letter == "#":
                if st:
                    st.pop()
            else:
                st.append(letter)
        return ss == st


assert Solution().backspaceCompare(s="ab#c", t="ad#c")
