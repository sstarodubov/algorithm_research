#include <stdio.h>
#include <assert.h>
#include <stdbool.h>
#include <stdlib.h>

#define HEAP_CAP 64000
#define CHUNK_LIST_CAP 1024 

// 1.23.56
typedef struct {
    void* start;
    size_t size;
} Chunk;

typedef struct {
    size_t count;
    Chunk chunks[CHUNK_LIST_CAP];
} Chunk_List;

Chunk_List alloced_chunks = {0};
Chunk_List freed_chunks = {0};

Chunk heap_freed[CHUNK_LIST_CAP] = {0};
Chunk heap_alloced[] = {0};

char heap[HEAP_CAP] = {0};
size_t heap_size = 0;

int compare(const void* a, const void* b) {
    const Chunk* a_chunk = a;
    const Chunk* b_chunk = b;
    return a_chunk->start - b_chunk->start;
}

int chunk_list_find(const Chunk_List* list, void* ptr) {
    Chunk key = {
        .start = ptr
    };
    Chunk* result = bsearch(&key, list->chunks,list->count, sizeof(list->chunks[0]), compare);
    if (result != NULL) {
        assert(list->chunks <= result);
        return result - list->chunks;
    } else {
        return -1;
    }
}

void chunk_list_remove(Chunk_List* list, size_t idx) {
    assert(idx < list->count);
    for (size_t i = idx; i < list->count - 1; ++i) {
        list->chunks[i] = list->chunks[i + 1];
    }

    list->count -= 1;
}

void chunk_list_insert(Chunk_List *list, void* ptr, int size) {
    assert(list->count < CHUNK_LIST_CAP);
    const int idx = list->count;
    list->chunks[idx].start = ptr;
    list->chunks[idx].size = size;
    for (size_t i = list->count - 1; i > 0 && list->chunks[i].start < list->chunks[i - 1].start; --i) {
        Chunk t = list->chunks[i];
        list->chunks[i] = list->chunks[i - 1];
        list->chunks[i - 1] = t;
    }

    list->count += 1;
}

void chunk_list_dump(const Chunk_List* list) {
    printf("dump chunks: (%zu)\n", list->count);
    for (int i = 0; i < list->count; i++) {
        printf("idx: %d   start: %p, size: %zu\n",
             i, list->chunks[i].start, list->chunks[i].size);
    }
}

void* heap_alloc(size_t size) {
    if (size <=0 ) {
        return NULL;
    }

    assert(heap_size + size <= HEAP_CAP);
    void* ptr = heap + heap_size;
    heap_size += size;

    chunk_list_insert(&alloced_chunks, ptr, size);
    return ptr;
}

void heap_free(void* ptr) {
    const int idx = chunk_list_find(&alloced_chunks, ptr);
    assert(idx >= 0);
    chunk_list_insert(&freed_chunks, alloced_chunks.chunks[idx].start, alloced_chunks.chunks[idx].size);
    chunk_list_remove(&alloced_chunks, (size_t) idx);
}

int main() {
    char *root = heap_alloc(25);
    char *root2 = heap_alloc(30);
    char *root3 = heap_alloc(55);

    heap_free(root);
    chunk_list_dump(&alloced_chunks);
    chunk_list_dump(&freed_chunks);
    return 0;
}