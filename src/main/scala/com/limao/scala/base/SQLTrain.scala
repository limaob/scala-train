package com.limao.scala.base

import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}


object SQLTrain {


  case class Person(name: String, age: Long)

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("test").setMaster("local")
    val sc = new SparkContext(conf);
    val sqlContext = new SQLContext(sc)
    val df = sqlContext.read.json("C:\\Users\\limaob\\Desktop\\Spark\\data\\people.json")
    df.show()
    df.select("name").show()


  }


}
