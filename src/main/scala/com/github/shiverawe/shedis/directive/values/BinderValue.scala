package com.github.shiverawe.shedis.directive.values

import com.redis.RedisClient
import com.github.shiverawe.shedis.directive.Directive

case class BinderValue(client: RedisClient, key: String, v1: String, v2: String) extends Directive {
  val binding: String = (v1, v2).toString()

  def bind: Unit =
    client.sadd(key, binding)

  def unbind: Unit =
    client.srem(key, binding)

  def exists: Boolean =
    client.sismember(key, binding)
}

object BinderValue {
  case class Binding (_1: String, _2: String)
}

