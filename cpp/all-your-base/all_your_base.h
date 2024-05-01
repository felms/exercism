#if !defined(ALL_YOUR_BASE_H)
#define ALL_YOUR_BASE_H

#include <vector>

using namespace std;

namespace all_your_base {
    vector<unsigned int> convert(unsigned int input_base, 
                                 vector<unsigned int> in_digits, unsigned int output_base);
}  // namespace all_your_base

#endif // ALL_YOUR_BASE_H


