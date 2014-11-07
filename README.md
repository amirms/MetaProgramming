# Monotone framework for Meta Programming

## Why

Meta programming is considered to be the science which concerns programming with programs as data. 
Hence programs are modified and analyzed by other programs.
While unknown to many programmers, these tools are used by themselves on a daily basis;
examples are compiles and debuggers.

Many forms of analyses are possible on any programming language.
However, for most of these special software should be written to perform any analysis.
It is therefore greatly advantageous to have a single framework which is capable of performing several analyses, 
and which can be extended relatively easily to new analyses.
Such a system requires more effort to build, but is easier to maintain, enhance, and extend.
These systems are called _monotone frameworks_ and are the main focus of this assignment.

## How to run

Simple clone the Github project to your PC and start your favorite IDE.
Then open the file `src/framework/Framework`.
Here you can define the file to run on, the analysis to perform and which data you are interested in.

The following outputs may be interesting:

````java
// To get the programs AST
System.out.println(MPWhileListener.FINAL_PROGRAM.astString());

// To get the program CFG
System.out.println(MPWhileListener.FINAL_PROGRAM.internalFlow());

// To perform an analysis
// change the AvailableExpressions to another class which implements Analysis to do other analyses
Analysis rd = new AvailableExpressions(MPWhileListener.FINAL_PROGRAM.internalFlow());
System.out.println(rd.performAnalysis());
````

## How to modify

To modify the parser, one needs [Antlr 4](http://www.antlr.org).
You can change the grammar (located in `src/parser/While.g4`).

Don't forget to parse the Antlr grammar and generate the Java files!
I use the following aliases to make my life easier (change the paths if you must)

````bash
CLASSPATH=".:/opt/local/bin/antlr-4.4-complete.jar:${PATH}"

alias antlr4='java -jar /opt/local/bin/antlr-4.4-complete.jar'
alias antlrc='javac -cp $CLASSPATH'
alias grun='java -cp $CLASSPATH org.antlr.v4.runtime.misc.TestRig'
````

## References

The assignment itself is done for the TUDelft course [IN4313 of Prof. dr. E. Visser](http://www.studiegids.tudelft.nl/a101\_displayCourse.do?course_id=31677) and derived from a Utrecht University [course of dr. J. Hage](http://www.cs.uu.nl/wiki/Apa/DataflowAndAbstractInterpretation).

