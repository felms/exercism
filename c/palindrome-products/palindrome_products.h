#ifndef PALINDROME_PRODUCTS_H
#define PALINDROME_PRODUCTS_H

#include <stdbool.h>
#include <stdlib.h>

#include <stdio.h>

#define MAXERR 100

typedef struct factors {
    int factor_a;
    int factor_b;
    struct factors *next;
} factor_t;

struct product {
    int smallest;
    int largest;
    factor_t *factors_sm;
    factor_t *factors_lg;
    char error[MAXERR];
};

typedef struct product product_t;

product_t *get_palindrome_product(int from, int to);
void add_to(factor_t *factors, factor_t *new_factor);
void insert(product_t *product, int value, factor_t *factor);
bool is_palindrome(int number);
bool factors_are_equal(const factor_t *const f1, const factor_t *const f2);
bool has_factor(factor_t *factors, const factor_t *const factor);
void free_product(product_t *p);

#endif
