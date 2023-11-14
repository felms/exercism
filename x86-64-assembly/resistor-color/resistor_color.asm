default rel

section .data 
black: db "black", 0
brown: db "brown", 0
red: db "red", 0
orange: db "orange", 0
yellow: db "yellow", 0
green: db "green", 0
blue: db "blue", 0
violet: db "violet", 0
grey: db "grey", 0
white: db "white", 0

all_colors: dq black, brown, red, orange, yellow, green, blue, violet, grey, white

section .text
global color_code

color_code:
    mov r8, rdi
    mov r9, 0
    lea rsi, [all_colors]
    lea rdi, [r8]

cmp_loop:
    call compare_str
    mov r10, rax
    cmp r10, 1
    je is_equal
    jmp not_equal

is_equal:
    mov rax, r9
    jmp done

not_equal:
    mov rax, -1
    jmp done

done:
    ret
    

; ===================
; Compares two strings
; returns 1 for true and 0 for false
compare_str:
    repe cmpsb
    jne done_not_equal
    jmp done_equal

done_equal:
    mov r15, 1
    jmp done_cmp

done_not_equal:
    mov r15, 0
    jmp done_cmp
    
done_cmp:
    mov rax, r15
    ret
; ===================
    
global colors
colors:
    lea rax, [all_colors]
    ret

%ifidn __OUTPUT_FORMAT__,elf64
section .note.GNU-stack noalloc noexec nowrite progbits
%endif
