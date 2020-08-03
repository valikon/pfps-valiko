package shop.domain

import io.estatico.newtype.macros.newtype
import squants.market._
import java.util.UUID
import shop.domain.category._
import shop.domain.brand._

object item {
  @newtype case class ItemId(value: UUID)
  @newtype case class ItemName(value: String)
  @newtype case class ItemDescription(value: String)

  case class Item(
    uuid: ItemId,
    name: ItemName,
    description: ItemDescription,
    price: Money,
    brand: Brand,
    category: Category
  )

  // ------ Create item ------

  case class CreateItem(
    name: ItemName,
    description: ItemDescription,
    price: Money,
    brandId: BrandId,
    categoryId: CategoryId
  )

  // ------ Update item -------

  case class UpdateItem(id: ItemId, price: Money)
}
