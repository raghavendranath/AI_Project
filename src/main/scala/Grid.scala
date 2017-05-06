/*
 * Grid wraps up all of the state for easy running of a test. It contains all of the polygons, the start point, and
 * the end goal, and contains some methods that are used when searching
 */
class Grid(polygons: List[Polygon], startPoint: Point, goalPoint: Point) {
  private var neighborMap = Map[Point, List[Point]]()

  val stats = new Stats()

  // Returns true if an agent can travel from one point to another
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

  // Gets the neighbors of the start point, which are the points that are accessible in a straight line without crossing
  // through a polygon
  def getNeighbors(startPoint: Point): List[Point] = {
    neighborMap.get(startPoint) match {
      case None =>
        // Compute and add
        val points = getAllPoints().filter { point => startPoint != point && canTravelFrom(startPoint, point) }
        stats.addBranchingFac(points.length)
        neighborMap = neighborMap + (startPoint -> points)
        points
      case Some(list) =>
        stats.addBranchingFac(list.length)
        list
    }

  }

  // Outputs the code that will plot the polygons in matlab
  def toMatlab: String = {
    val s = polygons.foldLeft("fill(") {(s: String, polygon: Polygon) =>
      s + polygon.toMatlab +","
    }

    s.substring(0, s.length - 1) +");hold on;"
  }

  // Checks all polygons to make sure that the point is not in the polygon, but it is okay if it is a vertex of a
  // polygon
  def isInAPolygon(point: Point): Boolean = {
    polygons.foreach { polygon =>
      if (polygon.contains(point) && !polygon.points.contains(point)) return true
    }

    false
  }

  // Stats helpers below
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
