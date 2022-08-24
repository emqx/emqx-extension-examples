# emqx-extension-examples

This repository only includes examples of some common programming languages for emqx-exhook and emqx-exproto.

We are pleased to welcome contributions of examples for other  programming languages


**emqx-exhook**

For 5.0:

| Language | Source                                                       |
| -------- | ------------------------------------------------------------ |
| Erlang   | [exhook-svr-erlang](https://github.com/emqx/emqx-extension-examples/tree/for-emqx-v5.0/exhook-svr-erlang) |
| Golang   | [exhook-svr-go](https://github.com/emqx/emqx-extension-examples/tree/for-emqx-v5.0/exhook-svr-go) |
| Java     | [exhook-svr-java](https://github.com/emqx/emqx-extension-examples/tree/for-emqx-v5.0/exhook-svr-java) |
| Python   | [exhook-svr-python](https://github.com/emqx/emqx-extension-examples/tree/for-emqx-v5.0/exhook-svr-python) |


For 4.4:

| Language | Source                                                       |
| -------- | ------------------------------------------------------------ |
| Erlang   | [exhook-svr-erlang](https://github.com/emqx/emqx-extension-examples/tree/for-emqx-v44/exhook-svr-erlang) |
| Golang   | [exhook-svr-go](https://github.com/emqx/emqx-extension-examples/tree/for-emqx-v44/exhook-svr-go) |
| Java     | [exhook-svr-java](https://github.com/emqx/emqx-extension-examples/tree/for-emqx-v44/exhook-svr-java) |
| Python   | [exhook-svr-python](https://github.com/emqx/emqx-extension-examples/tree/for-emqx-v44/exhook-svr-python) |


For 4.3:

| Language | Source                                                       |
| -------- | ------------------------------------------------------------ |
| Erlang   | [exhook-svr-erlang](https://github.com/emqx/emqx-extension-examples/tree/for-emqx-v43/exhook-svr-erlang) |
| Golang   | [exhook-svr-go](https://github.com/emqx/emqx-extension-examples/tree/for-emqx-v43/exhook-svr-go) |
| Java     | [exhook-svr-java](https://github.com/emqx/emqx-extension-examples/tree/for-emqx-v43/exhook-svr-java) |
| Python   | [exhook-svr-python](https://github.com/emqx/emqx-extension-examples/tree/for-emqx-v43/exhook-svr-python) |


**emqx-exproto**

For 4.4:

| Language | Source                                                       |
| -------- | ------------------------------------------------------------ |
| Erlang   | [exproto-svr-erlang](https://github.com/emqx/emqx-extension-examples/tree/master/exproto-svr-erlang) |
| Golang   | -                                                            |
| Java     | [exproto-svr-java](https://github.com/emqx/emqx-extension-examples/tree/master/exproto-svr-java)     |
| Python   | [exproto-svr-python](https://github.com/emqx/emqx-extension-examples/tree/master/exproto-svr-python) |

For 4.3:

| Language | Source                                                       |
| -------- | ------------------------------------------------------------ |
| Erlang   | [exproto-svr-erlang](https://github.com/emqx/emqx-extension-examples/tree/for-emqx-v43/exproto-svr-erlang) |
| Golang   | -                                                            |
| Java     | [exproto-svr-java](https://github.com/emqx/emqx-extension-examples/tree/for-emqx-v43/exproto-svr-java)     |
| Python   | [exproto-svr-python](https://github.com/emqx/emqx-extension-examples/tree/for-emqx-v43/exproto-svr-python) |


## For Legacy Version

***First, we recommend using exhook/exproto on emqx 4.3+ instead of 4.2***

***If you are looking for the exhook/exproto example codes on emqx 4.2,
you should first understand the following notes.***

### Enterprise Edition

We started introducing grpc as an implementation of exhook and exproto in the
enterprise version of e4.2.5. However, due to some early design issues, exproto
has some incompatible designs.

So if you are on Enterprise version 4.2.5 or higher and below 4.3.0,
the exproto example should refer to:

For exproto on e4.2.5+:

| Language | Source |
| -------- | ------ |
| Golang   | -      |
| Java     | [exproto-svr-java](https://github.com/emqx/emqx-extension-examples/tree/master/exproto-svr-java-for-enterpise-e4.2) |
| Python   | -      |

**emqx-exhook**

exhook is compatible with 4.2.5 + and 4.3.x, so you can use the 4.3.x example program directly.

### OpenSource Edition

The open source version in 4.2.x uses `erlport` as the underlying driver instead of grpc.
If you are using exproto and exhook based on the open source version 4.2.x,
please refer to:

- https://github.com/emqx/emqx-exhook
- https://github.com/emqx/emqx-exproto
