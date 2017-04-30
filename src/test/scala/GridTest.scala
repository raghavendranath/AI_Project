import org.scalatest.FunSpec

class GridTest extends FunSpec {
  registerTest("(1,1) should be travelable from (0,0) with square polygon") {
    val tempPoly = List(new Polygon(List(new Point(1,1), new Point(2,1), new Point(2,2), new Point(1,2))))
    val grid = new Grid(tempPoly, new Point(0,0), new Point(5,5))

    assert(grid.canTravelFrom(new Point(0,0), new Point(1,1)))
  }

  registerTest("Should be travelable from (0,0) to (1,1) on triangle vertex") {
    val tempPoly = List(new Polygon(List(new Point(1,1), new Point(2,1), new Point(1,2))))
    val grid = new Grid(tempPoly, new Point(0,0), new Point(5,5))

    assert(grid.canTravelFrom(new Point(0,0), new Point(1,1)))
  }

  registerTest("Single polygon(square) neighbors should be correct") {
    val tempPoly = List(new Polygon(List(new Point(1,1), new Point(2,1), new Point(2,2), new Point(1,2))))
    val grid = new Grid(tempPoly, new Point(0,0), new Point(5,5))
    val expectedNeighbors = List(new Point(1,1), new Point(2,1), new Point(1,2))

    assert(grid.getNeighbors(new Point(0,0)) == expectedNeighbors)
  }

  registerTest("Single polygon(triangle) neighbors should be correct") {
    val tempPoly = List(new Polygon(List(new Point(1,1), new Point(2,1), new Point(1,2))))
    val grid = new Grid(tempPoly, new Point(0,0), new Point(5,5))
    val expectedNeighbors = List(new Point(1,1), new Point(2,1), new Point(1,2))

    assert(grid.getNeighbors(new Point(0,0)) == expectedNeighbors)
  }

  registerTest("Single polygon(triangle) neighbors should be correct including goal state") {
    val tempPoly = List(new Polygon(List(new Point(1,1), new Point(2,2), new Point(2,1))))
    val grid = new Grid(tempPoly, new Point(0,0), new Point(5,5))
    val expectedNeighbors = List(new Point(5,5), new Point(1,1), new Point(2,2), new Point(2,1))

    assert(grid.getNeighbors(new Point(0,0)) == expectedNeighbors)
  }
}
