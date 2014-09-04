AOP Exeperiment
===============

This project contains simple examples of using AOP in Java. All experiments are *Java*, *Spring Framework* and built 
with *Maven*.

Code consists on:

* **module**: The basic module that will be intercepted by AOP. As long as I found that AOP is harder for classes that 
do not have default constructor, there are two module classes, one with default constructor and another without. Both classes
contain just one method that sums two integers (a+b)

* **springaop**: Contains the implementation of Aspects using Spring AOP Proxies. The aspect is an Around advice that modifies 
the sum to be (a+2)+(b+3).

* **aspecjaop**: Contains the implementation of Aspects using AspectJ and Load Time Weaving (LTW). The implementation is similar
as in `springaop` project.

* **app**: An standalone Java application that uses the Module and performs a sum(3,5) using both classes (with and without 
constructor). If built with the `exec-app` profile, it will execute the application. If built with the `springaop` profile, 
it will include the Aspects in that module, and same thing will happen with `aspectjaop`. You cannot use woth AOP implementations
in this example. In each case the application will use a different `applicationContext.xml` file.
Initially, instead of an application, Unit Tests were used, but they used a different flow for managing dependencies and Java Agent, so 
now it is a regular Application, even though the code for tests is still there.
The execution including the JavaAgent in the LTW example is managed in the `pom.xlm`.

* **webapp**: A Web application using the module. It has only be tested in JBoss 5.1.0.GA. LTW is not working.

* **module-woven**: Generates module code with aspects inside using AspectJ's Compile Time Weaving (CTW).

* **app-woven**: Defines the profile `exec-app-woven` that executes `app` with the woven module.

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

In the `exec-app` profile it has been added an execution of `maven-antrun-plugin` to show the classpath.

Profiles
--------

To list all the available profiles in Maven you can run

	mvn help:active-profiles
	
and
	
	mvn help:all-profiles
	
Activate Spring AOP
-------------------
In app/main/resources/applicationContext.xml the heading has to contain AOP references:

    xmlns:aop="http://www.springframework.org/schema/aop"

and

    http://www.springframework.org/schema/aop 		http://www.springframework.org/schema/aop/spring-aop-3.0.xsd

For Spring AOP also in `applicationContext.xml` there must be the following: `<aop:aspectj-autoproxy />`

Activate LTW AspectJ AOP
------------------------
`aop` namespace has to be included in applicationContext.xml like in Spring AOP.
You have to include in the same file also

	<context:spring-configured/>
	
so that AspectJ can be used. Documentation can be found in [Spring documentation](http://docs.spring.io/autorepo/docs/spring/3.0.6.RELEASE/spring-framework-reference/html/aop.html).


You also have to enable	Load Time Weaving:

	<context:load-time-weaver  aspectj-weaving="autodetect"/>
	
Apart, you have to run the application with the proper `javaagent`:

	-javaagent:/tmp/spring-instrument-3.2.3.RELEASE.jar		


Debugging JBOSS
---------------
Just for debugging JBOSS and seeing what is being weaved I have tried different options. These are some arguments I have been playing with:

	export JAVA_OPTS="-Xms256m -Xss512m -Xmx512m -Djava.awt.headless=true -XX:MaxPermSize=256m -server -Daj.weaving.verbose=true -Dorg.aspectj.weaver.loadtime.configuration=META-INF/aop.xml -Dorg.aspectj.weaver.showWeaveInfo=true -Dorg.aspectj.tracing.enabled=true -Dorg.aspectj.tracing.factory=default"

However, JBOSS with AspectJ is not working for me in JBoss 5.1.

Examples
--------

* [AspectJ Examples](https://github.com/jbellmann/aspectj-examples). Interesting POM for CTW.
* [AspectJ more Examples](https://github.com/jesperfj/tomcat7-maven-plugin-sample/blob/master/pom.xml)	
	