
object AStarH1 extends AStarBase{
  override def calculateHeuristic(startPoint: Point, grid: Grid): Double = {
    GridUtility.distance(startPoint, grid.getGoal)
  }
}
