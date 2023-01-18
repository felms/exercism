(ns bird-watcher)

(def last-week
  [0 2 5 3 7 8 4]
  )

(defn today [birds]
  (get birds 6)
  )

(defn inc-bird [birds]
  (assoc birds 6 (+ (today birds) 1))
  )

(defn day-without-birds? [birds]
  (not (every? (fn [x] (> x 0)) birds))
  )

(defn n-days-count [birds n]
  (reduce + (subvec birds 0 n))
  )

(defn busy-days [birds]
  (count (filter (fn [x] (> x 4)) birds))
  )

(defn odd-week? [birds]
  (every? (fn [x] (or (= x 1) (= x 0))) birds)
  )
