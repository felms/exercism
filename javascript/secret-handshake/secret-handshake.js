const actions = { 0b00001: 'wink', 0b00010: 'double blink', 
                                    0b00100: 'close your eyes', 0b01000: 'jump' };

export const commands = (code) => {
    let res = Object.entries(actions).reduce((acc, [number, action]) => 
                                        code & number ? [...acc, action] : acc, []);

    return code & 0b10000 ? res.reverse() : res;
};
