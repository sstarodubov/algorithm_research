#include <stdio.h>
#include <assert.h>
#include <stdbool.h>

#define HEAP_CAP 64000
#define HEAP_ALLOCED_CAP 1024 

// 33.59
typedef struct {
    void* start;
    size_t size;
} Heap_chunk;


Heap_chunk heap_alloced[] = {0};
char heap[HEAP_CAP] = {0};

size_t heap_size = 0;
size_t heap_alloced_size = 0;
void* heap_alloc(size_t size) {
    if (size <=0 ) {
        return NULL;
    }

    assert(heap_size + size <= HEAP_CAP);
    void* result = heap + heap_size;
    heap_size += size;
    assert(heap_alloced_size < HEAP_ALLOCED_CAP);
    const Heap_chunk chunk = {
        .start = result,
        .size = size
    };

    heap_alloced[heap_alloced_size++] = chunk;
    return result;
}

void heap_free(void* ptr) {

}

void heap_dump_alloced_chunks(void) {
    printf("Alloced chunks: (%zu)\n", heap_alloced_size);
    for (int i = 0; i < heap_alloced_size; i++) {
        printf("   start: %p, size: %zu\n", heap_alloced[i].start, heap_alloced[i].size);
    }
}

int main() {
    char *root = heap_alloc(25);
    char *root2 = heap_alloc(30);

    heap_dump_alloced_chunks();
    heap_free(root);
    return 0;
}