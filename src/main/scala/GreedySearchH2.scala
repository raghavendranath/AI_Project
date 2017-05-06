/*
 * Implements a heuristic that finds the best child using a combination of cost to the child, and then the straight line
 * distance from the goal to the child for Greedy Search
 */
object GreedySearchH2 extends GreedySearchBase {
  override def calculateHeuristic(startPoint: Point, grid: Grid): Double = {
    GridUtility.distance(startPoint, grid.getGoal) + grid.getNeighbors(startPoint).map { neighbor =>
      GridUtility.distance(startPoint, neighbor) + GridUtility.distance(neighbor, grid.getGoal)
    }.min
  }
}