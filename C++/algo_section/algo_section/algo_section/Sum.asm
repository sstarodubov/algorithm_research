
;extern "C" int SingedMinA_(int a, int b, int c);
;extern "C" int SingedMaxA_(int a, int b, int c);

    .code

SingedMinB_ proc

	cmp ecx, edx
	cmovg ecx, edx
	cmp ecx, r8d
	cmovg ecx, r8d
	mov eax, ecx
	ret
SingedMinB_ endp


SingedMaxB_ proc

	cmp ecx, edx
	cmovl ecx, edx
	cmp ecx, r8d
	cmovl ecx, r8d
	mov eax, ecx
	ret

SingedMaxB_ endp

SingedMinA_ proc

	cmp ecx, edx
	jle @F

	mov ecx, edx

@@: cmp ecx, r8d
	jle @F
	mov ecx, r8d
@@: 
	mov eax, ecx
	ret
	
SingedMinA_ endp
	
SingedMaxA_ proc
	
	cmp ecx, edx
	jge @F

	mov ecx, edx

@@: cmp ecx, r8d
	jge @F
	mov ecx, r8d
@@: 
	mov eax, ecx
	ret
	
SingedMaxA_ endp

end