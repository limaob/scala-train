package com.limao.scala.test


object TestFrock {

  def main(args: Array[String]): Unit = {
    println(Frock.getNextNum())
    println(Frock.getNextNum())

    val f1 = new Frock()
    val f2 = new Frock()
    val f3 = new Frock()
    println(f1.getSerialNumber)
    println(f2.getSerialNumber)
    println(f3.getSerialNumber)
  }

}


class Frock {

  private var serialNumber: Int = Frock.getNextNum()

  def getSerialNumber = {
    serialNumber
  }

}

object Frock {
  private var currentNum = 100000

  def getNextNum() = {
    currentNum += 100
    currentNum
  }
}
