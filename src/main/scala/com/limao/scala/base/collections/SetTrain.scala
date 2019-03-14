package com.limao.scala.base.collections

import scala.collection.mutable

object SetTrain {
  def main(args: Array[String]): Unit = {
    // 不可变set
    // 自动帮你去重复
    val set = Set(1, 1, 2, 3)
    println(set)
    // 可变set
    val set2 = mutable.Set(1, 1, 2, 3)
    set2.add(4)
    set2 += (5, 6) // +=5
    set2.+=(7)
    println(set2)

    // 删除元素
    set2.remove(1)
    set2 -= (3, 4)
    println(set2)


  }
}
