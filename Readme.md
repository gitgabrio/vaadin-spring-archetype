Vaadin Spring Archetype
=======================

Summary
-------
This archetype will create a simple Vaadin + Spring project. The generated application will implement a simple login.

Generated project characteristics
---------------------------------

No-xml Spring MVC 4 web application
Vaadin 7.6.3

Prerequisites
-------------
    JDK 7+
    Maven 3

Create a project
----------------
    mvn archetype:generate \
        -DarchetypeGroupId=net.cardosi \
        -DarchetypeArtifactId=vaadin-spring-archetype \
        -DarchetypeVersion=1.0.0 \
        -DgroupId=my.groupid \
        -DartifactId=my-artifactId \
        -Dversion=version \
        -DarchetypeRepository=http://gitgabrio.github.io/vaadin-spring-archetype

Note: The above command will bootstrap a project using the archetype published here: http://gitgabrio.github.io/vaadin-spring-archetype

Run the project
---------------

Navigate to newly created project directory (my-artifactId) and then run:

    mvn -DskpiTests compile vaadin:compile-theme vaadin:compile tomcat7:run-war
    
Test in the browser
-------------------

http://localhost:8080/my-artifactId

Implementation details
----------------------
For the UI a basic eventbus architecture has been implemented (taking GWT as model) to allow component decoupling.
 
The components are managed by the Spring framework.

About the container
-------------------
The application makes use of the new Servlet 3.0 specification, i.e. it does not use web.xml but it is completely managed by annotation. 
The drawback of this approach is that (currently) it does not run inside the Jetty server (embedded with the GWT environment) so Tomcat should be used for development. 
The generated Readme.md contains detailed instructions on how to cope with that.



