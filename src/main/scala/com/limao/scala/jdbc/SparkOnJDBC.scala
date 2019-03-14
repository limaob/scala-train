package com.limao.scala.jdbc

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SQLContext


object SparkOnJDBC {


  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName("label").setMaster("local")
      //.setJars(Array("D:\\Develop\\apache-maven-3.5.3\\respository\\mysql\\mysql-connector-java\\5.1.46\\mysql-connector-java-5.1.46.jar"))
    val sc = new SparkContext(sparkConf)
    val sqlContext = new SQLContext(sc)
    val df = sqlContext.read.format("jdbc").options(
      Map("url" -> "jdbc:mysql://192.168.212.59:3306/awifi_capacity?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&autoReconnect=true&failOverReadOnly=false&maxReconnects=1000&initialTimeout=30",
        "driver" -> "com.mysql.jdbc.Driver",
        "dbtable" -> "capacity_pub_area",
        "user" -> "DBcenter",
        "password" -> "root@2016"
      )).load()
    df.sqlContext.sql("select id,parent_id,area_name,area_full_name from capacity_pub_area")

    //sqlContext.setConf()

  }


  def connJDBC(): Unit = {
    val url = "jdbc:mysql://192.168.212.59:3306/awifi_capacity?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&autoReconnect=true&failOverReadOnly=false&maxReconnects=1000&initialTimeout=30"
    val tableName = "center_pub_industry_label"
    val prop = new java.util.Properties
    prop.setProperty("driver", "com.mysql.jdbc.Driver")
    prop.setProperty("user", "DBcenter")
    prop.setProperty("fetchSize", "100000")
    prop.setProperty("password", "root@2016")

  }

}
