import java.util.Date
import java.time.format.DateTimeFormatter
import java.time.LocalDate
object Date111 {
  

    def main(args: Array[String]): Unit = {
        
        val date="21/01/2018"
        val d=calcexp(date)

        val sal=50000
        val newsal:Double=sal+(sal*5/100)
        println(newsal)

        //println("year of experience : "+d)

    }
    def calcexp(date:String):Double={
        val formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy")
        val sd=LocalDate.parse(date,formatter)
        println(sd)
        val cd=LocalDate.now()
        println(cd)
        val yoe:Double=cd.getYear()-sd.getYear()
        val m:Double=(cd.getDayOfYear()-sd.getDayOfYear())/365
        println(m)
        yoe
    }
}

// import java.time.LocalDate
// import java.time.format.DateTimeFormatter

// def calculateExperienceYears(dateString: String): Double = {
//   val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
//   val startDate = LocalDate.parse(dateString, formatter)
//   val currentDate = LocalDate.now()
//   val yearsOfExperience = currentDate.getYear() - startDate.getYear() + (currentDate.getDayOfYear() - startDate.getDayOfYear()) / 365.0
//   yearsOfExperience
// }

