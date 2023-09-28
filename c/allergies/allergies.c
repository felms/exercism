#include "allergies.h"

bool is_allergic_to(allergen_t allergen, int allergy_score) {

    return (1 << allergen) & allergy_score;
}

allergen_list_t get_allergens(int allergy_score) {

    allergen_list_t allergies = (allergen_list_t) {0, {0}};

    for (int i = 0; i < ALLERGEN_COUNT; i++) {
        bool is_allergic = is_allergic_to(i, allergy_score);

        if (is_allergic) {
            allergies.count++;
            allergies.allergens[i] = true;
        }
    }

    return allergies;
}