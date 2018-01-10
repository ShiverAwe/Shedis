package com.github.shiverawe.shedis.directive.values

import com.redis.RedisClient
import com.github.shiverawe.shedis.directive.Directive
import com.github.shiverawe.shedis.operations.SgdeOperations

case class PlainValue(client: RedisClient, key: String) extends Directive with SgdeOperations {
  override def set(value: String): Unit =
    client.set(key, value)

  override def get(): Option[String] =
    client.get(key)

  override def del(): Unit =
    client.del(key)

  override def exists(): Boolean =
    client.exists(key)
}
