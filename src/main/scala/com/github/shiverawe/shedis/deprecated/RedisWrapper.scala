package com.github.shiverawe.shedis.deprecated

import com.redis.RedisClient
import com.github.shiverawe.shedis.RedisEmbeddedWrapper
import com.github.shiverawe.shedis.directive.collections.MapDirective
import com.github.shiverawe.shedis.directive.values.PlainValue
import com.github.shiverawe.shedis.operations.SgdeOperations

@deprecated("Use WrapperDirective instead")
class RedisWrapper
(
  val client: RedisClient,
  val key: String,
  keys: Map[String, String] = Map()
) {

  lazy val value: SgdeOperations = PlainValue(client, key)
  lazy val map: MapDirective = MapDirective(client, key)
  @deprecated("Use `map` property to use hashmaps")
  lazy val crud: RedisCrud = RedisCrud(client, key)

  def keyForName(name: String) = keys(name)

  def section(subkey: String, delimiter: String = ".") = {
    val newKey = key + delimiter + subkey
    new RedisWrapper(client, newKey, keys)
  }
}

object RedisWrapper {
  def apply(key: String, keys: Map[String, String] = Map.empty): RedisWrapper = {
    val client = RedisEmbeddedWrapper().client
    new RedisWrapper(client, key, keys)
  }
}
