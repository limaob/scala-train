package com.limao.scala.base.constructor.mixin

// 特质混入
object MixInTrain {
  def main(args: Array[String]): Unit = {
    // 动态混入构造是从左到右   E A B C D
    val e = new E with D with C
    // 动态混入方法执行  从右到左
    e.test()
    // 构造顺序 E A B C D F最后才是执行自己
    val f = new F
  }
}


trait A {
  println("A")

  def test() = println("test-A")
}

trait B extends A {
  println("B")

  override def test() = {
    println("test-B")
    super.test()
  }
}

trait C extends B {
  println("C")

  override def test() = {
    println("test-C")
    super.test()  // super指的时左边的trait 左右没有trait的才执行B中的
    super[B].test() // 可以直接指定直接超类，不能指定别的
  }
}

trait D extends B {
  println("D")

  override def test() = {
    println("test-D")
    super.test()
  }
}

class E {
  println("E")
}
class F extends E with D with B{
  println("F")
}