/**
  * Created by ragha on 5/1/2017.
  */
import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer


abstract class AStarBase {
  def search(grid: Grid): List[Point] = {
    val empty = new Point(Double.PositiveInfinity,Double.PositiveInfinity)
    val start = grid.getStart

    //change the goal for other cases
    val goal = grid.getGoal
    var open = new mutable.PriorityQueue[AStarNode]()( Ordering[AStarNode])
    val closed = new ArrayBuffer[AStarNode]()

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
      if(current.current == goal){
        grid.stopTimer()
        grid.addNodeExpanded(closed.length)
        return filter(closed)
      }

      //expanding the node
      grid.getNeighbors(current.current).foreach { neighborPoint =>
        val g = current.g + GridUtility.distance(current.current, neighborPoint)
        val h = GridUtility.distance(neighborPoint, goal)
        val f = g + h
        val neighbor = AStarNode(neighborPoint, current.current, g, h, f)

        if(!(open.exists(n => n == neighbor) || closed.contains(neighbor))){
          open += neighbor
        } else if(open.exists(n => n == neighbor)){
          open.filter(n => n.current == neighbor.current && n.g > neighbor.g).foreach { node =>
            node.previous = neighbor.previous
            node.g = neighbor.g
            node.f = neighbor.f
          }
        }
      }
    }
    // Should not reach
    grid.stopTimer()
    grid.addNodeExpanded(closed.length)
    filter(closed)
  }

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

  def calculateHeuristic(startPoint: Point, grid: Grid): Double
}

case class AStarNode(var current: Point, var previous: Point, var g: Double, var h: Double, var f: Double) extends Ordered[AStarNode] {
  override def compare(that: AStarNode): Int = {
    that.f compare this.f
  }

  override def equals(obj: scala.Any): Boolean = obj match {
    case that: AStarNode => this.current == that.current
    case _ => false
  }
}