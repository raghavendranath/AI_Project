object GreedySearchH2 extends GreedySearchBase {
  override def calculateHeuristic(startPoint: Point, grid: Grid): Double = {
    GridUtility.distance(startPoint, grid.getGoal) + grid.getNeighbors(startPoint).map { neighbor =>
      GridUtility.distance(startPoint, neighbor) + GridUtility.distance(neighbor, grid.getGoal)
    }.min
  }
}