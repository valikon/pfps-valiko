package shop.http.routes.admin

import shop.effects._
import shop.algebras.Items
import shop.http.decoder._
import shop.http.json._
import shop.domain.item._
import shop.http.auth.users.AdminUser

import cats.Defer
import org.http4s._
import org.http4s.circe.JsonDecoder
import org.http4s.dsl.Http4sDsl
import org.http4s.server.AuthMiddleware
import org.http4s.server.Router

final class AdminItemRoutes[F[_]: Defer: JsonDecoder: MonadThrow](items: Items[F])
  extends Http4sDsl[F] {

  private[admin] val prefixPath = "/items"

  private val httpRoutes: AuthedRoutes[AdminUser, F] =
    AuthedRoutes.of {

      // Create a new item
      case ar @ POST -> Root as _ =>
        ar.req.decodeR[CreateItemParam] { item =>
          Created(items.create(item.toDomain))
        }

      // Update price of item
      case ar @ PUT -> Root as _ =>
        ar.req.decodeR[UpdateItemParam] { item =>
          Ok(items.update(item.toDomain))
        }
    }

  def routes(authMiddleware: AuthMiddleware[F, AdminUser]): HttpRoutes[F] = Router(
    prefixPath -> authMiddleware(httpRoutes)
  )

}
