%include "stud_io.inc"
global _start
;resb - 1 byte
; resw - 2 byte
; resd - 4 byte
; example string resb 20 -> reserve 20 byte

; db  - 1 byte
; dw - 2 byte
; dd - 4 byte

; commands
; jnz mark - if not zero let go to the mark
; lea register, [mark] - compute address by value
section .bss

array resb 256

section .data
nums db "0123456789"
;stext db "hello world"
;idx dd 1

x db 'x'
y db 'y'


section .text
_start:

    mov eax , 1
    mov ebx, 1

    cmp eax, ebx
    jne else
    PRINT "EQUAL"
    FINISH
else:
    PRINT "NOT EQUAL"
    FINISH
;    =====================
;    mov eax , 2
;    mov ecx, 4
;    mul ecx
;    PUTCHAR [nums + eax]

; =========================
;    mov dword [x], "hello"
;    mov eax, 5
;    PUTCHAR [x + eax]

;-----------------------------
;    mov y , 'h'
;    mov eax, [x]
;    mov [y], eax
;    PUTCHAR [y]
;------------------------------
;    mov al, 'y'
;    mov [array + 1], al
;
;    lea eax , [array]
;    PUTCHAR [eax + 1]

; -----------------------------
;    mov ecx, 0
;    mov edi , array
;    mov al, 'y'
;
;again:
;    mov [array + ecx], al
;    inc ecx
;    cmp ecx, 255
;    jl again
;
;    xor ecx , ecx
;
;loop:
;    PUTCHAR [array + ecx]
;    inc ecx
;    cmp ecx, 255
;    jl loop
; ---------------------------------


; ----------------------------------
;print_word:
;    PUSH ecx
;    PUSH eax
;    xor ecx, ecx
;
;cycle:
;    PUTCHAR [stext + ecx]
;    inc ecx
;    cmp ecx , eax
;    jl cycle
;
;    POP eax
;    POP ecx
;    ret
;-------------------------------------
