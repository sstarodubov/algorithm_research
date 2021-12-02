def wave(people):
    ans = []
    for i in range(len(people)):
        if people[i].isalpha():
            word = people[0:i] + people[i].upper() + people[i + 1:]
            ans.append(word)
    return ans


assert wave("hello") == ["Hello", "hEllo", "heLlo", "helLo", "hellO"]
assert wave("two words") == ["Two words", "tWo words", "twO words", "two Words", "two wOrds", "two woRds", "two worDs",
                             "two wordS"]
print("tests passed")
