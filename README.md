# Shedis
Wrapper for RedisClient

## Examples

#### Get instanse of Shedis
```scala
val redisClient: RedisClient
val shedis = Shedis(redisClient, "app")()
```

#### Map values
```scala
val entry = shedis/"path"/"to"/"table" map "field"

entry set "value"
entry get()
entry del()
entry exists()
```

#### Plain values
```scala
val plain = shedis/"path"/"to"/"value" value
plain set "value"
plain get()
plain del()
plain exists()
```

#### Bindings
```scala
val binding = shedis/"path"/"again" binder ("one", "two")
binding bind()
binding unbind()
binding exists()
```