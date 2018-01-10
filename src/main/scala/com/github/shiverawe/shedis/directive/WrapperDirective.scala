package com.github.shiverawe.shedis.directive

import com.redis.RedisClient
import com.github.shiverawe.shedis.directive.collections.{BinderDirective, ListDirective, MapDirective}
import com.github.shiverawe.shedis.directive.values.PlainValue
import com.github.shiverawe.shedis.operations.SgdeOperations

case class WrapperDirective(client: RedisClient, key: String) extends KeyDirective {
  def /(subkey: String, delimiter: String = "."): WrapperDirective =
    WrapperDirective(client, key + delimiter + subkey)

  def section(subkey: String, delimiter: String = "."): WrapperDirective =
    WrapperDirective(client, key + delimiter + subkey)

  def value: SgdeOperations =
    PlainValue(client, key)

  def map: MapDirective =
    MapDirective(client, key)

  def list: ListDirective =
    ListDirective(client, key)

  def binder: BinderDirective =
    BinderDirective(client, key)
}
