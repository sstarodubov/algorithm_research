import math

heap = [8, 12, 23, 17, 31, 30, 44, 102, 18]


def parent_node_idx(i):
    return math.floor((i - 1) / 2)


def child_left_idx(i):
    return (2 * i) + 1


def child_right_idx(i):
    return (2 * i) + 2

def sift_up(heap, i):
    parent_idx = parent_node_idx(i)
    heap[parent_idx], heap[i] = heap[i], heap[parent_idx]

def insert(heap: [int], el: int) -> [int]:
    heap.append(el)
    cur_el_idx = len(heap) - 1
    parent_idx = parent_node_idx(cur_el_idx)
    while heap[cur_el_idx] <= heap[parent_idx]:
        sift_up(heap, cur_el_idx)
        cur_el_idx = parent_idx
        parent_idx = parent_node_idx(cur_el_idx)
    print(heap)


insert(heap, 9)


"""
I'd like to discuss Jim Carry playing in a film called by Truman's show.
Honestly It was usual Jim Carry. There was a lot of facial expressions, childish behavior and 
funny jokes during all films. I think everybody agrees these are main features of Jim Carry playing.
But also we could see in this film something new in his playing. He was playing as drama actor also.
He expressed disappointment when his personage found out about the show. 

Also we could notice how quickly Jim could change emotions for short time. Just now he is crying, after 10 seconds
he is laughing as if there wasn't tears before        


"""


