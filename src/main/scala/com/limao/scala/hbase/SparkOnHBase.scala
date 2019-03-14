package com.limao.scala.hbase

import java.io.IOException

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.hbase.client.{Admin, Connection, ConnectionFactory}
import org.apache.hadoop.hbase._
import org.apache.spark.{SparkConf, SparkContext}




object SparkOnHBase {

  def main(args: Array[String]): Unit = {
//    var sparkConf = new SparkConf().setAppName("SparkOnHBase").setMaster("local")

//    var sc = new SparkContext(sparkConf)

    // 获取 HBase 连接
    val conn = ConnectionFactory.createConnection(getConf())

    createTable(conn, "spark:test-spark")


    // 关闭连接
    close(conn)

  }


  def getConf(): Configuration = {
    val conf = HBaseConfiguration.create()
    /**
      * 1.配置zookeeper相关信息
      */
    conf.set(HConstants.ZOOKEEPER_QUORUM, "192.168.213.25,192.168.213.26,192.168.213.27")
    conf.set(HConstants.ZOOKEEPER_CLIENT_PORT, "2181")
    /**
      * 2.配置kerberos相关信息
      */
/*    conf.set("hadoop.rpc.protection", "privacy")
    conf.set("hadoop.security.authentication", "kerberos")
    conf.set("hbase.security.authentication", "kerberos")
    conf.set("hbase.master.kerberos.principal", "hbase/_HOST@AWIFI.COM")
    conf.set("hbase.regionserver.kerberos.principal", "hbase/_HOST@AWIFI.COM")*/

    return conf
  }

  /**
    * 创建表
    * @param conn HBase 连接
    * @param tableName 表名
    */
  def createTable(conn: Connection, tableName: String): Unit = {
    var admin: Admin = null
    try {
      admin = conn.getAdmin
      val nsd = NamespaceDescriptor.create("spark").build()
      admin.createNamespace(nsd);
      val tName = TableName.valueOf(tableName)
      if (!admin.tableExists(tName)) {
        val tableDescriptor = new HTableDescriptor(tName)
        tableDescriptor.addFamily(new HColumnDescriptor("info".getBytes()))
        admin.createTable(tableDescriptor)
        println("you have succeed create a table------------")
      } else {
        println("table " + tName + " already exists")
      }
    } finally {
      if ( null != admin) {
        try {
          admin.close()
          println("关闭成功!")
        } catch {
          case e: IOException => println("关闭失败!")
        }
      }
    }
  }


  // 关闭 connection 连接
  def close(connection: Connection)={
    if (connection!=null){
      try{
        connection.close()
        println("关闭成功!")
      }catch{
        case e:IOException => println("关闭失败!")
      }
    }
  }
}
