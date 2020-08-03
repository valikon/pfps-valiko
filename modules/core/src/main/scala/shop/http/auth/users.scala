package shop.http.auth

import shop.domain.auth._

object users {

  case class User(id: UserId, name: UserName)
}
