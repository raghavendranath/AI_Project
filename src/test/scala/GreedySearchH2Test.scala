import org.scalatest.FunSpec

/*
 * Runs all of the tests in TestUtility using GreedySearchH2 heuristic
 */
class GreedySearchH2Test extends FunSpec{
  def helper(grid: Grid, expectedPath: List[Point]): Unit = {
    val path = GreedySearchH2.search(grid)
    grid.addFinalPath(path)
    println(grid.statsToString())
    assert(path == expectedPath)
  }

  registerTest("Simple greedy search") {
    val expectedPath = List(new Point(0,0), new Point(4,6), new Point(4,8), new Point(10,10))
    helper(TestUtility.SimpleTest1, expectedPath)
  }

  registerTest("Simple greedy search 2") {
    val expectedPath = List(new Point(0,0), new Point(10,10))
    helper(TestUtility.SimpleTest2, expectedPath)
  }

  registerTest("Moderate greedy search (Backtracking)") {
    val expectedPath = List(new Point(0,0), new Point(12,12), new Point(11,15), new Point(15,18), new Point(20,20))
    helper(TestUtility.ModerateTest1, expectedPath)
  }

  registerTest("Moderate greedy search 2") {
    val expectedPath = List(new Point(0,0), new Point(10,0), new Point(14,4), new Point(20,20))
    helper(TestUtility.ModerateTest2, expectedPath)
  }

  registerTest("Moderate greedy search 3") {
    val expectedPath = List(new Point(0,0), new Point(0,14), new Point(3,15), new Point(20,20))
    helper(TestUtility.ModerateTest3, expectedPath)
  }

  registerTest("Moderate greedy search 4 (Backtracking)") {
    val expectedPath = List(new Point(0,0), new Point(5,10), new Point(11,11), new Point(20,20))
    helper(TestUtility.ModerateTest4, expectedPath)
  }

  registerTest("Difficult greedy search") {
    val expectedPath = List(new Point(0,0), new Point(20,0), new Point(20,20))
    helper(TestUtility.DifficultTest1, expectedPath)
  }

  registerTest("Difficult greedy search 2") {
    val expectedPath = List(new Point(0.0,0.0), new Point(0.0,20.0), new Point(20.0,20.0))
    helper(TestUtility.DifficultTest2, expectedPath)
  }

  registerTest("Difficult greedy search 3") {
    val expectedPath = List(new Point(0,0), new Point(0,20), new Point(20,20))
    helper(TestUtility.DifficultTest3, expectedPath)
  }

  registerTest("Difficult greedy search 4") {
    val expectedPath = List(new Point(8,2), new Point(7,3), new Point(1,11), new Point(8,17), new Point(20,20))
    helper(TestUtility.DifficultTest4, expectedPath)
  }

  registerTest("Impossible greedy search") {
    val expectedPath = List()
    helper(TestUtility.ImpossibleTest1, expectedPath)
  }

  registerTest("Impossible greedy search 2") {
    val expectedPath = List()
    helper(TestUtility.ImpossibleTest2, expectedPath)
  }

  registerTest("Impossible greedy search 3") {
    val expectedPath = List()
    helper(TestUtility.ImpossibleTest3, expectedPath)
  }

  registerTest("Large greedy search") {
    val expectedPath = List(new Point(30,5), new Point(78,25), new Point(62,58), new Point(70,70))
    helper(TestUtility.LargeTest1, expectedPath)
  }

  registerTest("Large greedy search 2") {
    val expectedPath = List(new Point(20,10), new Point(35,31), new Point(83,95), new Point(70,100))
    helper(TestUtility.LargeTest2, expectedPath)
  }

  registerTest("Large greedy search 3") {
    val expectedPath = List(new Point(5,95), new Point(0,93), new Point(0,54), new Point(2,38), new Point(23,34), new Point(30,50))
    helper(TestUtility.LargeTest3, expectedPath)
  }

  registerTest("Large greedy search 4") {
    val expectedPath = List(new Point(10,20), new Point(65,28), new Point(100,70), new Point(100,80))
    helper(TestUtility.LargeTest4, expectedPath)
  }

  registerTest("Large greedy search 5") {
    val expectedPath = List(new Point(50.0,65.0), new Point(42.0,77.0), new Point(3.0,32.0), new Point(0.0,31.0), new Point(0.0,11.0), new Point(5.0,5.0))
    helper(TestUtility.LargeTest5, expectedPath)
  }

  registerTest("Large greedy search 6") {
    val expectedPath = List(new Point(33,30), new Point(28,14), new Point(59,15), new Point(70,18), new Point(55,39), new Point(56,36))
    helper(TestUtility.LargeTest6, expectedPath)
  }

  registerTest("Large greedy search 7") {
    val expectedPath = List(new Point(0.0,0.0), new Point(17.0,54.0), new Point(55.0,74.0), new Point(60.0,95.0), new Point(75.0,92.0))
    helper(TestUtility.LargeTest7, expectedPath)
  }
}
