package com.github.shiverawe.shedis

import com.redis.RedisClient
import com.github.shiverawe.shedis.directive.WrapperDirective

case class Shedis(client: RedisClient, rootKey: String = "application") {
  val directive = WrapperDirective(client, rootKey)
  def apply() = directive
}
