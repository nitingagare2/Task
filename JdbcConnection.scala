import java.sql.Connection
import java.sql.DriverManager
import scala.io.StdIn.readLine
object JdbcConnection {
  def main(args: Array[String]): Unit = {

    val url = "jdbc:mysql://localhost:3306/emp"
    val driver = "com.mysql.cj.jdbc.Driver"
    val username = "root"
    val password = "root"
    var connection: Connection = null

    try {

      //println("enter emp name")
      //val ename=readLine()
      val age=28
      Class.forName(driver)
      connection = DriverManager.getConnection(url, username, password)
      val statement = connection.createStatement
      var sql="select * from emp where age="+age
      val rs = statement.executeQuery(sql)
      while (rs.next) {
       val eid = rs.getInt("eid")
        val ename = rs.getString("ename")
         
         val age=rs.getString("age")
         val sal=rs.getString("sal")       // println("host = %s, user = %s".format(host,user))
        println("Ename: "+ename)
        println("Eid: "+eid)
        println("Age: "+age)
        println("Salary: "+sal)
      }
    } catch {
      case e: Exception => e.printStackTrace
    }
    // connection.close
  }

}
