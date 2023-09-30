#!/usr/bin/env bash

main() {

    local number="$1"
    local slice_size="$2"

    if [[ ${#number} = 0 ]]; then
        echo "series cannot be empty"
        exit 1
    fi

    if [[ ${#number} -lt slice_size ]]; then
        echo "slice length cannot be greater than series length"
        exit 1
    fi

    if [[ $slice_size = 0 ]]; then
        echo "slice length cannot be zero"
        exit 1
    fi

    if [[ $slice_size -lt 0 ]]; then
        echo "slice length cannot be negative"
        exit 1
    fi
            
    res=""

    for ((i = 0; i<=$((${#number} - slice_size)); i++)); do
        slice=${number:$i:$slice_size}
        res="${res} ${slice}"
    done

    echo $res
}

main "$@"