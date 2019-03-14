package com.limao.scala.base.constructor

object Extends {


  def main(args: Array[String]): Unit = {
    val sub = new Sub()
    sub.sayOk()

    // 获取class名
    println(classOf[Sub])
    val base = new Sub
    // 判断对象类型
    println(base.isInstanceOf[Sub])

    // 强转
    base.asInstanceOf[Sub].sayOk()

  }

}


class Base{
  var n1: Int = 1 //public n1() , public n1_$eq()
  protected var n2: Int = 2
  private var n3: Int = 3 // private n3() , private n3_$eq()
  def test100(): Unit = { // 默认 public test100()
    println("base 100")
  }
  protected def test200(): Unit = { // ？
    println("base 200")
  }
  private def test300(): Unit = { //private
    println("base 300")
  }

}

/**
  * 私有属性不能继承
  */
class Sub extends Base {
  def sayOk(): Unit = {
    this.n1 = 20 //这里访问本质 this.n1_$eq()
    this.n2 = 40
    // this.n3   // 不能访问到
    println("范围" + this.n1 + this.n2)
    test100() //
    test200() //
    // test300   // 不能访问到
  }
}
