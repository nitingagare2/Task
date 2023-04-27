import org.apache.spark.sql.SparkSession
object Spatk11 extends App {
  val spark = SparkSession.builder()
      .master("local[1]")
      .appName("SparkByExamples.com")
      .getOrCreate();
  println(spark)
  println("Spark Version : "+spark.version)
  println("*$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$*$*#*")
}
