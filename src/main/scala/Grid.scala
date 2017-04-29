
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
    getAllPoints().filter(point => canTravelFrom(startPoint, point) && startPoint != point)
  }
}
