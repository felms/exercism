(ns collatz-conjecture)

(defn collatz_n [num, steps]
  (cond (= num 1) steps
        (even? num) (collatz_n (/ num 2) (+ steps 1))
        (odd? num) (collatz_n (+ (* 3 num) 1) (+ steps 1))
  )
)

(defn collatz [num] ;; <- arglist goes here
  (collatz_n num 0)
)
