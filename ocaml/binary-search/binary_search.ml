let find array value =
    let rec bin_search array value left right =
        let middle = (left + right) / 2 in
            if left > right then Error "value not in array"
            else if array.(middle) = value then Ok middle
            else if array.(middle) > value
            then bin_search array value left (middle - 1) 
            else bin_search array value (middle + 1) right

    in bin_search array value 0 ((Array.length array) - 1)
