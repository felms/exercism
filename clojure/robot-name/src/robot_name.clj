(ns robot-name)

(defn generate-name []
  (def alphabet "ABCDEFGHIJKLMNOPQRSTUVWXYZ") 
  (str 
    (get alphabet (rand-int 27)) 
    (get alphabet (rand-int 27))
    (+ 101 (rand-int 899))
  )

)

(defn robot [] 
  (def new-name (generate-name))
  (atom {:name new-name})
)


(defn robot-name [robot]
  (:name @robot)
)

(defn reset-name [robot]
  (swap! robot assoc :name (generate-name))
)
