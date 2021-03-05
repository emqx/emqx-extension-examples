// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: exhook.proto

package io.emqx.exhook;

public interface SubOptsOrBuilder extends
    // @@protoc_insertion_point(interface_extends:emqx.exhook.v1.SubOpts)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * The QoS level
   * </pre>
   *
   * <code>uint32 qos = 1;</code>
   * @return The qos.
   */
  int getQos();

  /**
   * <pre>
   * The group name for shared subscription
   * </pre>
   *
   * <code>string share = 2;</code>
   * @return The share.
   */
  java.lang.String getShare();
  /**
   * <pre>
   * The group name for shared subscription
   * </pre>
   *
   * <code>string share = 2;</code>
   * @return The bytes for share.
   */
  com.google.protobuf.ByteString
      getShareBytes();

  /**
   * <pre>
   * The Retain Handling option (MQTT v5.0)
   *  0 = Send retained messages at the time of the subscribe
   *  1 = Send retained messages at subscribe only if the subscription does
   *       not currently exist
   *  2 = Do not send retained messages at the time of the subscribe
   * </pre>
   *
   * <code>uint32 rh = 3;</code>
   * @return The rh.
   */
  int getRh();

  /**
   * <pre>
   * The Retain as Published option (MQTT v5.0)
   *  If 1, Application Messages forwarded using this subscription keep the
   *        RETAIN flag they were published with.
   *  If 0, Application Messages forwarded using this subscription have the
   *        RETAIN flag set to 0.
   * Retained messages sent when the subscription is established have the RETAIN flag set to 1.
   * </pre>
   *
   * <code>uint32 rap = 4;</code>
   * @return The rap.
   */
  int getRap();

  /**
   * <pre>
   * The No Local option (MQTT v5.0)
   * If the value is 1, Application Messages MUST NOT be forwarded to a
   * connection with a ClientID equal to the ClientID of the publishing
   * </pre>
   *
   * <code>uint32 nl = 5;</code>
   * @return The nl.
   */
  int getNl();
}
