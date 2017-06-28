package model

final case class Tweet[T](terms: Traversable[T])
