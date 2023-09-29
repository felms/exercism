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

# the resulting distance
distance_between_points() {

    a=$(echo "$3 - $1" | bc)
    b=$(echo "$4 - $2" | bc)
    part0=$(echo "$a^2" | bc)
    part1=$(echo "$b^2" | bc)
    c=$(echo "$part0 + $part1" | bc)
    distance=$(echo "scale=2;sqrt($c)" | bc)

}

main () {

    if [[ ${#} -ne 2 || "${1}${2}" =~ [^0-9\.\-] ]]; then
        echo "error"; exit 1
    fi

    distance_between_points 0 0 $1 $2

    # echo "$distance"

    if [ $(echo "$distance <= 1.0" | bc) = 1 ]; then
        echo "10"
    elif [ $(echo "$distance <= 5.0"| bc) = 1 ]; then
        echo "5"
    elif [ $(echo "$distance <= 10.0" | bc)  = 1 ]; then
        echo "1"
    else
        echo "0"
    fi

}

main "$@"