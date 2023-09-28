(ns difference-of-squares)

(defn sum-of-squares [number]
  (->> number
    (inc)
    (range 1)
    (map #(* % % ))
    (reduce +)
  )
)

(defn square-of-sum [number] 
  (->> number
    (inc)
    (range 1)
    (reduce +)
    (#(* % %))
  )
)

(defn difference [number] 
  (- 
    (square-of-sum number) 
    (sum-of-squares number)
  )
)
