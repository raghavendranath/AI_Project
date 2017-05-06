/*
 * Implements a basic heuristic which calculates the straight line distance from the current point to the goal for A*
 */
object AStarH1 extends AStarBase{
  override def calculateHeuristic(startPoint: Point, grid: Grid): Double = {
    GridUtility.distance(startPoint, grid.getGoal)
  }
}
