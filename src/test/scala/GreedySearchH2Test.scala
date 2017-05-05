import org.scalatest.FunSpec

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

  registerTest("Very Large greedy search") {
    val expectedPath = List(new Point(100,100), new Point(383,0), new Point(794,0), new Point(565,164), new Point(461,317), new Point(434,455), new Point(446,511), new Point(549,681), new Point(649,742), new Point(795,619), new Point(724,501), new Point(700,520))
    helper(TestUtility.VeryLargeTest1, expectedPath)
  }

  registerTest("Very Large greedy search 2") {
    val expectedPath = List(new Point(550.0,400.0), new Point(580.0,363.0), new Point(545.0,357.0), new Point(446.0,378.0), new Point(593.0,52.0), new Point(703.0,9.0), new Point(749.0,29.0), new Point(776.0,844.0), new Point(793.0,887.0), new Point(837.0,977.0), new Point(900.0,900.0))
    helper(TestUtility.VeryLargeTest2, expectedPath)
  }
}
