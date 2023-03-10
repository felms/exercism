pub fn actions(n: u8) -> Vec<&'static str> {
    let mut res: Vec<&'static str>  = Vec::new();
    exec_command(n & 1, &mut res);
    exec_command(n & 2, &mut res);
    exec_command(n & 4, &mut res);
    exec_command(n & 8, &mut res);
    exec_command(n & 16, &mut res);

    return res;
}

pub fn exec_command(n: u8, actions_vec: &mut Vec<&'static str>) {
    match n { 
        1 => actions_vec.push("wink"),
        2 => actions_vec.push("double blink"),
        4 => actions_vec.push("close your eyes"),
        8 => actions_vec.push("jump"),
        16 => actions_vec.reverse(),
        _ => return
    }
}
