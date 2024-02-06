units = ["", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"]
tens = ["","X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"]
hundreds = ["", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"]
thousands = ["", "M", "MM", "MMM"]

function to_roman(number)

    if number <= 0
        throw(ErrorException("error"))
    end

    th = div(number, 1000) + 1
    hh = div((number % 1000), 100) + 1
    tt = div((number % 100), 10) + 1
    uu = number % 10 + 1

    return thousands[th] * hundreds[hh] * tens[tt] * units[uu]
end
