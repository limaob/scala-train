package com.limao.scala.base.constructor


object PersonTest {
  def main(args: Array[String]): Unit = {
    val person = new Person("limaob", 18)
    person.name
    println(person)

  }
}


class Person(inName: String, inAge: Int) {


  var name: String = inName
  private[this] var age = inAge

  override def toString: String = {
    "name = " + name + "\tage = " + age
  }

  def this(name: String) {
    this("jack", 10)
    this.name = name
  }

}
