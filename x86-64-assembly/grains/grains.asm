section .text
global square
square:
    mov rax, 0 ; Initialize rax with zero
    mov rcx, rdi ; Initialize rax with zero

    cmp rdi, 0 ; if input is less than or equal zero return
    jle done_square

    cmp rdi, 64 ; if input is greater than 64 return
    jg  done_square

    dec rcx ; decrement input value
    mov rax, 1 ; set the first bit be updated
    shl rax, cl ; shifts the bit right by the value present in rcx

done_square:
    ret

global total
total:
    mov rdx, 0 ;the total
    mov rdi, 0 ;the counter

loop:
    call square
    add rdx, rax ; adds rax (the return value of the function) with rdx
    inc rdi
    cmp rdi, 65 ; loops while the counter is less than 65
    jl loop

    mov rax, rdx
    ret

%ifidn __OUTPUT_FORMAT__,elf64
section .note.GNU-stack noalloc noexec nowrite progbits
%endif
