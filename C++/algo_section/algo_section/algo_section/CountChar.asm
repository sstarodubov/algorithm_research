
    .code
CountChar_ proc frame
	push rsi
	.pushreg rsi
	.endprolog

	xor rax, rax
	mov rsi , rcx
	mov cl, dl
	xor rdx, rdx
	xor r8, r8

@@: lodsb
	or al, al
	jz @F

	cmp al, cl
	sete r8b
	add rdx, r8
	jmp @B

@@:	
	mov rax, rdx
	pop rsi
	ret


CountChar_ endp
	end