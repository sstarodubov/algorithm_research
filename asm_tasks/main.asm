%include "stud_io.inc"
global _start

section .data
stext db "hello world"

section .text
_start:
    mov eax , 11
    call print_word
    FINISH

print_word:
    PUSH ecx
    PUSH eax
    xor ecx, ecx

cycle:
    PUTCHAR [stext + ecx]
    inc ecx
    cmp ecx , eax
    jl cycle

    POP eax
    POP ecx
    ret
