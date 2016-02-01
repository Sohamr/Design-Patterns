CS542 Design Patterns
Fall 2014
PROJECT <5> README FILE

Due Date: <Friday, November 21, 2014>
Submission Date: <Friday, November 21, 2014>
Grace Period Used This Project: <0> Days
Grace Period Remaining: <0> Days
Author(s): <Anurag Baronia,Soham Rohankar> 
e-mail(s): <abaroni1@binghamton.edu,srohank1@binghamton.edu> 


PURPOSE:


  The purpose of this project is to implement visitor pattern to sort data
  stored in vector and arraylist by visiting heap and bubble sort.

PERCENT COMPLETE:

   I believe I have completed 100% of this project


PARTS THAT ARE NOT COMPLETE:

  None.

BUGS:

  None.

FILES:

  Included with this project are  8 files:

  
  build.xml, to build and run the project
  README, the text file you are presently reading
  

 src -  directory which contains all the source code files(.java files) used in the project.
maxKVisitors.driver
  Driver.java
maxKVisitors.util
  ADTI.java
  ADTVisitor.java
  FileProcessor.java
  GenerateInput.java
  Logger.java
  LogType.java
  MaxHeap.java
  MaxHeapVisitor.java
  ModifiedBubbleSortVisitor.java
  MyArray.java
  MyVector.java
  VisitorI.java  


SAMPLE OUTPUT:

	 [java] Heap sort on MyVector
     [java] 645656
     [java] 565656
     [java] 557575
     [java] 56463
     [java] 54546
     [java] Heap sort on MyArray
     [java] 645656
     [java] 565656
     [java] 557575
     [java] 56463
     [java] 54546
     [java] Bubble sort on MyVector
     [java] 645656
     [java] 565656
     [java] 557575
     [java] 56463
     [java] 54546
     [java] Bubble sort on MyArray
     [java] 645656
     [java] 565656
     [java] 557575
     [java] 56463
     [java] 54546

  
TO COMPILE:

  1. Go to maxKVisitors directory using command cd maxKVisitors
  2. ant clean
  3. ant compile

TO RUN:
  
  Format       :  <Input file> <k value> <Debug value>
  Please run as:  ant run -Darg1=Input.txt -Darg2=5 -Darg3=1

EXTRA CREDIT:

	N/A
 

BIBLIOGRAPHY:
Project team: Anurag Baronia, Soham Rohankar

MaxHeap code:http://www.cs.bu.edu/~snyder/cs112/CodeExamples/MaxHeap.java
BubbleSort:http://stackoverflow.com/questions/16195092/optimized-bubble-sort-java
  

ACKNOWLEDGEMENT:  
	N/A
