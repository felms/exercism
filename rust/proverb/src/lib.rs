pub fn build_proverb(list: &[&str]) -> String {

    if list.is_empty() {
        return String::new();
    }

    let mut provb = Vec::new();

    for index in 1..list.len() {
        provb.push(format!("For want of a {} the {} was lost.", list[index - 1], list[index]));
    }

    provb.push(format!("And all for the want of a {}.", list[0]));

    provb.join("\n")
}


