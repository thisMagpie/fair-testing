#!/bin/bash

if test -s /usr/bin/java ; then
    echo "Compiling Source Code"
    javac java/*.java
    echo "Done"
    echo "Run Java"
    cd java
    java RunTest
    cd ..
fi

if test -s java/output/exi-population.dat && test -s java/output/existing-grades.tex ; then
    if test -s which pdflatex; then
    echo "Compiling Population Gaussian Graph"
    fi
fi
