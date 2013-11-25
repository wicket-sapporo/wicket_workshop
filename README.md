Wicket Workshop
================

This is a sample web-application using [Apache Wicket](http://wicket.apache.org/).

Please check [README_JP.md](./README_JP.md) for details.

Running the project with Maven:

	$ mvn jetty:run

When OutOfMemoryError of PermGen space occurs, set MaxPermSize.

	$ export MAVEN_OPTS="-XX:MaxPermSize=128m"
