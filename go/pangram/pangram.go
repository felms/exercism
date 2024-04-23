package pangram

import (    
    "strings"
)

func IsPangram(input string) bool {

    alphabet := "abcdefghijklmnopqrstuvwxyz"

    for _, c := range alphabet {
        if !strings.Contains(strings.ToLower(input), string(c)) {
            return false
        }
    }

    return true
}
