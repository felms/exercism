(ns matching-brackets)

(defn valid_input? [input_values stack]
  (def current_char (first input_values))
  (cond 
    (and (= current_char nil) (empty? stack)) true
    (= current_char nil) false
    (not (some #(= current_char %) ["{", "[", "(", "}", "]", ")"])) (valid_input? (rest input_values) stack)
    (= current_char "{") (valid_input? (rest input_values) (conj stack current_char))
    (= current_char "[") (valid_input? (rest input_values) (conj stack current_char))
    (= current_char "(") (valid_input? (rest input_values) (conj stack current_char))
    (and (= current_char "}") (= (first stack) "{")) (valid_input? (rest input_values) (drop 1 stack))
    (and (= current_char "]") (= (first stack) "[")) (valid_input? (rest input_values) (drop 1 stack))
    (and (= current_char ")") (= (first stack) "(")) (valid_input? (rest input_values) (drop 1 stack))
    :else false
  )
)

(defn valid? [input] 
  (valid_input? (clojure.string/split input #"") ())
)
