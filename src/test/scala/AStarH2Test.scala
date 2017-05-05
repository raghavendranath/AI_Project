import org.scalatest.FunSpec

class AStarH2Test extends FunSpec{
  def helper(grid: Grid, expectedPath: List[Point]): Unit = {
    val path = AStarH2.search(grid)
    grid.addFinalPath(path)
    println(grid.statsToString())
    assert(path == expectedPath)
  }

  registerTest("Simple A* search") {
    val expectedPath = List(new Point(0,0), new Point(2,2), new Point(6,4), new Point(7,5), new Point(10,10))
    helper(TestUtility.SimpleTest1, expectedPath)
  }

  registerTest("Simple A* search 2") {
    val expectedPath = List(new Point(0,0), new Point(10,10))
    helper(TestUtility.SimpleTest2, expectedPath)
  }

  registerTest("Moderate A* search (Backtracking)") {
    val expectedPath = List(new Point(0,0), new Point(9,10), new Point(11,15), new Point(15,18), new Point(20,20))
    helper(TestUtility.ModerateTest1, expectedPath)
  }

  registerTest("Moderate A* search 2") {
    val expectedPath = List(new Point(0,0), new Point(1,0), new Point(20,20))
    helper(TestUtility.ModerateTest2, expectedPath)
  }

  registerTest("Moderate A* search 3") {
    val expectedPath = List(new Point(0,0), new Point(4,4), new Point(8,5), new Point(16,12), new Point(20,20))
    helper(TestUtility.ModerateTest3, expectedPath)
  }

  registerTest("Moderate A* search 4 (Backtracking)") {
    val expectedPath = List(new Point(0,0), new Point(5,10), new Point(10,11), new Point(20,20))
    helper(TestUtility.ModerateTest4, expectedPath)
  }

  registerTest("Difficult A* search") {
    val expectedPath = List(new Point(0,0), new Point(3,0), new Point(10,4), new Point(15,14), new Point(20,20))
    helper(TestUtility.DifficultTest1, expectedPath)
  }

  registerTest("Difficult A* search 2") {
    val expectedPath = List(new Point(0,0), new Point(5,7), new Point(5,8), new Point(10,17), new Point(16,20), new Point(20,20))
    helper(TestUtility.DifficultTest2, expectedPath)
  }

  registerTest("Difficult A* search 3") {
    val expectedPath = List(new Point(0,0), new Point(0,6), new Point(1,11), new Point(8,17), new Point(20,20))
    helper(TestUtility.DifficultTest3, expectedPath)
  }

  registerTest("Difficult A* search 4") {
    val expectedPath = List(new Point(8,2), new Point(10,0), new Point(15,0), new Point(20,20))
    helper(TestUtility.DifficultTest4, expectedPath)
  }

  registerTest("Impossible A* search") {
    val expectedPath = List()
    helper(TestUtility.ImpossibleTest1, expectedPath)
  }

  registerTest("Impossible A* search 2") {
    val expectedPath = List()
    helper(TestUtility.ImpossibleTest2, expectedPath)
  }

  registerTest("Impossible A* search 3") {
    val expectedPath = List()
    helper(TestUtility.ImpossibleTest3, expectedPath)
  }

  registerTest("Large A* search") {
    val expectedPath = List(new Point(30,5), new Point(44,11), new Point(50,15), new Point(61,28), new Point(70,70))
    helper(TestUtility.LargeTest1, expectedPath)
  }

  registerTest("Large A* search 2") {
    val expectedPath = List(new Point(20,10), new Point(32,27), new Point(58,76), new Point(60,100), new Point(70,100))
    helper(TestUtility.LargeTest2, expectedPath)
  }

  registerTest("Large A* search 3") {
    val expectedPath = List(new Point(5,95), new Point(0,93), new Point(0,90), new Point(0,88), new Point(0,81), new Point(10,75), new Point(30,50))
    helper(TestUtility.LargeTest3, expectedPath)
  }

  registerTest("Large A* search 4") {
    val expectedPath = List(new Point(10,20), new Point(23,30), new Point(35,40), new Point(42,45), new Point(52,50), new Point(93,63), new Point(100,70), new Point(100,80))
    helper(TestUtility.LargeTest4, expectedPath)
  }

  registerTest("Large A* search 5") {
    val expectedPath = List(new Point(50,65), new Point(42,77), new Point(37,69), new Point(0,31), new Point(0,11), new Point(5,5))
    helper(TestUtility.LargeTest5, expectedPath)
  }

  registerTest("Large A* search 6") {
    val expectedPath = List(new Point(33,30), new Point(28,14), new Point(59,15), new Point(70,18), new Point(59,33), new Point(56,36))
    helper(TestUtility.LargeTest6, expectedPath)
  }

  registerTest("Very Large A* search") {
    val expectedPath = List(new Point(100,100), new Point(186,76), new Point(348,57), new Point(368,58), new Point(356,95), new Point(420,114), new Point(448,149), new Point(434,455), new Point(446,511), new Point(549,681), new Point(649,742), new Point(795,619), new Point(731,551), new Point(700,520))
    helper(TestUtility.VeryLargeTest1, expectedPath)
  }

  registerTest("Very Large A* search 2") {
    val expectedPath = List(new Point(550.0,400.0), new Point(549.0,365.0), new Point(533.0,193.0), new Point(593.0,52.0), new Point(703.0,9.0), new Point(749.0,29.0), new Point(776.0,844.0), new Point(793.0,887.0), new Point(837.0,977.0), new Point(900.0,900.0))
    helper(TestUtility.VeryLargeTest2, expectedPath)
  }
}
