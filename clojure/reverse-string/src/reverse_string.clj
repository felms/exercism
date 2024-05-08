(ns reverse-string)

(defn do-reverse [string result]
  (cond
    (empty? string) (apply str result)
    :else (do-reverse (rest string) (cons (first string) result))
   )
)

(defn reverse-string [s] ;; <- arglist goes here
  (do-reverse s "")
)
