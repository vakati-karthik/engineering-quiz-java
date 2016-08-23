# engineering-quiz-java/requestbin

Developers often need to troubleshoot the HTTP requests that a client makes against an endpoint. This project aims to provide a tool that allows for the creation of a "bin": a temporary url, which a client can send HTTP requests to, so that they get recorded for logging purposes.
Another endpoint allows the user to retrieve the list of requests made against this "bin."

Complete the following classes to allow the creation, recording and inspection of HTTP requests:
* src/main/java/com/revinate/requestbin/bin/model/Bin.java
* src/main/java/com/revinate/requestbin/bin/model/Request.java
* src/main/java/com/revinate/requestbin/bin/BinController.java
* src/test/java/com/revinate/requestbin/bin/BinControllerTest

All basic tests in BinControllerTest should execute successfully, but you can add more if you wish. 
Feel free to extend the current solution in any way that you see fit.
