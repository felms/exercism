#include "palindrome_products.h"

product_t *get_palindrome_product(int from, int to) {


    product_t *product = (product_t *)malloc(sizeof(product_t));
    product->factors_sm = NULL;
    product->factors_lg = NULL;

    if (from > to) {
        snprintf(product->error, MAXERR, "invalid input: min is %d and max is %d", from, to);
        return product;
    }


    for (int i = from; i <= to; i++) {
        for (int j = i; j <= to; j++) {

            int possible_product = i * j;

            if (is_palindrome(possible_product)) {

                if (!product->factors_sm) {

                    product->smallest = possible_product;
                    product->largest = possible_product;

                    factor_t *sm_factor = malloc(sizeof(factor_t));
                    sm_factor->factor_a = i;
                    sm_factor->factor_b = j;

                    product->factors_sm = sm_factor;

                    factor_t *lg_factor = malloc(sizeof(factor_t));
                    lg_factor->factor_a = i;
                    lg_factor->factor_b = j;

                    product->factors_lg = lg_factor;


                } else {

                    factor_t *possible_factor = malloc(sizeof(factor_t));
                    possible_factor->factor_a = i;
                    possible_factor->factor_b = j;


                    if (possible_product < product->smallest 
                            || possible_product > product->largest) {
                        insert(product, possible_product, possible_factor);
                    } else if (possible_product == product->smallest) {
                        add_to(product->factors_sm, possible_factor);
                    } else if (possible_product == product->largest) {
                        add_to(product->factors_lg, possible_factor);
                    }

                }

            }

        }
    }

    if (!product->factors_sm) {
        snprintf(product->error, MAXERR, "no palindrome with factors in the range %d to %d", from, to);
        return product;
    }


    return product;

}

void add_to(factor_t *factors, factor_t *new_factor) {

    if (has_factor(factors, new_factor)) {
        return;
    }

    factor_t *current_factor = factors;
    while (current_factor->next != NULL) {
        current_factor = current_factor->next;
    }
    current_factor->next = new_factor;

}

void insert(product_t *product, int value, factor_t *factor) {

    if (value < product->smallest) {
        product->smallest = value;
        free(product->factors_sm);
        product->factors_sm = factor;
    } else if (value > product->largest) {
        product->largest = value;
        free(product->factors_lg);
        product->factors_lg = factor;
    }
}

bool is_palindrome(int number) {

    if (number > 1 && number < 10) {
        return true;
    }

    int n = number;
    int digit = 0;
    int reversed_number = 0;
    while (n > 0) {
        digit = n % 10;
        n /= 10;
        reversed_number = reversed_number * 10 + digit;
    }

    return reversed_number == number;
}

bool factors_are_equal(const factor_t *const f1,
        const factor_t *const f2)
{
    return ((f1->factor_a == f2->factor_a) && (f1->factor_b == f2->factor_b)) ||
        ((f1->factor_a == f2->factor_b) && (f1->factor_b == f2->factor_a));
}

bool has_factor(factor_t *factors, const factor_t *const factor)
{
    factor_t *current_factor = factors;
    while (current_factor != NULL) {
        if (factors_are_equal(current_factor, factor)) {
            return true;
        }
        current_factor = current_factor->next;
    }
    return false;
}

void free_product(product_t *p) {

    free(p->factors_sm);
    free(p->factors_lg); 
    free(p);

}

