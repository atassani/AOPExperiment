AOP Exeperiment
===============

...


Executing
---------

After discovering dependencies with
	
	mvn dependency:tree
	
and
	
	mvn dependency:build-classpath

	java -cp \
	/Users/atassani/.m2/repository/org/springframework/spring-core/3.2.3.RELEASE/spring-core-3.2.3.RELEASE.jar:\
	/Users/atassani/.m2/repository/org/springframework/spring-beans/3.2.3.RELEASE/spring-beans-3.2.3.RELEASE.jar:\
	/Users/atassani/.m2/repository/org/springframework/spring-context/3.2.3.RELEASE/spring-context-3.2.3.RELEASE.jar:\
	/Users/atassani/.m2/repository/commons-logging/commons-logging/1.1.1/commons-logging-1.1.1.jar:\
	/Users/atassani/.m2/repository/org/springframework/spring-expression/3.2.3.RELEASE/spring-expression-3.2.3.RELEASE.jar:\
	/Users/atassani/.m2/repository/org/springframework/spring-context-support/3.2.3.RELEASE/spring-context-support-3.2.3.RELEASE.jar:\
	/Users/atassani/.m2/repository/org/springframework/spring-aop/3.2.3.RELEASE/spring-aop-3.2.3.RELEASE.jar:\
	/Users/atassani/.m2/repository/aopalliance/aopalliance/1.0/aopalliance-1.0.jar:\
	/Users/atassani/.m2/repository/org/aspectj/aspectjrt/1.7.3/aspectjrt-1.7.3.jar:\
	/Users/atassani/.m2/repository/org/aspectj/aspectjweaver/1.7.3/aspectjweaver-1.7.3.jar:\
	/Users/atassani/.m2/repository/javax/inject/javax.inject/1/javax.inject-1.jar:\
	/Users/atassani/.m2/repository/cglib/cglib-nodep/3.1/cglib-nodep-3.1.jar:\
	/Users/atassani/.m2/repository/org/springframework/spring-instrument/3.2.3.RELEASE/spring-instrument-3.2.3.RELEASE.jar:\
	app/target/app-1.0.0.jar:\
	module/target/module-1.0.0.jar\
	 com.tonitassani.aopexperiment.app.App
	 	 
	 
Directly using the `exec:java` plugin with the created profile `exec-app`, defined in `app` module. 
The execution goal will be run in the `install` phase, and it will use the Spring instrumentation (`-javaagent`).
It is easier than building the whole execution command line.  

Profiles
--------

To list all the available profiles in Maven you can run

	mvn help:active-profiles
	
and
	
	mvn help:all-profiles
	
Activate AOP
------------
In app/main/resources/applicationContext.xml the heading has to contain AOP references:

    xmlns:aop="http://www.springframework.org/schema/aop"

and

    http://www.springframework.org/schema/aop 		http://www.springframework.org/schema/aop/spring-aop-3.0.xsd

	