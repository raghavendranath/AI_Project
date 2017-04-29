import org.scalatest._

class PolygonTest extends FlatSpec {
  "A square" should "be intersected by a diagonal line" in {
    val tempPoly = new Polygon(List(new Point(10, 15), new Point(10, 10), new Point(15,10), new Point(15, 15)))
    assert(tempPoly.lineIntersects(new Point(0,0), new Point(20,20)))
  }

  "An irregular polygon " should "be intersected by a diagonal line" in {
    val tempPoly = new Polygon(List(new Point(1,1), new Point(2,2), new Point(2,3), new Point(3,3), new Point(3,1)))
    assert(tempPoly.lineIntersects(new Point(0,0), new Point(20,20)))
  }

  it should "be able to travel on a vertex" in {
    val tempPoly = new Polygon(List(new Point(1,1), new Point(0,2), new Point(1,2)))
    assert(!tempPoly.lineIntersects(new Point(0,0), new Point(20,20)))
  }

  it should "be able to travel on an edge" in {
    val tempPoly = new Polygon(List(new Point(10, 15), new Point(10, 10), new Point(15, 15)))
    assert(!tempPoly.lineIntersects(new Point(0,0), new Point(20,20)))
  }

  it should "be able to travel on an edge with multiple verticies" in {
    val tempPoly = new Polygon(List(new Point(1,1), new Point(2,2), new Point(3,3), new Point(3,1)))
    assert(!tempPoly.lineIntersects(new Point(0,0), new Point(20,20)))
  }
}
