#!/usr/bin/env bash

regex='(^[aeiou]|^xr|^y[^aeiou])'

translate() {

    if [[ "$1" =~ $regex ]]; then
        echo "${1}ay"
    else
        quregex='^qu'
        if [[ "$1" =~ $quregex ]]; then
            newStr="${1:2}qu"
            translate "$newStr"
        else
            newString="${1:1}${1:0:1}"
            translate "$newString"
        fi
    fi

}

main() {

    local -a res
    local word

    for word in "$@"; do
        res+=("$(translate "$word")")
    done

    echo "${res[*]}"

}

main "$@"
