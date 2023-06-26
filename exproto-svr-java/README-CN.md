# ExProto Java Server Example

[English](README.md) | 简体中文

该示例程序基于 EMQX v5.1 的 ExProto 网关。它实现了消息回声的功能，以展示所有函数是如何工作的。

## 前提

- JDK 1.8 及以上。
- Maven。
- EMQX 5.1.0 及其以上。

## 快速开始

### 安装 JDK 和 Maven（可选）

如果您已经安装了 JDK 和 Maven，则可以跳过此步骤。

否则，您可以参考 [OpenJDK](https://openjdk.org/) 和
[Apache Maven 3.9.2](https://maven.apache.org/download.cgi) 进行安装。

### 使用 Maven 编译并打包 jar 程序

```
mvn package
```

如果编译成功，你可以在 `target` 目录下找到 `exproto-svr-java-1.0-jar-with-dependencies.jar` 文件。
例如：

```
ls target/exproto-svr-java-1.0-jar-with-dependencies.jar
```

### 启动 EMQX 的 ExProto 网关和打包好的 gRPC 服务

1. 确保您正在运行 EMQX v5.1.0 或更高版本，并通过 EMQX Dashboard 使用默认配置启动 ExProto 网关。
2. 在与 EMQX 相同的机器上使用以下命令启动 gRPC 服务器 `exproto-svr-java-1.0-jar-with-dependencies.jar`：
   ```
   java -cp exproto-svr-java-1.0-jar-with-dependencies.jar io.emqx.exproto.ExprotoServer
   ```
3. 使用 telnet 命令模拟 TCP 客户端连接到 ExProto 网关的 7993 监听器端口。例如：
   ```
   telnet 127.0.0.1 7993
   ```
4. 尝试在 telnet 命令中键入任何字符，可以发现服务器会将其原样输出到客户端它，表示整个示例已成功运行。例如：
   ```
   $ telnet 127.0.0.1 7993
   Trying 127 .0 .01...
   Connected to 127 .0 .01.
   Escape character is '^]'.
   Hi, this is tcp client!
   Hi, this is tcp client!
   ```

最后，您可以比较 gRPC 程序输出的日志和 ExprotoServer.java 代码，并了解其工作原理。

## 更新到最新的 `exproto.proto`

由于此演示中使用的 exproto.proto 文件未与你安装的 EMQX 版本中携带的 exproto.proto 同步，所以你可能需要
保持它们的一致性。

以 EMQX v5.1.0 为例，该文件存放在
https://github.com/emqx/emqx/blob/v5.1.0/apps/emqx_gateway_exproto/priv/protos/exproto.proto

你要手动将其更新到 `src/main/proto/exproto.proto` 位置，并使用 `mvn package` 命令重新打包代码。
