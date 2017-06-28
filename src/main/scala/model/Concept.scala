package model

sealed trait Concept
final case class TwitterHandle(handle: String) extends Concept
final case class Link(location: String) extends Concept
final case class NamedEntity(name: String) extends Concept
final case class RegularText(str: String) extends Concept
//Later addition
final case class HashTag(tag: String) extends Concept
//--
