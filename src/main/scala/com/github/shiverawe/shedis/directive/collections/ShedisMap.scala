package com.github.shiverawe.shedis.directive.collections

import com.redis.RedisClient
import com.github.shiverawe.shedis.directive.values.HashValue
import com.github.shiverawe.shedis.directive.{Directive, KeyDirective}
import com.github.shiverawe.shedis.operations.{MapOperations, SgdeOperations}

case class ShedisMap(client: RedisClient, key: String) extends KeyDirective with MapOperations {
  def apply (field: String): SgdeOperations =
    HashValue(client, key, field)
}
