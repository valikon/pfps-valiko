package shop.config

import eu.timepit.refined.types.numeric.PosInt
import eu.timepit.refined.types.string.NonEmptyString
import io.estatico.newtype.macros.newtype
import scala.concurrent.duration.FiniteDuration
import eu.timepit.refined.types.net.UserPortNumber

object data {

  case class CheckoutConfig(retriesLimit: PosInt, retriesBackoff: FiniteDuration)

  @newtype case class PaymentURI(value: NonEmptyString)
  @newtype case class PaymentConfig(uri: PaymentURI)

  case class HttpServerConfig(host: NonEmptyString, port: UserPortNumber)

  case class HttpClientConfig(
    connectTimeout: FiniteDuration,
    requestTimeout: FiniteDuration
  )

}
