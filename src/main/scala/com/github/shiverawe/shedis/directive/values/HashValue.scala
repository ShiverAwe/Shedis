package com.github.shiverawe.shedis.directive.values

import com.redis.RedisClient
import com.github.shiverawe.shedis.directive.Directive
import com.github.shiverawe.shedis.operations.SgdeOperations

case class HashValue(client: RedisClient, key: String, field: String) extends Directive with SgdeOperations {
  override def set(value: String): Unit =
    client.hset(key, field, value)

  override def get(): Option[String] =
    client.hget(key, field)

  override def del(): Unit =
    client.hdel(key, field)

  override def exists(): Boolean =
    client.hexists(key, field)
}
