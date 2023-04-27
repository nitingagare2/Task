
import java.io.{BufferedReader, FileReader}
import java.sql.{Connection, DriverManager, PreparedStatement}
import scala.collection.JavaConverters._
import scala.io.Source
import org.json4s._
import org.json4s.jackson.JsonMethods._
// import com.opencsv.CSVReader
// import com.opencsv.CSVReader
// import com.opencsv.CSVParser
// import com.opencsv.CSVParserBuilder
// import com.opencsv.CSVReader
// import com.opencsv.CSVReaderBuilder

object Tsk14 {

    def main(args: Array[String]): Unit = {
        

        
// Load the configuration file
implicit val formats: DefaultFormats.type = DefaultFormats
val config: Map[String, String] = parse(Source.fromFile("F:/Files/tasks/config.json").mkString).extract[Map[String, String]]

// Connect to the MySQL database
Class.forName("com.mysql.cj.jdbc.Driver")
val cnx: Connection = DriverManager.getConnection(
  s"jdbc:mysql://${config("host")}:${config("port")}/${config("database")}",
  config("username"),
  config("password")
)

// Create a prepared statement
val insertQuery: String = s"INSERT INTO ${config("target_table")} (name, age) VALUES (?, ?)"
val pstmt: PreparedStatement = cnx.prepareStatement(insertQuery)

// Read the CSV file
// 

val reader = new BufferedReader(new FileReader(config("source_file")))
val data: List[Array[String]] = reader.lines().iterator().asScala.toList.tail.map(_.split(","))
reader.close()
data.foreach { row =>
  val name: String = row.head
  val age: Int = row.last.toInt

  // Insert the data into the MySQL table
  pstmt.setString(1, name)
  pstmt.setInt(2, age)
  pstmt.executeUpdate()
}

println("data inserted success")

// Close the prepared statement and the database connection
pstmt.close()
cnx.close()

    }
  
}
