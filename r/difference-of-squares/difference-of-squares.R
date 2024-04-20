difference_of_squares <- function(natural_number) { 

    sum_of_squares <- (natural_number * (natural_number + 1) * (2 * natural_number + 1)) / 6

    sum_of_numbers <- (natural_number * (natural_number + 1)) / 2
    square_of_sum = sum_of_numbers * sum_of_numbers

    return (square_of_sum - sum_of_squares)

}
