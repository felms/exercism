#include "secret_handshake.h"

#include <algorithm>

namespace secret_handshake {

    vector<string> commands(int number) {

        vector<string> res;
        
        if ((number & 1) != 0) {
            res.push_back("wink");
        }

        if ((number & 2) != 0) {
            res.push_back("double blink");
        }

        if ((number & 4) != 0) {
            res.push_back("close your eyes");
        }

        if ((number & 8) != 0) {
            res.push_back("jump");
        }

        if ((number & 16) != 0) {
            reverse(res.begin(), res.end());
        }

        return res;
    }

}  // namespace secret_handshake
