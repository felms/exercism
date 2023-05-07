(defn distance [strand1 strand2] ; <- arglist goes here
  (if (= (count strand1) (count strand2))
    (count (filter (fn [[a b]] (not (= a b))) (map vector strand1 strand2)))
    nil
    )
  )
