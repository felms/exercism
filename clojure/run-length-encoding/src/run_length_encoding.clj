(ns run-length-encoding
  (:require [clojure.string :as str]))

(defn run-length-encode
  "encodes a string with run-length-encoding"
  [plain-text]
  (str/replace 
    plain-text 
    #"(.)\1+" 
    #(str (str (count (% 0))) (str (% 1)))))

(defn run-length-decode
  "decodes a run-length-encoded string"
  [cipher-text]
  (str/replace 
    cipher-text
    #"(\d+)(.)" 
    #(apply str (repeat (Integer/parseInt (% 1)) (str (% 2))))))
