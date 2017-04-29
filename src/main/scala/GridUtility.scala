sealed abstract class Eq
case class lineeq(xcoeff: Double, ycoeff: Double, c: Double) extends Eq  
object GridUtility {
  def distance(p1: Point, p2: Point): Double = {
    var x = Math.sqrt(Math.pow((p1.x - p2.x),2)+ Math.pow((p1.y - p2.y),2))
    println(x)
    return x
        
  }
  def lineEq(p1: Point, p2: Point): lineeq ={
    var xcor = (p2.y - p1.y)
    var ycor = -(p2.x - p1.x)
    var cons = p1.x*(p2.x-p1.y) - p1.y*(p2.x-p1.x)
    return lineeq(xcor,ycor,cons)
    
  }
  def isParallel(l1: lineeq, l2: lineeq): Boolean ={
    var x = l2.ycoeff * l1.xcoeff
    var y = l2.xcoeff * l1.ycoeff
    (x == y)
    
  }
  def interPoint(l1: lineeq, l2: lineeq): Point = {
    var x = l2.ycoeff * l1.c - l1.ycoeff * l2.c 
    var y =  l1.xcoeff * l2.c - l2.xcoeff * l1.c
    var div = l2.ycoeff * l1.xcoeff - l2.xcoeff * l1.ycoeff;
    var xcor = x/div
    var ycor = y/div
    return new Point(xcor.toInt, ycor.toInt)
    
  }
  //to check if it is present one the side of a polygon
  //(side: a,b and intersection x) -> (ax+xb = ab)
  def isValid(p1: Point, p2: Point,p3: Point): Boolean ={
    var x = distance(p1,p3)
    var y = distance(p2,p3)
    var z = distance(p1,p2)
    ((x + y) == z)  
  }
  
  def main(args: Array[String]) ={
    val p1:Point = new Point(14, 9)
    val p2:Point = new Point(13, 5)
    val dist:Double = gridUtility.distance(p1, p2)
  }
}


