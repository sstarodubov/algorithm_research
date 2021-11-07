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

msg db "Yello world!!!", 0

_start:
    mov rax, msg
    
    call print_string

    call exit

; | input
; rax = string 
print_string:
    push rax
    push rbx
    push rcx
    push rdx

    mov rcx, rax
    
    call length_string
    
    mov rdx, rax
    mov rax, 4 ; write
    mov rbx, 1 ; std out
    
    int 0x80
    
    pop rdx
    pop rcx
    pop rbx
    pop rax

    ret

; | input
; rax = string
; | output
; rax = lenthg
length_string:
    push rdx
    xor rdx, rdx
    .next_iter:
        cmp [rax + rdx], byte 0
        je .close
        inc rdx
        jmp .next_iter
    .close:
        mov rax, rdx
        pop rdx
        ret

exit:
    mov rax, 1 ; 1 - exit
    mov rbx, 0 ; 0 - return
    int 0x80