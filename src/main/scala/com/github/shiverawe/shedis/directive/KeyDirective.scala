package com.github.shiverawe.shedis.directive

trait KeyDirective extends Directive {
  def getDirective(): KeyDirective =
    WrapperDirective(client, key)

  def getType(): Option[String] =
    client.getType(key)

  def newWrapper() = WrapperDirective(client, key)
}
