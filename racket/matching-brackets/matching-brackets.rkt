#lang racket

(provide balanced?)

(define (balanced? str)
  (valid-input? (string->list str) '()))

(define (valid-input? str stack)
  (match (list str stack)
    [(list '() '()) #t]
    [(list '() _) #f]
    [(list (list first-item rem-items ...) stack) #:when (not (member first-item (string->list "([{}])"))) (valid-input? rem-items stack)]
    [(list (list #\( rem-items ...) stack) (valid-input? rem-items (list* #\( stack))]
    [(list (list #\[ rem-items ...) stack) (valid-input? rem-items (list* #\[ stack))]
    [(list (list #\{ rem-items ...) stack) (valid-input? rem-items (list* #\{ stack))]
    [(list (list #\) rem-items ...) (list #\( rem-stack ...)) (valid-input? rem-items rem-stack)]
    [(list (list #\] rem-items ...) (list #\[ rem-stack ...)) (valid-input? rem-items rem-stack)]
    [(list (list #\} rem-items ...) (list #\{ rem-stack ...)) (valid-input? rem-items rem-stack)]
    [_ #f]
    )
  )
