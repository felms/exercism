GIGA = 1_000_000_000
MEGA = 1_000_000
KILO = 1_000

encoding = {
    "black": 0, 
    "brown": 1, 
    "red": 2, 
    "orange": 3, 
    "yellow": 4, 
    "green": 5, 
    "blue": 6, 
    "violet": 7, 
    "grey": 8, 
    "white": 9
}

def format_output(value):
    
    if (value >= GIGA) :
            return f'{int(value / GIGA)} gigaohms'

    if (value >= MEGA) :
            return f'{int(value / MEGA)} megaohms'

    if (value >= KILO) :
            return f'{int(value / KILO)} kiloohms'
        
    return f'{value} ohms'

def label(colors):
     resistance = encoding[colors[0]] * 10 + encoding[colors[1]]
     resistance *= pow(10, encoding[colors[2]])

     return format_output(resistance)
