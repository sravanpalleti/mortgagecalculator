-------------------------------------
SYSTEM REQUIREMENT FOR TEST EXECUTION
-------------------------------------
JDK 1.8,
APACHE MAVEN 3.6.3,
TestNG 6.14.3,
Selenium Server 3.141.59,
Chrome Browser  80.0.3987,
Log4J 1.2.17.


----------------------------------------------------------------------------------------------------------------------------------------
TEST DATA APPROACH
----------------------------------------------------------------------------------------------------------------------------------------
There are multiple approaches to implement the given task and below are few:

1)Providing data in TestNG.xml suite file
TestNG Suite file:  Data is provided using parameter tag having 'name' and 'value' for each class in the XML file,'name' and 'value' can be mapped to
   appropriate TestNG @Test method to pass the variables in method signature and these values can be used as an input data.

2)Data Providers
Creating test data using multi-dimensional array object and mapping it to corresponding @test method
2a)data provider can be created within the same test class. example:@Test(dataProvider = "data-provider")
2b)data provider can be created in a different class and mapped to @test method along with dataprovider class name
example: @Test(dataProvider = "data-provider", dataProviderClass = DataProviderClass.class)

3)Properties file
 Data can be provided in properties file using 'key=value' pair, same can be used by 'load' method of properties class object.

4) Excel file: Using POI API
 POI API gives flexibility to retrieve and insert records from excel sheet(s) by accessing each sheet based on index.

Conclusion: I have chosen properties file approach because it's light weight for the given task.

----------------------------------------------------------------------------------------------------------------------------------------
Framework Design:
----------------------------------------------------------------------------------------------------------------------------------------

I have approached to solve the problem by choosing page object model(POM) using selenium and java as programming language, used maven as a build tool to download dependencies and used log4j for automation execution logs.

----------------------------------------------------------------------------------------------------------------------------------------
HOW TO RUN:
----------------------------------------------------------------------------------------------------------------------------------------

Prerequisite: Please check system requirements above
1. Download and import as maven project into workspace.
2. Execute maven goals using POM.XML file that will download maven dependencies and also triggers the execution of test cases.
NOTE: I have mapped all the test scenarios in suite file(TestNG.XML), the same file has been configured to trigger when POM.xml is executed.
----------------------------------------------------------------------------------------------------------------------------------------
