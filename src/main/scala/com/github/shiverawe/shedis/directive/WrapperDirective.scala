package com.github.shiverawe.shedis.directive

import com.redis.RedisClient
import com.github.shiverawe.shedis.directive.collections.{ShedisBinder, ShedisList, ShedisMap}
import com.github.shiverawe.shedis.directive.values.PlainValue
import com.github.shiverawe.shedis.operations.SgdeOperations

case class WrapperDirective(client: RedisClient, key: String) extends KeyDirective {
  def /(subkey: String, delimiter: String = "."): WrapperDirective =
    WrapperDirective(client, key + delimiter + subkey)

  def section(subkey: String, delimiter: String = "."): WrapperDirective =
    WrapperDirective(client, key + delimiter + subkey)

  def value: SgdeOperations =
    PlainValue(client, key)

  def map: ShedisMap =
    ShedisMap(client, key)

  def list: ShedisList =
    ShedisList(client, key)

  def binder: ShedisBinder =
    ShedisBinder(client, key)
}
