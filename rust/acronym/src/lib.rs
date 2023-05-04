pub fn abbreviate(phrase: &str) -> String {
    if phrase.is_empty() {
        return String::new();
    }

    let cleaned_phrase: String = phrase
        .replace('\'', "")
        .replace(|c: char| c.is_ascii_punctuation(), " ");

    cleaned_phrase
        .split_ascii_whitespace()
        .map(parse_word)
        .collect::<String>()
        .to_uppercase()
}

fn parse_word(word: &str) -> String {
    if is_camelcase(word) {
        return word
            .chars()
            .filter(|c| c.is_ascii_uppercase())
            .collect::<String>();
    }

    String::from(word.chars().take(1).last().unwrap())
}

fn is_camelcase(word: &str) -> bool {
    if word.len() < 4 {
        return false;
    }

    let second_char = word.chars().nth(1).unwrap();

    return second_char.is_ascii_lowercase()
        && word
            .get(2..word.len())
            .unwrap()
            .chars()
            .any(|c| c.is_ascii_uppercase());
}
