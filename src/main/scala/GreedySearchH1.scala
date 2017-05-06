/*
 * Implements a basic heuristic which calculates the straight line distance from the current point to the goal for
 * greedy search
 */
object GreedySearchH1 extends GreedySearchBase {
  override def calculateHeuristic(startPoint: Point, grid: Grid): Double = {
    GridUtility.distance(startPoint,grid.getGoal)
  }
}