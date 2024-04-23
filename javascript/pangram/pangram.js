const ALPHABET = 'abcdefghijklmnopqrstuvwxyz';

export const isPangram = (word) => 
                [...ALPHABET].every(letter => word.toLowerCase().includes(letter));
