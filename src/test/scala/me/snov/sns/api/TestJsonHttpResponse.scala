package me.snov.sns.api

import java.util.UUID

import me.snov.sns.response.JsonHttpResponse
import org.scalatest.FunSuite

import scala.xml.Elem

/**
  * Created by gabe.testa on 3/22/17.
  */
class TestJsonHttpResponse extends FunSuite{
  trait TestFixture extends JsonHttpResponse {
    val foo = "bar"
    val testXML: Elem = <SubscribeResponse xmlns="http://sns.amazonaws.com/doc/2010-03-31/">
      <SubscribeResult>
        <SubscriptionArn>
          testArn
        </SubscriptionArn>
      </SubscribeResult>
      <ResponseMetadata>
        <RequestId>
          test_UUID
        </RequestId>
      </ResponseMetadata>
    </SubscribeResponse>
  }

  test("jsonhttpresponse returns json") {
    new TestFixture {
      val response_string = response(testXML)
      println(s"$response_string")
    }
  }
}
