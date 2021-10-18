input = [8, 4, 2, 1, 3, 6, 7, 9, 5]



# Time O(n) and Space O(n)
def min_rewards(scores: [int]):
    rewards = [0 for a in scores]
    min_val = float("inf")
    min_idx: int = 0
    for i in range(len(scores)):
        if scores[i] < min_val:
            min_idx = i
            min_val = scores[i]

    rewards[min_idx] = 1

    # go right
    cur_idx = min_idx + 1
    prev_idx = min_idx
    while cur_idx < len(scores):
        cur_el = scores[cur_idx]
        prev_el = scores[prev_idx]
        if cur_el > prev_el:
            rewards[cur_idx] = rewards[prev_idx] + 1
        else:
            rewards[cur_idx] = 1
        cur_idx += 1
        prev_idx += 1

    # go left

    cur_idx = min_idx - 1
    next_idx = min_idx

    while cur_idx >= 0:
        cur_el = scores[cur_idx]
        next_el = scores[next_idx]
        if cur_el > next_el:
            rewards[cur_idx] = rewards[next_idx] + 1
        else:
            rewards[cur_idx] = 1
        cur_idx -= 1
        next_idx -= 1

    print(rewards)
    return sum(rewards)



# Time O(n) and Space O(n)
def min_rewards_2(scores: [int]):
    rewards = [1 for a in scores]

    prev_idx, cur_idx = 0, 1
    while cur_idx < len(scores):
        cur_el = scores[cur_idx]
        prev_el = scores[prev_idx]
        if cur_el > prev_el:
            rewards[cur_idx] = rewards[prev_idx] + 1
        cur_idx += 1
        prev_idx += 1
    cur_idx, prev_idx = len(scores) - 2, len(scores) - 1
    while cur_idx >= 0:
        cur_el = scores[cur_idx]
        prev_el = scores[prev_idx]
        if cur_el > prev_el:
            if rewards[cur_idx] <= rewards[prev_idx]:
                rewards[cur_idx] = rewards[prev_idx] + 1
        cur_idx -= 1
        prev_idx -= 1
    print(rewards)

min_rewards_2(input)
