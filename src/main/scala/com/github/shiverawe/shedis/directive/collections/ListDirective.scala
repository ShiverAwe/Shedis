package com.github.shiverawe.shedis.directive.collections

import com.redis.RedisClient
import com.github.shiverawe.shedis.directive.KeyDirective
import com.github.shiverawe.shedis.operations.ListOperations

case class ListDirective(client: RedisClient, key: String) extends KeyDirective with ListOperations{}
