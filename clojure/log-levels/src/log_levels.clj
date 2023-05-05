(ns log-levels
  (:require [clojure.string :as str]))

(defn message
  "Takes a string representing a log line
   and returns its message with whitespace trimmed."
  [s]
    (str/replace
      (str/trim s)
      #"\[.+\]:\s+"
      ""
    )
  )

(defn log-level
  "Takes a string representing a log line
   and returns its level in lower-case."
  [s]
  (
    str/replace
    (str/lower-case s)
    #"\[|\].*"
    ""
  )
  )


(defn reformat
  "Takes a string representing a log line and formats it
   with the message first and the log level in parentheses."
  [s]
  (def msg (message s))
  (def level (str/trim (log-level s)))
  (str "" msg " ("level")")
  )
