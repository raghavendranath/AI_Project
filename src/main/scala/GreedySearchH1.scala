object GreedySearchH1 extends GreedySearchBase {
  override def calculateHeuristic(startPoint: Point, grid: Grid): Double = {
    GridUtility.distance(startPoint,grid.getGoal)
  }
}