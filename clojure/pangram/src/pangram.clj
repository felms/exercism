(ns pangram)

(defn pangram? [phrase]
  (def graphemes (clojure.string/lower-case phrase))
  (every?
    (set graphemes)
    "abcdefghijklmnopqrstuvwxyz"
  )
)
