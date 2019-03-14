package com.limao.scala.base.collections

import scala.collection.mutable


object QueueTrain {


  def main(args: Array[String]): Unit = {
    // 通常使用可变的队列
    val q1 = new mutable.Queue[Int]
    q1 += 1
    println("q1: " + q1)
    q1 ++= List(4, 5, 7)
    println("q1: " + q1)
    val ele = q1.dequeue() //
    println("弹出的元素: " + ele + "q1: " + q1) // 弹出的元素: 1q1: Queue(4, 5, 7)
    q1.dequeueAll(_>5)
    println("q1: " + q1) // q1: Queue(4, 5)

  }
}
