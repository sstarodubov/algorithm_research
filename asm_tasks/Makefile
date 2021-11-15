FILE_NAME=main

once:
	nasm -f  elf ${FILE_NAME}.asm
	ld  -m  elf_i386 ${FILE_NAME}.o -o ${FILE_NAME}
	rm ${FILE_NAME}.o
run:
	./${FILE_NAME}