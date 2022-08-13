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



// Processando o input

let params = ARGS.slice(2); // Só essa parte dos argumentos me interessa
let pattern = params.filter(item => !(/(.+\.txt$)|(^-.+)/g.test(item)));
let flags = params.filter(item => /^-.+/g.test(item));
let files = params.filter(item => /.+\.txt$/g.test(item));

let addLineNumbers = flags.includes('-n');
let printFileNames = flags.includes('-l');
let ignoreCase = flags.includes('-i');
let reverseResults = flags.includes('-v');
let matchEntireLine = flags.includes('-x');


// Procurando pelos matches no arquivo
const searchForMatches = (file, multipleFiles) => {
  let match = '';
  let lineNumber = 1;

  let lines = readLines(file);
  lines.forEach(line => {

    let m = '';
    if (ignoreCase) {
      let p = matchEntireLine ? `^${pattern}$` : pattern;
      let regex = new RegExp(p, 'i');

      if (reverseResults) {
        if (!regex.test(line)) {
          if (printFileNames) {
            m += file;
          } else {
            m += multipleFiles ? file + ':' : '';
            if (addLineNumbers){
              m += `${lineNumber}:`;
            }
            m += line;
          }
        }

      } else if (regex.test(line)) {
        if (printFileNames) {
          m += file;
        } else {
          m += multipleFiles ? file + ':' : '';
          if (addLineNumbers){
            m += `${lineNumber}:`;
          }
          m += line;
        }
      }

    } else {
      let p = matchEntireLine ? `^${pattern}$` : pattern;
      let regex = new RegExp(p);

      if (reverseResults) {
        if (!regex.test(line)){
          if (printFileNames) {
            m += file;
          } else {
            m += multipleFiles ? file + ':' : '';
            if (addLineNumbers){
              m += `${lineNumber}:`;
            }
            m += line;
          }
        }

      } else if (regex.test(line)){
        if (printFileNames) {
          m += file;
        } else {
          m += multipleFiles ? file + ':' : '';
          if (addLineNumbers){
            m += `${lineNumber}:`;
          }
          m += line;
        }
      }
    }

    lineNumber++;
    let regex = new RegExp(m);
    if (m.length > 0 && !regex.test(match)) {
      match += m + '\n';
    }

  });

  return match = match.trim();
};

// Gerando e formatando o output
let multipleFiles = files.length > 1;
let output = '';
files.forEach(file => {
  let result = searchForMatches(file, multipleFiles)
  if (result.length > 0) {
    output += result + '\n';
  }
});
console.log(output);

