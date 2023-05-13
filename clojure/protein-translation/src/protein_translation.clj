(ns protein-translation)

(def lookup {
              "AUG" "Methionine"
              "UUU" "Phenylalanine"
              "UUC"	"Phenylalanine" 
              "UUA" "Leucine"
              "UUG"	"Leucine" 
              "UCU" "Serine" 
              "UCC" "Serine" 
              "UCA" "Serine" 
              "UCG"	"Serine" 
              "UAU" "Tyrosine" 
              "UAC"	"Tyrosine" 
              "UGU" "Cysteine" 
              "UGC" "Cysteine" 
              "UGG" "Tryptophan" 
              "UAA" "STOP" 
              "UAG" "STOP" 
              "UGA" "STOP"
              })

(defn translate-codon [codon] 
  (get lookup codon)
)

(defn do-translate-rna [acc, codons]

  (def translated-codon (translate-codon (first codons)))
  (cond 
    (= translated-codon "STOP") acc
    (empty? (rest codons)) (concat acc [translated-codon])
    :else (do-translate-rna (concat acc [translated-codon]) (rest codons))
  )
)

(defn translate-rna [rna] ;; <- arglist goes here
  (->> rna ;; This thingy is like Elixir's Pipe Operator but not exactly the same
    (partition 3)
    (map clojure.string/join)
    (do-translate-rna [])
  )
)
