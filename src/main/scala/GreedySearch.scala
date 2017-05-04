import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object GreedySearch {
  def search(grid: Grid): List[Point] = {
    val empty = new Point(Double.PositiveInfinity,Double.PositiveInfinity)
    val start = grid.getStart

    //change the goal for other cases
    val goal = grid.getGoal
    var open = new mutable.PriorityQueue[GreedySearchNode]()(Ordering[GreedySearchNode])
    var closed = new ArrayBuffer[GreedySearchNode]()
    // to keep track of open list
    val tracking = new ArrayBuffer[GreedySearchNode]()

    //Adding start point to open
    open += GreedySearchNode(start, empty, GridUtility.distance(start, goal))
    tracking.append(GreedySearchNode(start, empty, GridUtility.distance(start,goal)))
    grid.startTimer()
    while(true) {
      if(open.isEmpty){
        grid.stopTimer()
        grid.addNodeExpanded(closed.length)
        return List()
      }
      val current = open.dequeue()
      tracking.filter(_ != current)
      closed.append(current)
      if(current.current == goal && !grid.isInAPolygon(goal)){
        grid.stopTimer()
        grid.addNodeExpanded(closed.length)
        return GreedySearchNode.filter(closed)
      }
      //expanding the node
      val successors = grid.getNeighbors(current.current)
      val neighbors = new ArrayBuffer[GreedySearchNode]()
      for(successor <- successors){
        neighbors.append(GreedySearchNode(successor, current.current, GridUtility.distance(successor,goal)))
      }
      for(neighbor <- neighbors){
        if(!(tracking.contains(neighbor) ||closed.contains(neighbor))){
          open += neighbor
          tracking.append(neighbor)
        }
      }
    }
    // should not reach
    grid.stopTimer()
    grid.addNodeExpanded(closed.length)
    GreedySearchNode.filter(closed)
  }
}

case class GreedySearchNode(var current: Point, var previous: Point, var h: Double) extends Ordered[GreedySearchNode] {
  override def compare(that: GreedySearchNode): Int = {
    (this.h compare that.h) * -1
  }

  override def equals(obj: scala.Any): Boolean = obj match {
    case that: GreedySearchNode => this.current == that.current
    case _ => false
  }
}
object GreedySearchNode {
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
}