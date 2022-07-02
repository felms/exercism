export const countWords = (phrase) => {
    let regex = /[\.,\n:!@$%^&]/g;
    let processedPhrase = phrase.replace(regex, " ").trim();
    let words = processedPhrase.split(/\s+/g)
                    .map(word => word.toLowerCase()
                                    .replace(/^'|'$/g, " ").trim());

    let wordCount = {};

    words.forEach(word =>  wordCount[word] = wordCount[word] ? wordCount[word] + 1 : 1);
    
    return wordCount;
};
