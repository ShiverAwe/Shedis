package com.github.shiverawe.shedis.deprecated

import com.redis.RedisClient

/**
  * Provides CRUD operations for RedisClient
  */
@deprecated("Use MapDirectiveInstead")
class RedisCrud(client: RedisClient, key: String) {

  //--------------------------------CRUD-------------------------------------------------

  def create(field: String, value: Any): Unit = {
    if (read(field).isDefined) throw new IllegalArgumentException("Element with such id already exists")
    client.hset(key, field, value.toString)
  }

  def read(field: String): Option[String] = {
    client.hget(key, field)
  }

  def update(field: String, value: Any): Unit = {
    if (read(field).isEmpty) throw new NoSuchElementException("No such id to update")
    client.hset(key, field, value.toString)
  }

  def delete(field: String): Unit = {
    client.hdel(key, field)
  }

  //--------------------------------EXPERIMENTAL------------------------------------------------------

  def all(): Option[Map[String, String]] = {
    client.hgetall1(key)
  }

  def fields(): Option[List[String]] = {
    client.hkeys(key)
  }
}

object RedisCrud {
  def apply(client: RedisClient, key: String): RedisCrud = new RedisCrud(client, key)
}