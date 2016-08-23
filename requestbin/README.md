# engineering-quiz-java/requestbin

We often need to troubleshoot the HTTP requests that a client make against an endpoint. This project aim to provide a tool that allow the creation of a "Bin": a temporary url, where a client can send HTTP request that got recorded.
Then another endpoint allow to retrieve the list of requests made against this "Bin".

Complete the following classes:
* src/main/java/com/revinate/requestbin/bin/model/Bin.java
* src/main/java/com/revinate/requestbin/bin/model/Request.java
* src/main/java/com/revinate/requestbin/bin/BinController.java
* src/test/java/com/revinate/requestbin/bin/BinControllerTest
to allow the creation, recording and inspection of such Bin.

All basic tests in BinControllerTest should execute successfully, but you can add more if you whish. You can also extend the current solution in any way you want.

