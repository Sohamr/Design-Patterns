CS542 Design Patterns
Fall 2014
PROJECT <PROJECT 3> README FILE

Due Date: <Tuesday, November 4, 2014>
Submission Date: <Tuesday, November 4, 2014>
Grace Period Used This Project: <0> Days
Grace Period Remaining: <0> Days
Author(s): <Soham Rohankar>
e-mail(s): <srohank1@binghamton.edu> 


PURPOSE:

 The basic idea of the project is to create a Binary Search Tree and create and
 maintain its backup trees via Observer pattern.
 
 The driver class creates a Creates a BSTBuilder object, and passes it with a 
 file object and 2 - for creating 2 backup trees as parameters.
 The BSTBuilder creates trees, subject and observers, and register observers.
 The driver then calls the printTree, updateTree methods on BSTBuilder instance
PERCENT COMPLETE:

 I believe I have completed 100% of this project.

PARTS THAT ARE NOT COMPLETE:

 I believe the project is complete.

BUGS:

 None.


FILES:

  Below are the files that are necessary for the project to run:
  
 Package studentRecordsBackup.bst
1.) Node.java
2.) Tree.java
3.) TreeI.java

 Package studentRecordsBackup.driver
1.) Driver.java 

 Package studentRecordsBackup.observerP
1.) ObserverI.java
2.) SubjectI.java

 Package studentRecordsBackup.util
1.) BSTBuilder.java - Creates BST's, prints them, and prints sum of 
						all nodes.
2.) GenerateBnumbers.java - To generate input file

build.xml - The ANT uses this file to compile and run the project

README - The file you are currently reading
  
SAMPLE OUTPUT:

bingsuns2% ant run -DDebug=1
Buildfile: build.xml

jar:
    [mkdir] Created dir: /u0/users/0/srohank1/DP/dp2/myComputerManual/build/jar
    [jar] Building jar: /u0/users/0/srohank1/DP/dp2/myComputerManual/build/jar/
						myComputerManual.jar

run:

     [java]      **********User Manual**********

     [java]     **********Index**********
     [java] 1.) AMD FX-8350 Eight-Core CPU                      1
     [java] 2.) Intel i5-4770 processor quad-core               4
     [java] 3.) 1TB 7200 RPM SATA Hard Drive            		7
     [java] 4.) Intel HD Graphics                               11
     [java] 5.) 64 Bit Windows 10 Operating System              14
     [java] 6.) HP  20" Widescreen LCD               			18



 
BUILD SUCCESSFUL
Total time: 25 second
bingsuns2% 

TO COMPILE:

	Make sure you are in studentRecordsBackup folder (In the folder containing build.xml)

	cd Soham_Rohankar_assign2/srohank1/studentRecordsBackup/
		
	Please Compile as:
		ant compile
		
		or 
		
		ant clean
		ant compile
		
TO RUN:

  To run the program, it needs 2 arguments.

  Please run as: ant run -Darg0=<Input File Name> -Darg1=<Update value>
						 
  Example : ant run -Darg0=bstInput.txt -Darg1=10 

EXTRA CREDIT:



BIBLIOGRAPHY:

This serves as evidence that we are in no way intending Academic Dishonesty.
<Soham Rohankar>

  * http://stackoverflow.com/
  * http://www.tutorialspoint.com/
  * Head First Design Patterns Book
  * http://algs4.cs.princeton.edu/32bst
  http://cslibrary.stanford.edu/110/BinaryTrees.html
  
ACKNOWLEDGEMENT:


