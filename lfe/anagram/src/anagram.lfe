(defmodule anagram
  (export (find 2)))

(defun anagram? (word tested)
  (let ((uppercase-word (string:uppercase word)) 
        (uppercase-tested (string:uppercase tested)))
    (and 
      (/= uppercase-word uppercase-tested)
      (== (lists:sort uppercase-word) (lists:sort uppercase-tested)))))

(defun find (word prospect-list)
   (lists:filter (lambda (x) (anagram? word x)) prospect-list))
