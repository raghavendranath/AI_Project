/**
  * Created by ragha on 5/1/2017.
  */
import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer


object AStar {
  def search(grid: Grid): List[Point] = {
    val empty = new Point(Double.PositiveInfinity,Double.PositiveInfinity)
    val start = grid.getStart

    //change the goal for other cases
    val goal = grid.getGoal
    var open = new mutable.PriorityQueue[AStarNode]()( Ordering[AStarNode])
    var closed = new ArrayBuffer[AStarNode]()
    // to keep track of open list
    val tracking = new ArrayBuffer[AStarNode]()

    //Adding start point to open
    open += AStarNode(start, empty, 0.0, GridUtility.distance(start, goal), GridUtility.distance(start, goal))
    tracking.append(AStarNode(start, empty, 0.0, GridUtility.distance(start,goal), GridUtility.distance(start,goal)))
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
      val neighbors = new ArrayBuffer[AStarNode]()
      for(successor <- successors){
        val g = GridUtility.distance(current.current, successor)
        val h = GridUtility.distance(successor, goal)
        val f = g + h
        neighbors.append(AStarNode(successor, current.current, g, h, f))
      }
      for(neighbor <- neighbors){
        if(!(tracking.contains(neighbor) ||closed.contains(neighbor))){
          open += neighbor
          tracking.append(neighbor)
        }
        else if(tracking.contains(neighbor)){

          open.foreach { node =>
            if (node.current == neighbor.current && node.g > neighbor.g) {
              node.previous = neighbor.previous
              node.g = neighbor.g
              node.f = neighbor.f
              tracking.filter(_ !=node)
              tracking.append(neighbor)
            }
          }
        }
      }
    }

    toList(closed)
  }

  private def toList(l: ArrayBuffer[AStarNode]): List[Point] = {
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

case class AStarNode(var current: Point, var previous: Point, var g: Double, var h: Double, var f: Double) extends Ordered[AStarNode] {
  override def compare(that: AStarNode): Int = {
    (this.f compare that.f) * -1
  }
}