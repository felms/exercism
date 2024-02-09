export const commands = (number) => {

    let actions = {
        1: "wink",
        2: "double blink",
        4: "close your eyes",
        8: "jump",
    };

    let list = [];

    for (const [code, action] of Object.entries(actions)) {
        if ((number & code) == code) {
            list.push(action);
        }
    }

    if((number & 16) == 16) {
        list = list.reverse();
    }
    
    return list;
};

