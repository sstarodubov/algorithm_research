

;extern "C" int64_t IntegerMul_(int8_t a, int16_t b, int32_t c, int64_t d, int8_t e, int16_t f, int32_t g, int64_t h);

; ecx = a, edx = b, r8 = c, r9 = d
; return eax


    .code
IntegerMul_ proc


	mov eax, ecx
	imul eax, edx
	imul eax, r8d
	imul eax, r9d
	

	movsx ecx, byte ptr [rsp + 40]
	imul eax, ecx
	movsx ecx, word ptr [rsp + 48]
	imul eax, ecx
	imul eax, [rsp + 56]
	imul rax, qword ptr [rsp + 64]
	
	ret
		
IntegerMul_ endp
	end