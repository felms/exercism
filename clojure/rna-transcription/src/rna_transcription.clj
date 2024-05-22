(ns rna-transcription)

(defn get-complement [nucleotide]
  (case nucleotide
    \G \C
    \C \G
    \T \A
    \A \U
    (throw (AssertionError. "invalid"))
   )
  )

(defn to-rna [dna]
  (if
    (empty? dna) ""
    (apply str (get-complement (first dna)) (to-rna (rest dna)))
    )
)
