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

if test -s java/output/recorded-population-grades.dat; then
    echo "Compiling population Gaussian graph using pgfplots"
    pdflatex java/output/existing-grades.tex
    echo "Open the pdf in your browser window now"
fi

# Generate JavaDocs
if test -s /usr/bin/javadoc ; then
    javadoc -d /home/magpie/fair-testing/java/docs -sourcepath /home/magpie/fair-testing/java/*.java -verbose
fi
