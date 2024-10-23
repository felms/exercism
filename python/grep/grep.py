import re


def grep(pattern: str, flags: list[str], files: list[str]) -> str:
    return ''.join([search_pattern(file, pattern, flags, len(files) > 1)
                     for file in files])


def search_pattern(file: str, pattern: str,
                   flags: list[str], multiple_file_search: bool) -> str:

    pattern_str = f'^{pattern}$' if '-x' in flags else f'.*{pattern}.*'
    f = re.IGNORECASE if '-i' in flags else 0
    the_pattern = re.compile(pattern_str, f)
    input_str = open(file).read().strip()
    output = ''

    for (index, line) in enumerate(input_str.split('\n')):
        if '-v' in flags:
            if not the_pattern.match(line) and '-v' in flags:
                output += (f'{file}:' if multiple_file_search else '') \
                                + (f'{index + 1}:' if '-n' in flags else '') \
                                + line + '\n'

        elif the_pattern.match(line):
            output += (f'{file}:' if multiple_file_search else '') \
                            + (f'{index + 1}:' if '-n' in flags else '') \
                            + line + '\n'

    if output and '-l' in flags:
        output = file + '\n'

    return output
