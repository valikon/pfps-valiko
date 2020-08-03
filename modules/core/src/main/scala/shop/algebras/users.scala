package shop.algebras

import shop.domain.auth._
import shop.http.auth.users.User

trait Users[F[_]] {
  def find(username: UserName, password: Password): F[Option[User]]
  def create(username: UserName, password: Password): F[UserId]
}
