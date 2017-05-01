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

  registerTest("Find all the neighbors properly") {
    val grid = new Grid(List(new Polygon(List(new Point(17,16),new Point(12,14),new Point(14,10),new Point(16,9),new Point(18,12))), new Polygon(List(new Point(9,20),new Point(6,20),new Point(4,20),new Point(3,17),new Point(7,15),new Point(10,16),new Point(11,20))), new Polygon(List(new Point(14,7),new Point(14,5),new Point(18,5))), new Polygon(List(new Point(10,20),new Point(10,15),new Point(15,17))), new Polygon(List(new Point(6,16),new Point(5,20),new Point(2,17),new Point(2,14),new Point(5,14),new Point(8,12),new Point(6,16)))), new Point(0,0), new Point(20,20))
    val expectedNeighbors = List(new Point(12.0,14.0), new Point(14.0,10.0), new Point(16.0,9.0), new Point(14.0,7.0), new Point(14.0,5.0), new Point(18.0,5.0), new Point(10.0,15.0), new Point(2.0,17.0), new Point(2.0,14.0), new Point(5.0,14.0), new Point(8.0,12.0))

    assert(grid.getNeighbors(new Point(0,0)) == expectedNeighbors)
  }

  // This test fails, but it is okay since the missing points are ones that are on the same polygon
  // and are parallel
  registerTest("Final all the neighbors properly 2") {
    val grid = new Grid(List(new Polygon(List(new Point(5.0,9.0),new Point(2.0,8.0),new Point(0.0,8.0),new Point(0.0,5.0),new Point(2.0,5.0),new Point(3.0,5.0),new Point(4.0,7.0))),new Polygon(List(new Point(3.0,2.0),new Point(0.0,2.0),new Point(0.0,0.0),new Point(3.0,0.0),new Point(6.0,0.0))),new Polygon(List(new Point(9.0,17.0),new Point(7.0,15.0),new Point(6.0,12.0),new Point(10.0,10.0),new Point(11.0,14.0))),new Polygon(List(new Point(11.0,16.0),new Point(9.0,13.0),new Point(6.0,13.0),new Point(8.0,9.0),new Point(12.0,9.0),new Point(10.0,13.0))),new Polygon(List(new Point(20.0,2.0),new Point(18.0,2.0),new Point(18.0,1.0),new Point(16.0,0.0),new Point(18.0,0.0),new Point(20.0,0.0)))), new Point(0.0,0.0), new Point(20.0,20.0))
    val expectedNeighbors = List(new Point(0.0,8.0),new Point(0.0,5.0),new Point(0.0,2.0),new Point(3.0,0.0),new Point(6.0,0.0),new Point(16.0,0.0),new Point(18.0,0.0),new Point(20.0,0.0))
    println(grid.toMatlab)
    println(GridUtility.toMatlab(expectedNeighbors))
    println(GridUtility.toMatlab(grid.getNeighbors(new Point(0,0))))
    assert(grid.getNeighbors(new Point(0,0)) == expectedNeighbors)
  }

  registerTest("Should have all the proper neighbors when starting on a vertex") {
    val grid = new Grid(List(new Polygon(List(new Point(0,0), new Point(0,2), new Point(2,0)))), new Point(0,0), new Point(5,5))
    val expectedNeighbors = List(new Point(0,2), new Point(2,0))

    assert(grid.getNeighbors(new Point(0,0)) == expectedNeighbors)
  }
}
