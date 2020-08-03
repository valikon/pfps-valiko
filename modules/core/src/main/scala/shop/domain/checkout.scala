package shop.domain

import io.estatico.newtype.macros.newtype

object checkout {

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
