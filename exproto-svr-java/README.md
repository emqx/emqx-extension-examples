# Exproto Java Server

English | [简体中文](README-CN.md)

This example is based on the Exroto Gateway of EMQX v5.1.
It implements the function of message echo to demonstrate how all functions work.

## Prerequisites 

- JDK 1.8 or higher
- Maven
- EMQX 5.1.0 or higher


## Quick start

### Install OpenJDK and Maven (Optional)

You can skip this step, if you have installed JDK and maven.

If not, you can refer to [OpenJDK](https://openjdk.org/) and [Apache Maven 3.9.2](https://maven.apache.org/download.cgi)
to install it

### Use Maven to compile and pack .jar

```
mvn package
```

If it compiled successfully, you can find the `exproto-svr-java-1.0-jar-with-dependencies.jar` in
the `target` directory. i.e:
```
ls target/exproto-svr-java-1.0-jar-with-dependencies.jar
```

### Start ExProto gateway and the compiled gRPC server

1. Make sure you are running EMQX v5.1.0 or above and start the ExProto Gateway with default
   configuration through EMQX Dashboard.

2. Start the gRPC Server using the following command on the same machine as EMQX.
   ```
   java -cp exproto-svr-java-1.0-jar-with-dependencies.jar io.emqx.exproto.ExprotoServer
   ```

3. Use the "telnet" command to simulate a TCP client connecting to the ExProto Gateway's 7993
   listener port. i.e:

   ```
   telnet 127.0.0.1 7993
   ```

4. When trying to type any character in the telnet command, we will find that the server outputs
   it as is, indicating that the entire example has run successfully. For example:

   ```
   $ telnet 127.0.0.1 7993
   Trying 127.0.0.1...
   Connected to 127.0.0.1.
   Escape character is '^]'.
   Hi, this is tcp client!
   Hi, this is tcp client!
   ```

Finally, you can compare the logs output by the gRPC program with the ExProto.java code
and understand how it works.


## Update to the latest exproto.proto

Due to the inconsistency between the exproto.proto file used in this demo and the one included
in your installed version of EMQX, you may need to ensure their consistency.

For example, in EMQX v5.1.0, this file is located at
https://github.com/emqx/emqx/blob/v5.1.0/apps/emqx_gateway_exproto/priv/protos/exproto.proto

You need to manually update it to the `src/main/proto/exproto.proto` location and
regenerate code using either `mvn package` command.
