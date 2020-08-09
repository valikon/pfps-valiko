package shop

import cats.MonadError
import cats.ApplicativeError
import cats.effect.Bracket

package object effects {

  type BracketThrow[F[_]] = Bracket[F, Throwable]

  object BrackeThrow {
    def apply[F[_]](implicit ev: Bracket[F, Throwable]): BracketThrow[F] = ev
  }

  type ApThrow[F[_]] = ApplicativeError[F, Throwable]

  object ApThrow {
    def apply[F[_]](implicit ev: ApplicativeError[F, Throwable]): ApThrow[F] = ev
  }

  type MonadThrow[F[_]] = MonadError[F, Throwable]

  object MonadThrow {
    def apply[F[_]](implicit ev: MonadError[F, Throwable]): MonadThrow[F] = ev
  }
}
