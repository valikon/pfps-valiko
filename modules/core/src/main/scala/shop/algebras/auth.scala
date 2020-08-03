package shop.algebras

import dev.profunktor.auth.jwt.JwtToken
import shop.http.auth.users.User
import shop.domain.auth._

trait Auth[F[_]] {
  def findUser(token: JwtToken): F[Option[User]]
  def newtUser(username: UserName, password: Password): F[JwtToken]
  def login(username: UserName, password: Password): F[JwtToken]
  def logout(token: JwtToken, username: UserName): F[Unit]
}
