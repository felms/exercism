main () {

    # create array of size 'n' populated with the value 'true'
    sieve=()

    for ((i = 0; i <= $1; i++)); do
        sieve[i]=true
    done

    # change the value of indices 0 and 1 to false
    sieve[0]=false
    sieve[1]=false

    # loop through the array and, for every 'true' found I 
    # change all his multiples to false.
    res=()
    for ((i = 0; i <= $1; i++)); do
        if ${sieve[i]}; then
            for ((j = i + i; j <= $1; j+=i)); do
                sieve[j]=false
            done
            res+=($i)
        fi
    done

    echo ${res[@]}
}

main "$@"
