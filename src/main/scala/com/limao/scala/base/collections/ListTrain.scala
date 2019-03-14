package com.limao.scala.base.collections

import scala.collection.mutable.ListBuffer

object ListTrain {



  def main(args: Array[String]): Unit = {
    // ListTest
    // ListBufferTest

    // test01
    val names = List("Alice", "Bob", "Nick")
    val names2 = names.flatMap(_.toUpperCase)
    println(names2)
    
    val ints = List(1,2,3,4,5)
    // 调用 reduceRight 方法
    println(ints.reduce(_-_))
    // ((((1-2)-3)-4)-5)
    println(ints.reduceRight(_-_))
    // (1-(2-(3-(4-5))))
    println(ints.reduceLeft(_-_))
    // 求最小值
    println(ints.reduce((n1,n2) => if (n1 > n2) n2 else n1))
    // 保存每次中间值 Vector(3, 4, 6, 9, 13, 18)
    println((1 to 5).scan(3)(_+_))

  }

  private def test01 = {
    val list = ListBuffer(1, 2, 3)
    val list01 = list.map(num => num * 2)
    val list02 = list.map(_ * 2)
    println(list)
    println(list01)
    println(list02)
  }

  private def ListTest = {
    // List时不可变的 ListBuffer 可变
    val list = List[Int](1, 2, 3)
    val list01 = list :+ 4 // 返回List(1, 2, 3, 4)
    println(4 +: list01) // List(4, 1, 2, 3, 4)
    val list02 = list :: 2 :: Nil
    val list03 = list ::: 2 :: Nil
    println(list02) // List(List(1, 2, 3), 2)
    println(list03) // List(1, 2, 3, 2)

    println(list :+ list03) //List(1, 2, 3, List(1, 2, 3, 2))

    println("q" :: "w" :: list) //List(q, w, 1, 2, 3)
  }


  def ListBufferTest={
    val list = ListBuffer[Any]()
    println(list)
    list += "qwer"
    list += 1
    println(list)

    val list01 = new ListBuffer[Any]
    list01++=list
    list01.+("1")
    list01++list
    println(list01)


  }

}
