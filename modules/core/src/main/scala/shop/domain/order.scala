package shop.domain

import shop.domain.cart._
import shop.domain.item._

import java.util.UUID
import io.estatico.newtype.macros.newtype
import squants.market.Money

object order {
  @newtype case class OrderId(value: UUID)
  @newtype case class PaymentId(value: UUID)

  case class Order(
    id: OrderId,
    paymentId: PaymentId,
    items: Map[ItemId, Quantity],
    total: Money
  )
}
