package shop.domain

import squants.market.Money
import shop.domain.auth.UserId
import shop.domain.checkout.Card

object payment {
  case class Payment(
    id: UserId,
    total: Money,
    card: Card
  )
}
