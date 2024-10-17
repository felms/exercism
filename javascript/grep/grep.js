#!/usr/bin/env node

// The above line is a shebang. On Unix-like operating systems, or environments,
// this will allow the script to be run by node, and thus turn this JavaScript
// file into an executable. In other words, to execute this file, you may run
// the following from your terminal:
//
// ./grep.js args
//
// If you don't have a Unix-like operating system or environment, for example
// Windows without WSL, you can use the following inside a window terminal,
// such as cmd.exe:
//
// node grep.js args
//
// Read more about shebangs here: https://en.wikipedia.org/wiki/Shebang_(Unix)

const fs = require('fs');
const path = require('path');

function readLines(file) {
    const data = fs.readFileSync(path.resolve(file), { encoding: 'utf-8' });
    return data.split(/\r?\n/);
}

const VALID_OPTIONS = [
    'n', // add line numbers
    'l', // print file names where pattern is found
    'i', // ignore case
    'v', // reverse files results
    'x', // match entire line
];

const ARGS = process.argv;

const processFile = (file, pattern, flags, searchMultipleFiles) => {

    const regex = new RegExp(
        flags.includes('-x') ? `^${pattern}$` : pattern, 
        flags.includes('-i') ? 'i' : '' );

    let matches = [];

    const predicate = (text) => flags.includes('-v') ? !regex.test(text) : regex.test(text);
    const assemble = (line, lineNumber) => (searchMultipleFiles ? `${file}:` : '') 
        + (flags.includes('-n') ? `${lineNumber}:${line}` : line);

    matches = readLines(file)
        .reduce((acc, line, lineNumber) => 
            predicate(line) ? [...acc, assemble(line, lineNumber + 1)] : acc, []);

    if (flags.includes('-l') && matches.length > 0) {
        return file;
    }

    return matches.join('\n');
};

let args = ARGS.slice(2);

const isFile = (item) => item.match(/\w+\.txt/);
const isFlag = (item) => item.startsWith('-');
const flags = args.filter(isFlag);
const files = args.filter(isFile);
const pattern = args.filter(item => !isFile(item) && !isFlag(item));


let res = files.map(file => 
    processFile(file, pattern, flags, files.length > 1))
               .filter(r => r.length > 0).join('\n');

console.log(res);

