(defpackage :raindrops
  (:use :cl)
  (:export :convert))

(in-package :raindrops)

(defun pling (n) 
  (if (= (rem n 3) 0) "Pling" "")
  )

(defun plang (n) 
  (if (= (rem n 5) 0) "Plang" "")
  )

(defun plong (n) 
  (if (= (rem n 7) 0) "Plong" "")
  )

(defun rdrps (n) 
  (concatenate 'string (pling n) (plang n) (plong n))
  )

(defun convert (n)
  (let ((s (rdrps n)))
    (if (= (length s) 0) (write-to-string n) s))
  )
