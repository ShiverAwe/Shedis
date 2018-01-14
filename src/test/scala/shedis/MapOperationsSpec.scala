package shedis

import RedisEmbeddedWrapper
import org.scalatest.FlatSpec
import com.github.shiverawe.shedis.directive.collections.ShedisMap

class MapOperationsSpec extends FlatSpec with RedisSpec {

  //--------------------------------INITIALIZING--------------------------------

  override var SERVER: RedisEmbeddedWrapper = _
  try {
    SERVER = RedisEmbeddedWrapper()
    val redisClient = SERVER.client

    //--------------------------------VARIABLES--------------------------------------

    val KEY = "testkey"
    val FIELD = "field"
    val VALUE = "value"
    val FIELD_NOT_EXISTS = "j7b5d4kc2o6lsn6r2l5sdf6wer87cw6"
    val MAP = ShedisMap(redisClient, KEY)
    val MAP_NOT_EXISTS = ShedisMap(redisClient, "mwcreomq6cwer146wqr84cqwe6")

    //--------------------------------TESTS---------------------------------------

    "HashOperations" should "correctly add values with `+=`" in {
      MAP += (FIELD, VALUE)
      assert(redisClient.hget(KEY, FIELD) contains VALUE)
    }

    it should "correctly values with `-=`" in {
      redisClient.hset(KEY, FIELD, VALUE)
      MAP -= FIELD
      assert(!redisClient.hexists(KEY, FIELD))
    }

    it should "get existing values with `get()`" in {
      redisClient.hset(KEY, FIELD, VALUE)
      assert(MAP.get(FIELD) contains VALUE)
    }

    it should "throw exception when trying `get()` not existing field" in {
      assertThrows[NoSuchElementException](MAP.get(FIELD_NOT_EXISTS))
    }

    it should "correctly return fields list" in {
      redisClient.hset(KEY, "fieldA", "valueA")
      redisClient.hset(KEY, "fieldB", "valueB")
      redisClient.hset(KEY, "fieldC", "valueC")
      redisClient.hset(KEY, "fieldD", "valueD")
      // Using set to sort values
      assert(MAP.fields.toSet == Set("fieldD", "fieldC", "fieldB", "fieldA"))
    }

    it should "return empty list when trying get `fields()` on key which is not a map key" in {
      assert(MAP_NOT_EXISTS.fields == List.empty)// contains List.empty)
    }

    it should "correctly return values list" in {
      redisClient.hset(KEY, "fieldA", "valueA")
      redisClient.hset(KEY, "fieldB", "valueB")
      redisClient.hset(KEY, "fieldC", "valueC")
      redisClient.hset(KEY, "fieldD", "valueD")
      // Using set to sort values
      assert(MAP.values.toSet == Set("valueD", "valueC", "valueB", "valueA"))
    }

    it should "return empty when trying get `values()` on key which is not a map key" in {
      assert(MAP_NOT_EXISTS.values == List.empty)// contains List.empty)
    }

    //--------------------------------DESTROYING--------------------------------

  } finally {
    SERVER.close()
  }
}
