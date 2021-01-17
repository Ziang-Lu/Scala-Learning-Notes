package ziang

case class MyCaseClass(empId: Int, empName: String, empAddress: String)
// 自动定义了 equals / hashCode / copy / toString 等方法

object CaseClassDemo {
  def main(args: Array[String]): Unit = {
    val m1 = MyCaseClass(100, "Test1", "Somewhere1")
    val m2 = MyCaseClass(200, "Test2", "Somewhere2")

    println(m1 == m2)  // false
    val m3 = m1.copy()
    println(m1 == m3)  // true

    // Copy all the fields, but overriding some fields
    val m4 = m1.copy(empId = 400)
  }
}
