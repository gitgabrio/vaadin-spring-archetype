#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
${artifactId}
=================
This software is a Vaadin + Spring application. It provide a simple "Login" form and makes use of events to decouple views and components.
The Spring context read run-time properties from ".properties" files inside src/main/config.
This properties are set at compile-time from the maven profile used.

Quick start
-----------
Go to the project directory and issue the command:

      mvn -DskpiTests compile vaadin:compile-theme vaadin:compile tomcat7:run-war

Build
-----
The command to cleanly generate the full war is:
    
       mvn clean compile vaadin:compile-theme vaadin:compile war:war (-DskipTests)

Deploy and run
--------------
Generated war may be deployed in an application server (tested on Tomcat).
It is also possible to run it with the tomcat7 plugin
    
    mvn tomcat7:run-war (-DskipTests) 

Test in the browser
-------------------

http://localhost:8080/${artifactId}

Debug
-----
Debugging client side code
  - run "mvn vaadin:run-codeserver" on a separate console while the application is running
  - activate Super Dev Mode in the debug window of the application

Different options are available for server-side debugging:

+ start a remote server in debug mode (catalina.sh jpda start) and connect to it
+ start the tomcat7:run-war goal in debug mode, and connect to it (default port:5005).

    mvnDebug tomcat7:run-war (-DskipTests)

In the above ways the application start in Vaadin debug mode (i.e. adding "?debug" to the opened page will show the "vaadin debug window".
