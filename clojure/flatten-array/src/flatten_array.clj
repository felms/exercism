(ns flatten-array)

(defn flatten [arr]
  (let [[x & xs] arr]
    (cond
      (empty? arr) '()
      (nil? x) (flatten xs)
      (vector? x) (concat (flatten x) (flatten xs))
      :else (cons x (flatten xs))
      )
    )
  )
