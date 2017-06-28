package v2

import common.model._
import org.scalatest.{Matchers, WordSpec}

class TweetFormattingV2Test extends WordSpec with Matchers{
  "TweetFormattingV2" should {
    "processTweet" in {
      val tweet = {
        import TweetFormattingV2._
        Tweet(
          Seq(
            NamedEntity("Obama"),
            RegularText(" visited "),
            NamedEntity("Facebook"),
            RegularText(" headquarters: "),
            Link("http://bit.ly/xyz"),
            RegularText(" "),
            TwitterHandle("elversatile"),
            //Later addition
            RegularText(" "),
            HashTag("potus")
            //--
          )
        ): Tweet[AnyHtmlFormattable]
      }
      TweetFormattingV2.processTweet(tweet) shouldBe common.TestCommon.expected
    }
  }
}
