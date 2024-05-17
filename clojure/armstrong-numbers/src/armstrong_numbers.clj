(ns armstrong-numbers)

(defn armstrong-sum [num digits sum]
  (if
    (zero? num) sum
    (armstrong-sum 
      (quot num 10) 
      digits 
      (+ sum (int (Math/pow (rem num 10) digits))))))

(defn armstrong? [num]
  (if 
    (zero? num) true
    (let [digits (+ 1 (int (Math/log10 num)))]
      (= (armstrong-sum num digits 0) num))))
