import re


def parse_header(markdown: str) -> str:
    m = re.match(r'^(#{1,6})\s(.*)$', markdown)
    return f'<h{len(m.group(1))}>{m.group(2)}</h{len(m.group(1))}>'


def parse_bold_and_italics(markdown: str) -> str:

    markdown = re.sub(r'__(.*)__', r'<strong>\1</strong>', markdown)
    markdown = re.sub(r'_(.*)_', r'<em>\1</em>', markdown)

    return markdown


def parse_line(markdown: str) -> str:
    if re.match(r'^#{1,6}\s.*$', markdown):
        return parse_header(markdown)

    markdown = parse_bold_and_italics(markdown)

    if re.match(r'\* .*', markdown):
        return f'<ul><li>{markdown[2:]}</li></ul>'

    return f'<p>{markdown}</p>'


def parse(markdown):
    res = ''.join([parse_line(line) for line in markdown.split('\n')])
    return res.replace('</ul><ul>', '')
