import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
import scala.math.Ordering.Implicits._

object GreedySearch {
  def main(args: Array[String]): Unit = {
    var polygons = GridUtility.randomGrid(5, new Point(20, 20))
    print(polygons.getAllPoints())
    val empty = new Point(999,999)
    val start = new Point(0,0)

    //change the goal for other cases
    val goal = new Point(7,2)
    var open = new mutable.PriorityQueue[(Point, Point, Double)]()( Ordering.by((_: (Point, Point, Double))._3).reverse)
    var closed = new ArrayBuffer[(Point, Point, Double)]()
    // to keep track of open list
    var tracking = new ArrayBuffer[(Point, Point, Double)]()

    //Adding start point to open
    open += ((start, empty, GridUtility.distance(start,goal)))
    tracking.append((start, empty, GridUtility.distance(start,goal)))
    while(true) {
      if(open.isEmpty){
        println("Failed to search")
        return
      }
      var current = open.dequeue()
      tracking.filter(_ != current)
      closed.append(current)
      if(current._1 == goal){
        println("Success: Goal Found")
        return
      }
      //expanding the node
      var successors = polygons.getNeighbors(current._1)
      var neighbors = new ArrayBuffer[(Point, Point, Double)]()
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
    closed.foreach(println)

  }
}
