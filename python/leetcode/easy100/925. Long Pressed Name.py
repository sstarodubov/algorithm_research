class Solution:
    def isLongPressedName(self, name: str, typed: str) -> bool:
        name_ptr, typed_ptr = 0, 0

        while name_ptr < len(name) and typed_ptr < len(typed):
            if name[name_ptr] == typed[typed_ptr]:
                name_ptr += 1
                typed_ptr += 1
            else:
                if name_ptr == 0:
                    return False
                if name[name_ptr - 1] == typed[typed_ptr]:
                    typed_ptr += 1
                else:
                    return False


        if name_ptr == len(name):
           while typed_ptr < len(typed) and typed[typed_ptr] == name[name_ptr - 1]:
               typed_ptr += 1

        if len(name) == name_ptr and len(typed) == typed_ptr:
            return True
        return False