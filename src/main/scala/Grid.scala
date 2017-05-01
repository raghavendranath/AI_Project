
class Grid(polygons: List[Polygon], startPoint: Point, goalPoint: Point) {
  def canTravelFrom(start: Point, to: Point): Boolean = {
    polygons.foreach { polygon =>
      if (polygon.lineIntersects(start, to)) return false
    }

    if (isInAPolygon(to)) return false

    true
  }

  def getStart: Point = startPoint
  def getGoal: Point = goalPoint

  // Returns all points that are on the grid
  def getAllPoints(): List[Point] = {
    polygons.flatMap { polygon => polygon.points }.::(goalPoint)
  }

  // Gets the neighbors of the start point
  def getNeighbors(startPoint: Point): List[Point] = {
    getAllPoints().filter { point => startPoint != point && canTravelFrom(startPoint, point) }
  }

  // Outputs the code that will plot the grid in matlab
  def toMatlab: String = {
    val s = polygons.foldLeft("fill(") {(s: String, polygon: Polygon) =>
      s + polygon.toMatlab +","
    }

    s.substring(0, s.length - 1) +");xlim([0 "+ goalPoint.x +"]);ylim([0 "+ goalPoint.y +"]);hold on;"
  }

  // Checks all polygons to make sure that the point is not in the polygon, but it is okay if it is a vertex
  def isInAPolygon(point: Point): Boolean = {
    polygons.foreach { polygon =>
      if (polygon.contains(point) && !polygon.points.contains(point)) return true
    }

    false
  }

  override def toString: String = {
    polygons.mkString("new Grid(List(", ",", s"), $startPoint, $goalPoint)")
  }
}
