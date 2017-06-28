package v3

import org.scalatest.{Matchers, WordSpec}
import v3.TweetFormattingV3.Tweet

class TweetFormattingV3Test extends WordSpec with Matchers{
  "TweetFormattingV3" should {
    "processTweet" in {
      val tweet = new Tweet {
        import ConceptSyntax._
        //Later addition
        import AdditionalConceptSyntax._
        //--
        def terms[T: Concept :
        //Later addition
        AdditionalConcept
        //--
        ]: List[T] = List(
          namedEntity("Obama"),
          regularText(" visited "),
          namedEntity("Facebook"),
          regularText(" headquarters: "),
          link("http://bit.ly/xyz"),
          regularText(" "),
          twitterHandle("elversatile"),
          //Later addition
          regularText(" "),
          hashTag("potus")
          //--
        )
      }
      TweetFormattingV3.processTweet(tweet) shouldBe common.TestCommon.expected
    }
  }
}
