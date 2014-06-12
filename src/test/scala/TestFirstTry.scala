import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TestFirstTry extends FunSuite {

  /**
   * This method would theoretically check against the brute force case
   * but that doesn't make sense to do if I'm *using* the brute force case.
   *
   * In evaluating an *approximate* solution, it makes sense for this to tell
   * *how closely* the approximation was done to optimal.
   */
  trait SolutionChecker extends Semester with Solver

  trait MiniHouse extends SolutionChecker {
    val inmateNames = Vector("A", "B", "C")
    val maxVotes = 2
    val numJobs = 4
  }

  test("inmate vector constructed from names") {
    new MiniHouse {
      assert(inmates === Vector(Person("A"), Person("B"), Person("C")))
    }
  }
}
