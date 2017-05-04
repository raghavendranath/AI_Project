import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Lookahead {
  def search(grid: Grid,k: Int): List[Point] = {
    val empty = new Point(Double.PositiveInfinity,Double.PositiveInfinity)
    val start = grid.getStart

    //change the goal for other cases
    val goal = grid.getGoal

    var allNeighbors = new mutable.PriorityQueue[LookaheadNode]()(Ordering[LookaheadNode])
    val open = new ArrayBuffer[LookaheadNode]()
    val closed = new ArrayBuffer[LookaheadNode]()
    // to keep track of open list
    val tracking = new ArrayBuffer[LookaheadNode]()

    //A flag to check if k is not crossing the actual depth
    var foundEndOfTree = false
    //Adding start point to open
    open.append(LookaheadNode(start, empty, GridUtility.distance(start, goal)))
    while(true) {
      if(open.isEmpty){
        return List()
      }
      val current = open(0)
      open.clear()
      closed.append(current)
      if(current.current == goal && !grid.isInAPolygon(goal)){
        return LookaheadNode.filter(closed)
      }
      if(!foundEndOfTree ) {
        //expanding the node
        val currentVertex = current
        val neighbors = new ArrayBuffer[LookaheadNode]()
        var successors = List[Point]()
        for (i <- 1 to k; if !foundEndOfTree) {
          if (i == 1) {
            successors = grid.getNeighbors(currentVertex.current)
            for (successor <- successors) {
              neighbors.append(LookaheadNode(successor, currentVertex.current, GridUtility.distance(successor, goal)))
            }

            for (neighbor <- neighbors) {
              if (!(tracking.contains(neighbor) || closed.contains(neighbor))) {
                if (i == k) {
                  allNeighbors += neighbor
                }
                tracking.append(neighbor)
              }
            }
          }
          else {
            val neighbors2 = neighbors.clone()
            neighbors.clear()
            neighbors2.foreach { neighbor =>
              successors = grid.getNeighbors(neighbor.current)
              for (successor <- successors) {
                if (!LookaheadNode.getElements(neighbors).contains(successor)) {
                  neighbors.append(LookaheadNode(successor, neighbor.current, GridUtility.distance(successor, goal)))
                }
              }
              for (children <- neighbors) {
                if (!(tracking.contains(children) || closed.contains(children))) {
                  if (i == k) {
                    allNeighbors += children
                  }
                  tracking.append(children)
                }
              }
//              if (tracking.exists { node => node.current == goal}) {
//                foundEndOfTree = true
//              }
            }
          }
        }
        if (allNeighbors.isEmpty) {
          foundEndOfTree = true
        } else {
          val node = allNeighbors.dequeue()
          tracking.append(node)
          allNeighbors.clear()
          val selectedPoints = LookaheadNode.filter(tracking)
          val selectedPoint = selectedPoints.head
          tracking.clear()
          open.append(new LookaheadNode(selectedPoint, current.current, GridUtility.distance(selectedPoint, goal)))
          neighbors.clear()
        }
      }
      if(foundEndOfTree){
        //expanding the node
        val successors = grid.getNeighbors(current.current)
        val neighbors = new ArrayBuffer[LookaheadNode]()
        for(successor <- successors){
          neighbors.append(LookaheadNode(successor, current.current, GridUtility.distance(successor,goal)))
        }
        for(neighbor <- neighbors){
          if(!closed.contains(neighbor)){
            allNeighbors += neighbor
            tracking.append(neighbor)
          }
        }
        if (allNeighbors.nonEmpty) {
          open.append(allNeighbors.dequeue())
        }
        allNeighbors.clear()
        tracking.clear()

      }
    }
   LookaheadNode.filter(closed)
  }
}

case class LookaheadNode(var current: Point, var previous: Point, var h: Double) extends Ordered[LookaheadNode] {
  override def compare(that: LookaheadNode): Int = {
    (this.h compare that.h) * -1
  }

  override def equals(obj: scala.Any): Boolean = obj match {
    case that: LookaheadNode => this.current == that.current
    case _ => false
  }
}
object LookaheadNode {
  def filter(points: ArrayBuffer[LookaheadNode]): List[Point] = {
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
  def getElements(points: ArrayBuffer[LookaheadNode]): List[Point] ={
    var allPoints = List[Point]()
    points.foreach{node=>
      allPoints = allPoints :+ node.current
    }
    allPoints
  }
}