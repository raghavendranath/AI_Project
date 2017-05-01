import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object GreedySearch {
  def search(grid: Grid): List[Point] = {
    val empty = new Point(Double.PositiveInfinity,Double.PositiveInfinity)
    val start = grid.getStart

    //change the goal for other cases
    val goal = grid.getGoal
    var open = new mutable.PriorityQueue[(Point, Point, Double)]()( Ordering.by((_: (Point, Point, Double))._3).reverse)
    var closed = new ArrayBuffer[(Point, Point, Double)]()
    // to keep track of open list
    val tracking = new ArrayBuffer[(Point, Point, Double)]()

    //Adding start point to open
    open += ((start, empty, GridUtility.distance(start,goal)))
    tracking.append((start, empty, GridUtility.distance(start,goal)))
    while(true) {
      if(open.isEmpty){
        return List()
      }
      val current = open.dequeue()
      tracking.filter(_ != current)
      closed.append(current)
      if(current._1 == goal && !grid.isInAPolygon(goal)){
        return toList(closed)
      }
      //expanding the node
      val successors = grid.getNeighbors(current._1)
      val neighbors = new ArrayBuffer[(Point, Point, Double)]()
      for(successor <- successors){
        neighbors.append((successor, current._1, GridUtility.distance(successor,goal)))
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

  private def toList(l: ArrayBuffer[(Point, Point, Double)]): List[Point] = {
    if (l.isEmpty) return List[Point]()

    var points = List[Point]()

    1 until l.length foreach { i =>
      val previousPoint = l(i-1)
      val currentPoint = l(i)
      if (previousPoint._1 == currentPoint._2) {
        points = points :+ previousPoint._1
      }
    }

    points :+ l.last._1
  }
}
