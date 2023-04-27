import scala.io.Source
import org.json4s._
import org.json4s.jackson.JsonMethods._

object JsonFilter {
  case class Person(name: String, age: Int, city: String)

  def main(args: Array[String]): Unit = {
    val inputPath = args(0)
    val ageFilter = args(1).toInt

    val json = Source.fromFile(inputPath).getLines().mkString
    implicit val formats = DefaultFormats
    val people = parse(json).extract[Array[Person]]

    val filteredPeople = people.filter(_.age >= ageFilter)

    filteredPeople.foreach(p => println(s"${p.name} (${p.age}) - ${p.city}"))
  }
}

//libraryDependencies += "org.json4s" %% "json4s-jackson" % "3.6.10"





