
class Grid(polygons: List[Polygon], start: Point, goal: Point) {

  def canTravelFrom(start: Point, to: Point): Boolean = {
    polygons.foreach { polygon =>
      if (polygon.lineIntersects(start, to)) return false
    }

    true
  }
}
