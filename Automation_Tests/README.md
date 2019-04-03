Instructions on how to set up and execute the tests
====================================================

Step 1. Install java on the system.
-----------------------------------

- Java 12 is the latest version as of date 3-April-2019
- Go to https://www.oracle.com/technetwork/java/javase/downloads/index.html 
- Click on download for Java SE 12. Java SE Development Kit 12 Downloads page will open. Accept the license agreement.
- Click on dk-12_windows-x64_bin.exe (for 64-bit operating system) and save it on the drive. Install java 12 by double clicking on the exe file and complete the execution.
- Go to Control Panel\System and Security\System
- Click on "Advanced system settings". Click on "Environment Variables". 
- In the section "System variables", create new variable JAVA_HOME and set its value ==> C:\Program Files\Java\jdk-12
- From the section "System variables", select Variable "Path", click on "Edit" and add the new path ==> %JAVA_HOME%\bin

QUICK CHECK:
------------
To check whether Java is successfully installed,
- Open new command prompt and type echo %JAVA_HOME% 
- You should see the result as: C:\Program Files\Java\jdk-12
- On the command prompt type java -version
- You should see the java version installed


Step 2. Install Apache Maven
----------------------------

- go to http://maven.apache.org/download.cgi#Requirements
- Download apache-maven-3.6.0-bin.zip This is the current latest version as of date 3-April-2019
- unzip apache-maven-3.6.0-bin.zip in any directory of your choice. For example, C:
- Go to "Environment variables". In the section "System variables", create new variable M2_HOME and set its value ==> C:\apache-maven-3.6.0
- From the section "System variables", select Variable "Path", click on "Edit" and add the new path ==> %M2_HOME%\bin

QUICK CHECK:
------------

To check whether Maven is successfully installed,
- Open new command prompt and type mvn -version
- It should give you the information about Apache maven version, Maven home directory, java version, java home directory, information related to locale and operating system

Executing the Tests:
--------------------

- Download the project "Automation_Tests" to any directory of your choice. For example, C:
- Open command prompt and go inside the folder "Automation_Tests"
- Type command ==> mvn clean
- Hit enter and wait till the command completes
- Type command ==> mvn compile
- Hit enter and wait till the command completes
- Type command ==> mvn test
- Hit enter and wait till the command completes

Once the test execution is completed, test execution report is created at location:
- Automation_Tests\test-output\ExtentReport.html                                                                                  
