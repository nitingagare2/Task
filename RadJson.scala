import javax.xml.transform.Source
import scala.util.parsing.json.JSONType

import play.api.libs.json._
//import Scala.io.Source
object RadJson {
  def main(args: Array[String]): Unit = {

    // val filename="F:/Files/demo.txt"
    

    // for(i<-filename)
    // {
    //     //println(i)
    // }
    // for(line<-scala.io.Source.fromFile(filename).getLines)
    // {
    //     println(line)
    // }

    
    



val jsonString = scala.io.Source.fromFile("F:/Files/data.json").mkString

val json = Json.parse(jsonString)




val name = (json \ "name").as[String]
val age = (json \ "age").as[Int]
val street = (json \ "address" \ "street").as[String]
val city=(json\"address"\"city").as[String]
val phoneNumbers = (json \ "phoneNumbers").as[Seq[JsValue]]
phoneNumbers.foreach { phoneNumber =>
  val phoneNumberType = (phoneNumber \ "type").as[String]
  val phoneNumberValue = (phoneNumber \ "number").as[String]
  println(s"$phoneNumberType: $phoneNumberValue")}


println(s"Name: $name")
println(s"Age: $age")
println(s"Street Address: $street")
println(s"City: $city")
//println(s"PhoneNo: $homenumber")



  }
}
