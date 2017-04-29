
class Polygon(var points: List[Point]) {
  // Generates a random polygon with a maximum number of sides in the plane 0<=x<=width and 0<=y<=height
  def this(maxSides: Int, width: Int, height: Int) {
    this(List[Point]())
    val r = new scala.util.Random
    val numSides = 3 + r.nextInt((maxSides-3) + 1)

    val centerX = r.nextInt(width + 1)
    val centerY = r.nextInt(height + 1)

    val minDistFromCenter = ((width + height) / 2) * .025
    val maxDistFromCenter = ((width + height) / 2) * .25

    val angleStep = (2 * Math.PI) / numSides
    val finalPoints = 1 to numSides map { i =>
      // Binds the number 0..<max
      def bindNumber(n: Int, max: Int): Int = n match {
        case v if v > max => max
        case v if v < 0 => 0
        case v => v
      }

      val straightDist = minDistFromCenter + (r.nextDouble()*(maxDistFromCenter - minDistFromCenter))
      val angle = angleStep * i
      val finalX = bindNumber(((straightDist*Math.cos(angle)) + centerX).toInt, width)
      val finalY = bindNumber(((straightDist*Math.sin(angle)) + centerY).toInt, height)

      new Point(finalX, finalY)
    }

    points = finalPoints.toList.distinct
  }

  // Returns true if the point is inside or on the polygon
  def contains(point: Point): Boolean = {
    var i = 0
    var j = points.length - 1
    var result = false
    while (i < points.length) {
      if ((points(i).y > point.y) != (points(j).y > point.y) &&
        (point.x < (points(j).x - points(i).x) * (point.y - points(i).y) / (points(j).y - points(i).y) + points(i).x)) {
        result = !result
      }
      j = { i += 1; i - 1 }
    }

    result
  }

  def lineIntersects(start: Point, end: Point): Boolean = {
    points.indices foreach { i =>
      val firstPoint = points(i)
      val secondPoint = if (i == points.size - 1) points.head else points(i+1)

      if (lineIntersects(start, end, firstPoint, secondPoint)) {
        return true
      }
    }

    false
  }

  private def lineIntersects(start1: Point, end1: Point, start2: Point, end2: Point): Boolean = {
    val denom:Double = ((end1.x - start1.x) * (end2.y - start2.y)) - ((end1.y - start1.y) * (end2.x - start2.x))
    // Parallel lines
    if (denom == 0) return false

    val numer:Double = ((start1.y - start2.y) * end2.x - start2.x) - ((start1.x - start2.x) * end2.y - start2.y)

    val r:Double = numer / denom

    val numer2:Double = ((start1.y - start2.y) * (end1.x - start1.x)) - ((start1.x - start2.x) * (end1.y - start1.y))

    val s:Double = numer2 / denom

    if ((r < 0 || r > 1) || (s < 0 || s > 1)) return false

    val result = new Point((start1.x + (r * (end1.x - start1.x))).toInt, (start1.y + (r * (end1.y - start1.y))).toInt)
    if (result == start1 || result == end1) return false

    true
  }
}
