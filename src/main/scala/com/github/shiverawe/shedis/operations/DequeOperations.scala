package com.github.shiverawe.shedis.operations

import com.github.shiverawe.shedis.directive.Directive

trait DequeOperations {
  self: Directive =>
  def size(): Option[Long] =
    client.llen(key)

  //--------------------------------LEFT--------------------------------------

  /**
    * Pushes if list exists
    */
  def pushFirstX(value: Any): Option[Long] =
    client.lpushx(key, value)

  def pushFirst(value: Any): Option[Long] =
    client.lpush(key, value)

  def popFirst(): Option[String] =
    client.lpop(key)

  def popFirstBlocking(timeoutInSeconds: Int): Option[(String, String)] =
    client.blpop(timeoutInSeconds, key)

  //--------------------------------RIGHT--------------------------------------

  /**
    * Pushes if list exists
    */
  def pushLastX(value: Any): Option[Long] =
    client.rpushx(key, value)

  def pushLast(value: Any): Option[Long] =
    client.rpush(key, value)

  def popLast(): Option[String] =
    client.rpop(key)

  def popLastBlocking(timeoutInSeconds: Int): Option[(String, String)] =
    client.brpop(timeoutInSeconds, key)
}
