# FizzBuzz HTTP API Game

FizzBuzz Game created with Spring Initializr and Eclipse IDE

**INSTRUCTIONS ON RUNNING LOCALLY**

STEP 1: RUNNING THE APPLICATION

 - Download the executable JAR file called fizzbuzz-0.0.1-SNAPSHOT.jar. 
 - Open terminal/cmdprompt and navigate to directory of JAR file. 
 - Type the following command: java -jar fizzbuzz-0.0.1-SNAPSHOT.jar
 - The application will boot.

STEP 2: USING THE APPLICATION

Can be used with the User Interface at localhost:8080 on any browser (follow on screen instructions).

OR

 - Make direct Get or Post requests with something like Postman
 - url = localhost:8080/fizzbuzz
 - Parameters key and value pair where:
 - key='content' and value='{number(s) separated by a semicolon}'
 - EXAMPLE GET REQUEST: key='content' AND value='1;2;3;5;10;15;'

OR Simplest alternative

 - You can try the Get request on your browser just by typing url
 - For example type localhost:8080/fizzbuzz?content=1;3;5;8;15 in Chrome and press enter

STEP 3: RESULT

The UI will display the FizzBuzzed string, numbers and words separated by a semicolon. A link wil be provided to the plain text response as well. On errors, error messages received and user can make new input.

Making direct Post requests will result in an html response. Making a direct Get request will result in plain text response.
