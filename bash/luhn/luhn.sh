#!/usr/bin/env bash

main () {

    # cleaning the input
    input_string=$(echo $1 | tr -d ' ')
    input_length=${#input_string} 

    # tests the length of the string 
    # and if it contains only numbers
    if [[ input_length -lt 2 ]] || [[ ! $input_string =~ ^[0-9]+$ ]]; then 
        echo "false"
    else

        total=0

        # reverse input
        input_value=$(echo $input_string | rev)

        for ((i = 0; i < $input_length; i++)); do

            #iterates every digit of the input
            digit=${input_value:$i:1}
            
            if [[ $(($i % 2)) = 1 ]]; then
                new_digit=$((digit * 2))
                if [[ new_digit -gt 9 ]]; then
                    total=$((total + new_digit - 9)) 
                else
                    total=$((total + new_digit))
                fi
            else
                total=$((total + digit))
            fi

        done
        
        if [[ $(($total % 10)) = 0 ]]; then
            echo "true"
        else
            echo "false"
        fi

    fi
}

main "$@"