from google.protobuf.internal import containers as _containers
from google.protobuf.internal import enum_type_wrapper as _enum_type_wrapper
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from typing import ClassVar as _ClassVar, Iterable as _Iterable, Mapping as _Mapping, Optional as _Optional, Union as _Union

CONN_PROCESS_NOT_ALIVE: ResultCode
DESCRIPTOR: _descriptor.FileDescriptor
DTLS: SocketType
KEEPALIVE: TimerType
PARAMS_TYPE_ERROR: ResultCode
PERMISSION_DENY: ResultCode
REQUIRED_PARAMS_MISSED: ResultCode
SSL: SocketType
SUCCESS: ResultCode
TCP: SocketType
UDP: SocketType
UNKNOWN: ResultCode

class Address(_message.Message):
    __slots__ = ["host", "port"]
    HOST_FIELD_NUMBER: _ClassVar[int]
    PORT_FIELD_NUMBER: _ClassVar[int]
    host: str
    port: int
    def __init__(self, host: _Optional[str] = ..., port: _Optional[int] = ...) -> None: ...

class AuthenticateRequest(_message.Message):
    __slots__ = ["clientinfo", "conn", "password"]
    CLIENTINFO_FIELD_NUMBER: _ClassVar[int]
    CONN_FIELD_NUMBER: _ClassVar[int]
    PASSWORD_FIELD_NUMBER: _ClassVar[int]
    clientinfo: ClientInfo
    conn: str
    password: str
    def __init__(self, conn: _Optional[str] = ..., clientinfo: _Optional[_Union[ClientInfo, _Mapping]] = ..., password: _Optional[str] = ...) -> None: ...

class CertificateInfo(_message.Message):
    __slots__ = ["cn", "dn"]
    CN_FIELD_NUMBER: _ClassVar[int]
    DN_FIELD_NUMBER: _ClassVar[int]
    cn: str
    dn: str
    def __init__(self, cn: _Optional[str] = ..., dn: _Optional[str] = ...) -> None: ...

class ClientInfo(_message.Message):
    __slots__ = ["clientid", "mountpoint", "proto_name", "proto_ver", "username"]
    CLIENTID_FIELD_NUMBER: _ClassVar[int]
    MOUNTPOINT_FIELD_NUMBER: _ClassVar[int]
    PROTO_NAME_FIELD_NUMBER: _ClassVar[int]
    PROTO_VER_FIELD_NUMBER: _ClassVar[int]
    USERNAME_FIELD_NUMBER: _ClassVar[int]
    clientid: str
    mountpoint: str
    proto_name: str
    proto_ver: str
    username: str
    def __init__(self, proto_name: _Optional[str] = ..., proto_ver: _Optional[str] = ..., clientid: _Optional[str] = ..., username: _Optional[str] = ..., mountpoint: _Optional[str] = ...) -> None: ...

class CloseSocketRequest(_message.Message):
    __slots__ = ["conn"]
    CONN_FIELD_NUMBER: _ClassVar[int]
    conn: str
    def __init__(self, conn: _Optional[str] = ...) -> None: ...

class CodeResponse(_message.Message):
    __slots__ = ["code", "message"]
    CODE_FIELD_NUMBER: _ClassVar[int]
    MESSAGE_FIELD_NUMBER: _ClassVar[int]
    code: ResultCode
    message: str
    def __init__(self, code: _Optional[_Union[ResultCode, str]] = ..., message: _Optional[str] = ...) -> None: ...

class ConnInfo(_message.Message):
    __slots__ = ["peercert", "peername", "sockname", "socktype"]
    PEERCERT_FIELD_NUMBER: _ClassVar[int]
    PEERNAME_FIELD_NUMBER: _ClassVar[int]
    SOCKNAME_FIELD_NUMBER: _ClassVar[int]
    SOCKTYPE_FIELD_NUMBER: _ClassVar[int]
    peercert: CertificateInfo
    peername: Address
    sockname: Address
    socktype: SocketType
    def __init__(self, socktype: _Optional[_Union[SocketType, str]] = ..., peername: _Optional[_Union[Address, _Mapping]] = ..., sockname: _Optional[_Union[Address, _Mapping]] = ..., peercert: _Optional[_Union[CertificateInfo, _Mapping]] = ...) -> None: ...

class EmptySuccess(_message.Message):
    __slots__ = []
    def __init__(self) -> None: ...

class Message(_message.Message):
    __slots__ = ["id", "node", "payload", "qos", "timestamp", "topic"]
    FROM_FIELD_NUMBER: _ClassVar[int]
    ID_FIELD_NUMBER: _ClassVar[int]
    NODE_FIELD_NUMBER: _ClassVar[int]
    PAYLOAD_FIELD_NUMBER: _ClassVar[int]
    QOS_FIELD_NUMBER: _ClassVar[int]
    TIMESTAMP_FIELD_NUMBER: _ClassVar[int]
    TOPIC_FIELD_NUMBER: _ClassVar[int]
    id: str
    node: str
    payload: bytes
    qos: int
    timestamp: int
    topic: str
    def __init__(self, node: _Optional[str] = ..., id: _Optional[str] = ..., qos: _Optional[int] = ..., topic: _Optional[str] = ..., payload: _Optional[bytes] = ..., timestamp: _Optional[int] = ..., **kwargs) -> None: ...

class PublishRequest(_message.Message):
    __slots__ = ["conn", "payload", "qos", "topic"]
    CONN_FIELD_NUMBER: _ClassVar[int]
    PAYLOAD_FIELD_NUMBER: _ClassVar[int]
    QOS_FIELD_NUMBER: _ClassVar[int]
    TOPIC_FIELD_NUMBER: _ClassVar[int]
    conn: str
    payload: bytes
    qos: int
    topic: str
    def __init__(self, conn: _Optional[str] = ..., topic: _Optional[str] = ..., qos: _Optional[int] = ..., payload: _Optional[bytes] = ...) -> None: ...

class RawPublishRequest(_message.Message):
    __slots__ = ["payload", "qos", "topic"]
    PAYLOAD_FIELD_NUMBER: _ClassVar[int]
    QOS_FIELD_NUMBER: _ClassVar[int]
    TOPIC_FIELD_NUMBER: _ClassVar[int]
    payload: bytes
    qos: int
    topic: str
    def __init__(self, topic: _Optional[str] = ..., qos: _Optional[int] = ..., payload: _Optional[bytes] = ...) -> None: ...

class ReceivedBytesRequest(_message.Message):
    __slots__ = ["bytes", "conn"]
    BYTES_FIELD_NUMBER: _ClassVar[int]
    CONN_FIELD_NUMBER: _ClassVar[int]
    bytes: bytes
    conn: str
    def __init__(self, conn: _Optional[str] = ..., bytes: _Optional[bytes] = ...) -> None: ...

class ReceivedMessagesRequest(_message.Message):
    __slots__ = ["conn", "messages"]
    CONN_FIELD_NUMBER: _ClassVar[int]
    MESSAGES_FIELD_NUMBER: _ClassVar[int]
    conn: str
    messages: _containers.RepeatedCompositeFieldContainer[Message]
    def __init__(self, conn: _Optional[str] = ..., messages: _Optional[_Iterable[_Union[Message, _Mapping]]] = ...) -> None: ...

class SendBytesRequest(_message.Message):
    __slots__ = ["bytes", "conn"]
    BYTES_FIELD_NUMBER: _ClassVar[int]
    CONN_FIELD_NUMBER: _ClassVar[int]
    bytes: bytes
    conn: str
    def __init__(self, conn: _Optional[str] = ..., bytes: _Optional[bytes] = ...) -> None: ...

class SocketClosedRequest(_message.Message):
    __slots__ = ["conn", "reason"]
    CONN_FIELD_NUMBER: _ClassVar[int]
    REASON_FIELD_NUMBER: _ClassVar[int]
    conn: str
    reason: str
    def __init__(self, conn: _Optional[str] = ..., reason: _Optional[str] = ...) -> None: ...

class SocketCreatedRequest(_message.Message):
    __slots__ = ["conn", "conninfo"]
    CONNINFO_FIELD_NUMBER: _ClassVar[int]
    CONN_FIELD_NUMBER: _ClassVar[int]
    conn: str
    conninfo: ConnInfo
    def __init__(self, conn: _Optional[str] = ..., conninfo: _Optional[_Union[ConnInfo, _Mapping]] = ...) -> None: ...

class SubscribeRequest(_message.Message):
    __slots__ = ["conn", "qos", "topic"]
    CONN_FIELD_NUMBER: _ClassVar[int]
    QOS_FIELD_NUMBER: _ClassVar[int]
    TOPIC_FIELD_NUMBER: _ClassVar[int]
    conn: str
    qos: int
    topic: str
    def __init__(self, conn: _Optional[str] = ..., topic: _Optional[str] = ..., qos: _Optional[int] = ...) -> None: ...

class TimerRequest(_message.Message):
    __slots__ = ["conn", "interval", "type"]
    CONN_FIELD_NUMBER: _ClassVar[int]
    INTERVAL_FIELD_NUMBER: _ClassVar[int]
    TYPE_FIELD_NUMBER: _ClassVar[int]
    conn: str
    interval: int
    type: TimerType
    def __init__(self, conn: _Optional[str] = ..., type: _Optional[_Union[TimerType, str]] = ..., interval: _Optional[int] = ...) -> None: ...

class TimerTimeoutRequest(_message.Message):
    __slots__ = ["conn", "type"]
    CONN_FIELD_NUMBER: _ClassVar[int]
    TYPE_FIELD_NUMBER: _ClassVar[int]
    conn: str
    type: TimerType
    def __init__(self, conn: _Optional[str] = ..., type: _Optional[_Union[TimerType, str]] = ...) -> None: ...

class UnsubscribeRequest(_message.Message):
    __slots__ = ["conn", "topic"]
    CONN_FIELD_NUMBER: _ClassVar[int]
    TOPIC_FIELD_NUMBER: _ClassVar[int]
    conn: str
    topic: str
    def __init__(self, conn: _Optional[str] = ..., topic: _Optional[str] = ...) -> None: ...

class ResultCode(int, metaclass=_enum_type_wrapper.EnumTypeWrapper):
    __slots__ = []

class TimerType(int, metaclass=_enum_type_wrapper.EnumTypeWrapper):
    __slots__ = []

class SocketType(int, metaclass=_enum_type_wrapper.EnumTypeWrapper):
    __slots__ = []
