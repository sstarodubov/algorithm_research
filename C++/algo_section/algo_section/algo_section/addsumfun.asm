
; int IntegerAddSub_(int a, int b, int c)

; ecx = a, edx = b , r8d = c
; return eax

    .code
IntegerAddSub_ proc
	
	mov eax, ecx		;eax = a
	add eax, edx		;eax = a + b
	sub eax, r8d		;eax = a + b - c
	
	ret

IntegerAddSub_ endp
	end