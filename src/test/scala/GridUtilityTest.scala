import org.scalatest.FunSpec

class GridUtilityTest extends FunSpec {
  registerTest("Correct equation for (0,0) to (0,1)") {
    val equation = new Line(new Point(0,0), new Point(0,1))
    assert(equation.m == Double.PositiveInfinity)
    assert(equation.b == 0)
  }

  registerTest("Correct equation for (0,0) to (1,1)") {
    val equation = new Line(new Point(0,0), new Point(1,1))
    assert(equation.m == 1)
    assert(equation.b == 0)
  }

  registerTest("Correct equation for (0,0) to (1,0)") {
    val equation = new Line(new Point(0,0), new Point(1,0))
    assert(equation.m == 0)
    assert(equation.b == 0)
  }

  registerTest("Correct equation for (1,1) to (0,0)") {
    val equation = new Line(new Point(1,1), new Point(0,0))
    assert(equation.m == 1)
    assert(equation.b == 0)
  }

  registerTest("Correct equation for (0,0) to (2,1)") {
    val equation = new Line(new Point(0,0), new Point(2,1))
    assert(equation.m == 0.5)
    assert(equation.b == 0)
  }

  registerTest("Correct equation for (1,1) to (2,1)") {
    val equation = new Line(new Point(1,1), new Point(2,1))
    assert(equation.m == 0)
    assert(equation.b == 1)
  }

  registerTest("Correct equation for (1,1) to (1,2)") {
    val equation = new Line(new Point(1,1), new Point(1,2))
    assert(equation.m == Double.PositiveInfinity)
    assert(equation.b == 1)
  }

  registerTest("Correct Intersection point from (0,0) to (5,5) and (2,1) to (1,2)") {
    val start1 = new Point(0,0)
    val end1 = new Point(5,5)
    val start2 = new Point(2,1)
    val end2 = new Point(1,2)
    val eq1 = new Line(start1, end1)
    val eq2 = new Line(start2, end2)
    val result = GridUtility.intersectionPoint(eq1, eq2)

    assert(result.x == 1.5)
    assert(result.y == 1.5)
  }

  // Intersection tests

  registerTest("(0,0) to (5,5) intersects with (1,0) to (1,2) at (1,1)") {
    val line1 = new Line(new Point(0,0), new Point(5,5))
    val line2 = new Line(new Point(1,0), new Point(1,2))

    assert(GridUtility.intersectionPoint(line1, line2) == new Point(1,1))
  }

  registerTest("(0,0) to (5,5) intersects with (0,1) to (2,1) at (1,1)") {
    val line1 = new Line(new Point(0,0), new Point(5,5))
    val line2 = new Line(new Point(0,1), new Point(2,1))

    assert(GridUtility.intersectionPoint(line1, line2) == new Point(1,1))
  }

  registerTest("(0,0) to (5,5) intersects with (2,0) to (0,2) at (1,1)") {
    val line1 = new Line(new Point(0,0), new Point(5,5))
    val line2 = new Line(new Point(2,0), new Point(0,2))

    assert(GridUtility.intersectionPoint(line1, line2) == new Point(1,1))
  }
}
