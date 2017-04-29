sealed abstract class Eq
case class lineeq(xcoeff: Double, ycoeff: Double, c: Double) extends Eq  
object GridUtility {
  def distance(p1: Point, p2: Point): Double = {
    val x = Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2))
    println(x)
    x
  }

  // Creates a line equation from two points
  def lineEq(p1: Point, p2: Point): lineeq = {
    val xcor = p2.y - p1.y
    val ycor = -(p2.x - p1.x)
    val cons = p1.x * (p2.x - p1.y) - p1.y * (p2.x - p1.x)

    lineeq(xcor,ycor,cons)
  }

  // Checks to see if a line is parallel to another
  def isParallel(l1: lineeq, l2: lineeq): Boolean ={
    val x = l2.ycoeff * l1.xcoeff
    val y = l2.xcoeff * l1.ycoeff

    x == y
  }

  // Returns the point in which the two lines intersect
  // Note: Call isParallel to make sure that the lines intersect first
  def interPoint(l1: lineeq, l2: lineeq): Point = {
    val x = l2.ycoeff * l1.c - l1.ycoeff * l2.c
    val y = l1.xcoeff * l2.c - l2.xcoeff * l1.c
    val div = l2.ycoeff * l1.xcoeff - l2.xcoeff * l1.ycoeff
    val xcor = x / div
    val ycor = y / div

    new Point(xcor.toInt, ycor.toInt)
  }

  //to check if it is present one the side of a polygon
  //(side: a,b and intersection x) -> (ax+xb = ab)
  def isValid(p1: Point, p2: Point,p3: Point): Boolean ={
    val x = distance(p1, p3)
    val y = distance(p2, p3)
    val z = distance(p1, p2)

    (x + y) == z
  }
  
  def main(args: Array[String]) = {
    val p1:Point = new Point(14, 9)
    val p2:Point = new Point(13, 5)
    val dist:Double = GridUtility.distance(p1, p2)
  }
}


