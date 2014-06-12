/**
 * Ethan Petuchowski
 * 6/12/14
 */
object A extends App {
  println("asdf")
}

trait Semester {
  val inmateNames: Vector[String]
  val numJobs: Int
  val maxVotes: Int
  lazy val inmates: Vector[Person] = inmateNames map Person // lazy bc base hasn't been set yet

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

trait Solver extends Semester {
  // TODO
}
