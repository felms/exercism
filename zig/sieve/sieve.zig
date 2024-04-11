pub fn primes(buffer: []u32, comptime limit: u32) []u32 {
    
    var sieve = [_]bool{true} ** (limit + 1);
    var bufferPos: u32 = 0;

    sieve[0] = false;
    sieve[1] = false;

    var i: u32 = 0;
    while (i <= limit) : (i += 1) {
        var elem = sieve[i];
        if (elem) {
            var j: u32 = i + i;
            while (j <= limit) : (j += i) {
                sieve[j] = false;
            }
            buffer[bufferPos] = i;
            bufferPos += 1;
        }
    }

    return buffer[0..bufferPos];
}
