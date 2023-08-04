# Test Webapp
Simple Java Web Application for DevOps pipeline testing

## How to Build
Use maven to build the application.

The following command compiles the java sources, executes the unit tests, and
generates an executable jar file of the application:

```
$ mvn clean package
```

## Unit testing
Use maven to run the unit tests:

```
$ mvn clean test
```


## Running the web app
To run the web app from the command line, type:

```
$ cd target
$ java -jar testwebapp-1.0.jar -p8080
```

where 8080 is the HTTP port to bind to. (Note that binding to port 80 requires root rights.)

The expected output is the following:

```
$ java -jar testwebapp-1.0.jar -p8080
WARNING: sun.reflect.Reflection.getCallerClass is not supported. This will impact performance.
2022-07-13 20:13:24,666 INFO  [testwebapp.TestWebApp] [main] Port set to: 8080
2022-07-13 20:13:24,682 INFO  [org.eclipse.jetty.util.log] [Thread-0] Logging initialized @379ms to org.eclipse.jetty.util.log.Slf4jLog
2022-07-13 20:13:24,712 INFO  [spark.embeddedserver.jetty.EmbeddedJettyServer] [Thread-0] == Spark has ignited ...
2022-07-13 20:13:24,712 INFO  [spark.embeddedserver.jetty.EmbeddedJettyServer] [Thread-0] >> Listening on 0.0.0.0:8080
2022-07-13 20:13:24,714 INFO  [org.eclipse.jetty.server.Server] [Thread-0] jetty-9.4.z-SNAPSHOT; built: 2019-04-29T20:42:08.989Z; git: e1bc35120a6617ee3df052294e433f3a25ce7097; jvm 16.0.1+9-24
2022-07-13 20:13:24,747 INFO  [org.eclipse.jetty.server.session] [Thread-0] DefaultSessionIdManager workerName=node0
2022-07-13 20:13:24,748 INFO  [org.eclipse.jetty.server.session] [Thread-0] No SessionScavenger set, using defaults
2022-07-13 20:13:24,751 INFO  [org.eclipse.jetty.server.session] [Thread-0] node0 Scavenging every 600000ms
2022-07-13 20:13:24,770 INFO  [org.eclipse.jetty.server.AbstractConnector] [Thread-0] Started ServerConnector@66b9f639{HTTP/1.1,[http/1.1]}{0.0.0.0:8080}
2022-07-13 20:13:24,771 INFO  [org.eclipse.jetty.server.Server] [Thread-0] Started @468ms
```

Open ``http://localhost:8080`` in the browser to verify that the web app is running. The expected output is "Hello World!".


## Running as a systemd service
The following steps are required to start the application on system bootup:
- copy the the systemd service file ``systemd/testwebapp.service`` to the target host's /etc/systemd/system directory
- copy the jar file to ``/opt/testwebapp/lib/java/testwebapp-1.0.jar``
- issue the ``sudo systemctl daemon-reload`` commmand
- enable the service with ``sudo systemctl enable testwebapp``
- start the service with ``sudo systemctl start testwebapp``
