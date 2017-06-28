package v2

import common._
import common.model._

object TweetFormattingV2 extends ConceptFormatting{
  import HtmlFormat._
  type AnyHtmlFormattable = TypeClassBox[HtmlFormat]
  def processTweet(t: Tweet[AnyHtmlFormattable]): String = t.htmlFormat
}
