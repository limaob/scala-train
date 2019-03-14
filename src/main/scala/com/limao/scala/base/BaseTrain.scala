package com.limao.scala.base

import com.limao.scala.base.constructor.Person

import scala.util.control.Breaks


object BaseTrain {


  def main(args: Array[String]): Unit = {
    // test
    // test01
    // test02
    // solveEquation(1, 4, 4)
    // loop
    // sumNum
    //println("第20位的斐波那契数为: " + fibonacciSum(20));
    //defaultParam(name = "limaob", age = 26)
    //handlerExce
    val person = new Person("limaob", 18)
    println(person)


  }

  def test: Unit = {
    var n: Byte = 10
    var ch: Char = 'a'
    println((n + ch).toChar)
    println("123.5".toFloat)
  }

  def test01(): Unit = {
    var r1: Int = 10 / 3 // 3
    println("r1=" + r1)
    var r2: Double = 10 / 3 // 3.0
    println("r2=" + r2)
    var r3: Double = 10.0 / 3 // 3.333333
    println("r3=" + r3)
    println("r3=" + r3.formatted("%.2f")) // 3.33
  }

  /**
    * 测试位运算符
    */
  def test02(): Unit = {
    var a: Int = 256
    // >> 与 >>= 的区别
    println("右移: " + (a >>= 2) + "\ta: " + a) // 右移两位: ()	a: 64
    println("左移: " + (a << 3)) // 左移: 512
    println("无符号右移: " + (-1 >>> 10)) // 无符号右移: 4194303

  }


  /**
    * 求方程的解ax*x + bx +c = 0
    */
  def solveEquation(a: Int, b: Int, c: Int): Unit = {
    val m = b * b - 4 * a * c
    if (m > 0) {
      var x1 = (-b + math.sqrt(m)) / 2 * a * c
      var x2 = (-b - math.sqrt(m)) / 2 * a * c
      println(s"该方程有两个解分别为: ${x1}与" + x2.formatted("%.2f"))
    } else if (m == 0) {
      println(s"该方程只有一个解为: ${-b / 2 * a * c}")
    } else {
      println("该方程无解...")
    }
  }


  /**
    * 测试循环
    */
  def loop(): Unit = {

    for (i <- 1 to 5) {
      print(i + "\t")
    }
    var list = List("a", "b", "c")
    for (item <- list) {
      println("hello " + item)
    }
    // 守卫循环
    for (i <- 1 until 5 if i != 2) {
      print(i + "\t") //1 3 4
    }
    println()
    // 嵌套循环
    for (i <- 1 to 3; j <- 1 to 3) {
      println(" i =" + i + " j = " + j)
    }
    // 循环返回值  返回一个
    val res = for (i <- 1 to 10) yield {
      if (i % 2 == 0) {
        i
      } else {
        "不是偶数"
      }
    }
    println(res) // Vector(不是偶数, 2, 不是偶数, 4, 不是偶数, 6, 不是偶数, 8, 不是偶数, 10)

    var i = 0
    while (i < 2) {
      println("测试while循环..." + "\t" + i)
      i += 1
    }
    var j = 0
    do {
      println("测试do-while循环..." + "\t" + j)
      j += 1
    } while (j < 2)
  }

  /**
    * 100 以内的数求和，求出当和 第一次大于 20 的当前数
    * 使用 break()
    */
  def sumNum(): Unit = {
    var sum = 0
    val breaks = new Breaks()
    breaks.breakable({
      for (i <- 1 to 100) {
        sum += i
        if (sum > 20) {
          println(sum)
          breaks.break()
        }
      }
    })
    /*
    import util.control.Breaks._
    breakable{
      for(i<- 1 to 100){
        sum += i
        if(sum > 20){
          println(sum)
          breaks.break()
        }
      }
    }*/
  }


  /**
    * 斐波那契数 1,1,2,3,5,8,13...
    */

  def fibonacciSum(n: Int): Int = {

    if (n < 3) {
      return 1

    } else {
      return fibonacciSum(n - 1) + fibonacciSum(n - 2)
    }
  }


  /**
    * 测试默认参数
    */
  def defaultParam(name: String = "xxx", age: Int = 18, height: Double = 1.81): Unit = {

    println(name + "的年龄是" + age + "，身高为" + height)

  }


  @throws(classOf[NumberFormatException])//等同于 NumberFormatException.class
  def handlerExce() = {
    "abc".toInt
  }


}
