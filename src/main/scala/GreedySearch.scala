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
    while(true) {
      if(open.isEmpty){
        return List()
      }
      val current = open.dequeue()
      tracking.filter(_ != current)
      closed.append(current)
      if(current.current == goal && !grid.isInAPolygon(goal)){
        return toList(closed)
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

    toList(closed)
  }

  private def toList(l: ArrayBuffer[GreedySearchNode]): List[Point] = {
    if (l.isEmpty) return List[Point]()

    var points = List[Point]()

    1 until l.length foreach { i =>
      val previousPoint = l(i-1)
      val currentPoint = l(i)
      if (previousPoint.current == currentPoint.previous) {
        points = points :+ previousPoint.current
      }
    }

    points :+ l.last.current
  }
}

case class GreedySearchNode(var current: Point, var previous: Point, var h: Double) extends Ordered[GreedySearchNode] {
  override def compare(that: GreedySearchNode): Int = {
    (this.h compare that.h) * -1
  }
}