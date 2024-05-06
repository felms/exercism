export const hey = (message) => {

    message = message.trim();

    if (message === "") {
        return "Fine. Be that way!";
    }

    if (isQuestion(message) && isYelling(message)) {
        return "Calm down, I know what I'm doing!";
    }

    if (isYelling(message)) {
        return "Whoa, chill out!";
    }

    if (isQuestion(message)) {
        return "Sure.";
    }

    
    return "Whatever.";
};

const isQuestion = (message) => /.*\?$/g.test(message);
const isYelling = (message) => {
    let r = message.replaceAll(/[^a-zA-Z]/g, '');
    return /^[A-Z]+$/g.test(r);
}
