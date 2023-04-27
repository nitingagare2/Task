import java.io.File
import java.sql.{Connection, DriverManager}
import scala.io.Source
import scala.util.{Failure, Success, Try}

object Task13 {
  def main(args: Array[String]): Unit = {
    // Read the target to source config file
    val configFilePath = "F:/Files/tasks/config2.json"
    val columnMapping = Source.fromFile(configFilePath).getLines()
      .map(line => line.split(","))
      .map(cols => (cols(0), cols(1)))
      .toMap

    // Open the CSV file
    val csvFilePath = "F:/Files/tasks/emp1.csv"
    val csvFile = new File(csvFilePath)

    // Connect to the MySQL database
    val url = "jdbc:mysql://localhost:3306/emp"
    val username = "root"
    val password = "root"

    val connTry = Try(DriverManager.getConnection(url, username, password))

    connTry match {
      case Success(conn) =>
        try {
          // Create the MySQL table if it doesn't exist
          val stmt = conn.createStatement()
          stmt.execute("CREATE TABLE IF NOT EXISTS mytable (col1 VARCHAR(255), col2 VARCHAR(255), col3 VARCHAR(255))")

          // Iterate through the rows of the CSV file and insert them into the MySQL table
          val csvLines = Source.fromFile(csvFile).getLines()
          for (line <- csvLines) {
            val cols = line.split(",").map(_.trim)

            for(j<-cols)
            {
              println(j)
            }
            //  val col1 = cols(columnMapping("col1"))
            //  val col2 = cols(columnMapping("col2"))
            //  val col3 = cols(columnMapping("col3"))

            //  val sql = "INSERT INTO mytable (col1, col2, col3) VALUES (?, ?, ?)"
            //  val pstmt = conn.prepareStatement(sql)
            //   pstmt.setString(1, col1)
            //  pstmt.setString(2, col2)
            //  pstmt.setString(3, col3)
            //     pstmt.executeUpdate()
          }
        } finally {
          conn.close()
        }

      case Failure(e) => e.printStackTrace()
    }
  }
}
