package com.github.shiverawe.shedis.operations

trait SgdeOperations {
  def set(value: String): Unit

  def get(): Option[String]

  def del(): Unit

  def exists(): Boolean
}
