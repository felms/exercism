raindrops <- function(number) {
    res <- ""

    if (number %% 3 == 0) {
        res <- paste(res, "Pling", sep="")
    }

    if (number %% 5 == 0) {
        res <- paste(res, "Plang", sep="")
    }

    if (number %% 7 == 0) {
        res <- paste(res, "Plong", sep="")
    }


    if (res == "") {
        res <- as.character(number)
    }

    return (res)
}
