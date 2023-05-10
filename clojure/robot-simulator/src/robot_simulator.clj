(ns robot-simulator)

(defn robot [coordinates, bearing] 
  {
    :coordinates coordinates
    :bearing bearing
    }
)

(defn turn-right [direction]
  (cond 
   (= :north direction) :east
   (= :east direction) :south
   (= :south direction) :west
   (= :west direction) :north
  )
)

(defn turn-left [direction]
  (cond 
   (= :north direction) :west
   (= :west direction) :south
   (= :south direction) :east
   (= :east direction) :north
  )
)

(defn advance [robbie]
  (def bearing (:bearing robbie))
  (def x (:x (:coordinates robbie)))
  (def y (:y (:coordinates robbie)))

  (cond
    (= :north bearing) (robot {:x x :y (+ y 1)} bearing)
    (= :east bearing) (robot {:x (+ x 1) :y y} bearing)
    (= :south bearing) (robot {:x x :y (- y 1)} bearing)
    (= :west bearing) (robot {:x (- x 1) :y y} bearing)
  )     
        
)

(defn apply-move [move, robbie] 
  (cond
    (= "L" move) (robot (:coordinates robbie) (turn-left (:bearing robbie)))
    (= "R" move) (robot (:coordinates robbie) (turn-right (:bearing robbie)))
    (= "A" move) (advance robbie)
  )
)

(defn do-simulate [moves_list, robbie]
  (if (empty? moves_list) 
    robbie
    (do-simulate (rest moves_list) (apply-move (first moves_list) robbie))
  )
)

(defn simulate [moves, robbie] 
  (def moves_list (clojure.string/split moves #""))
  (do-simulate moves_list robbie)
)
