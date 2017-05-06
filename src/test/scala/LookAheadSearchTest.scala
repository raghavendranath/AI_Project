import org.scalatest.FunSpec

/*
 * Runs all of the tests in TestUtility using LookAheadSearch heuristic
 */
class LookAheadSearchTest extends FunSpec {
  def helper(grid: Grid, expectedPath: List[Point]): Unit = {
    val path = LookAheadSearch.search(grid, 3)
    grid.addFinalPath(path)
    println(grid.statsToString())
    assert(path == expectedPath)
  }

  registerTest("Simple lookahead search") {
    val expectedPath = List(new Point(0.0,0.0), new Point(2.0,1.0), new Point(8.0,1.0), new Point(10.0,10.0))
    helper(TestUtility.SimpleTest1, expectedPath)
  }

  registerTest("Simple lookahead search 2") {

    val expectedPath = List(new Point(0,0), new Point(10,10))
    helper(TestUtility.SimpleTest2, expectedPath)
  }

  registerTest("Moderate lookahead search (Backtracking)") {
    val expectedPath = List(new Point(0.0,0.0), new Point(5.0,10.0), new Point(20.0,5.0), new Point(20.0,20.0))
    helper(TestUtility.ModerateTest1, expectedPath)
  }

  registerTest("Moderate lookahead search 2") {
    val expectedPath = List(new Point(0.0,0.0), new Point(0.0,2.0), new Point(11.0,20.0), new Point(20.0,20.0))
    helper(TestUtility.ModerateTest2, expectedPath)
  }

  registerTest("Moderate lookahead search 3") {

    val expectedPath = List(new Point(0,0), new Point(0,14), new Point(3,15), new Point(20,20))
    helper(TestUtility.ModerateTest3, expectedPath)
  }

  registerTest("Moderate lookahead search 4 (Backtracking)") {
    val expectedPath = List(new Point(0.0,0.0), new Point(5.0,10.0), new Point(11.0,11.0), new Point(20.0,20.0))
    helper(TestUtility.ModerateTest4, expectedPath)
  }

  registerTest("Difficult lookahead search") {
    val expectedPath = List(new Point(0.0,0.0), new Point(11.0,0.0), new Point(20.0,0.0), new Point(20.0,20.0))
    helper(TestUtility.DifficultTest1, expectedPath)
  }

  registerTest("Difficult lookahead search 2") {
    val expectedPath = List(new Point(0.0,0.0), new Point(5.0,7.0), new Point(2.0,20.0), new Point(20.0,20.0))
    helper(TestUtility.DifficultTest2, expectedPath)
  }

  registerTest("Difficult lookahead search 3") {
    val expectedPath = List(new Point(0.0,0.0), new Point(10.0,0.0), new Point(15.0,0.0), new Point(20.0,20.0))
    helper(TestUtility.DifficultTest3, expectedPath)
  }

  registerTest("Difficult lookahead search 4") {
    val expectedPath = List(new Point(8.0,2.0), new Point(10.0,0.0), new Point(15.0,0.0), new Point(20.0,20.0))
    helper(TestUtility.DifficultTest4, expectedPath)
  }

  registerTest("Impossible lookahead search") {
    val expectedPath = List()
    helper(TestUtility.ImpossibleTest1, expectedPath)
  }

  registerTest("Impossible lookahead search 2") {
    val expectedPath = List()
    helper(TestUtility.ImpossibleTest2, expectedPath)
  }

  registerTest("Impossible lookahead search 3") {
    val expectedPath = List()
    helper(TestUtility.ImpossibleTest3, expectedPath)
  }

  registerTest("Large lookahead search") {
    val expectedPath = List(new Point(30.0,5.0), new Point(78.0,25.0), new Point(71.0,43.0), new Point(70.0,70.0))
    helper(TestUtility.LargeTest1, expectedPath)
  }

  registerTest("Large lookahead search 2") {
    val expectedPath = List(new Point(20.0,10.0), new Point(32.0,27.0), new Point(83.0,95.0), new Point(70.0,100.0))
    helper(TestUtility.LargeTest2, expectedPath)
  }

  registerTest("Large lookahead search 3") {
    val expectedPath = List(new Point(5.0,95.0), new Point(0.0,93.0), new Point(0.0,10.0), new Point(30.0,50.0))
    helper(TestUtility.LargeTest3, expectedPath)
  }

  registerTest("Large lookahead search 4") {
    val expectedPath = List(new Point(10,20), new Point(65,28), new Point(100,70), new Point(100,80))
    helper(TestUtility.LargeTest4, expectedPath)
  }

  registerTest("Large lookahead search 5") {
    val expectedPath = List(new Point(50.0,65.0), new Point(51.0,88.0), new Point(0.0,31.0), new Point(0.0,11.0), new Point(5.0,5.0))
    helper(TestUtility.LargeTest5, expectedPath)
  }

  registerTest("Large lookahead search 6") {
    val expectedPath = List(new Point(33.0,30.0), new Point(19.0,42.0), new Point(30.0,38.0), new Point(32.0,26.0), new Point(33.0,35.0), new Point(28.0,14.0), new Point(59.0,15.0), new Point(79.0,19.0), new Point(56.0,36.0))
    helper(TestUtility.LargeTest6, expectedPath)
  }

  registerTest("large lookahead search 7") {
    val expectedPath = List(new Point(0.0,0.0), new Point(4.0,60.0), new Point(32.0,49.0), new Point(62.0,99.0), new Point(75.0,92.0))
    helper(TestUtility.LargeTest7, expectedPath)
  }
}