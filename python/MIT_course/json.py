from collections import deque
from typing import List, Deque, Dict

json_data = {
    "hello": {
        "world": "hoho",
        "w1": 123,
        "123": [12, 3]
    },
    "!!": 1,
    "some": {
        "text": {
            "for": "you"
        }
    }
}


def exists(json, val) -> bool:
    match json:
        case {}:
            children = list(json.keys())
            for child in children:
                if exists(json[child], val):
                    return True
            return False

        case _:
            return json == val


assert exists(json_data, 1)
assert exists(json_data, 123)
assert exists(json_data, "hoho")
assert exists(json_data, [12, 3])
assert exists(json_data, "you")
assert not exists(json_data, "h1")
print("tests passed")


def bfs(json) -> None:
    dq: Deque[str] = deque([])
    for f in json.keys():
        dq.append((f, json))

    while dq:
        cur_field, cur_json = dq.popleft()

        print(cur_field)

        children = cur_json[cur_field]
        if type(children) != dict:
            continue

        for child in children:
            dq.append((child, cur_json[cur_field]))
