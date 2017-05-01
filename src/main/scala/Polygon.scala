
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
    val possiblePath = new Line(start, end)
    var intersectingVertices = List[Int]()

    points.indices foreach { i =>
      val firstPoint = points(i)
      val secondPoint = if (i == points.size - 1) points.head else points(i + 1)
      val polygonSide = new Line(firstPoint, secondPoint)

      val intersectingPoint = possiblePath.intersectsWith(polygonSide)
      if (intersectingPoint == null) {
        // the lines never intersect, we can move on without doing anything
      } else {
        // lines intersected at a point within the two lines
        if (intersectingPoint != firstPoint && intersectingPoint != secondPoint) {
          // Intersected in the middle of the polygon side, definitely intersected with polygon
          return true
        } else {
          // Intersected a vertex, which could be okay
          intersectingVertices = points.indexOf(intersectingPoint) :: intersectingVertices
        }
      }
    }

    val distinctVertices = intersectingVertices.distinct.sorted
    // Passing through just one vertex is okay
    if (distinctVertices.isEmpty || distinctVertices.length == 1) return false

    0 to distinctVertices.length - 2 foreach { i =>
      val vertex = points(distinctVertices(i))
      val nextVertex = points(distinctVertices(i+1)) // Okay since the loop is length - 2
    val midpoint = new Point((vertex.x + nextVertex.x)/2, (vertex.y + nextVertex.y)/2)
      val indexDiff = Math.abs(distinctVertices(i) - distinctVertices(i+1))
      val adjacentVerticies = indexDiff != 1 && indexDiff != points.length - 1
      if (contains(midpoint) && adjacentVerticies) {
        // Polygon contains the midpoint between two vertices, and the two vertices are adjacent
        // means the line intersects the polygon
        return true
      }
    }

    false
  }

  // Outputs the coordinates for matlab
  def toMatlab: String = {
    val xString = points.foldLeft("[") { (s: String, point: Point) =>
      s + point.x.toInt +" "
    }
    val yString = points.foldLeft("[") { (s: String, point: Point) =>
      s + point.y.toInt +" "
    }
    xString+"], "+ yString+"], 'r'"
  }

  override def toString: String = points.mkString("new Polygon(List(", ",","))")
}