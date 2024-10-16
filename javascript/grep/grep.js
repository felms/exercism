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

/**
 * Reads the given file and returns lines.
 *
 * This function works regardless of POSIX (LF) or windows (CRLF) encoding.
 *
 * @param {string} file path to file
 * @returns {string[]} the lines
 */
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

//
// This is only a SKELETON file for the 'Grep' exercise. It's been provided as a
// convenience to get you started writing code faster.
//
// This file should *not* export a function. Use ARGS to determine what to grep
// and use console.log(output) to write to the standard output.

const processArgs = (input) => {
    let [_a, _b, ...args] = input;

    let flags = [];
    let pattern = "";
    let files = [];

    while (args.length > 0) {

        let item = args.shift();

        if (item.startsWith('-')) {
            flags.push(item);
        } else if (item.endsWith('.txt')) {
            files.push(item);
        } else {
            pattern = item;
        }

    }

    return {flags, pattern, files};
};


const processFile = (file, pattern, flags) => {

    if (flags.includes('-x')) {
        pattern = `^${pattern}$`;
    }

    const regex = flags.includes('-i') ? new RegExp(pattern, "i") 
        : new RegExp(pattern);

    let matches = [];

    const predicate = (text) => flags.includes('-v') ? !regex.test(text) : regex.test(text);

    matches = readLines(file)
        .reduce((acc, line, lineNumber) => 
            predicate(line) ? [...acc, `${lineNumber + 1}:${line}`] : acc, []);

    if (flags.includes('-l') && matches.length > 0) {
        return [file];
    }

    if (flags.length == 0 || !flags.includes('-n')) {
        return matches.map(line => line.replace(/^\d+:/, ''));
    }

    return matches;
};


let arg = processArgs(ARGS);

let res = arg.files.map(file => {
    let lines = processFile(file, arg.pattern, arg.flags);
    if (arg.files.length > 1 && !arg.flags.includes('-l')) {
        return lines.map(line => `${file}:${line}`).join('\n');
    }
    return lines.join('\n');
}).filter(r => r.length > 0).join('\n');

console.log(res);

