# Alasc: A Logo to ActionScript compiler

Alasc is a simple project we made as lab assignment for the formal languages and compiler class that we took in 2008 at [University of Bergamo](http://www.unibg.it/struttura/en_struttura.asp?cerca=en_dingind_intro).

The idea of Alasc is pretty straightforward: you write [Logo](http://en.wikipedia.org/wiki/Logo_%28programming_language%29) programs and Alasc tranlates them into an [ActionScript](http://en.wikipedia.org/wiki/ActionScript) class. Once you compile the class with your favourite compiler, the swf movie obtained will draw the shape you described in Logo.

Alasc has been revamped in 2015, when Google Code shut down and we decided to to make it a better reusable tool, released under MIT license on Github.

## Building Alasc

Alasc project comes with an Ant script that downloads all the needed tools ([Apache Ivy](http://ant.apache.org/ivy/), [Java Compiler Compiler](https://javacc.java.net/) and other dependencies) and builds the Alasc jar.

Once you cloned this repository, launch ant build:

    ant clean
    ant target

You will find a jar file called alasc.jar in the target folder. Congratulations, you have just built your own copy of Alasc!

## Compiling a Logo program with Alasc

Once you have built the Alasc project, you can start writing your own Logo programs. The compilation process takes two steps: 

1. compile the Logo program to an ActionScript class
2. compile the generated ActionScript class to an SWF movie

Let's start with an included example, the Logo program that will draw a dashed box (examples/e01_repeat.logo).

### From Logo to ActionScript

To compile the Logo file with Alasc, just type:

    java -jar alasc.jar examples/e01_repeat.as
    
This command will generate an ActionScript 3 class inside your current directory.

Alasc can take multiple source files as input:

	java -jar alasc.jar examples/e01_repeat.logo examples/02_selection.logo
	java -jar alasc.jar examples/*.logo
	
For the time being, Alasc supports two options:

* verbose (--verbose, -v) will write a verbose log of compile process
* tos (--tos, -t) will write the table of symbols used when resolving variables name (useful for debugging)

### From ActionScript to SWF

Once you have got your ActionScript files, you may want to compile them to obtain SWF movies. You can use your favourite ActionScript compiler. We suggest mxmlc, provided with the [Apache Flex SDK](http://flex.apache.org/).

    mxmlc e01_repeat.as

## Supported Logo features

As toy project we did not provide support to many advanced Logo features, such as IO. Alasc supports the following Logo instructions.

* FD n:  turtle goes forward of n steps
* BK n: turtle goes backward of n steps
* LT k: turtle turns left of k degrees
* RT k: turtle turns right of k degrees
* CLEAN: clean the screen
* PENUP/PENDOWN: raise the pen up or down
* COLOR c: set the pen color, where c is the RGB value in base 10 (from 0 black to 2^24-1 white)
* MAKE: v: creates a variable with name v
* LET: v k: assign to the variable v the value k

Our Logo dialect supports local variable scoping inside code blocks.

Values can be written as numbers or obtained with simple arithmetical operations:

* SUM a b
* DIFFERENCE a b
* PRODUCT a b
* QUOTIENT a b

We supported flow control instructions (blocks are contained inside square brackets):

* IF binary_condition [ block ]
* REPEAT times [ block ]

Binary conditions supported are:

* LESS a b: true when a < b
* GREATER a b: true when a > b
* EQUAL a b: true when a = b
* NOTEQUAL a b: false when a = b
