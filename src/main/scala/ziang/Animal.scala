package ziang

// Abstract class
abstract class Creature() {}

// Inheritance from an abstract class
class Animal(protected var name: String, protected var sound: String) extends Creature() {  // Primary constructor

  protected val id: Int = Animal.newIdNum()  // 调用下面companion object中的静态方法
  this.setName(name)
  this.setSound(sound)

  // Auxiliary constructors
  def this(name: String) = {
    this(name, "No Sound")
  }

  // Getters
  def getName: String = name
  def getSound: String = sound

  // Setters
  def setName(name: String): Unit = {
    if (name.matches(".*\\d+.*")) {  // name contains digits
      this.name = "No Name"
    } else {
      this.name = name
    }
  }
  def setSound(sound: String): Unit = this.sound = sound

  override def toString: String = s"${this.name} with id ${this.id} says ${this.sound}"
}

// Companion object
// 专门存放静态变量/方法
object Animal {
  private var idNum: Int = 0

  private def newIdNum(): Int = {
    idNum += 1
    idNum
  }
}

// Inheritance from a concrete class
class Dog(name: String, sound: String, private val growl: String) extends Animal(name, sound) {

  // Auxiliary constructors
  def this(name: String) = {
    this(name, "No Sound", "No Growl")
  }
  def this(name: String, sound: String) = {
    this(name, sound, "No Growl")
  }

  override def toString: String = s"${this.name} with id ${this.id} says ${this.sound} or ${this.growl}"
}
