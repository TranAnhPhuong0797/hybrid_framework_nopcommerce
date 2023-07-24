set ProjectPath=%~dp0
cd %ProjectPath%
set p=%PATH%
java -javaagent:"%ProjectPath%libAllure\aspectjweaver-1.9.8.jar" -classpath "%ProjectPath%bin;%ProjectPath%libAllure\*;%ProjectPath%libAllureReport\*;%ProjectPath%libExtendReportV5\*;%ProjectPath%libraryLog4j\*;%ProjectPath%libWeddriverManager\*;%ProjectPath%libReportNG\*;%ProjectPath%librariesSelenium\*" org.testng.TestNG "%ProjectPath%bin\rrunNopcommerceTest.xml"
pause