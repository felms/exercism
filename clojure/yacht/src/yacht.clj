(ns yacht)

(defn number-freq [number, xs]
  (cond 
    (empty? xs) 0
    (= (first xs) number) (+ 1 (number-freq number (rest xs)))
    :else (number-freq number (rest xs))
  )
)

(defn score-yacht [dice]
  (if (= (count (set dice)) 1)
    50
    0
  )
)

(defn score-n [dice, n]
  (* n (number-freq n, dice))
)

(defn score-full-house [dice]
  (def num-a (first (sort dice)))
  (def num-b (last (sort dice)))
  
  (cond
    (and (= (number-freq num-a dice) 2) (= (number-freq num-b dice) 3)) (reduce + dice)
    (and (= (number-freq num-a dice) 3) (= (number-freq num-b dice) 2)) (reduce + dice)
    :else 0
  )
)

(defn score-foak [dice]
  (def num-a (first (sort dice)))
  (def num-b (last (sort dice)))
  
  (cond
    (>= (number-freq num-a dice) 4) (* 4 num-a)
    (>= (number-freq num-b dice) 4) (* 4 num-b)
    :else 0
  )
)

(defn score-little-straight [dice]
  (if (= [1 2 3 4 5] (sort dice))
    30
    0
  )
)

(defn score-big-straight [dice]
  (if (= [2 3 4 5 6] (sort dice))
    30
    0
  )
)

(defn score [dice, category]
  (case category
    "yacht" (score-yacht dice)
    "ones" (score-n dice 1)
    "twos" (score-n dice 2)
    "threes" (score-n dice 3)
    "fours" (score-n dice 4)
    "fives" (score-n dice 5)
    "sixes" (score-n dice 6)
    "full house" (score-full-house dice)
    "four of a kind" (score-foak dice)
    "little straight" (score-little-straight dice)
    "big straight" (score-big-straight dice)
    "choice" (reduce + dice)
  )
)
