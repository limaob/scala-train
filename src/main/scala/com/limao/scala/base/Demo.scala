package com.limao.scala.base

object Demo {
  def main(args: Array[String]) {
    def main(args: Array[String]) {
      print("请输入菜鸟教程官网 : " )
      val line = Console.readLine()

      println("谢谢，你输入的是: " + line)
    }

    /*val x = Demo(5)
    println(x)

    x match
    {
      case Demo(num) => println(x + " 是 " + num + " 的两倍！")
      //unapply 被调用
      case _ => println("无法计算")
    }
*/
  }
  def apply(x: Int) = x*2
  def unapply(z: Int): Option[Int] = if (z%2==0) Some(z/2) else None
}
