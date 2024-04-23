"""
    ispangram(input)

Return `true` if `input` contains every alphabetic character (case insensitive).

"""
function ispangram(input)
    
    return all(letter -> (occursin(letter, lowercase(input))), 'a':'z')

end
