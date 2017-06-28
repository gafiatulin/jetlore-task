package common

import common.model._

trait ConceptFormatting {
  implicit val twitterHandleFormat: HtmlFormat[TwitterHandle] =
    (obj: TwitterHandle) => s"""@<a href="https://twitter.com/${obj.handle}">${obj.handle}</a>"""
  implicit val linkFormat: HtmlFormat[Link] =
    (obj: Link) => s"""<a href="${obj.location}">${obj.location}</a>"""
  implicit val namedEntityFormat: HtmlFormat[NamedEntity] =
    (obj: NamedEntity) => s"<strong>${obj.name}</strong>"
  implicit val regularTextFormat: HtmlFormat[RegularText] =
    (obj: RegularText) => obj.str
  //Later addition
  implicit val hashTagFormat: HtmlFormat[HashTag] =
    (obj: HashTag) => s"""<a href="https://twitter.com/hashtag/${obj.tag}">#${obj.tag}</a>"""
  //--
  implicit def tweetFormat[T](implicit ev: HtmlFormat[T]): HtmlFormat[Tweet[T]] =
    (obj: Tweet[T]) => obj.terms.map(ev.htmlFormat).mkString
}
