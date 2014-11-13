README
======

This Maven project can be used to start developing an embedded OrientDB 2.x Graph database.

To build this project:

````bash
cd orientdb-embedded-graph/
$ mvn clean install
[INFO] Scanning for projects...
[INFO]                                                                         
[INFO] ------------------------------------------------------------------------
[INFO] Building orientdb-embedded-graph 1.0.0-SNAPSHOT
[INFO] ------------------------------------------------------------------------
 
...

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 2.046 s
[INFO] Finished at: 2014-11-13T13:53:51+01:00
[INFO] Final Memory: 16M/205M
[INFO] ------------------------------------------------------------------------
````

Now you can you the example `Main` class

````bash
$ export JAVA_HOME=/usr/lib/jvm/java-8-oracle &&  mvn exec:java -Dexec.mainClass=eu.infomas.research.orientdb.Main
````

Both OrientDB and Maven report some warning, those warnings can be ignored.

Finally you can check the result, using the OrientDB console (should be installed separately)

````
$ ./console.sh 

OrientDB console v.2.0-M2 (build UNKNOWN@r; 2014-09-29 21:06:32+0000) www.orientechnologies.com
Type 'help' to display all the commands supported.
Installing extensions for GREMLIN language v.2.6.0

orientdb> connect plocal:/home/rmuller/orientdb/test admin admin

Connecting to database [plocal:/home/rmuller/orientdb/test] with user 'admin'...OK
orientdb {db=test}> select from V                                         

----+----+------+----+---------+-----------+--------+----+----------
#   |@RID|name  |age |out_knows|out_created|in_knows|lang|in_created
----+----+------+----+---------+-----------+--------+----+----------
0   |#9:0|marko |29  |[size=2] |[size=1]   |null    |null|null      
1   |#9:1|vadas |27  |null     |null       |[size=1]|null|null      
2   |#9:2|lop   |null|null     |null       |null    |java|[size=3]  
3   |#9:3|josh  |32  |null     |[size=2]   |[size=1]|null|null      
4   |#9:4|ripple|null|null     |null       |null    |java|[size=1]  
5   |#9:5|peter |35  |null     |[size=1]   |null    |null|null      
----+----+------+----+---------+-----------+--------+----+----------

6 item(s) found. Query executed in 0.005 sec(s).

````
