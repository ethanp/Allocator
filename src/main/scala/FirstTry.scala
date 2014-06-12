/**
 * Ethan Petuchowski
 * 6/12/14
 */
object A extends App {
  println("asdf")
}

trait Semester {
  val inmateNames: Vector[String]
  val numInmates = inmateNames.length  // remove this if it doesn't get used
  val numJobs: Int
  val maxVotes: Int
  val inmates: Vector[Person] = inmateNames map Person

  case class Preference(cost: Int)

  case class Person(name: String) {
    val prefs = Vector.fill[Preference](numJobs)(Preference(maxVotes+1))
  }

  // TODO future work...

  sealed abstract class Job(title: String, holder: Option[Person] = None)
  case class DCU(day: Day, holder: Option[Person] = None) extends Job(this.getClass.toString, holder)
  // etc.

  sealed abstract class Day
  case object Monday extends Day
  // etc.
}

