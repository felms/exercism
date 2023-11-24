pub fn reply(message: &str) -> &str {

    let m = message.trim();

    if m.is_empty() {
        return "Fine. Be that way!";
    }

    if is_question(m) {
        if is_shouting(m) {
            return "Calm down, I know what I'm doing!";
        }

        return "Sure.";
    }

    if is_shouting(m) {
        return "Whoa, chill out!";
    }
    
    "Whatever."
}

fn is_question(message: &str) -> bool {
    message.ends_with("?")
}

fn is_shouting(message: &str) -> bool {
    message.chars().any(|c| c.is_ascii_alphabetic() && c.is_ascii_uppercase())
    && !message.chars().any(|c| c.is_ascii_alphabetic() && c.is_ascii_lowercase())
}
