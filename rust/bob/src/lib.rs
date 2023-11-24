pub fn reply(message: &str) -> &str {
    let m = message.trim();

    if m.is_empty() {
        return "Fine. Be that way!";
    }

    let is_question = m.ends_with('?');
    let is_shouting = m.chars().any(|c| c.is_ascii_alphabetic()) && m == m.to_ascii_uppercase();

    match (is_question, is_shouting) {
        (true, true) => "Calm down, I know what I'm doing!",
        (true, false) => "Sure.",
        (false, true) => "Whoa, chill out!",
        _ => "Whatever.",
    }
}
