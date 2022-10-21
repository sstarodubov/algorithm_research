;extern "C" int CalculateSum_(int* arr, int n);
; ecx = *arr, edx = n 

.code

CalculateSum_ proc
	xor rax, rax
	xor r8, r8

	cmp rdx, 0
	jle Error

@@:	add rax, [rcx]
	inc r8
	cmp r8, rdx
	jge @F
	add rcx, 4
	jmp @B

@@: ret

Error:
	mov rax, -1
	ret

CalculateSum_ endp

end