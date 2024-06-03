const GIGASECOND = 1_000_000_000_000;

export const gigasecond = (date) => {
    let newDate = new Date(date.getTime() + GIGASECOND);
    return newDate;
};
