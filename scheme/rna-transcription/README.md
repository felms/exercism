# RNA Transcription

Welcome to RNA Transcription on Exercism's Scheme Track.
If you need help running the tests or submitting your code, check out `HELP.md`.

## Introduction

You work for a bioengineering company that specializes in developing therapeutic solutions.

Your team has just been given a new project to develop a targeted therapy for a rare type of cancer.

~~~~exercism/note
It's all very complicated, but the basic idea is that sometimes people's bodies produce too much of a given protein.
That can cause all sorts of havoc.

But if you can create a very specific molecule (called a micro-RNA), it can prevent the protein from being produced.

This technique is called [RNA Interference][rnai].

[rnai]: https://admin.acceleratingscience.com/ask-a-scientist/what-is-rnai/
~~~~

## Instructions

Your task is determine the RNA complement of a given DNA sequence.

Both DNA and RNA strands are a sequence of nucleotides.

The four nucleotides found in DNA are adenine (**A**), cytosine (**C**), guanine (**G**) and thymine (**T**).

The four nucleotides found in RNA are adenine (**A**), cytosine (**C**), guanine (**G**) and uracil (**U**).

Given a DNA strand, its transcribed RNA strand is formed by replacing each nucleotide with its complement:

- `G` -> `C`
- `C` -> `G`
- `T` -> `A`
- `A` -> `U`

~~~~exercism/note
If you want to look at how the inputs and outputs are structured, take a look at the examples in the test suite.
~~~~


## Running and testing your solutions


### From the command line

Simply type `make chez` if you're using ChezScheme or `make guile` if you're using GNU Guile\.
Sometimes the name for the scheme binary on your system will differ from the defaults\.
When this is the case, you'll need to tell make by running `make chez chez=your-chez-binary` or `make guile guile=your-guile-binary`\.

### From a REPL

* Enter `(load "test.scm")` at the repl prompt\.
* Develop your solution in `rna-transcription.scm` reloading as you go\.
* Run `(test)` to check your solution\.

### Failed Test Cases

If some of the test cases fail, you should see the failing input and the expected output\.
The failing input is presented as a list because the tests call your solution by `(apply rna-transcription input-list)`\.
To learn more about `apply` see [The Scheme Programming Language -- Chapter 5](https://www.scheme.com/tspl4/control.html#./control:h1)

## Source

### Created by

- @canweriotnow

### Contributed to by

- @cyborgsphinx
- @guygastineau
- @jitwit
- @kytrinyx

### Based on

Hyperphysics - https://web.archive.org/web/20220408112140/http://hyperphysics.phy-astr.gsu.edu/hbase/Organic/transcription.html