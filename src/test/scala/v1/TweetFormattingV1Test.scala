package v1

import common.model._
import org.scalatest.{Matchers, WordSpec}

class TweetFormattingV1Test extends WordSpec with Matchers{
  "TweetFormattingV1" should {
    "processTweet" in {
      val tweet: Tweet[Concept] = Tweet(
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
      )
      TweetFormattingV1.processTweet(tweet) shouldBe common.TestCommon.expected
    }
  }
}
