(ns bob)

(defn shouting? [s]
  (def cleaned-str (apply str (filter #(Character/isLetter %) s)))
  (and 
    (not (clojure.string/blank? cleaned-str))
    (= cleaned-str (clojure.string/upper-case cleaned-str))
   )
)

(defn question? [s]
  (clojure.string/ends-with? s "?")
)

(defn response-for [s] ;; <- arglist goes here
  (def phrase (clojure.string/trim s))
  (cond
    (clojure.string/blank? phrase) "Fine. Be that way!"
    (and (shouting? phrase) (question? phrase)) "Calm down, I know what I'm doing!"
    (shouting? phrase) "Whoa, chill out!"
    (question? phrase) "Sure."
    true "Whatever."
  )
)

