VaadinSpringModel
=================

Template for a simple Vaadin + Spring application that show a table bind to a database. It requires a Servlet 3.0 container to run.
sql/vaadinstub.sql contains statement to create the database/table used for test.
To use this project, clone it and then push to a different repository with

    git remote set-url origin (new-repo-git)

Then, search all instances of "VaadinSpringTemplate" (case insensitive) inside Class names, packages, configuration files, xml, etc., and replace them with project-specific, appropriate, ones.



Quick Start
===========
    1. mvn clean
    2. mvn compile
    3. mvn vaadin:compile
    4. war:war
    5. tomcat7:run
OR

     mvn clean compile vaadin:compile-theme vaadin:compile war:war tomcat7:run -DskipTests
     
In the above ways the application start in Vaadin debug mode (i.e. adding "?debug" to the opened page will show the "vaadin debug window".
To have server-side debug mode, start with

    mvnDebug clean compile vaadin:compile-theme vaadin:compile war:war tomcat7:run -DskipTests
then fire a "remote debug" on port 8000.


Workflow
========

To compile the entire project, run "mvn install".
To run the application, run "mvn jetty:run" and open http://localhost:8080/ .

To develop the theme, simply update the relevant theme files and reload the application.
Pre-compiling a theme eliminates automatic theme updates at runtime - see below for more information.

Debugging client side code
  - run "mvn vaadin:run-codeserver" on a separate console while the application is running
  - activate Super Dev Mode in the debug window of the application

To produce a deployable production mode WAR:
- change productionMode to true in the servlet class configuration (nested in the UI class)
- run "mvn clean vaadin:compile-theme package"
  - See below for more information. Running "mvn clean" removes the pre-compiled theme.
- test with "mvn jetty:run-war

Using a precompiled theme
-------------------------

When developing the application, Vaadin can compile the theme on the fly when needed,
or the theme can be precompiled to speed up page loads.

To precompile the theme run "mvn vaadin:compile-theme". Note, though, that once
the theme has been precompiled, any theme changes will not be visible until the
next theme compilation or running the "mvn clean" target.

When developing the theme, running the application in the "run" mode (rather than
in "debug") in the IDE can speed up consecutive on-the-fly theme compilations
significantly.

Remember to put/update the theme name inside the web.xml

        <servlet>
                <servlet-name>application</servlet-name>
                <servlet-class>com.vaadin.server.VaadinServlet</servlet-class>
               ...
                <init-param>
                    <param-name>theme</param-name>
                    <param-value>mytheme</param-value>
                </init-param>
        </servlet>