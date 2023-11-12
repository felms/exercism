#include "roman_numerals.h"

#define MAX_LENGTH 16

static const char* units[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
static const char* tens[] = {"","X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
static const char* hundreds[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
static const char* thousands[] = {"", "M", "MM", "MMM"};

char *to_roman_numeral(unsigned int number) {

   char *roman_number = (char*)calloc(MAX_LENGTH, sizeof(char));
   int n = number;

   int m = n / 1000;
   strcat(roman_number, thousands[m]);

   int c = (n % 1000) / 100;
   strcat(roman_number, hundreds[c]);

   int x = (n % 100) / 10;
   strcat(roman_number, tens[x]);

   int i = n % 10;
   strcat(roman_number, units[i]);

   return roman_number;
}
