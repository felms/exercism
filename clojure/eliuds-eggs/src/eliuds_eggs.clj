(ns eliuds-eggs)

(defn do-count [number counter]
  (if (zero? number)
    counter
    (do-count (bit-shift-right number 1) (+ counter (bit-and number 1)))))

(defn egg-count [number]
  (do-count number 0))
