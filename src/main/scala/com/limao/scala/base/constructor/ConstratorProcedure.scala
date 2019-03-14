package com.limao.scala.base.constructor


object ConstratorProcedure {

  def main(args: Array[String]): Unit = {
    new Dog
  }

}


class Animal(aName: String) {
  var name: String = aName
  println("Animal")

  def this() {
    this("默认的名字")
    println("默认的名字")
  }
}


class Dog() extends Animal {

  println("dog")

  def this(dName: String) {
    //  只有主构造器可以调用父类的构造器  没有super()的语法
    this() // 调用主构造器
    this.name = dName
    println("dog 辅助构造器")
  }

}