#include "reverse_string.h"

namespace reverse_string {

    std::string reverse_string(std::string input_string) {

        return std::string(input_string.rbegin(), input_string.rend());

    }

}  // namespace reverse_string
