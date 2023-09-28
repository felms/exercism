#!/usr/bin/env bash

# The following comments should help you get started:
# - Bash is flexible. You may use functions or write a "raw" script.
#
# - Complex code can be made easier to read by breaking it up
#   into functions, however this is sometimes overkill in bash.
#
# - You can find links about good style and other resources
#   for Bash in './README.md'. It came with this exercise.
#
#   Example:
#   # other functions here
#   # ...
#   # ...
#
#   main () {
#     # your main function code here
#   }
#
#   # call main with all of the positional arguments
#   main "$@"
#
# *** PLEASE REMOVE THESE COMMENTS BEFORE SUBMITTING YOUR SOLUTION ***

# variable to hold the result
result=""

# encodes a single letter
encode_letter () {

    plain_alphabet="abcdefghijklmnopqrstuvwxyz1234567890"
    cipher_alphabet="zyxwvutsrqponmlkjihgfedcba1234567890"

    # finds the position of the letter
    search_letter="$1"

    rest=${plain_alphabet#*$search_letter}
    pos=$(( ${#plain_alphabet} - ${#rest} - ${#search_letter}))

    # adds the "encoded" letter to the result
    if [ $pos -ge 0 ]; then

        # tamanho da string
        len=${#result}

        if [ $(($len % 6)) = 0 ]; then
            result+=" "
        fi

        result+=${cipher_alphabet:$pos:1}
    fi
}

# encodes the input text
encode () {

    local input="$@"

    # to lower case
    local word=$(echo $input | tr '[:upper:]' '[:lower:]')

    for ((i = 0; i<${#word}; i++)); do
        # Iterates each letter from the input
        letter=${word:$i:1}
        
        # calls the function on each letter
        encode_letter "$letter"
    done

    echo $result
}

# decodes a single letter
decode_letter () {

    plain_alphabet="abcdefghijklmnopqrstuvwxyz1234567890"
    cipher_alphabet="zyxwvutsrqponmlkjihgfedcba1234567890"

    # finds the position of the letter
    search_letter="$1"

    rest=${plain_alphabet#*$search_letter}
    pos=$(( ${#plain_alphabet} - ${#rest} - ${#search_letter}))

    # adds the "decoded" letter to the result
    if [ $pos -ge 0 ]; then
        result+=${cipher_alphabet:$pos:1}
    fi
}

# decodes the input text
decode () {

    local word="$@"

    for ((i = 0; i<${#word}; i++)); do
        # Iterates each letter from the input
        letter=${word:$i:1}
        
        # calls the function on each letter
        decode_letter "$letter"
    done

    echo $result
}

main () {
    case "$1" in 
        encode) encode "$2";;
        decode) decode "$2";;
    esac
}

main "$@"