def namelist(names):
    ans = ""
    size = len(names)
    if size == 1:
        return names[0]["name"]
    for idx, table in enumerate(names):
        if idx == size - 1:
            ans += "& " + table["name"]
        elif idx == size - 2:
            ans += f"{table['name']} "
        else:
            ans += f"{table['name']}, "
    return ans


assert namelist([{'name': 'Bart'}, {'name': 'Lisa'}, {'name': 'Maggie'}]) == 'Bart, Lisa & Maggie'
assert namelist([{'name': 'Bart'}, {'name': 'Lisa'}]) == 'Bart & Lisa'
assert namelist([{'name': 'Bart'}]) == 'Bart'
assert namelist([]) == ""

print("tests passed")
