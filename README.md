fair-testing
============

## To run java file

The entries are still hard coded for now so all that is needed is to compile

```
cd java

javac *.java
```

Run using

```
java RunTest
```

## To compile the latex standalones

These reside in the java/output/one folder for the first test which is a single subject 100 times assuming a 3% error on their score (arbitrary estimate).

```
cd java/output

pdflatex output-datafile.tex
```
