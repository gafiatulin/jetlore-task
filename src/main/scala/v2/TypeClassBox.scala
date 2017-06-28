package v2

sealed trait TypeClassBox[TC[_]]{
  type T
  val value: T
  val evidence: TC[T]
}

private final case class MkTypeClassBox[T1, TC[_]](value: T1)(implicit val evidence: TC[T1]) extends TypeClassBox[TC]{
  type T = T1
}

object TypeClassBox{
  def apply[T, TC[_]](value: T)(implicit ev: TC[T]): TypeClassBox[TC] = MkTypeClassBox(value)
  implicit def lift[TC[_], A: TC](v: A): TypeClassBox[TC] = TypeClassBox(v)
}
