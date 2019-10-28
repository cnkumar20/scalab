/**

package cnkumar20.lab.scala

import cnkumar20.lab.scala.Tubular


trait SparkSessionWrapper extends Serializable {

  lazy val spark: Unit = {
    val spark = SparkSession.builder().master("local").appName("spark session").getOrCreate()
    import spark.implicits._
    val a = spark.sparkContext
    val accessKeyId = System.getenv("AWS_ACCESS_KEY_ID")
    val secretAccessKey = System.getenv("AWS_SECRET_ACCESS_KEY")
    a.hadoopConfiguration.set("fs.s3n.awsAccessKeyId", accessKeyId)
    a.hadoopConfiguration.set("fs.s3n.awsSecretAccessKey", secretAccessKey)
    spark.sparkContext.hadoopConfiguration.set("fs.s3n.impl", "org.apache.hadoop.fs.s3native.NativeS3FileSystem")

    val df = List("sue", "fan").toDF("test")
    val betterDF = df.transform(Tubular.withGoodVibes())

    betterDF.show()
    betterDF.coalesce(1).write
      .format("com.databricks.spark.csv")
      .option("header","true")
      .save("s3n://cc-core-bidlogs-dev/")
  }

}

  *
  */

