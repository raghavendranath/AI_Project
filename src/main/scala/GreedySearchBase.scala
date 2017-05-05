import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

abstract class GreedySearchBase {
  def search(grid: Grid): List[Point] = {
    val empty = new Point(Double.PositiveInfinity,Double.PositiveInfinity)
    val start = grid.getStart

    //change the goal for other cases
    val goal = grid.getGoal
    var open = new mutable.PriorityQueue[GreedySearchNode]()(Ordering[GreedySearchNode])
    val closed = new ArrayBuffer[GreedySearchNode]()

    //Adding start point to open
    open += GreedySearchNode(start, empty, GridUtility.distance(start, goal))
    // get all children, find distance from children to goal + actual distance to the child
    grid.startTimer()
    while(true) {
      if(open.isEmpty){
        grid.stopTimer()
        grid.addNodeExpanded(closed.length)
        return List()
      }
      val current = open.dequeue()
      closed.append(current)
      if(current.current == goal){
        grid.stopTimer()
        grid.addNodeExpanded(closed.length)
        return filter(closed)
      }

      //expanding the node
      grid.getNeighbors(current.current).foreach { neighborPoint =>
        val neighbor = GreedySearchNode(neighborPoint, current.current, calculateHeuristic(neighborPoint, grid))
        if(!(open.exists(n => n == neighbor) ||closed.contains(neighbor))){
          open += neighbor
        }
      }
    }
    // should not reach
    grid.stopTimer()
    grid.addNodeExpanded(closed.length)
    filter(closed)
  }

  def filter(points: ArrayBuffer[GreedySearchNode]): List[Point] = {
    if (points.isEmpty) return List[Point]()

    var finalPoints = List[Point]()
    var expectedPoint = points.last.current
    points.length - 1 to 0 by -1 foreach { i =>
      val currentPoint = points(i)
      if (currentPoint.current == expectedPoint) {
        finalPoints = finalPoints :+ currentPoint.current
        expectedPoint = currentPoint.previous
      }
    }

    finalPoints.reverse
  }

  def calculateHeuristic(startPoint: Point, grid: Grid): Double
}

case class GreedySearchNode(var current: Point, var previous: Point, var h: Double) extends Ordered[GreedySearchNode] {
  override def compare(that: GreedySearchNode): Int = {
    that.h compare this.h
  }

  override def equals(obj: scala.Any): Boolean = obj match {
    case that: GreedySearchNode => this.current == that.current
    case _ => false
  }
}