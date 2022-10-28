
    .code
ReverseArray_ proc frame
	push rsi
	.pushreg rsi
	 push rdi
	.pushreg rdi
	.endprolog


	test r8d, r8d
	jle Error
	xor eax, eax

	mov rsi, rcx
	mov rdi, rdx
	mov ecx, r8d
	lea rsi, [rsi + rcx * 4 -4]

	pushfq
	std

@@: lodsd
	mov [rdi], eax
	add rdi, 4
	dec rcx
	jnz @B
	xor eax, eax
	popfq
	jmp Exit

Error:
	mov eax, 1

Exit: 
	pop rdi
	pop rsi
	ret

ReverseArray_ endp
	end