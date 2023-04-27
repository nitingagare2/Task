import scala.io.Source
import org.json4s._
import org.json4s.jackson.JsonMethods._
import java.io.FileReader
import java.sql.{Connection, DriverManager, PreparedStatement}
import scala.collection.JavaConverters._
object TTask {
  def main(args: Array[String]): Unit = {
    implicit val formats: DefaultFormats.type = DefaultFormats

    //val config: Any=parse(Source.fromFile("F:/Files/tasks/config.json")).mkString().extract[Map[String, String]]

  }
}
