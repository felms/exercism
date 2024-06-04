(ns interest-is-interesting)

(defn interest-rate
  "Returns the interest rate based on the specified balance."
  [balance]
  (cond
    (>= balance 5000M) 2.475
    (>= balance 1000M) 1.621
    (>= balance 0M) 0.5
    :else -3.213
    ))

(defn annual-balance-update
  "Returns the annual balance update, taking into account the interest rate."
  [balance]
  (let [interest (* balance (/ (bigdec(interest-rate balance)) 100.0M))]
    (if (> balance 0) 
      (+ balance interest)
      (- balance interest)
      )
    )
  )

(defn amount-to-donate
  "Returns how much money to donate based on the balance and the tax-free percentage."
  [balance tax-free-percentage]
  (if (> balance 0) 
    (int (* 2 (* balance (/ tax-free-percentage 100)))) 
    0))
