trait HtmlFormat[T]{
  def htmlFormat(obj: T): String
}

object HtmlFormat {
  def apply[T](implicit format: HtmlFormat[T]): HtmlFormat[T] =
    format
  def mkInstance[T](f: T => String): HtmlFormat[T] = (obj: T) =>
    f(obj)
  implicit class HtmlFormatOps[T: HtmlFormat](obj: T){
    def htmlFormat: String = HtmlFormat[T].htmlFormat(obj)
  }
}
