package letter

// FreqMap records the frequency of each rune in a given text.
type FreqMap map[rune]int

// Frequency counts the frequency of each rune in a given text and returns this
// data as a FreqMap.
func Frequency(text string) FreqMap {
	frequencies := FreqMap{}
	for _, r := range text {
		frequencies[r]++
	}
	return frequencies
}

// ConcurrentFrequency counts the frequency of each rune in the given strings,
// by making use of concurrency.
func ConcurrentFrequency(texts []string) FreqMap {

    res := make(FreqMap)
    c := make(chan FreqMap, 10)

    for _, text := range texts {
        go func(txt string) {
            c <- Frequency(txt)
        }(text)
    }

    for i := 0; i < len(texts); i++ {
        frequencies := <- c

        for letter, freq := range frequencies {
            res[letter] = res[letter] + freq
        }
    }


    return res
}
