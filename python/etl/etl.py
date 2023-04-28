def transform(legacy_data):
    data = {}

    for key in legacy_data:
        letters = legacy_data[key]
        for letter in letters:
            data[letter.lower()] = key

    return data
