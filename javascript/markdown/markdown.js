let parsingList;

function wrap(text, tag) {
    return `<${tag}>${text}</${tag}>`;
}

function parser(markdown, delimiter, tag) {
    const pattern = new RegExp(`${delimiter}(.+)${delimiter}`);
    const replacement = `<${tag}>$1</${tag}>`;
    return markdown.replace(pattern, replacement);
}

function parseText(markdown) {
    const parsedStrong = parser(markdown, '__', 'strong');
    const parsedText = parser(parsedStrong, '_', 'em');
    if (parsingList) {
        return parsedText;
    } else {
        return wrap(parsedText, 'p');
    }
}

function parseHeader(markdown) {

    let count = /^\#+/.exec(markdown)[0].length;
    const headerTag = `h${count}`;
    const headerHtml = wrap(markdown.substring(count + 1), headerTag);

    return headerHtml;
}

function parseListItem(markdown) {
    return wrap(parseText(markdown.substring(2)), 'li');
}

function parseParagraph(markdown) {
    return parseText(markdown);
}

function parseLine(markdown, list) {

    if (/^\#{1,6} /.test(markdown)) {
        return parseHeader(markdown, list);
    }

    if (markdown.startsWith('*')) {
        let tag = parsingList ? '' : '<ul>';

        if (!parsingList) {
            parsingList = true;
        }

        return tag + parseListItem(markdown);
    } 

    let tag = parsingList ? '</ul>' : '';
    parsingList = false;

    return tag + parseParagraph(markdown);
}

export function parse(markdown) {

    parsingList = false;

    let result = markdown.split('\n').map(parseLine).join('');

    if (parsingList) {
        result += '</ul>';
    } 

    parsingList = false;

    return result;
}
