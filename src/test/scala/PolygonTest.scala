import org.scalatest.FlatSpec

/*
 * Test cases to verify that some of the methods in the polygon class are accurate
 */
class PolygonTest extends FlatSpec {
  "A square" should "be intersected by a diagonal line" in {
    val tempPoly = new Polygon(List(new Point(1, 1), new Point(1, 2), new Point(2,2), new Point(2, 1)))
    assert(tempPoly.lineIntersects(new Point(0,0), new Point(5,5)))
  }

  "An irregular polygon " should "be intersected by a diagonal line" in {
    val tempPoly = new Polygon(List(new Point(1,1), new Point(2,2), new Point(2,3), new Point(3,3), new Point(3,1)))
    assert(tempPoly.lineIntersects(new Point(0,0), new Point(5,5)))
  }

  "a line" should "be able to travel on a vertex" in {
    val tempPoly = new Polygon(List(new Point(1,1), new Point(0,2), new Point(1,2)))
    assert(!tempPoly.lineIntersects(new Point(0,0), new Point(5,5)))
  }

  it should "be able to travel on an edge" in {
    val tempPoly = new Polygon(List(new Point(2, 3), new Point(2, 2), new Point(3, 3)))
    assert(!tempPoly.lineIntersects(new Point(0,0), new Point(5,5)))
  }

  it should "be able to travel on an edge with multiple vertices" in {
    val tempPoly = new Polygon(List(new Point(1,1), new Point(2,2), new Point(3,3), new Point(3,1)))
    assert(!tempPoly.lineIntersects(new Point(0,0), new Point(5,5)))
  }

  it should "not be able to travel through a polygon (triangle)" in {
    val tempPoly = new Polygon(List(new Point(1,1), new Point(2,1), new Point(1,2)))
    assert(tempPoly.lineIntersects(new Point(0,0), new Point(5,5)))
  }

  it should "be able to travel along two vertices on a concave polygon" in {
    val tempPoly = new Polygon(List(new Point(1,1), new Point(2,1), new Point(2,2), new Point(3,2), new Point(3,0), new Point(1,0)))
    assert(!tempPoly.lineIntersects(new Point(0,0), new Point(5,5)))
  }

  it should "not be able to travel through a polygon when starting on a vertex" in {
    val tempPoly = new Polygon(List(new Point(0,0), new Point(0,2), new Point(1,2), new Point(2,1), new Point(2,0)))
    assert(tempPoly.lineIntersects(new Point(0,0), new Point(1,2)))
  }
}
