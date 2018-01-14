package shedis

import com.redis.RedisClient
import redis.embedded.RedisServer

case class RedisEmbeddedWrapper
(
  HOST: String = "localhost",
  PORT: Int = 6379
) extends AutoCloseable {

  private val redisServer: RedisServer = new RedisServer(PORT)
  try {
    redisServer.start()
  } catch {
    case e: Exception => print(e.getMessage)
  }

  lazy val client = new RedisClient(HOST, PORT)

  def status(): Boolean =
    redisServer.isActive

  def reset(): Unit = {
    client.flushall
  }

  override def close(): Unit = redisServer.stop()
}


