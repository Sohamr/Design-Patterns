CS542 Design Patterns
Fall 2014
PROJECT <Final(4)> README FILE

Due Date: <Monday, December 15, 2014>
Submission Date: <Monday, December 15, 2014>
Grace Period Used This Project: <0> Days
Grace Period Remaining: <0> Days
Author(s): <Soham Rohankar> 
e-mail(s): <srohank1@binghamton.edu> 


PURPOSE:


  The purpose of this project is to implement dynamic proxy using
  reflection and strategy pattern. We use strategy to Serialize- write
  class objects to XML file or Deserialize - Read from XML and create
  class objects. We compare the object vectors for serialized and 
  deserialized objects and print mismatched number of objects.
  

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

	genericCheckpointing.driver
	Driver.java - 
	genericCheckpointing.server - Interfaces
	/RestoreI.java
	/StoreI.java
	/StoreRestoreI.java 
	genericCheckpointing.util - Utilities
	/MyAllTypesFirst.java
	/MyAllTypesSecond.java
	/ProxyCreator.java		- Creates proxy
	/SerializableObject.java	- Empty class
	genericCheckpointing.xmlStoreRestore
	/StoreRestoreHandler.java	-	Invocation handler
	xmlStrategies
	/StrategyI.java	- Strategy interface
	/XMLDeserializableStrategy.java
	/XMLSerializableStrategy.java


SAMPLE OUTPUT:

bingsuns2% ant run -Darg1=4 -Darg2=checkpoint.txt -Darg3=deser
Buildfile: build.xml

jar:

run:
     [java] 0 Mismatched Objects 

BUILD SUCCESSFUL
Total time: 1 second
bingsuns2% 

  
TO COMPILE:

  1. Go to genericCheckpointing directory using command cd genericCheckpointing
  2. ant clean
  3. ant compile

TO RUN:
  
  Format       :	<Num of objects> <Input file> <Strategy>
  Please run as:	ant run -Darg1=4 -Darg2=checkpoint.txt -Darg3=serdeser

EXTRA CREDIT:

	N/A
 

BIBLIOGRAPHY:
Project team:

  

ACKNOWLEDGEMENT:  
	N/A
