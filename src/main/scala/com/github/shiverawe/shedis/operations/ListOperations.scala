package com.github.shiverawe.shedis.operations

import com.github.shiverawe.shedis.directive.Directive

trait ListOperations {
  self: Directive =>
  def lenght(): Option[Long] =
    client.llen(key)

  def get(index: Int): Option[String] =
    client.lindex(key, index)

  def set(index: Int, value: Any): Boolean =
    client.lset(key, index, value)

  def lrange(start: Int, end: Int): Option[List[Option[String]]] =
    client.lrange(key, start, end)

  def ltrim(start: Int, end: Int): Boolean =
    client.ltrim(key, start, end)

  def lrem(count: Int, value: Any): Option[Long] =
    client.lrem(key, count, value)
}
