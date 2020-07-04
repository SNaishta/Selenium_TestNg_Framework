**# Sauce Demo-Webapp**
Sauce Demo Selenium Automation Framework

SETUP
Please follow the below steps as a pre-requisite for running the automation scripts 

- Download Java
- Download Maven
- Download IntelliJ IDE
- Download Latest version of selenium
- Download Node.js
- Create git account to access the automation repository

Set the path in your bash profile
******************* Sample ******************* 

Bash Profile
export JAVA_HOME=$(/Library/Java/JavaVirtualMachines/jdk1.8.0_172.jdk/Contents/Home)
export PATH=$PATH:$JAVA_HOME/bin
export PATH=$PATH:$JAVA_HOME/jre

export M2_HOME=$(/usr/local/Cellar/maven/3.5.3/libexec)
export M2=$M2_HOME/bin

export MAVEN_OPTS=-Xms256m -Xmx512m
export PATH=$M2:$PATH


Clone or download the project from Github link ->

Framework Features
------------------------------------------------------------------------------------------------------------------
1. System used for configuration and scripting - MAC OS.
2. This is a TestNg framework, designed pattern is Page Object Model and written in Java. Command line execution with tags
3. This framework uses Threadlocal property. Execution will progress in parallel on Chrome and Firefox if its installed on your system.
4. Behaviour driver development style of test case, parameterised feature files.
5. All assertion in Step definition files.
6. Project params saved on enums.
7. Minimal test data , thereby used properties file rather than CSV.
8. Logging libraries Log4j and cucumber reports in place.
9. Have used dependency Injection to instantiate classes.
10. SauceDemo website testing, there isn’t any data fetch /loading so have not included any sort of fluent waits. 
11. Used io.github.bonigarcia maven dependency for internally configuring and managing of driver.exe rather having exe files on the framework.

Also, ** Please note: I have not included any configurations for docker or selenium Grid as this framework is only designed to run locally on individual machines.

Running the scripts via command line:
Local: mvn clean verify -P SauceDemo -Dtags=@EndToEnd

Reports are generated within target folder
/target/cucumber-reports/cucumber-html-reports/overview-features.

http://localhost:63343/saucedemoAssessment/target/cucumber-reports/cucumber-html-reports/overview-features.html
http://localhost:63343/saucedemoAssessment/target/cucumber-reports/cucumber-html-reports/overview-tags.html

Exception logs can be found in folder path
project directory/logs/SauceDemo_automation.log.


**Execution Flow**
---------------------------------------------------------------------------------------------------------------------------------
Execution starts from POM file , reads the name from the profile and identifies the testNg xml file path from the tag
 <suiteXmlFile>src/test/resources/runner/testNg.xml</suiteXmlFile>

TestNg.xml file has configuration for Tests to run on N number of browsers, instance, classes or methods.
It then navigates to classes which invokes selenium Webdriver locally or on Grid/Docker using RemoteWedriver.

Feature files can be found in (src/test/java/resources/features)

The following are descriptions of some classes that might be of interest to you.

DriverHelper - acts as middleman between the Selenium driver instance and the framework. 
Useful functionality is added as methods of the class, such as click(...) and isPageDisplayed(...) methods. 
It is recommended that you add any general functionality / actions that are used across multiple pages onto here, and create an instance of it in all action pages. 


Pages
The framework is built using the Page Object Design Pattern, and the classes are split up in the following ways.

Objects
Object classes (found in src/test/java/pages/objects) contain Java classes that encapsulate selectors for specific pages of the app. These form as bases for the action Java classes, which then make use of these selectors to define functions that the test framework will make use of.

Actions
Action classes (found in src/test/java/pages/actions) contain Java classes that encapsulate functions and actions for specific pages of the app. These extend their Object Java class counterparts, so no selectors should be defined here.