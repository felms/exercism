(defpackage :yacht
  (:use :cl)
  (:export :score))
(in-package :yacht)

(defun score-n (scores n)
  (* n (count n scores)))

(defun score-yacht (scores)
  (if (= (count (first scores) scores) 5) 50 0))

(defun score-full-house (scores)
  (let ((f (nth 0 scores)) (l (nth 4 scores)))
    (cond
      ((and (= (count f scores) 2) (= (count l scores) 3)) (apply '+ scores))
      ((and (= (count f scores) 3) (= (count l scores) 2)) (apply '+ scores))
      (t 0))))

(defun score-foak (scores)
  (if (>= (count (second scores) scores) 4) (* 4 (second scores)) 0))

(defun score-straight (scores straight)
  (if (equal (sort scores #'<) straight) 30 0))

(defun score (scores category)
  "Returns the score of the scores for the given category."
  (case category
    (:yacht (score-yacht scores))
    (:ones (score-n scores 1))
    (:twos (score-n scores 2))
    (:threes (score-n scores 3))
    (:fours (score-n scores 4))
    (:fives (score-n scores 5))
    (:sixes (score-n scores 6))
    (:full-house (score-full-house (sort scores #'<)))
    (:four-of-a-kind (score-foak (sort scores #'<)))
    (:little-straight (score-straight scores '(1 2 3 4 5)))
    (:big-straight (score-straight scores '(2 3 4 5 6))) 
    (:choice (apply '+ scores))
    )
  )
