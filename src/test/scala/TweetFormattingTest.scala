import model._
import org.scalatest.{Matchers, WordSpec}

class TweetFormattingTest extends WordSpec with Matchers{
  "TweetFormatting" should {
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
      TweetFormatting.processTweet(tweet) shouldBe """<strong>Obama</strong> visited <strong>Facebook</strong> headquarters: <a href="http://bit.ly/xyz">http://bit.ly/xyz</a> @<a href="https://twitter.com/elversatile">elversatile</a> <a href="https://twitter.com/hashtag/potus">#potus</a>"""
    }
  }
}
