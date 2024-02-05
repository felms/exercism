units = ['', 'I', 'II', 'III', 'IV', 'V', 'VI', 'VII', 'VIII', 'IX']
tens = ['','X', 'XX', 'XXX', 'XL', 'L', 'LX', 'LXX', 'LXXX', 'XC']
hundreds = ['', 'C', 'CC', 'CCC', 'CD', 'D', 'DC', 'DCC', 'DCCC', 'CM']
thousands = ['', 'M', 'MM', 'MMM']

def roman(number):
    
    th = number // 1000
    hh = (number % 1000) // 100
    tt = (number % 100) // 10
    uu = number % 10

    return thousands[th] + hundreds[hh] + tens[tt] + units[uu]

