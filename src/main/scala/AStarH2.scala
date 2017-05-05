object AStarH2 extends AStarBase {
  override def calculateHeuristic(startPoint: Point, grid: Grid): Double = {
    grid.getNeighbors(startPoint).map { neighbor =>
      GridUtility.distance(startPoint, neighbor) + GridUtility.distance(neighbor, grid.getGoal)
    }.min
  }
}