import java.nio.file.Paths
import scala.io.Source
import org.json4s._
import org.json4s.jackson.JsonMethods._
object Js1 {

    def main(args: Array[String]): Unit = {
    

        val path="Documents/details.json"
        val f1=Source.fromFile(path).getLines().mkString

        implicit  val formats=DefaultFormats

        val json=parse(f1)

        val people = (json \ "people")

       // people.foreach(println)
    }
  
}
