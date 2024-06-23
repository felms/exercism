(ns secret-handshake)

(defn exec-commands [commands acc]
  (cond
    (bit-test commands 0) (exec-commands (bit-flip commands 0) (conj acc "wink"))
    (bit-test commands 1) (exec-commands (bit-flip commands 1) (conj acc "double blink"))
    (bit-test commands 2) (exec-commands (bit-flip commands 2) (conj acc "close your eyes"))
    (bit-test commands 3) (exec-commands (bit-flip commands 3) (conj acc "jump"))
    (bit-test commands 4) (reverse acc)
    :else acc
    )
  )

(defn commands [commands-list]
  (exec-commands commands-list [])
)
