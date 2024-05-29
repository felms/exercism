local vowelsounds = {"^a", "^e", "^i", "^o", "^u", "^xr", "^yt"}

function func(phrase)

    for _, sound in ipairs(vowelsounds) do
        if string.find(phrase, sound) ~= nil then
            return phrase .. "ay"
        end
    end

    if string.len(phrase) == 2 and string.find(phrase, "y$") ~= nil then
        return "y" .. string.sub(phrase, 1, 1) .. "ay"
    end

    local newword = ""

    if string.find(phrase, "^qu") ~= nil then
        newword = string.sub(phrase, 3, -1) .. "qu"
    else 
        newword = string.sub(phrase, 2, -1) .. string.sub(phrase, 1, 1)
    end

    return func(newword)
end

function translate(phrase)

    local res = ""

    for value in string.gmatch(phrase, "%S+") do
        res = res .. " " .. func(value)
    end

    return string.sub(res, 2, -1)

end

return translate
