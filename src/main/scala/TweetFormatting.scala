import model._

object TweetFormatting extends ConceptFormatting{
  import HtmlFormat._

  implicit val conceptFormat: HtmlFormat[Concept] = {
    case obj: TwitterHandle => HtmlFormat[TwitterHandle].htmlFormat(obj)
    case obj: Link => HtmlFormat[Link].htmlFormat(obj)
    case obj: NamedEntity => HtmlFormat[NamedEntity].htmlFormat(obj)
    case obj: RegularText => HtmlFormat[RegularText].htmlFormat(obj)
    //Later addition
    case obj: HashTag => HtmlFormat[HashTag].htmlFormat(obj)
    //--
  }

  def processTweet(t: Tweet[Concept]): String = t.htmlFormat
}
