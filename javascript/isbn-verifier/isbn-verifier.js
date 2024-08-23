export const isValid = (input) => {

    let isbn = input.replaceAll(/[^X\d]/g, '');

    if (!/^\d{9}[\dX]$/.test(isbn)) {
        return false;
    }

    return [...isbn].reduce((acc, number, index) => 
        ((number === 'X') ? 10 : Number(number)) * (10 - index) + acc, 0) 
            % 11 === 0;
};
