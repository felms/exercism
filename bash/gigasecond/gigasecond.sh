#!/usr/bin/env bash

main () {
    
    gigasecond=1000000000
    input_date=$(date -u +%s --date="$1")

    new_date=$( date -u +%Y-%m-%dT%H:%M:%S --date="@$(( input_date + gigasecond))" )

    echo "$new_date"
    
}

main "$@"