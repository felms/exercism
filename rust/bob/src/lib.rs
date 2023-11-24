pub fn reply(message: &str) -> &str {

    let m = message.trim();

    if m.is_empty() {
        return "Fine. Be that way!";
    }

    let is_question = m.ends_with("?");
    let is_shouting = m.chars().any(|c| c.is_ascii_alphabetic()) && m == m.to_ascii_uppercase();

    if is_question { 
        return if is_shouting {
            "Calm down, I know what I'm doing!"
        } else { "Sure." }
    }

    if is_shouting {
        return "Whoa, chill out!";
    }
    
    "Whatever."
}

