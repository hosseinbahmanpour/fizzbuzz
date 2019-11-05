# fizzbuzz

FizzBuzz Game created with Spring Initializr and Eclipse IDE

INSTRUCTIONS ON RUNNING LOCALLY

STEP 1: RUNNING THE APPLICATION

Download the executable JAR file found in the GitHub repository folder "target".
The file is called fizzbuzz-0.0.1-SNAPSHOT.jar.
Open terminal/cmdprompt and navigate to directory of JAR file.
Type the following command: java -jar fizzbuzz-0.0.1-SNAPSHOT.jar
The application will boot.

STEP 2: USING THE APPLICATION

Can be used with the User Interface at localhost:8080 on any browser (follow on screen instructions).

OR

Send an http POST request (you can use Postman application on Chrome for example) as follows:
url = localhost:8080/fizzbuzz 
Parameters key and value pair where key='content' and value='{number(s) separated by a semicolon}':
EXAMPLE POST REQUEST:
key='content'
value='1;2;3;5;10;15;'

STEP 3: RESULT

The http api will return a plain text response where numbers and words are separated by a semicolon.
