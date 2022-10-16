


; int XorAnd_(int a, int b, int c)

; ecx = a, edx = b, r8 = c
; return eax


	;extern g_Val1:dword
	
    .code
XorAnd_ proc
	
	xor edx, ecx
	and edx, r8d
	;add edx, [g_Val1]
	mov eax, edx
	
	
	ret

XorAnd_ endp
	end