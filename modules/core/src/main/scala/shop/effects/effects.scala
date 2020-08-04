package shop

import cats.MonadError

package object effects {
  type MonadThrow[F[_]] = MonadError[F, Throwable]
}
