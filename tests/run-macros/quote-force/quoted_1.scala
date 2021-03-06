import scala.quoted._

case class Location(owners: List[String])

object Location {

  implicit inline def location: Location = ${impl}

  def impl(using QuoteContext): Expr[Location] = {
    val list = Expr(List("a", "b", "c", "d", "e", "f"))
    '{new Location(${list})}
  }

}
