

;extern "C" int MemoryAddressing_(int i, int* v1, int* v2, int* v3, int* v4);

.const

FibVals  dword 0, 1, 1, 2, 3, 5, 8, 13
		 dword 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597


NumFibVals_ dword ($ - FibVals) / sizeof dword
public NumFibVals_


.data

FibValsSum_ dword ? ;value to demo RIP-relative addressing
public FibValsSum_



    .code
MemoryAddressing_ proc
	
	cmp ecx, 0
	jl ValidationLessZero

	cmp ecx, [NumFibVals_]
	jge ValidationOutOfIndex
	

	movsxd rcx, ecx
	mov [rsp + 8], rcx
	
	; example 1
	 mov r11, offset FibVals
	 shl rcx, 2
	 add r11, rcx
	 mov eax, [r11]
	 mov r11, [rsp + 40]
	 mov [r11], eax

	; example 2
	mov r11, offset FibVals
	mov eax, [r11 + rcx*4]
	mov [rdx], eax

	add [FibValsSum_], eax
	ret



ValidationLessZero:
	mov eax, 1
	ret
ValidationOutOfIndex:
	mov eax, 2
	ret

MemoryAddressing_ endp
	

end