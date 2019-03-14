package com.limao.scala.base.collections

import scala.collection.mutable


object MapTrain {
  def main(args: Array[String]): Unit = {
    // 不可变map
    val map = Map("Alice" -> 10, "Bob" -> 20, "Kotlin" -> "北京")
    println(map)
    // 可变map
    val map01 = mutable.Map("Alice" -> 10, "Bob" -> 20, "Kotlin" -> "北京")
    println(map01)
    // 添加元素 存在的话就覆盖
    map01 += ("Alice" -> 111)
    map01 += ("Alice" -> 111, "AAA" -> 33)
    println(map01)
    // 删除元素  不存在的元素也不会给报错
    map01 -= ("Alice", "AAA")
    map01 -= ("BBb")
    map01 -= "BBb"
    println(map01)
    // 遍历
    for ((k, v) <- map01) println(k + " is mapped to " + v)
    for (k <- map01.keys) println(k)
    for (v <- map01.values) println(v)
    for (v <- map01) println(v)
  }
}
