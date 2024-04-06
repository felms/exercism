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
#

main () {

    n="$1"

    # create array of size 'n' populated with the value 'true'
    sieve=()

    for ((i = 0; i <= $n; i++)); do
        sieve[$i]=true
    done

    # change the value of indices 0 and 1 to false
    sieve[0]=false
    sieve[1]=false

    # loop through the array and, for every 'true' found I 
    # change all his multiples to false.
    res=()
    for ((i = 0; i <= $n; i++)); do
        if sieve[$i]; then
            for ((j = $i + $i; j <= $n; j+=$i)); do
                sieve[$j]=false
            done
            res+=($i)
        fi
    done

    echo ${res[@]}
}

main "$@"
