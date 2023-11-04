section .bss ; block starting symbol
    ; variables

section .data 
    ; constants

section .text

global egg_count
egg_count:
    
    mov rax, rdi ; read from arguments
    mov rbx, 0   ; register to store the sum value

start_loop: 

    cmp rax, 0
    jz  exit_loop
    mov rcx, rax ; variable used to operate
    and rcx, 1   ; (rcx & 1)
    add rbx, rcx ; (rbx += rcx)
    shr rax, 1   ; shift right value of rax by 1 bit 
    jmp start_loop

exit_loop:

    mov rax, rbx
    ret

%ifidn __OUTPUT_FORMAT__,elf64
section .note.GNU-stack noalloc noexec nowrite progbits
%endif
