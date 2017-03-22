package me.snov.sns.response

import akka.http.scaladsl.model.{ContentTypes, HttpEntity, HttpResponse}

import scala.xml.Elem
import spray.json._

trait JsonHttpResponse {

  def response(xml: Elem) =
    HttpResponse(
      entity = HttpEntity(ContentTypes.`application/json`, scala.xml.Utility.trim(xml).toString().toJson)
    )
}
