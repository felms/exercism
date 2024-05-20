(ns nucleotide-count)

(defn count-of-nucleotide-in-strand [nucleotide strand]
  (let [[x & xs] strand]
    (cond
      (empty? strand) 0
      (not (some #{nucleotide} [\A \T \C \G])) (throw (Throwable "invalid"))
      (= nucleotide x) (inc (count-of-nucleotide-in-strand nucleotide xs))
      :else  (count-of-nucleotide-in-strand nucleotide xs))))

(defn get_frequencies [strand nucleotides freq-map]
  (if
    (empty? nucleotides) freq-map
    (let [[x & xs] nucleotides]
      (get_frequencies 
        strand 
        xs 
        (assoc freq-map x (count-of-nucleotide-in-strand x strand))))))

(defn nucleotide-counts [strand]
  (get_frequencies strand [\A, \T, \C, \G] {}))
