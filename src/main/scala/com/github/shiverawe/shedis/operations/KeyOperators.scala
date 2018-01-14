package com.github.shiverawe.shedis.operations

import com.github.shiverawe.shedis.directive.Directive
import com.github.shiverawe.shedis.directive.collections.{ShedisBinder, ShedisMap}
import com.github.shiverawe.shedis.directive.values.PlainValue

trait KeyOperators {
  self: Directive =>
  def :/ =
    PlainValue(client, key)

  def :/(field: String) =
    ShedisMap(client, key)(field)

  def :/(pair: (String, String)) =
    ShedisBinder(client, key)(pair._1, pair._2)
}
