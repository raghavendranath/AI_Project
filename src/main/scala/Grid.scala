
class Grid(polygons: List[Polygon], startPoint: Point, goalPoint: Point) {

  val stats = new Stats()

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
    val points = getAllPoints().filter { point => startPoint != point && canTravelFrom(startPoint, point) }
    stats.addBranchingFac(points.length)
    points
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

  def startTimer(): Unit ={
    stats.startTimer()
  }

  def stopTimer(): Unit ={
    stats.stopTimer()
  }

  def getRuntime(): Double ={
    stats.getRunTime()
  }

  def getBranchingFac(): Int ={
    stats.getBranchingFac()
  }

  def getEffectiveBranching(): Double ={
    stats.getEffectiveBranching()
  }

  def addFinalPath(points: List[Point]): Unit ={
    stats.addFinalPath(points)
  }

  def getActualCost(): Double = {
    stats.getActualCost()
  }

  def addNodeExpanded(i: Int): Unit ={
    stats.addNodesExp(i)
  }

  def getNodesExpanded(): Int ={
    stats.getNodesExp()
  }

  def statsToString(): String ={
    stats.toString
  }

  override def toString: String = {
    polygons.mkString("new Grid(List(", ",", s"), $startPoint, $goalPoint)")
  }
}
