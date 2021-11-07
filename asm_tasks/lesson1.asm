format ELF64

public _start

; rax - 64 bit
; eax - 32 bit
; ax - 16 bit
; ah/al - 9 bit

_start:
    call exit
exit:
    mov rax, 1
    mov rbx, 0
    int 0x80


