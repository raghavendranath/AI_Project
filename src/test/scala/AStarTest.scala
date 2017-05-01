import org.scalatest.FunSpec

class AStarTest extends FunSpec{
  registerTest("Simple A* search") {
    val grid = new Grid(List(
      new Polygon(List(new Point(2,1), new Point(3,1), new Point(3,2), new Point(2,2))),
      new Polygon(List(new Point(1,3), new Point(2,3), new Point(2,4), new Point(1,4))),
      new Polygon(List(new Point(3,4), new Point(4,4), new Point(4,6))),
      new Polygon(List(new Point(5,1), new Point(8,1), new Point(8,2), new Point(5,2))),
      new Polygon(List(new Point(6,4), new Point(7,5), new Point(5,8), new Point(4,8)))
    ), new Point(0,0), new Point(10,10))

    val path = AStar.search(grid)
    val expectedPath = List(new Point(0.0,0.0), new Point(2.0,2.0), new Point(6.0,4.0), new Point(7.0,5.0), new Point(10.0,10.0))
    assert(path == expectedPath)
  }

  registerTest("Simple A* search 2") {
    val grid = new Grid(List(
      new Polygon(List(new Point(2,1), new Point(3,1), new Point(3,2), new Point(2,2))),
      new Polygon(List(new Point(1,3), new Point(2,3), new Point(2,4), new Point(1,4))),
      new Polygon(List(new Point(3,4), new Point(4,4), new Point(4,6))),
      new Polygon(List(new Point(5,1), new Point(8,1), new Point(8,2), new Point(5,2)))
    ), new Point(0,0), new Point(10,10))

    val path = AStar.search(grid)
    val expectedPath = List(new Point(0,0), new Point(10,10))
    assert(path == expectedPath)
  }

  registerTest("Unreachable goal") {
    val grid = new Grid(List(
      new Polygon(List(new Point(2,1), new Point(3,1), new Point(3,2), new Point(2,2))),
      new Polygon(List(new Point(1,3), new Point(2,3), new Point(2,4), new Point(1,4))),
      new Polygon(List(new Point(3,4), new Point(4,4), new Point(4,6))),
      new Polygon(List(new Point(5,1), new Point(8,1), new Point(8,2), new Point(5,2))),
      new Polygon(List(new Point(6,4), new Point(7,5), new Point(5,8), new Point(4,8)))
    ), new Point(0,0), new Point(6,6))

    val path = AStar.search(grid)
    val expectedPath = List()
    assert(path == expectedPath)
  }

  registerTest("Moderate A* search (Backtracking)") {
    val grid = new Grid(List(
      new Polygon(List(new Point(8,14),new Point(5,10),new Point(8,9),new Point(9,10))),
      new Polygon(List(new Point(16,16),new Point(14,15),new Point(13,15),new Point(12,13),new Point(14,13),new Point(17,12),new Point(18,15))),
      new Polygon(List(new Point(18,15),new Point(13,14),new Point(15,10),new Point(17,9),new Point(20,11))),
      new Polygon(List(new Point(15,18),new Point(13,15),new Point(11,15),new Point(12,12),new Point(15,13),new Point(15,15))),
      new Polygon(List(new Point(19,11),new Point(16,12),new Point(17,8),new Point(20,5),new Point(20,9)))
    ), new Point(0,0), new Point(20,20))

    val path = AStar.search(grid)
    val expectedPath = List(new Point(0.0,0.0), new Point(9.0,10.0), new Point(11.0,15.0), new Point(15.0,18.0), new Point(20.0,20.0))
    assert(path == expectedPath)
  }

  registerTest("Moderate A* search 2") {
    val grid = new Grid(List(new Polygon(List(new Point(10,20),new Point(6,20),new Point(3,20),new Point(6,18),new Point(8,19),new Point(11,20))),new Polygon(List(new Point(14,9),new Point(9,8),new Point(14,4),new Point(15,7))),new Polygon(List(new Point(1,3),new Point(0,2),new Point(0,0),new Point(1,0))),new Polygon(List(new Point(13,8),new Point(10,8),new Point(10,5),new Point(7,3),new Point(10,0),new Point(11,3),new Point(13,4))),new Polygon(List(new Point(2,10),new Point(1,8),new Point(0,5),new Point(2,6),new Point(3,8)))), new Point(0,0), new Point(20,20))

    val path = AStar.search(grid)
    val expectedPath = List(new Point(0.0,0.0), new Point(1.0,0.0), new Point(20.0,20.0))
    assert(path == expectedPath)
  }

  registerTest("Moderate A* search 3") {
    val grid = new Grid(List(new Polygon(List(new Point(3,15),new Point(0,14),new Point(0,11),new Point(0,9),new Point(2,8),new Point(1,11))),new Polygon(List(new Point(17,8),new Point(16,5),new Point(20,7))),new Polygon(List(new Point(6,13),new Point(1,9),new Point(5,5),new Point(8,9))),new Polygon(List(new Point(13,5),new Point(14,3),new Point(19,3))),new Polygon(List(new Point(17,6),new Point(14,4),new Point(13,3),new Point(14,2),new Point(14,0),new Point(15,2),new Point(19,2))),new Polygon(List(new Point(11,13),new Point(10,13),new Point(8,13),new Point(8,9),new Point(12,9),new Point(14,13))),new Polygon(List(new Point(9,11),new Point(5,10),new Point(8,5),new Point(10,10))),new Polygon(List(new Point(19,9),new Point(17,9),new Point(14,9),new Point(13,5),new Point(17,5),new Point(20,4),new Point(20,7))),new Polygon(List(new Point(4,4),new Point(1,0),new Point(3,0),new Point(7,0))),new Polygon(List(new Point(9,16),new Point(10,9),new Point(16,12)))), new Point(0,0), new Point(20,20))
    val path = AStar.search(grid)

    val expectedPath = List(new Point(0.0,0.0), new Point(4.0,4.0), new Point(8.0,5.0), new Point(16.0,12.0), new Point(20.0,20.0))
    assert(path == expectedPath)
  }

  registerTest("Moderate A* search 4 (Backtracking)") {
    val grid = new Grid(List(new Polygon(List(new Point(11.0,4.0),new Point(8.0,4.0),new Point(6.0,3.0),new Point(6.0,0.0),new Point(8.0,0.0),new Point(10.0,0.0),new Point(11.0,1.0))),new Polygon(List(new Point(11.0,11.0),new Point(8.0,9.0),new Point(5.0,10.0),new Point(4.0,6.0),new Point(8.0,8.0),new Point(11.0,6.0),new Point(11.0,9.0))),new Polygon(List(new Point(17.0,6.0),new Point(15.0,5.0),new Point(17.0,1.0),new Point(17.0,5.0))),new Polygon(List(new Point(18.0,16.0),new Point(16.0,11.0),new Point(20.0,15.0))),new Polygon(List(new Point(9.0,20.0),new Point(6.0,20.0),new Point(5.0,16.0),new Point(9.0,17.0),new Point(12.0,19.0))),new Polygon(List(new Point(6.0,15.0),new Point(1.0,14.0),new Point(6.0,11.0),new Point(7.0,14.0))),new Polygon(List(new Point(10.0,14.0),new Point(6.0,13.0),new Point(10.0,11.0),new Point(10.0,13.0))),new Polygon(List(new Point(11.0,18.0),new Point(9.0,19.0),new Point(7.0,17.0),new Point(8.0,15.0),new Point(9.0,14.0),new Point(10.0,14.0),new Point(12.0,16.0))),new Polygon(List(new Point(4.0,18.0),new Point(0.0,17.0),new Point(3.0,15.0),new Point(4.0,17.0))),new Polygon(List(new Point(11.0,7.0),new Point(7.0,7.0),new Point(6.0,2.0),new Point(12.0,0.0),new Point(12.0,5.0)))), new Point(0.0,0.0), new Point(20.0,20.0))

    val path = AStar.search(grid)
    val expectedPath = List(new Point(0.0,0.0), new Point(5.0,10.0), new Point(10.0,11.0), new Point(20.0,20.0))
    assert(path == expectedPath)
  }
}
