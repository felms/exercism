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
    return parser(parsedStrong, '_', 'em');
}

function parseHeader(markdown) {
    let count = /^\#+/.exec(markdown)[0].length;
    const headerTag = `h${count}`;
    return wrap(markdown.substring(count + 1), headerTag);
}

function parseListItem(markdown) {
    return wrap(parseText(markdown.substring(2)), 'li');
}

function parseParagraph(markdown) {
    return wrap(parseText(markdown), 'p');
}

function parseLine(markdown) {

    if (/^\#{1,6} /.test(markdown)) {
        return parseHeader(markdown);
    }

    if (markdown.startsWith('*')) {
        return parseListItem(markdown);
    } 

    return parseParagraph(markdown);
}

export function parse(markdown) {
    return markdown.split('\n')
            .map(parseLine).join('')
            .replace(new RegExp('(<li>.+</li>)'), '<ul>$1</ul>');
}
