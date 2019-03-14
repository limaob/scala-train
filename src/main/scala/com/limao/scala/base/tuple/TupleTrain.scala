package com.limao.scala.base.tuple


object TupleTrain {
  def main(args: Array[String]): Unit = {
    val tuple = (1,2,3,4,5,"qwer")
    println(tuple.productElement(1))
    println(tuple)
    // 元组遍历
    for (item <- tuple.productIterator){
      println(item)
    }
  }
}
