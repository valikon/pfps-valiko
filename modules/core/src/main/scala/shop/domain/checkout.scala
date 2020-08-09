package shop.domain

import eu.timepit.refined._
import eu.timepit.refined.api._
import eu.timepit.refined.boolean.And
import eu.timepit.refined.collection.Size
import eu.timepit.refined.string.MatchesRegex
import eu.timepit.refined.string.ValidInt
import io.estatico.newtype.macros.newtype

object checkout {
  type Rgx = W.`"^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$"`.T

  type CardNamePred = String Refined MatchesRegex[Rgx]
  type CardNumberPred = Long Refined Size[16]
  type CardExpirationPred = String Refined (Size[4] And ValidInt)
  type CardCVVPred = Int Refined Size[3]

  @newtype case class CardName(value: String)
  @newtype case class CardNumber(value: Long)
  @newtype case class CardExpiration(value: String)
  @newtype case class CardCVV(value: Int)

  case class Card(
    name: CardName,
    number: CardNumber,
    expiration: CardExpiration,
    cvv: CardCVV
  )
}
