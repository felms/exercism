(ns raindrops)

(defn convert [n] ;; <- arglist goes here
  (let [s 
        (str 
          (if (zero? (mod n 3)) "Pling" "") 
          (if (zero? (mod n 5)) "Plang" "") 
          (if (zero? (mod n 7)) "Plong" "") 
          )] 
    (if (= "" s) (str n) s))
)
