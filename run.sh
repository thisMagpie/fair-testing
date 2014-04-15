#!/bin/bash


for i in *; do
  if [ -d $i ]; then
    cd $i;
    if [[ -n 'ls | grep *.log' ]]; then
      echo -n " " $i-; rm *.log; echo -n;
    fi
    if [[ -n 'ls | grep *.aux' ]]; then
      echo -n " " $i-; rm *.aux; echo -n;
    fi
    if [[ -n 'ls | grep *.class' ]]; then
      echo -n " " $i-; rm *.class; echo -n;
    fi
    if [[ -n 'ls | grep *.*~' ]]; then
      echo -n " " $i-; rm *.*~; echo -n;
    fi
    cd ..
  fi
done

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
