# onlinedictionary

This is the online web-application based dictionary project that uses sql dictionary.
The sql dictionary is a open source dictionary found in the internet.

There are only two java file in the project. The first one is DbConnection.java that helps the
application to connect to the MySQL server and the table entries that holds the dictionary.
The second java file is mainServlet.java that takes the request from the browser, build the response
taking help of mysql db and sends the response back to browser in JSON format.

The application use jquery for presenting the content in the browser. The application also makes the
use of ajax call and loading gif has been implemented during the wait period of ajax call.

To use this project you need to import 4 jar files - 3 for converting GSON TO JSON and 1 jar file 
for connecting mysql. The jar file are included in the src folder.

