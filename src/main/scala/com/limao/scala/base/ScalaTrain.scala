package com.limao.scala.base

object ScalaTrain {


  def main(args: Array[String]): Unit = {
    /*def numsForm(n:BigInt):Stream[BigInt]= n #:: numsForm(n+1)

    val squares = numsForm(5)

    squares.take(2).foreach(num => println(num))*/


    //testCase

/*    for (k <- System.getProperties.stringPropertyNames())
      println (k)


    val strings = System.getProperties.stringPropertyNames()*/
    

  }


  def testCase(): Unit ={

    for (arr <-  Array ( Array (0),  Array (1, 0),  Array (0, 1, 0),  Array (1, 1, 0))) {
      val result = arr  match {
        case  Array (0) =>  "0"
        case  Array (x, y) => x +  " " + y
        case  Array (0, _*) =>  "0 ..."
        case _ =>

      }
      println (result)
    }
  }

  def testCase01 = {
    for (ch <- "+--3!") {
      var sign = 0
      var digit = 0
      ch match {
        case '+' => sign = 1
        case ' ' => sign = -1
        case _ if Character.isDigit(ch) => digit = Character.digit(ch, 10)
        case _ => sign = 0
      }
      println(ch + " " + sign + " " + digit)
    }
  }
}
