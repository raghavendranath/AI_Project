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

    //Adding start point to open
    open += AStarNode(start, empty, 0.0, GridUtility.distance(start, goal), GridUtility.distance(start, goal))
    grid.startTimer()
    while(true) {
      if(open.isEmpty){
        grid.stopTimer()
        grid.addNodeExpanded(closed.length)
        return List()
      }
      val current = open.dequeue()
      closed.append(current)
      if(current.current == goal && !grid.isInAPolygon(goal)){
        grid.stopTimer()
        grid.addNodeExpanded(closed.length)
        return AStarNode.filter(closed)
      }
      //expanding the node
      val successors = grid.getNeighbors(current.current)
      val neighbors = new ArrayBuffer[AStarNode]()
      for(successor <- successors){
        val g = current.g+ GridUtility.distance(current.current, successor)
        val h = GridUtility.distance(successor, goal)
        val f = g + h
        neighbors.append(AStarNode(successor, current.current, g, h, f))
      }
      for(neighbor <- neighbors){
        if(!(open.exists(n => n == neighbor) || closed.contains(neighbor))){
          open += neighbor
        }
        else if(open.exists(n => n == neighbor)){
          open.foreach { node =>
            if (node.current == neighbor.current && node.g > neighbor.g) {
              node.previous = neighbor.previous
              node.g = neighbor.g
              node.f = neighbor.f
            }
          }
        }
      }
    }
    // Should not reach
    grid.stopTimer()
    grid.addNodeExpanded(closed.length)
    AStarNode.filter(closed)
  }
}

case class AStarNode(var current: Point, var previous: Point, var g: Double, var h: Double, var f: Double) extends Ordered[AStarNode] {
  override def compare(that: AStarNode): Int = {
    (this.f compare that.f) * -1
  }

  override def equals(obj: scala.Any): Boolean = obj match {
    case that: AStarNode => this.current == that.current
    case _ => false
  }
}
object AStarNode {
  def filter(points: ArrayBuffer[AStarNode]): List[Point] = {
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