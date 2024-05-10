(ns accumulate)

(defn accumulate [f input]
  (if
    (empty? input) '()
    (cons
      (f (first input))
      (accumulate f (rest input))
      )
    )
  )
