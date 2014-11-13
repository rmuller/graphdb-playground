README
======

This repository offers some simple project templates to get started with Graph databases. It will primarily focus on:

+ [Tinkerpop 3](http://www.tinkerpop.com)
+ [Neo4J](http://neo4j.com)
+ [OrientDB](http://www.orientechnologies.com/orientdb)

It you are going to use any information and/or artifacts of this repository, please be aware of the fact that

+ You need a current version of Java installed (Java 7 or better). I highly recommend using Java 8!
+ You need a current version of Maven 3 installed

To test your Java version:

````bash
$ java -version
java version "1.8.0_25"
Java(TM) SE Runtime Environment (build 1.8.0_25-b17)
Java HotSpot(TM) 64-Bit Server VM (build 25.25-b02, mixed mode)
````

To test your maven install (environment variable JAVA_HOME must be defined!):

````bash
$ echo $JAVA_HOME
/usr/lib/jvm/java-8-oracle

$ mvn --version
Apache Maven 3.2.2 (45f7c06d68e745d05611f7fd14efb6594181933e; 2014-06-17T15:51:42+02:00)
Maven home: /usr/share/maven/apache-maven-3.2.2
Java version: 1.8.0_25, vendor: Oracle Corporation
Java home: /usr/lib/jvm/jdk1.8.0_25/jre
Default locale: en_US, platform encoding: UTF-8
OS name: "linux", version: "3.13.0-39-generic", arch: "amd64", family: "unix"
````

or if your JAVA_HOME links to another Java version:

````bash
export JAVA_HOME=/usr/lib/jvm/java-8-oracle && mvn --version
````

