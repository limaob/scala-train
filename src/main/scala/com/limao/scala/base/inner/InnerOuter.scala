package com.limao.scala.base.inner

import com.limao.scala.base.inner

object InnerOuter {
  def main(args: Array[String]): Unit = {
    val outer: ScalaOuter = new ScalaOuter()
    val inner = new outer.ScalaInner()
    inner.info();

    // 创建静态内部类
    val staticInner = new ScalaOuter.ScalaStaticInner
  }
}


// 外部类
// 外部类
class ScalaOuter {
  outer =>       //这里我们可以这里理解 外部类的别名 看做是外部类的一个实例
  var name = "xxx"
  private var sal = 12000.6

  //成员内部类
  class ScalaInner {
    // 推荐使用别名访问outer.属性
    def info() = println("name = " + outer.name + "\tsal = " + ScalaOuter.this.sal)
  }

}


object ScalaOuter { // 伴生对象
class ScalaStaticInner {} // 静态内部类
}