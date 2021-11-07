format ELF64

public _start

; rax - 64 bit
; eax - 32 bit
; ax - 16 bit
; ah/al - 9 bit

; byte - 8 bit
; word - 16 bit
; dword - 32 bit
; qword - 64 bit

msg db "hello world!!!", 0
len = $-msg

_start:
    mov rax, 4 ; write
    mov rbx, 1 ; 1 - std out
    mov rcx, msg
    mov rdx, len
    int 0x80
    call exit
exit:
    mov rax, 1 ; 1 - exit
    mov rbx, 0 ; 0 - return
    int 0x80


