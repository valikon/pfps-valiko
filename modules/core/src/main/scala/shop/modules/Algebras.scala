package shop.modules

import shop.algebras._

final class Algebras[F[_]]( // TODO make private
  val cart: ShoppingCart[F],
  val brands: Brands[F],
  val categories: Categories[F],
  val items: Items[F],
  val orders: Orders[F]
  // val healthCheck: HealthCheck[F]
)
