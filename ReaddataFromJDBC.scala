import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import scala.io.StdIn.readLine
import java.sql.ResultSet
import java.sql.Statement
object ReaddataFromJDBC {
  def main(args: Array[String]): Unit = {

    val driver="com.mysql.cj.jdbc.Driver"
    val url="Jdbc:mysql://localhost:3306/emp"
    var username="root"
    val password="root"

    try {
        
        Class.forName(driver)
        println("Enter Employee name")

        val ena=readLine()
       var connetion:Connection=DriverManager.getConnection(url,username,password)
       val query=s"SELECT * FROM emp WHERE ename='$ena'"

       // val ps:PreparedStatement=connetion.prepareStatement(query)
       val stmt:Statement=connetion.createStatement()
        //ps.setString(1,ena)
        var rs:ResultSet=stmt.executeQuery(query)
        while(rs.next())
        {
            val eid=rs.getString(1)
            val ename=rs.getString(2)
            val age=rs.getString(3)
            val sal=rs.getString(4)

            println(eid)
            println(ename)
            println(age)
            println(sal)
        }

        


    } catch {
        case e: Exception => e.printStackTrace
    }

  } 
}
