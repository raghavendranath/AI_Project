/*
 * Implements a heuristic that finds the best child using a combination of cost to the child, and then the straight line
 * distance from the goal to the child for A*
 */
object AStarH2 extends AStarBase {
  override def calculateHeuristic(startPoint: Point, grid: Grid): Double = {
    grid.getNeighbors(startPoint).map { neighbor =>
      GridUtility.distance(startPoint, neighbor) + GridUtility.distance(neighbor, grid.getGoal)
    }.min
  }
}