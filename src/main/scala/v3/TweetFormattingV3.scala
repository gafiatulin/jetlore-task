package v3

trait Concept[T] {
  def twitterHandle(handle: String): T
  def link(location: String): T
  def namedEntity(name: String): T
  def regularText(txt: String): T
}

object ConceptSyntax{
  def twitterHandle[T](handle: String)(implicit ev: Concept[T]): T = ev.twitterHandle(handle)
  def link[T](location: String)(implicit ev: Concept[T]): T = ev.link(location)
  def namedEntity[T](name: String)(implicit ev: Concept[T]): T = ev.namedEntity(name)
  def regularText[T](txt: String)(implicit ev: Concept[T]): T = ev.regularText(txt)
}

//Later addition
trait AdditionalConcept[T]{
  def hashTag(tag: String): T
}
object AdditionalConceptSyntax{
  def hashTag[T](tag: String)(implicit ev: AdditionalConcept[T]): T = ev.hashTag(tag)
}
//--

object TweetFormattingV3{
  trait Tweet{
    def terms[T : Concept :
    //Later addition
    AdditionalConcept
    //--
    ]: List[T]
  }

  implicit val formatConcept: Concept[String] = new Concept[String] {
    def link(location: String): String = s"""<a href="$location">$location</a>"""
    def regularText(txt: String): String = txt
    def twitterHandle(handle: String): String = s"""@<a href="https://twitter.com/$handle">$handle</a>"""
    def namedEntity(name: String): String = s"<strong>$name</strong>"
  }
  //Later addition
  implicit val formatNewConcept: AdditionalConcept[String] =
    (tag: String) => s"""<a href="https://twitter.com/hashtag/$tag">#$tag</a>"""
  //--

  def processTweet(t: Tweet): String = t.terms[String].mkString
}
