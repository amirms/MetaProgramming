![TUDelft logo](http://www.tudelft.nl/fileadmin/Default/Templates/images/logo.gif)

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

As stated before, the project includes several sample analyses, including example files.
Open `src/framework/Framework.java` to see the examples.
If you run the example, you will get the following output.

````
#################################
#                               #
# DEFINITE ASSIGNMENTS ANALYSIS #
#                               #
This is the generated AST:
Procedure(ID(derp),ID(a),[ID(b), ID(c)],Block(Assignment(ID(a),BinaryExpression(+,ID(b),ID(c))))), Assignment(ID(a),4), Assignment(ID(b),ID(a)), IfThenElse(BinaryExpression(==,ID(b),ID(a)),Block(Assignment(ID(b),BinaryExpression(+,ID(b),1)), ProcedureCall(derp,ID(c),[ID(b), ID(a)]), Assignment(ID(d),3)),Block(Assignment(ID(b),BinaryExpression(-,ID(b),1)), Assignment(ID(d),2), Assignment(ID(e),ID(b)))), Assignment(ID(z),BinaryExpression(+,BinaryExpression(+,ID(a),ID(b)),ID(d)))

This is the generated CFG
[From 1 [START] to 17 [Assignment(ID(a),4)]
, From 17 [Assignment(ID(a),4)] to 20 [Assignment(ID(b),ID(a))]
, From 20 [Assignment(ID(b),ID(a))] to 25 [BinaryExpression(==,ID(b),ID(a))]
, From 25 [BinaryExpression(==,ID(b),ID(a))] to 31 [Assignment(ID(b),BinaryExpression(+,ID(b),1))]
, From 25 [BinaryExpression(==,ID(b),ID(a))] to 48 [Assignment(ID(b),BinaryExpression(-,ID(b),1))]
, From 31 [Assignment(ID(b),BinaryExpression(+,ID(b),1))] to 39 [ProcedureCall(derp,ID(c),[ID(b), ID(a)])]
, From 39 [ProcedureCall(derp,ID(c),[ID(b), ID(a)])] to 44 [Assignment(ID(d),3)]
, From 48 [Assignment(ID(b),BinaryExpression(-,ID(b),1))] to 54 [Assignment(ID(d),2)]
, From 54 [Assignment(ID(d),2)] to 57 [Assignment(ID(e),ID(b))]
, From 44 [Assignment(ID(d),3)] to 61 [Assignment(ID(z),BinaryExpression(+,BinaryExpression(+,ID(a),ID(b)),ID(d)))]
, From 57 [Assignment(ID(e),ID(b))] to 61 [Assignment(ID(z),BinaryExpression(+,BinaryExpression(+,ID(a),ID(b)),ID(d)))]
, From 61 [Assignment(ID(z),BinaryExpression(+,BinaryExpression(+,ID(a),ID(b)),ID(d)))] to 2 [END]
]

These are the computed definite assignments
{17=Entry: []; Exit; [[ID(a)]]
, 20=Entry: [[ID(a)]]; Exit; [[ID(a)], [ID(b)]]
, 25=Entry: [[ID(b)], [ID(a)]]; Exit; [[ID(b)], [ID(a)]]
, 31=Entry: [[ID(b)], [ID(a)]]; Exit; [[ID(b)], [ID(a)]]
, 39=Entry: [[ID(b)], [ID(a)]]; Exit; [[ID(b)], [ID(a)], [ID(c)]]
, 44=Entry: [[ID(b)], [ID(a)], [ID(c)]]; Exit; [[ID(b)], [ID(d)], [ID(a)], [ID(c)]]
, 48=Entry: [[ID(b)], [ID(a)]]; Exit; [[ID(b)], [ID(a)]]
, 54=Entry: [[ID(b)], [ID(a)]]; Exit; [[ID(b)], [ID(a)], [ID(d)]]
, 57=Entry: [[ID(b)], [ID(a)], [ID(d)]]; Exit; [[ID(b)], [ID(e)], [ID(a)], [ID(d)]]
, 61=Entry: [[ID(b)], [ID(a)], [ID(d)]]; Exit; [[ID(b)], [ID(a)], [ID(d)], [ID(z)]]
}

#     #
#######

##################################
#                                #
# AVAILABLE EXPRESSIONS ANALYSIS #
#                                #
#                                #

This is the generated AST:
Assignment(ID(x),BinaryExpression(+,ID(a),ID(b))), Assignment(ID(y),BinaryExpression(*,ID(a),ID(b))), While(BinaryExpression(>,ID(y),BinaryExpression(+,ID(a),ID(b))),Block(Assignment(ID(a),BinaryExpression(+,ID(a),1)), Assignment(ID(x),BinaryExpression(+,ID(a),ID(b)))))

This is the generated CFG
[From 1 [START] to 72 [Assignment(ID(x),BinaryExpression(+,ID(a),ID(b)))]
, From 72 [Assignment(ID(x),BinaryExpression(+,ID(a),ID(b)))] to 79 [Assignment(ID(y),BinaryExpression(*,ID(a),ID(b)))]
, From 79 [Assignment(ID(y),BinaryExpression(*,ID(a),ID(b)))] to 87 [BinaryExpression(>,ID(y),BinaryExpression(+,ID(a),ID(b)))]
, From 87 [BinaryExpression(>,ID(y),BinaryExpression(+,ID(a),ID(b)))] to 96 [Assignment(ID(a),BinaryExpression(+,ID(a),1))]
, From 96 [Assignment(ID(a),BinaryExpression(+,ID(a),1))] to 102 [Assignment(ID(x),BinaryExpression(+,ID(a),ID(b)))]
, From 102 [Assignment(ID(x),BinaryExpression(+,ID(a),ID(b)))] to 87 [BinaryExpression(>,ID(y),BinaryExpression(+,ID(a),ID(b)))]
, From 87 [BinaryExpression(>,ID(y),BinaryExpression(+,ID(a),ID(b)))] to 2 [END]
]

These are the computed definite assignments
{72=Entry: []; Exit; [[BinaryExpression(+,ID(a),ID(b))]]
, 79=Entry: [[BinaryExpression(+,ID(a),ID(b))]]; Exit; [[BinaryExpression(*,ID(a),ID(b))], [BinaryExpression(+,ID(a),ID(b))]]
, 87=Entry: [[BinaryExpression(+,ID(a),ID(b))]]; Exit; [[BinaryExpression(>,ID(y),BinaryExpression(+,ID(a),ID(b))), BinaryExpression(+,ID(a),ID(b))], [BinaryExpression(+,ID(a),ID(b))]]
, 96=Entry: [[BinaryExpression(>,ID(y),BinaryExpression(+,ID(a),ID(b))), BinaryExpression(+,ID(a),ID(b))], [BinaryExpression(+,ID(a),ID(b))]]; Exit; []
, 102=Entry: []; Exit; [[BinaryExpression(+,ID(a),ID(b))]]
}

#     #
#######

#################################
#                               #
# REACHING DEFINITIONS ANALYSIS #
#                               #
This is the generated AST:
Assignment(ID(x),5), Assignment(ID(y),1), While(BinaryExpression(>,ID(x),1),Block(Assignment(ID(y),BinaryExpression(*,ID(x),ID(y))), Assignment(ID(x),BinaryExpression(-,ID(x),1))))

This is the generated CFG
[From 1 [START] to 110 [Assignment(ID(x),5)]
, From 110 [Assignment(ID(x),5)] to 113 [Assignment(ID(y),1)]
, From 113 [Assignment(ID(y),1)] to 117 [BinaryExpression(>,ID(x),1)]
, From 117 [BinaryExpression(>,ID(x),1)] to 122 [Assignment(ID(y),BinaryExpression(*,ID(x),ID(y)))]
, From 122 [Assignment(ID(y),BinaryExpression(*,ID(x),ID(y)))] to 129 [Assignment(ID(x),BinaryExpression(-,ID(x),1))]
, From 129 [Assignment(ID(x),BinaryExpression(-,ID(x),1))] to 117 [BinaryExpression(>,ID(x),1)]
, From 117 [BinaryExpression(>,ID(x),1)] to 2 [END]
]

These are the computed definite assignments
{110=Entry: []; Exit; [(ID(x),110)]
, 113=Entry: [(ID(x),110)]; Exit; [(ID(y),113), (ID(x),110)]
, 117=Entry: [(ID(y),113), (ID(x),129), (ID(y),122), (ID(x),110)]; Exit; [(ID(y),113), (ID(x),129), (ID(y),122), (ID(x),110)]
, 122=Entry: [(ID(y),113), (ID(x),129), (ID(y),122), (ID(x),110)]; Exit; [(ID(x),129), (ID(y),122), (ID(x),110)]
, 129=Entry: [(ID(x),129), (ID(y),122), (ID(x),110)]; Exit; [(ID(x),129), (ID(y),122)]
}

#     #
#######
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

