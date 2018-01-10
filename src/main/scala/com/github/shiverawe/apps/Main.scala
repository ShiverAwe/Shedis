package com.github.shiverawe.apps

import com.github.shiverawe.shedis.{RedisEmbeddedWrapper, Shedis}
import com.redis.RedisClient

object Main {
  def main(args: Array[String]): Unit = {
    val REDIS_EMBEDDED = RedisEmbeddedWrapper(PORT = 6381)
    val redis = Shedis(REDIS_EMBEDDED.client, "app")()

    println(("v1", "v2"))

    val mapvalue = redis/"path"/"to"/"table" map "field"

    mapvalue set "value"
    println(mapvalue get())
    mapvalue del()
    println(mapvalue exists())

    val plainvalue = redis/"path"/"to"/"value" value

    val plainValue = redis.section("path").section("to").section("map").map("field")

    val bindervalue = redis/"path"/"again" binder ("one", "two")

    REDIS_EMBEDDED.close()
  }

  def demo1(redisClient: RedisClient): Unit ={
    val redis = Shedis(redisClient, "root_key")()

    val mapvalue = redis/"path"/"to"/"table" map "field"

    mapvalue set "value"
    println(mapvalue get())
    mapvalue del()
    println(mapvalue exists())

    val plainvalue = redis/"path"/"to"/"value" value

    val bindervalue = redis/"path"/"again" binder ("one", "two")

  }
}