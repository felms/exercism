(ns strain)

(defn retain [predicate input-list]
  (let [[x & xs] input-list]
    (cond
      (empty? input-list) '()
      (predicate x) (cons x (retain predicate xs))
      :else (retain predicate xs)
     )
   )
)

(defn discard [predicate input-list]
  (let [[x & xs] input-list]
    (cond
      (empty? input-list) '()
      (predicate x) (discard predicate xs)
      :else (cons x (discard predicate xs))
     )
   )

)
