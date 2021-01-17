package ziang

// Trait definition (Similar to interfaces in Java)
// 区别在于可以存放state variables, 也可以定义concrete method
trait Flyable {
  // Method declaration
  def fly(): String
}

trait BulletProof {
  def hitByBullet(): String

  // Concrete method
  def ricochet(startSpeed: Double): String = "the bullet is of speed %.1f ft/sec".format(startSpeed * 0.75)
}

class SuperHero(private val name: String) extends Flyable with BulletProof {
  override def fly(): String = s"${this.name} flies through the air"

  override def hitByBullet(): String = s"The bullet bounces off of ${this.name}"
}

object SuperHero {
  def main(args: Array[String]): Unit = {
    val ironman = new SuperHero("Tony")
    println(ironman.fly())
  }
}
