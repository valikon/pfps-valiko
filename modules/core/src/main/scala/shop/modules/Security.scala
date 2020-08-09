package shop.modules

import shop.algebras.Auth
import shop.algebras.UsersAuth
import shop.http.auth.users._

object Security {
  // def make[F[_]: Sync](
  //   // cfg: AppConfig,
  //   // sessionPool: Resource[F, Session[F]],
  //   // redis: RedisCommands[F, String, String]
  // ): F[Security[F]] = {}
}

final class Security[F[_]]( // TODO make private
  val auth: Auth[F],
  val adminAuth: UsersAuth[F, AdminUser],
  val usersAuth: UsersAuth[F, CommonUser],
  val adminJwtAuth: AdminJwtAuth,
  val userJwtAuth: UserJwtAuth
)
