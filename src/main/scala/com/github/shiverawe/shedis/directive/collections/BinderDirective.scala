package com.github.shiverawe.shedis.directive.collections

import com.redis.RedisClient
import com.github.shiverawe.shedis.directive.KeyDirective
import com.github.shiverawe.shedis.directive.values.BinderValue

case class BinderDirective(client: RedisClient, key: String) extends KeyDirective {
  def apply(v1: String, v2: String): BinderValue =
    BinderValue(client, key, v1, v2)
}
