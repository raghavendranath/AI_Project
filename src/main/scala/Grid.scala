
class Grid(polygons: List[Polygon], startPoint: Point, goalPoint: Point) {
  def canTravelFrom(start: Point, to: Point): Boolean = {
    polygons.foreach { polygon =>
      if (polygon.lineIntersects(start, to)) return false
    }

    true
  }

  // Returns all points that are on the grid
  def getAllPoints(): List[Point] = {
    polygons.flatMap { polygon => polygon.points }.::(goalPoint)
  }

  // Gets the neighbors of the start point
  def getNeighbors(startPoint: Point): List[Point] = {
    getAllPoints().filter { point => canTravelFrom(startPoint, point) && startPoint != point }
  }

  // Outputs the code that will plot the grid in matlab
  def toMatlab: String = {
    val s = polygons.foldLeft("fill(") {(s: String, polygon: Polygon) =>
      s + polygon.toMatlab +","
    }

    s.substring(0, s.length - 1) +")\nxlim([0 "+ goalPoint.x +"])\nylim([0 "+ goalPoint.y +"])"
  }
}
