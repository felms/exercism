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

tolerance = {
    "grey": 0.05,
    "violet": 0.1,
    "blue": 0.25,
    "green": 0.5,
    "brown": 1,
    "red": 2,
    "gold": 5,
    "silver": 10
}

def format_output(value, percentage):

    if (value >= GIGA) :
        return f'{(value / GIGA):g} gigaohms ±{percentage}%'

    if (value >= MEGA) :
        return f'{(value / MEGA):g} megaohms ±{percentage}%'

    if (value >= KILO) :
        return f'{(value / KILO):g} kiloohms ±{percentage}%'

    return f'{value} ohms ±{percentage}%'

def resistor_label(colors):

    if (len(colors) < 3):
        return "0 ohms"

    resistance = int("".join([str(encoding[x]) for x in colors[0:-2]]))
    resistance *= pow(10, encoding[colors[-2]])

    return format_output(resistance, tolerance[colors[-1]])
