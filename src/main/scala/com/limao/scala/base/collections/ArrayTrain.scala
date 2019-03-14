package com.limao.scala.base.collections

import java.util

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer


object ArrayTrain {



  def main(args: Array[String]): Unit = {

    //arrayBufferToList

    listToArrayList

  }

  private def arrayBufferToList = {
    import scala.collection.JavaConversions.bufferAsJavaList
    /*
    implicit def bufferAsJavaList[A](b : scala.collection.mutable.Buffer[A]) : java.util.List[A] = { /*
    compiled code */ }
    */
    val arr = ArrayBuffer("q", "w", "r")
    val list = new util.ArrayList[String]()
    list.addAll(arr)
    val javaArr = new ProcessBuilder(arr) //为什么可以这样使用?
    // 这里 arrList 就是 java 中的 List
    val arrList = javaArr.command()
    println(arr)
    println(list)
    println(arrList)
  }

  private def listToArrayList ={

    // asScalaBuffer 隐式函数
    import scala.collection.JavaConversions.asScalaBuffer

    val list = new util.ArrayList[String]()
    list.add("1234")
    list.add("1234")
    list.add("1234")
    val scalaArr: mutable.Buffer[String] = list
    println(scalaArr)
    println(list)
  }

}
