(ns anagram
  (:require [clojure.string :as str]))

(defn anagram? [word tested-word]
  (let [uppercase-word (str/upper-case word) 
        upper-tested (str/upper-case tested-word)]
  (and 
    (not (= uppercase-word upper-tested)) 
    (= (sort uppercase-word) (sort upper-tested)))))

(defn anagrams-for [word prospect-list]
  (filter #(anagram? word %) prospect-list)
)
