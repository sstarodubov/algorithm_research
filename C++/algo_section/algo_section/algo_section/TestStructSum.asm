

TestStruct struct 

Val1 qword ?
Val2 qword ?
Val3 qword ?

TestStruct ends

    .code

TestStructSum_ proc
	xor rax, rax
	add rax, [rcx + TestStruct.Val1]
	add rax, [rcx + TestStruct.Val2]
	add rax, [rcx + TestStruct.Val3]
	ret
	

TestStructSum_ endp
	end