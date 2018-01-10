package com.github.shiverawe.shedis.operations

import com.github.shiverawe.shedis.directive.Directive

//TODO: Implement iterator
trait MapOperations {
  self: Directive =>
  def get(field: String): String =
    client.hget(key, field).getOrElse(throw new NoSuchElementException("No element for " + key + " : " + field))

  def +=(fv: (String, String)): MapOperations.this.type = {
    client.hset(key, fv._1, fv._2)
    this
  }

  def -=(field: String): MapOperations.this.type = {
    client.hdel(key, field)
    this
  }

  /**
    * Even if key does not exists `hkeys` returns `List.empty` but never `None`
    */
  def fields: List[String] =
    client.hkeys(key).getOrElse(List.empty)

  def values: List[String] =
    client.hvals(key).getOrElse(List.empty)
}
