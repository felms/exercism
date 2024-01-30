(defpackage :raindrops
  (:use :cl)
  (:export :convert))

(in-package :raindrops)

(defun pling? (n)
  (if (= (rem n 3) 0)
    (return-from pling? "Pling")
    (return-from pling? "")
    )
  )

(defun plang? (n)
  (if (= (rem n 5) 0)
    (return-from plang? "Plang")
    (return-from plang? "")
    )
  )

(defun plong? (n)
  (if (= (rem n 7) 0)
    (return-from plong? "Plong")
    (return-from plong? "")
    )
  )

(defun rdrps (n) 
  (concatenate 'string (pling? n) (plang? n) (plong? n))
  )

(defun convert (n)
  (let ((s (rdrps n)))
    (if (= (length s) 0)
      (return-from convert (write-to-string n))
      (return-from convert s)
      )
    )
  )
