export function parse(markdown) {

    if (/^#.*/.test(markdown)) {
        return parseHeader(markdown);
    }

    let text = parseBoldAndItalics(markdown);
    return `<p>${text}</p>`;
}

const parseHeader = (text) => {

    let [_, header] = /(\#+).*/.exec(text);
    let len = header.length;

    if (len > 6) {
       return `<p>${text}</p>`;
    }

    let tag = `h${header.length}`;
    return `<${tag}>${text.substring(header.length + 1)}</${tag}>`;
    
};

const parseBoldAndItalics = (text) => {

    if (/_{2}.*_{2}/.test(text)) {
        let [matches] = [...text.matchAll(/(_{2}.*_{2})/g)];

        matches.forEach(m => {
            let [_, r] = [.../_{2}(.*)_{2}/.exec(m)];
            r = `<strong>${r}</strong>`;
            text = text.replace(m, r);
        });
    }

    if (/_{1}.*_{1}/.test(text)) {
        let [matches] = [...text.matchAll(/(_{1}.*_{1})/g)];

        matches.forEach(m => {
            let [_, r] = [.../_{1}(.*)_{1}/.exec(m)];
            r = `<em>${r}</em>`;
            text = text.replace(m, r);
        });
    }

    return text;

};
