
;extern "C" int IntegerMulDiv_(int a, int b, int* prod, int* quo, int* rem);

; ecx = a, edx = b, r8d = prod, r9d = quo, rsp + 40 = rem


.code

IntegerMulDiv_ proc

mov eax, edx
or eax, eax
jz InvalidDivisor


imul eax, ecx
mov [r8], eax

mov eax, ecx
mov r10d, edx

cdq
idiv r10d

mov [r9], eax
mov rax, [rsp + 40]
mov [rax], edx
mov eax, 1

InvalidDivisor:
 ret ;return to caller

IntegerMulDiv_ endp
end