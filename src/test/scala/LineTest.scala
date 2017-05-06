import org.scalatest.FunSpec

/*
 * Test cases to verify that the methods in the line class are correct
 */
class LineTest extends FunSpec {
  registerTest("Positive slope") {
    val line = new Line(new Point(1,1), new Point(2,2))
    assert(line.m == 1)
    assert(line.b == 0)
  }

  registerTest("Negative slope") {
    val line = new Line(new Point(2,1), new Point(1,2))
    assert(line.m == -1)
    assert(line.b == 3)
  }

  registerTest("Simple line intersection") {
    val line1 = new Line(new Point(1,1), new Point(2,2))
    assert(line1.m == 1)
    assert(line1.b == 0)
    val line2 = new Line(new Point(2,1), new Point(1,2))
    assert(line2.m == -1)
    assert(line2.b == 3)

    val intersectionPoint = line1.intersectsWith(line2)
    assert(intersectionPoint.x == 1.5)
    assert(intersectionPoint.y == 1.5)
  }

  registerTest("Intersection point on line") {
    val line1 = new Line(new Point(1,1), new Point(3,3))
    assert(line1.m == 1)
    assert(line1.b == 0)
    val line2 = new Line(new Point(2,2), new Point(3,1))
    assert(line2.m == -1)
    assert(line2.b == 4)

    val intersectionPoint = line1.intersectsWith(line2)
    assert(intersectionPoint.x == 2)
    assert(intersectionPoint.y == 2)
  }

  registerTest("Intersection vertical") {
    val line1 = new Line(new Point(1,1), new Point(3,3))
    assert(line1.m == 1)
    assert(line1.b == 0)
    val line2 = new Line(new Point(2,0), new Point(2,4))
    assert(line2.m == Double.PositiveInfinity)
    assert(line2.b == 2)

    val intersectionPoint = line1.intersectsWith(line2)
    assert(intersectionPoint.x == 2)
    assert(intersectionPoint.y == 2)
  }

  registerTest("Parallel Lines, no intersection") {
    val line1 = new Line(new Point(1,1), new Point(3,3))
    assert(line1.m == 1)
    assert(line1.b == 0)
    val line2 = new Line(new Point(2,0), new Point(4,2))
    assert(line2.m == 1)
    assert(line2.b == -2)

    val intersectionPoint = line1.intersectsWith(line2)
    assert(intersectionPoint == null)
  }

  registerTest("Parallel vertical lines, no intersection") {
    val line1 = new Line(new Point(0,0), new Point(0,4))
    assert(line1.m == Double.PositiveInfinity)
    assert(line1.b == 0)
    val line2 = new Line(new Point(2,0), new Point(2, 4))
    assert(line2.m == Double.PositiveInfinity)
    assert(line2.b == 2)

    val intersectionPoint = line1.intersectsWith(line2)
    assert(intersectionPoint == null)
  }

  registerTest("Parallel horizontal lines, no intersection") {
    val line1 = new Line(new Point(0,0), new Point(4,0))
    assert(line1.m == 0)
    assert(line1.b == 0)
    val line2 = new Line(new Point(0,2), new Point(4,2))
    assert(line2.m == 0)
    assert(line2.b == 2)

    val intersectionPoint = line1.intersectsWith(line2)
    assert(intersectionPoint == null)
  }

  registerTest("Parallel Lines, intersection at tail and head") {
    val line1 = new Line(new Point(1,1), new Point(3,3))
    assert(line1.m == 1)
    assert(line1.b == 0)
    val line2 = new Line(new Point(3,3), new Point(4,4))
    assert(line2.m == 1)
    assert(line2.b == 0)

    val intersectionPoint = line1.intersectsWith(line2)
    assert(intersectionPoint.x == 3)
    assert(intersectionPoint.y == 3)
  }

  registerTest("Parallel Lines, intersection at head and tail") {
    val line1 = new Line(new Point(3,3), new Point(4,4))
    assert(line1.m == 1)
    assert(line1.b == 0)
    val line2 = new Line(new Point(1,1), new Point(3,3))
    assert(line2.m == 1)
    assert(line2.b == 0)

    val intersectionPoint = line1.intersectsWith(line2)
    assert(intersectionPoint.x == 3)
    assert(intersectionPoint.y == 3)
  }

  registerTest("Vertical lines and sloped line intersect at heads") {
    val line1 = new Line(new Point(0,0), new Point(0,5))
    assert(line1.m == Double.PositiveInfinity)
    assert(line1.b == 0)
    val line2 = new Line(new Point(0,0), new Point(3,3))
    assert(line2.m == 1)
    assert(line2.b == 0)

    val intersectionPoint = line1.intersectsWith(line2)
    assert(intersectionPoint.x == 0)
    assert(intersectionPoint.y == 0)
  }

  registerTest("Line contained within line") {
    val line1 = new Line(new Point(0,0), new Point(5,5))
    assert(line1.m == 1)
    assert(line1.b == 0)
    val line2 = new Line(new Point(1,1), new Point(3,3))
    assert(line2.m == 1)
    assert(line2.b == 0)

    val intersectionPoint = line1.intersectsWith(line2)
    assert(intersectionPoint.x == 1)
    assert(intersectionPoint.y == 1)
  }

  registerTest("Overlapping offset lines") {
    val line1 = new Line(new Point(0,0), new Point(3,3))
    assert(line1.m == 1)
    assert(line1.b == 0)
    val line2 = new Line(new Point(1,1), new Point(4,4))
    assert(line2.m == 1)
    assert(line2.b == 0)

    val intersectionPoint = line1.intersectsWith(line2)
    assert(intersectionPoint.x == 1)
    assert(intersectionPoint.y == 1)
  }

  registerTest("Overlapping offset lines 2") {
    val line1 = new Line(new Point(2,2), new Point(4,4))
    assert(line1.m == 1)
    assert(line1.b == 0)
    val line2 = new Line(new Point(1,1), new Point(3,3))
    assert(line2.m == 1)
    assert(line2.b == 0)

    val intersectionPoint = line1.intersectsWith(line2)
    assert(intersectionPoint.x == 2)
    assert(intersectionPoint.y == 2)
  }

  registerTest("Parallel lines non overlapping with same slope") {
    val line1 = new Line(new Point(0,0), new Point(2,2))
    assert(line1.m == 1)
    assert(line1.b == 0)
    val line2 = new Line(new Point(3,3), new Point(5,5))
    assert(line2.m == 1)
    assert(line2.b == 0)

    val intersectionPoint = line1.intersectsWith(line2)
    assert(intersectionPoint == null)
  }

  registerTest("Vertical and non intercepting line") {
    val line1 = new Line(new Point(0,0), new Point(5,5))
    assert(line1.m == 1)
    assert(line1.b == 0)
    val line2 = new Line(new Point(3,2), new Point(3,0))
    assert(line2.m == Double.PositiveInfinity)
    assert(line2.b == 3)

    val intersectionPoint = line1.intersectsWith(line2)
    assert(intersectionPoint == null)

    val line3 = new Line(new Point(0,0), new Point(5,5))
    assert(line3.m == 1)
    assert(line3.b == 0)
    val line4 = new Line(new Point(3,0), new Point(1,0))
    assert(line4.m == 0)
    assert(line4.b == 0)

    val intersectionPoint2 = line3.intersectsWith(line4)
    assert(intersectionPoint2 == null)
  }
}
