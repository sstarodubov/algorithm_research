; Define variables in the data section
SECTION .data
	 arr: DD 1,2,3,4
         val: DD 11
; Code goes in the text section

SECTION .text 
global main

main:
    mov rbp, rsp; for correct debugging
    mov ebp, esp; for correct debugging
    mov rbx, val
    lea rax, val
    
    mov rax, 60
    xor rdi,rdi
    syscall