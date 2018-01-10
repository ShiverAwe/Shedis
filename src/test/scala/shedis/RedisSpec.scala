package shedis

import com.github.shiverawe.shedis.RedisEmbeddedWrapper
import org.scalatest.{BeforeAndAfterEach, Suite}

trait RedisSpec extends BeforeAndAfterEach{
  this: Suite =>

  var SERVER: RedisEmbeddedWrapper

  override protected def beforeEach(): Unit = {
    SERVER.reset()
  }

  override protected def afterEach(): Unit = {

  }
}
