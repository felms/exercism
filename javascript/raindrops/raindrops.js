export const convert = (number) => {
    let res = "";

    if (number % 3 === 0) {
        res = "Pling";
    }

    if (number % 5 === 0) {
        res += "Plang";
    }

    if (number % 7 === 0) {
        res += "Plong";
    }

    return res === "" ? number.toString() : res;
};
