
class Polygon(var points: List[Point]) {
  // Generates a random polygon with a maximum number of sides in the plane 0<=x<=width and 0<=y<=height
  def this(maxSides: Int, width: Int, height: Int) {
    this(List[Point]())
    val r = new scala.util.Random
    val numSides = 3 + r.nextInt((maxSides - 3) + 1)

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

      val straightDist = minDistFromCenter + (r.nextDouble() * (maxDistFromCenter - minDistFromCenter))
      val angle = angleStep * i
      val finalX = bindNumber(((straightDist * Math.cos(angle)) + centerX).toInt, width)
      val finalY = bindNumber(((straightDist * Math.sin(angle)) + centerY).toInt, height)

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
      j = {
        i += 1; i - 1
      }
    }

    result
  }

  // Returns true if the line created between start and end intersects the polygon
  def lineIntersects(start: Point, end: Point): Boolean = {
    val possiblePath = new lineeq(start, end)
    var intersectingVerticies = List[Int]()

    points.indices foreach { i =>
      val firstPoint = points(i)
      val secondPoint = if (i == points.size - 1) points.head else points(i + 1)
      val polygonSide = new lineeq(firstPoint, secondPoint)

      if (!GridUtility.isParallel(possiblePath, polygonSide)) {
        val intersectionPoint = GridUtility.interPoint(possiblePath, polygonSide)
        if (GridUtility.isValid(firstPoint, secondPoint, intersectionPoint)) {
          if (points.contains(intersectionPoint)) {
            intersectingVerticies = intersectingVerticies.::(i)
          }
        }
      }
    }

    val distinctVerticies = intersectingVerticies.distinct
    if (distinctVerticies.isEmpty || distinctVerticies.size == 1) {
      return false
    }

    var expectedVertex = distinctVerticies.head
    distinctVerticies.foreach { value =>
      if (expectedVertex != value) {
        return true
      }
      expectedVertex = if (distinctVerticies.size == value) 1 else value + 1
    }

    false
  }


}