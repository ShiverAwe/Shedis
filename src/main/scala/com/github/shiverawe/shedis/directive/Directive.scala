package com.github.shiverawe.shedis.directive

import com.redis.RedisClient

trait Directive {
  val client: RedisClient
  val key: String
}
