(import (rnrs))

(define (score word)
  (score-word (string->list (string-downcase word)))
)

(define (score-word word) 
  (if (null? word)
    0
   (+ (score-letter (car word)) (score-word (cdr word)))
   )
)

(define (score-letter letter)
  (cond 
    ((member letter '(#\a #\e #\i #\o #\u #\l #\n #\r #\s #\t)) 1)
    ((member letter '(#\d #\g)) 2)
    ((member letter '(#\b #\c #\m #\p)) 3)
    ((member letter '(#\f #\h #\v #\w #\y)) 4)
    ((member letter '(#\k)) 5)
    ((member letter '(#\j #\x)) 8)
    ((member letter '(#\q #\z)) 10)
  )
)
