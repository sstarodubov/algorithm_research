format ELF64 executable


hello:
    file "text.txt"

hello_len = $-hello
i: dq 0



print:
    mov     r9, -3689348814741910323
    sub     rsp, 40
    mov     BYTE [rsp+31], 10
    lea     rcx, [rsp+30]
.L2:
    mov     rax, rdi
    lea     r8, [rsp+32]
    mul     r9
    mov     rax, rdi
    sub     r8, rcx
    shr     rdx, 3
    lea     rsi, [rdx+rdx*4]
    add     rsi, rsi
    sub     rax, rsi
    add     eax, 48
    mov     BYTE [rcx], al
    mov     rax, rdi
    mov     rdi, rdx
    mov     rdx, rcx
    sub     rcx, 1
    cmp     rax, 9
    ja      .L2
    lea     rax, [rsp+32]
    mov     edi, 1
    sub     rdx, rax
    xor     eax, eax
    lea     rsi, [rsp+32+rdx]
    mov     rdx, r8
    mov     rax, 1
    syscall
    add     rsp, 40
    ret


macro for i, low, upper {
    mov QWORD [i], low 
.#i#_again:
    cmp QWORD [i], upper 
    jge .#i#_over
}

macro endfor i {
    inc QWORD [i]
    jmp .#i#_again
.#i#_over:
}

entry _start

_start:
;;    int3
    for i, 0, 5 
        mov rdi, QWORD [i] 
        call print
    endfor i

    mov rax, 0x3c 
    mov rdi, 111 
    syscall
