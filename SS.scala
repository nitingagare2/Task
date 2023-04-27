import java.io.{BufferedWriter, File, FileWriter}
import scala.collection.mutable.ArrayBuffer
import scala.io.Source
import org.json4s._
import org.json4s.jackson.JsonMethods._

object SS {
  case class Person(name: String, age: Int, city: String)

  def main(args: Array[String]): Unit = {
    val inputPath = "F:/Files/emp.json"
    val outputPath = "F:/Files/emp.csv"

    val json = Source.fromFile(inputPath).getLines().mkString
    implicit val formats = DefaultFormats
    val people = parse(json).extract[Array[Person]]

    val header = "name,age,city\n"
    val rows = new ArrayBuffer[String]()
    people.foreach(p => rows += s"${p.name},${p.age},${p.city}\n")

    val writer = new BufferedWriter(new FileWriter(new File(outputPath)))
    writer.write(header)
    rows.foreach(row => writer.write(row))
    writer.close()
  }
}
