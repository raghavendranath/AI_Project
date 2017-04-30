sealed abstract class Eq
case class Line(var m: Double, var b: Double) extends Eq {
  // Returns a new Line from two Points
  def this(p1: Point, p2: Point) = {
    this(Double.PositiveInfinity, p1.x)
    if (p2.x - p1.x != 0) {
      m = (p2.y - p1.y) / (p2.x - p1.x)
      b = p1.y - (m * p1.x)
    }
  }
}

object GridUtility {
  def distance(p1: Point, p2: Point): Double = {
    val x = Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2))
    x
  }

  // Returns the point where the two lines intersect
  def intersectionPoint(l1: Line, l2: Line): Point = {
    if (l1.m == Double.PositiveInfinity) return new Point(l1.b, (l2.m*l1.b)+ l2.b)
    if (l2.m == Double.PositiveInfinity) return new Point(l2.b, (l1.m*l2.b)+ l1.b)

    val x = (l2.b-l1.b) / (l1.m-l2.m)
    val y = l1.m * x + l1.b

    new Point(x,y)
  }

  // Checks if the two lines are parallel
  def isParallel(l1: Line, l2: Line): Boolean = {
    l1.m == l2.m
  }

  //to check if it is present one the side of a polygon
  //(side: a,b and intersection x) -> (ax+xb = ab)
  def isValid(p1: Point, p2: Point,p3: Point): Boolean = {
    val x = distance(p1, p3)
    val y = distance(p2, p3)
    val z = distance(p1, p2)

    // Round the points to ensure that rounding doesn't become an issue
    val lhs = BigDecimal(x + y).setScale(5, BigDecimal.RoundingMode.HALF_UP).toDouble
    val rhs = BigDecimal(z).setScale(5, BigDecimal.RoundingMode.HALF_UP).toDouble
    lhs == rhs
  }

  // Generates a grid with n polygons with 3..7 sides with a start point of (0,0) and a specified goal state
  def randomGrid(numPolygons: Int, goalState: Point): Grid = {
    val polygons = 1 to numPolygons map { i =>
      new Polygon(7, goalState.x.toInt, goalState.y.toInt)
    }

    new Grid(polygons.toList, new Point(0,0), goalState)
  }

}

