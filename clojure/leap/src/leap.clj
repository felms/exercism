(ns leap)

(defn leap-year? [year] ;; <- argslist goes here
  (or 
    (zero? (mod year 400))
    (and 
      (not (zero? (mod year 100)))
      (zero? (mod year 4))
      )
    )

)