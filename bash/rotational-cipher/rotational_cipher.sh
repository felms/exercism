main () {

    input_string=$1
    input_length=${#input_string}
    shift=$2
    lowercase_alphabet="abcdefghijklmnopqrstuvwxyz"
    uppercase_alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    alphabet_length=${#lowercase_alphabet}

    output=""

    for ((i = 0; i < input_length; i++)) do

        # gets the current letter of the input
        current_letter=${input_string:$i:1}

        lower_pos=-1
        upper_pos=-1

        for ((j = 0; j < alphabet_length; j++)) do
            lower_letter=${lowercase_alphabet:$j:1}
            upper_letter=${uppercase_alphabet:$j:1}

            if [ "$current_letter" = "$lower_letter" ]; then
                lower_pos=$j
            else
                if [ "$current_letter" = "$upper_letter" ]; then
                    upper_pos=$j
                fi
            fi
        done

        if [[ $lower_pos -gt -1 ]]; then 
            lower_pos=$(((lower_pos + shift) % 26))
            new_letter=${lowercase_alphabet:$lower_pos:1}
            output="${output}${new_letter}"

        else

            if [[ $upper_pos -gt -1 ]]; then
                upper_pos=$(((upper_pos + shift) % 26))
                new_letter=${uppercase_alphabet:$upper_pos:1}
                output="${output}${new_letter}"
            else
                output="${output}${current_letter}"
            fi
        fi
    done

    echo "$output"
}

main "$@"
