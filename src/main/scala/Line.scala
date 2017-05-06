/*
 * A line class which helps with geometry. Holds a line in the form of y = mx+b along with the start point and end point
 * of the line
 */
sealed abstract class Eq
case class Line() extends Eq {
  var p1: Point = _
  var p2: Point = _
  var m: Double = 0
  var b: Double = 0

  def this(p1: Point, p2: Point) = {
    this()
    this.p1 = p1
    this.p2 = p2

    if (p2.x - p1.x != 0) {
      m = (p2.y - p1.y) / (p2.x - p1.x)
      b = p1.y - (m * p1.x)
    } else {
      m = Double.PositiveInfinity
      b = p1.x
    }
  }

  // Returns true if a line intersects with another line
  def intersectsWith(line: Line): Point = {
    if (isParallelWith(line)) {
      if (p1 == line.p1) return p1
      if (p2 == line.p2) return p2
      if (p1 == line.p2) return p1
      if (p2 == line.p1) return p2
      if (contains(line.p1)) return line.p1
      if (line.contains(p1)) return p1

      return null
    }

    // At this point, we are guaranteed not to have two parallel lines,
    if (m == Double.PositiveInfinity) {
      val point = new Point(b, (line.m*b)+ line.b)
      return if (contains(point) && line.contains(point)) point else null
    }
    if (line.m == Double.PositiveInfinity) {
      val point = new Point(line.b, (m*line.b)+ b)
      return if (contains(point) && line.contains(point)) point else null
    }

    // At this point, we are guaranteed not to have any vertical lines
    val x = BigDecimal((line.b-b) / (m-line.m)).setScale(5, BigDecimal.RoundingMode.HALF_UP).toDouble
    val y = BigDecimal(m * x + b).setScale(5, BigDecimal.RoundingMode.HALF_UP).toDouble

    val point = new Point(x,y)
    // Make sure that both lines actually contain this point
    // This matters when one of the lines has a slope of zero
    if (contains(point) && line.contains(point)) point else null
  }

  // Returns true if a line is parallel with another line
  def isParallelWith(line: Line): Boolean = m == line.m

  // Returns true if a point contains another point. Rounded slightly to help with floating point numbers
  def contains(point: Point): Boolean = {
    val x = GridUtility.distance(p1, point)
    val y = GridUtility.distance(p2, point)
    val z = GridUtility.distance(p1, p2)

    val lhs = BigDecimal(x + y).setScale(5, BigDecimal.RoundingMode.HALF_UP).toDouble
    val rhs = BigDecimal(z).setScale(5, BigDecimal.RoundingMode.HALF_UP).toDouble
    lhs == rhs
  }
}