.code

IntegerShift_ proc

 cmp edx,31			;compare count against 31
 ja InvalidCount	;jump if count > 31


 xchg ecx,edx		;exchange contents of ecx & edx
 mov eax,edx		;eax = a
 shl eax,cl			;eax = a << count;
 mov [r8],eax		;save result

 shr edx,cl			;edx = a >> count
 mov [r9],edx		;save result
 mov eax,1			;set success return code


InvalidCount:
 xor eax, eax
 ret				;return to caller


IntegerShift_ endp
end