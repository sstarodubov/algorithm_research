#include <stdio.h>
#include <assert.h>
#include <stdbool.h>
#include <stdlib.h>
#include <stdint.h>
#define HEAP_CAP 64000
#define CHUNK_LIST_CAP 1024 
//38.46
typedef struct {
    uintptr_t* start;
    size_t size;
} Chunk;

typedef struct {
    size_t count;
    Chunk chunks[CHUNK_LIST_CAP];
} Chunk_List;

uintptr_t heap[HEAP_CAP] = {0};

Chunk_List alloced_chunks = {0};
Chunk_List freed_chunks = {
    .count = 1,
    .chunks = {
       [0] = { .size = sizeof(heap), .start = heap }
    }    
};
Chunk_List tmp_chunks = {0};

int compare(const void* a, const void* b) {
    const Chunk* a_chunk = a;
    const Chunk* b_chunk = b;
    return a_chunk->start - b_chunk->start;
}

int chunk_list_find(const Chunk_List* list, uintptr_t* ptr) {
    for (size_t i = 0; i < list->count; ++i) {
        if (list->chunks[i].start == ptr) {
            return (int) i;
        }
    }

    return -1;
}

void chunk_list_remove(Chunk_List* list, size_t index) {
    assert(index < list->count);
    for (size_t i = index; i < list->count - 1; ++i) {
        list->chunks[i] = list->chunks[i + 1];
    }
    list->count -= 1;
}

void chunk_list_insert(Chunk_List *list, void* ptr, int size) {
    assert(list->count < CHUNK_LIST_CAP);
    list->chunks[list->count].start = ptr;
    list->chunks[list->count].size  = size;

    for (size_t i = list->count;
            i > 0 && list->chunks[i].start < list->chunks[i - 1].start;
            --i) {
        const Chunk t = list->chunks[i];
        list->chunks[i] = list->chunks[i - 1];
        list->chunks[i - 1] = t;
    }

    list->count += 1;
}

void chunk_list_dump(const Chunk_List* list) {
    printf("dump chunks: (%zu)\n", list->count);
    for (int i = 0; i < list->count; i++) {
        printf("idx: %d   start: %p, size: %zu\n",
             i, list->chunks[i].start, list->chunks[i].size * sizeof(uintptr_t));
    }
}

void chunk_list_merge(Chunk_List* dst, Chunk_List* src) {
    dst->count = 0;
    for (size_t i = 0; i < src->count; ++i) {
        const Chunk chunk = src->chunks[i];

        if (dst->count > 0) {
            Chunk *top_chunk = &dst->chunks[dst->count - 1];

            if (top_chunk->start + top_chunk->size == chunk.start) {
                top_chunk->size += chunk.size;
            } else {
                chunk_list_insert(dst, chunk.start, chunk.size);
            }
        } else {
            chunk_list_insert(dst, chunk.start, chunk.size);
        }
    }
}


void* heap_alloc(size_t size_bytes) {
    size_t size = (size_bytes + sizeof(uintptr_t) - 1) /sizeof(uintptr_t);
    if (size <= 0) {
        return NULL;
    }
    chunk_list_merge(&tmp_chunks, &freed_chunks);
    freed_chunks = tmp_chunks;
    for (size_t i = 0; i < freed_chunks.count; i++) {
        const Chunk chunk = freed_chunks.chunks[i];
        if (chunk.size >= size ) {
            chunk_list_remove(&freed_chunks,i);
            void* const  ptr = chunk.start;
            const size_t tail_size = chunk.size - size;
            chunk_list_insert(&alloced_chunks, chunk.start, size);
            if (tail_size > 0) {
                chunk_list_insert(&freed_chunks, chunk.start + size, tail_size);
            } 
            return ptr;
        }
    }

    return NULL;
}

void heap_free(void* ptr) {
    if (ptr != NULL) {
        const int index = chunk_list_find(&alloced_chunks, ptr);
        assert(index >= 0);
        assert(ptr == alloced_chunks.chunks[index].start);
        chunk_list_insert(&freed_chunks,
                          alloced_chunks.chunks[index].start,
                          alloced_chunks.chunks[index].size);
        chunk_list_remove(&alloced_chunks, (size_t) index);
    }
}

int main() {
    char *root = heap_alloc(1);
    char *root2 = heap_alloc(2);
    char *root3 = heap_alloc(3);
    heap_free(root);
    heap_free(root2);
    heap_free(root3);
    
    char* p = heap_alloc(9);
    chunk_list_dump(&alloced_chunks);
    chunk_list_dump(&freed_chunks);
    return 0;
}